package com.ei.designpatterns.structural;

// Component
interface Coffee {
    double cost();
}

// Concrete component
class SimpleCoffee implements Coffee {
    public double cost() { return 5.0; }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) { this.coffee = coffee; }
}

// Concrete decorator
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }
    public double cost() { return coffee.cost() + 2.0; }
}

// Demo
public class DecoratorExample {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println("Cost of simple coffee: " + coffee.cost());

        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println("Cost of coffee with milk: " + milkCoffee.cost());
    }
}
