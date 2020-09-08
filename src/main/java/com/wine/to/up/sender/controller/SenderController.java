package com.wine.to.up.sender.controller;


import com.wine.to.up.demo.service.api.feign.KafkaServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("/load-testing")
@Slf4j
public class SenderController {
    private final KafkaServiceClient client;
    private final ExecutorService executorService;
    private final List<String> messagesPool;

    public SenderController(@Qualifier("MessagesPool") List<String> messagesPool,
                            KafkaServiceClient client) {
        this.messagesPool = messagesPool;
        this.client = client;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    private AtomicBoolean isLoadTestingPerformed = new AtomicBoolean(false);

    @GetMapping(value = "/start")
    public void startLoadTesting() {
        isLoadTestingPerformed.set(true);
        executorService.submit(() -> {
            Random random = new Random();
            int sentCounter = 0;
            while (isLoadTestingPerformed.get()) {
                int messagePoolNumber = random.nextInt(messagesPool.size());
                client.sendMessage(messagesPool.get(messagePoolNumber));
                sentCounter++;
                int sleepTime = random.nextInt(60000);
                log.info("Messages count {}\nMessage number from messages pool {}\nSleeping time {}",
                        sentCounter, messagePoolNumber, sleepTime);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    log.warn(e.getMessage());
                }
            }
        });
    }

    @GetMapping(value = "/stop")
    public void stopLoadTesting() {
        isLoadTestingPerformed.set(false);
    }
}