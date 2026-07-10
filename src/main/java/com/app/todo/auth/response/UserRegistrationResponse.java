package com.app.todo.auth.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRegistrationResponse {
    private String registrationStatus;
}
