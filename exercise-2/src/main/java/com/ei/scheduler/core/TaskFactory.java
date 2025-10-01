package com.ei.scheduler.core;

public class TaskFactory {
    public static Task createTask(String desc, String start, String end, Priority priority) {
        TaskId id = new TaskId();
        TimeRange timeRange = new TimeRange(start, end);
        return new Task(id, desc, timeRange, priority);
    }
}
