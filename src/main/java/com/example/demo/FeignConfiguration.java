package com.example.demo;

import com.wine.to.up.api.feign.KafkaServiceClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    @Value("${service.app.host}")
    private String serviceAppHost;

    @Bean
    public KafkaServiceClient getKafkaServiceClient() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .client(new OkHttpClient())
                .target(KafkaServiceClient.class, "http://" + serviceAppHost);
    }
}
