package com.ei.scheduler.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Singleton class managing all tasks.
 */
public class ScheduleManager {

    private static ScheduleManager instance;

    private final List<Task> tasks;
    private final List<ScheduleListener> listeners;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addListener(ScheduleListener listener) {
        listeners.add(listener);
    }

    public void addTask(Task task) {
        // Notify ConflictDetector first
        notifyListeners(new ScheduleEvent(ScheduleEvent.Type.TASK_ADDED, task));

        tasks.add(task);
        // Notify UX
        notifyListeners(new ScheduleEvent(ScheduleEvent.Type.TASK_ADDED, task));
    }

    public void removeTask(Task task) {
        if (!tasks.remove(task)) {
            throw DomainExceptions.taskNotFound();
        }
        notifyListeners(new ScheduleEvent(ScheduleEvent.Type.TASK_REMOVED, task));
    }

    public List<Task> getAllTasks() {
        return Collections.unmodifiableList(tasks);
    }
    
    public void clearTasks() {
        tasks.clear();
    }

    private void notifyListeners(ScheduleEvent event) {
        for
