package com.ei.designpatterns.behavioural;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String message);
}

// Concrete Observer
class ConsoleObserver implements Observer {
    private String name;
    public ConsoleObserver(String name) { this.name = name; }
    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

// Subject interface
interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers(String message);
}

// Concrete Subject
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    @Override
    public void register(Observer o) { observers.add(o); }
    @Override
    public void unregister(Observer o) { observers.remove(o); }
    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) o.update(message);
    }
}

// Demo
public class ObserverExample {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        Observer o1 = new ConsoleObserver("Observer 1");
        Observer o2 = new ConsoleObserver("Observer 2");

        agency.register(o1);
        agency.register(o2);

        agency.notifyObservers("Breaking News!");
    }
}
