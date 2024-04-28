package com.springevent.demo.configuration.listener;

import com.springevent.demo.event.UserCreatedEvent;
import com.springevent.demo.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailListener {

    private final EmailService emailService;
    private static final Logger log = LoggerFactory.getLogger(EmailListener.class);

    @EventListener(UserCreatedEvent.class)
    public void onApplicationEvent(UserCreatedEvent event) {
        log.info("Sending email to " + event.getUser().getEmail());
        emailService.sendEmail(event.getUser().getId());
    }
}
