package com.ei.scheduler.core;

public class ScheduleNotifier implements ScheduleListener {

    @Override
    public void onScheduleEvent(ScheduleEvent event) {
        switch (event.getType()) {
            case TASK_ADDED:
                System.out.println("Task added successfully: " + event.getTask());
                break;
            case TASK_REMOVED:
                System.out.println("Task removed successfully: " + event.getTask());
                break;
            case TASK_CONFLICT:
                System.out.println("Conflict detected: " + event.getTask());
                break;
        }
    }
}
