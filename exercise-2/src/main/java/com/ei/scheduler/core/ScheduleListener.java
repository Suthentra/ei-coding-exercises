package com.ei.scheduler.core;

/**
 * Observer interface for schedule events.
 * Any class that wants to listen to schedule changes should implement this.
 */
public interface ScheduleListener {

    /**
     * Called when a task is added or removed, or when a conflict is detected.
     *
     * @param event The event object containing details about the change.
     */
    void onScheduleEvent(ScheduleEvent event);
}
