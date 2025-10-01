package com.ei.scheduler.core;

import java.util.UUID;

public class TaskId {
    private final String id;

    public TaskId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() { return id; }

    @Override
    public String toString() { return id; }
}
