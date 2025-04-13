package app;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Square;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Circle created with radius: " + circle.getRadius());
        System.out.println("Circle render: " + circle.render());
        Rectangle rectangle = new Rectangle(4, 6);
        System.out.println("Rectangle created with width: " + rectangle.getWidth() + " and height: " + rectangle.getHeight());
        System.out.println("Rectangle render: " + rectangle.render());
        Square square = new Square(4);
        System.out.println("Square created with side length: " + square.getSideLength());
        System.out.println("Square render: " + square.render());
    }
}
