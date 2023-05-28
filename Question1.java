package in.neuron.ai;

//Define the Shape interface
interface Shape {
 double calculateArea();
 double calculatePerimeter();
}

//Circle class implementing the Shape interface
class Circle implements Shape {
 private double radius;

 public Circle(double radius) {
     this.radius = radius;
 }

 @Override
 public double calculateArea() {
     return Math.PI * radius * radius;
 }

 @Override
 public double calculatePerimeter() {
     return 2 * Math.PI * radius;
 }
}

//Triangle class implementing the Shape interface
class Triangle implements Shape {
 private double base;
 private double height;
 private double side1;
 private double side2;
 private double side3;

 public Triangle(double base, double height, double side1, double side2, double side3) {
     this.base = base;
     this.height = height;
     this.side1 = side1;
     this.side2 = side2;
     this.side3 = side3;
 }

 @Override
 public double calculateArea() {
     return 0.5 * base * height;
 }

 @Override
 public double calculatePerimeter() {
     return side1 + side2 + side3;
 }
}

//Main class to test the Shape interface and its implementations
public class Question1 {
 public static void main(String[] args) {
     // Create a circle object
     Circle circle = new Circle(5);
     System.out.println("Circle Area: " + circle.calculateArea());
     System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

     // Create a triangle object
     Triangle triangle = new Triangle(5, 3, 4, 4, 6);
     System.out.println("Triangle Area: " + triangle.calculateArea());
     System.out.println("Triangle Perimeter: " + triangle.calculatePerimeter());
 }
}
