package com.app.todo.auth.controller;

import com.app.todo.auth.request.RegisterUserRequest;
import com.app.todo.auth.response.UserRegistrationResponse;
import com.app.todo.auth.service.UserRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/todo/auth")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(@Valid @RequestBody RegisterUserRequest registerUserRequest) {
        return ResponseEntity.ok(userRegistrationService.registerUser(registerUserRequest));
    }

}
