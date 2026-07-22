package com.app.todo.auth.service;

import com.app.todo.auth.entity.AuthUser;
import com.app.todo.auth.repository.AuthUserRepository;
import com.app.todo.auth.request.RegisterUserRequest;
import com.app.todo.auth.response.UserRegistrationResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final AuthUserRepository authUserRepository;
    private final KafkaService kafkaService;

    @Transactional
    public UserRegistrationResponse registerUser(RegisterUserRequest registerUserRequest) {

        AuthUser user = AuthUser.builder()
                .email(registerUserRequest.getEmail())
                .passwordHash(passwordEncoder.encode(registerUserRequest.getPassword()))
                .build();

        user = authUserRepository.save(user);

        kafkaService.send(user);

        return UserRegistrationResponse.builder()
                .registrationStatus("User Registered")
                .build();
    }

}
