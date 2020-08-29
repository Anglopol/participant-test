package com.example.demo;


import com.wine.to.up.demo.service.api.feign.KafkaServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class SimpleController {
    private final KafkaServiceClient client;

    @GetMapping(value = "/get")
    public void get() {
        for (int i = 0; i < 100; i++) {
            System.out.println("send " + i);
            client.sendMessage("hello Andrey!");
        }
    }
}