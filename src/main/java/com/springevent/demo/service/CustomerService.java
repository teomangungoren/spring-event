package com.springevent.demo.service;

import com.springevent.demo.domain.CreateCustomerRequest;
import com.springevent.demo.domain.User;
import com.springevent.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionalEventPublisher;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final UserRepository customerRepository;
    private final ApplicationEventPublisher applicationEventPublisher;


    @Transactional
    public User createCustomer(CreateCustomerRequest request) {
         User user = customerRepository.save(new User(request.getName(), request.getEmail()));
         System.out.println("User created with id: " + user.getId());
        applicationEventPublisher.publishEvent(user);
        return user;
    }
}
