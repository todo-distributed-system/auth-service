package com.app.todo.auth.utility;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class UserCreationEvent {
    private UUID userId;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
