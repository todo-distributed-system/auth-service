package com.app.todo.auth.service;

import com.app.todo.auth.entity.AuthUser;
import com.app.todo.auth.utility.UserCreationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, UserCreationEvent> kafkaTemplate;
    private final String USER_CREATE_EVENT = "user-create-events";

    public void send(AuthUser user) {

        UserCreationEvent userEvent = UserCreationEvent.builder().
                email(user.getEmail()).
                userId(user.getUserId()).
                createdAt(user.getCreatedAt()).
                updatedAt(user.getUpdatedAt()).
                build();

        kafkaTemplate.send(USER_CREATE_EVENT, userEvent);
    }
}
