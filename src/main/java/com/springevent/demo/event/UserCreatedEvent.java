package com.springevent.demo.event;

import com.springevent.demo.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
@Setter
public class UserCreatedEvent {
    private User user;

    public UserCreatedEvent(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CustomerCreatedEvent{" +
                "customer=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCreatedEvent that = (UserCreatedEvent) o;

        return user.equals(that.user);
    }


}
