package com.ei.scheduler.app;

import com.ei.scheduler.core.ScheduleManager;
import com.ei.scheduler.core.Task;
import com.ei.scheduler.core.TaskFactory;
import com.ei.scheduler.core.Priority;
import com.ei.scheduler.util.InputUtils;

public class ConsoleApp {

    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        boolean running = true;

        System.out.println("=== Astronaut Daily Schedule Organizer ===");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");

            int choice = InputUtils.readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    addTask(manager);
                    break;
                case 2:
                    removeTask(manager);
                    break;
                case 3:
                    manager.viewTasks();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addTask(ScheduleManager manager) {
        try {
            String desc = InputUtils.readString("Task Description: ");
            String start = InputUtils.readString("Start Time (HH:mm): ");
            String end = InputUtils.readString("End Time (HH:mm): ");
            String prio = InputUtils.readString("Priority (HIGH/MEDIUM/LOW): ");
            Priority priority = Priority.valueOf(prio.toUpperCase());

            Task task = TaskFactory.createTask(desc, start, end, priority);
            manager.addTask(task);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void removeTask(ScheduleManager manager) {
        String desc = InputUtils.readString("Enter task description to remove: ");
        try {
            manager.removeTask(desc);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
