package com.ei.scheduler.core;

import java.util.Objects;

/**
 * Represents a Task in the astronaut scheduler.
 */
public class Task {
    private final TaskId id;
    private final String description;
    private final TimeRange timeRange;
    private final Priority priority;
    private boolean completed;

    public Task(TaskId id, String description, TimeRange timeRange, Priority priority) {
        if (description == null || description.isBlank()) {
            throw new ValidationException("Task description cannot be empty");
        }
        this.id = Objects.requireNonNull(id, "TaskId cannot be null");
        this.description = description;
        this.timeRange = Objects.requireNonNull(timeRange, "TimeRange cannot be null");
        this.priority = Objects.requireNonNull(priority, "Priority cannot be null");
        this.completed = false;
    }

    public TaskId getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TimeRange getTimeRange() {
        return timeRange;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return String.format("%s: %s [%s]%s", 
                timeRange, description, priority, completed ? " (Completed)" : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
