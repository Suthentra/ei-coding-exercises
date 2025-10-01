package com.ei.scheduler.core;

import java.util.UUID;

/**
 * Represents a unique identifier for a Task.
 */
public final class TaskId {
    private final String id;

    private TaskId(String id) {
        this.id = id;
    }

    public static TaskId generate() {
        return new TaskId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TaskId)) return false;
        TaskId other = (TaskId) obj;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
