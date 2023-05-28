package in.neuron.ai;

//Abstract class example
abstract class Animal {
 protected String name;

 public Animal(String name) {
     this.name = name;
 }

 public abstract void sound();
}

class Dog extends Animal {
 public Dog(String name) {
     super(name);
 }

 @Override
 public void sound() {
     System.out.println(name + " barks");
 }
}

//Interface example
interface Vehicle {
 void start();
 void stop();
}

class Car implements Vehicle {
 @Override
 public void start() {
     System.out.println("Car started");
 }

 @Override
 public void stop() {
     System.out.println("Car stopped");
 }
}

public class Question5 {
 public static void main(String[] args) {
     // Abstract class example
     Animal animal = new Dog("Buddy");
     animal.sound();

     // Interface example
     Vehicle vehicle = new Car();
     vehicle.start();
     vehicle.stop();
 }
}
