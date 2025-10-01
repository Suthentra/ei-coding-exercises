package com.ei.scheduler.core;

/**
 * Event fired for schedule changes.
 */
public class ScheduleEvent {
    public enum Type {
        TASK_ADDED, TASK_REMOVED, TASK_CONFLICT
    }

    private final Type type;
    private final Task task;

    public ScheduleEvent(Type type, Task task) {
        this.type = type;
        this.task = task;
    }

    public Type getType() {
        return type;
    }

    public Task getTask() {
        return task;
    }
}
