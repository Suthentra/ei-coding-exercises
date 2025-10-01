package com.ei.designpatterns.creational;

// Singleton class
class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Demo
public class SingletonExample {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First message");
        logger2.log("Second message");

        System.out.println("logger1 == logger2? " + (logger1 == logger2));
    }
}
