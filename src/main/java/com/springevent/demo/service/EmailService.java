package com.springevent.demo.service;

import com.springevent.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final UserRepository userRepository;

    public void sendEmail(Long userId) {
       userRepository.findById(userId).ifPresent(user -> {
           System.out.println("Sending email to " + user.getEmail());
       });
}
}

