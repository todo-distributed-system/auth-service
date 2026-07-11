package com.app.todo.auth.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorMessage {
    private String exception;
    private String errorMessage;
    private LocalDateTime localDateTime;
}
