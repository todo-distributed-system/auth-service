package com.app.todo.auth.security;

import com.app.todo.auth.entity.AuthUser;
import com.app.todo.auth.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        AuthUser authUser = authUserRepository.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));


        return CustomerUserDetails.builder()
                .userId(authUser.getUserId())
                .username(authUser.getEmail())
                .password(authUser.getPasswordHash())
                .build();
    }
}
