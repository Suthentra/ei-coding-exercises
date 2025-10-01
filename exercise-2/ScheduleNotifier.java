package com.ei.scheduler.core;

/**
 * Notifies console or UI about schedule events.
 */
public class ScheduleNotifier implements ScheduleListener {

    @Override
    public void onScheduleEvent(ScheduleEvent event) {
        switch (event.getType()) {
            case TASK_ADDED -> System.out.println("Task added successfully: " + event.getTask());
            case TASK_REMOVED -> System.out.println("Task removed successfully: " + event.getTask());
            case TASK_CONFLICT -> System.out.println("Conflict detected: " + event.getTask());
        }
    }
}
