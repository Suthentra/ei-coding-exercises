package com.ei.scheduler.core;

import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks;
    private final List<ScheduleListener> listeners;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        listeners = new ArrayList<>();
        listeners.add(new ConflictDetector(this));
        listeners.add(new ScheduleNotifier());
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            synchronized (ScheduleManager.class) {
                if (instance == null) instance = new ScheduleManager();
            }
        }
        return instance;
    }

    public void addTask(Task task) throws ValidationException {
        for (Task t : tasks) {
            if (t.getTimeRange().overlaps(task.getTimeRange())) {
                notifyListeners(new ScheduleEvent(ScheduleEvent.Type.TASK_CONFLICT, task));
                throw new ValidationException("Task conflicts with existing task: " + t.getDescription());
            }
        }
        tasks.add(task);
        notifyListeners(new ScheduleEvent(ScheduleEvent.Type.TASK_ADDED, task));
    }

    public void removeTask(String description) throws ValidationException {
        Task toRemove = null;
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                toRemove = t;
                break;
            }
        }
        if (toRemove == null) throw new ValidationException("Task not found.");
        tasks.remove(toRemove);
        notifyListeners(new ScheduleEvent(ScheduleEvent.Type.TASK_REMOVED, toRemove));
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        tasks.stream()
                .sorted((t1, t2) -> t1.getTimeRange().getStart().compareTo(t2.getTimeRange().getStart()))
                .forEach(System.out::println);
    }

    private void notifyListeners(ScheduleEvent event) {
        for (ScheduleListener listener : listeners) {
            listener.onScheduleEvent(event);
        }
    }

    // Required for ConflictDetector
    public List<Task> getAllTasks() {
        return tasks;
    }
}
