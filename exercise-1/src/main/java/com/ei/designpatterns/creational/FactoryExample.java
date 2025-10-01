package com.ei.designpatterns.creational;

public class FactoryExample {

    // Factory method
    public static Shape getShape(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        switch(type.toLowerCase()) {
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            default:
                throw new IllegalArgumentException("Unknown shape: " + type);
        }
    }

    // Test the factory
    public static void main(String[] args) {
        Shape shape1 = FactoryExample.getShape("circle");
        shape1.draw();  // Output: Drawing a Circle

        Shape shape2 = FactoryExample.getShape("square");
        shape2.draw();  // Output: Drawing a Square

        // Uncommenting the line below will throw exception
        // Shape shape3 = FactoryExample.getShape("triangle");
    }
}
