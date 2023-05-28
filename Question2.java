// Parent class
package in.neuron.ai;
class Parent {
    public Parent() {
        System.out.println("Parent class constructor invoked");
    }
}

// Child class inheriting from the Parent class
class Child extends Parent {
    public Child() {
        super(); // Invoking the parent class constructor
        System.out.println("Child class constructor invoked");
    }
}

// Main class
public class Question2 {
    public static void main(String[] args) {
        Child child = new Child(); // Creating an instance of the Child class
    }
}
