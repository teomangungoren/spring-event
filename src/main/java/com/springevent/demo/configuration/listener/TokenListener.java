package com.springevent.demo.configuration.listener;

import com.springevent.demo.event.UserCreatedEvent;
import com.springevent.demo.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenListener{

    private final TokenService tokenService;

    @EventListener(UserCreatedEvent.class)
    public void onApplicationEvent(UserCreatedEvent event) {
        tokenService.generateToken(event.getUser());
    }
}
