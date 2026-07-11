package com.app.todo.auth.service;

import com.app.todo.auth.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class UserServiceClient {

    private final RestClient userServiceClient;

    public void createUser(CreateUserRequest createUserRequest) {

        userServiceClient.post()
                .uri("http://localhost:8081/app/todo/user/create")
                .body(createUserRequest)
                .retrieve()
                .toBodilessEntity();

    }

}
