package com.ei.scheduler.core;

import java.util.List;

/**
 * Detects conflicts when new tasks are added.
 */
public class ConflictDetector implements ScheduleListener {

    private final ScheduleManager scheduleManager;

    public ConflictDetector(ScheduleManager scheduleManager) {
        this.scheduleManager = scheduleManager;
    }

    @Override
    public void onScheduleEvent(ScheduleEvent event) {
        if (event.getType() != ScheduleEvent.Type.TASK_ADDED) return;

        Task newTask = event.getTask();
        List<Task> existingTasks = scheduleManager.getAllTasks();

        for (Task task : existingTasks) {
            if (!task.equals(newTask) && task.getTimeRange().overlaps(newTask.getTimeRange())) {
                throw DomainExceptions.taskConflict(task.getDescription());
            }
        }
    }
}
