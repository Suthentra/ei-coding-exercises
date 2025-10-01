package com.ei.scheduler.core;

public class Task {
    private final TaskId id;
    private final String description;
    private final TimeRange timeRange;
    private final Priority priority;

    public Task(TaskId id, String description, TimeRange timeRange, Priority priority) {
        this.id = id;
        this.description = description;
        this.timeRange = timeRange;
        this.priority = priority;
    }

    public TaskId getId() { return id; }
    public String getDescription() { return description; }
    public TimeRange getTimeRange() { return timeRange; }
    public Priority getPriority() { return priority; }

    @Override
    public String toString() {
        return timeRange + ": " + description + " [" + priority + "]";
    }
}
