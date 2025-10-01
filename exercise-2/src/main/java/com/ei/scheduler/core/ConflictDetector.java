package com.ei.scheduler.core;

import java.util.List;

public class ConflictDetector implements ScheduleListener {

    private ScheduleManager scheduleManager;

    public ConflictDetector(ScheduleManager scheduleManager) {
        this.scheduleManager = scheduleManager;
    }

    @Override
    public void onScheduleEvent(ScheduleEvent event) {
        // We don't use generic event notifications here.
        // Conflict detection is triggered manually when a task is added.
    }

    public boolean hasConflict(Task newTask) {
        List<Task> existingTasks = scheduleManager.getAllTasks();
        for (Task task : existingTasks) {
            if (task.getTimeRange().overlaps(newTask.getTimeRange())) {
                System.out.println("Conflict detected between: " 
                    + newTask.getDescription() + " and " + task.getDescription());
                return true;
            }
        }
        return false;
    }
}
