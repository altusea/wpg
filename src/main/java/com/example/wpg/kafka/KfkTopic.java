package com.example.wpg.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KfkTopic {

    @Bean
    public NewTopic topic() {
        return new NewTopic("topic1", 1, (short) 1);
    }

    @Bean
    public NewTopic dlt() {
        return new NewTopic("topic1.DLT", 1, (short) 1);
    }
}
