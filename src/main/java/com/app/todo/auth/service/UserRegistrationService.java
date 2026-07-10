package com.app.todo.auth.service;

import com.app.todo.auth.entity.AuthUser;
import com.app.todo.auth.repository.AuthUserRepository;
import com.app.todo.auth.request.RegisterUserRequest;
import com.app.todo.auth.response.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final AuthUserRepository authUserRepository;

    public UserRegistrationResponse registerUser(RegisterUserRequest registerUserRequest) {

        AuthUser user = AuthUser.builder()
                .email(registerUserRequest.getEmail())
                .passwordHash(passwordEncoder.encode(registerUserRequest.getPassword()))
                .build();

        authUserRepository.save(user);

        UserRegistrationResponse userRegistrationResponse = UserRegistrationResponse.builder()
                .registrationStatus("User Registered")
                .build();

        System.out.println(userRegistrationResponse.getRegistrationStatus());

        return userRegistrationResponse;
    }

}
