package com.springevent.demo.configuration;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.reactive.TransactionalEventPublisher;

@Configuration
public class TransactionalEventPublisherConfiguration {

    @Bean
    public TransactionalEventPublisher transactionalEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        return new TransactionalEventPublisher(applicationEventPublisher);
    }
}
