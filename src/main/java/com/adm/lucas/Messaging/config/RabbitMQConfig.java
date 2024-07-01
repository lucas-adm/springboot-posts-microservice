package com.adm.lucas.Messaging.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${broker.queue.email.name}")
    private String queue;

    @Value("${broker.queue.recover.name}")
    private String recoverQueue;

    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

    @Bean
    public Queue recoverQueue() {
        return new Queue(recoverQueue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}