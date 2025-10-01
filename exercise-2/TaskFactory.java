package com.ei.scheduler.core;

/**
 * Factory for creating Task objects.
 */
public class TaskFactory {

    public static Task createTask(String description, String startTime, String endTime, Priority priority) {
        TaskId id = TaskId.generate();
        TimeRange timeRange = new TimeRange(startTime, endTime);
        return new Task(id, description, timeRange, priority);
    }
}
