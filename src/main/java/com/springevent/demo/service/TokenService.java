package com.springevent.demo.service;

import com.springevent.demo.domain.User;
import com.springevent.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UserRepository userRepository;

    @Transactional
    public void generateToken(User user){
        System.out.println("Generating token for " + user.getEmail());
        final String token = UUID.randomUUID().toString();
        user.activatedWith(token);
        userRepository.save(user);
    }

}
