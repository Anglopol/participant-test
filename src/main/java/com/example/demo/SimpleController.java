package com.example.demo;

import com.wine.to.up.api.feign.KafkaServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@RequiredArgsConstructor
public class SimpleController {
    private final KafkaServiceClient client;

    @GetMapping
    public void get() {
        for (int i = 0; i < 100; i++) {
            client.sendMessage("hello message");
        }
    }
}