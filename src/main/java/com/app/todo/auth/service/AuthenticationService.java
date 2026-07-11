package com.app.todo.auth.service;

import com.app.todo.auth.entity.AuthUser;
import com.app.todo.auth.request.LoginRequest;
import com.app.todo.auth.response.LoginResponse;
import com.app.todo.auth.security.CustomerUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginResponse login(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String token = jwtTokenProvider.generateToken((CustomerUserDetails) authentication.getPrincipal());

        System.out.println(token);

        return LoginResponse.builder()
                .token(token)
                .build();
    }

}
