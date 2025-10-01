package com.ei.scheduler.core;

/**
 * Exception thrown for validation errors.
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
