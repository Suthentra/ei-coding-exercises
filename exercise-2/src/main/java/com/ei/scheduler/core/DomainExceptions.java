package com.ei.scheduler.core;

/**
 * Centralized domain exceptions.
 */
public class DomainExceptions {
    public static ValidationException taskNotFound() {
        return new ValidationException("Task not found.");
    }

    public static ValidationException taskConflict(String conflictingTask) {
        return new ValidationException("Task conflicts with existing task: " + conflictingTask);
    }
}
