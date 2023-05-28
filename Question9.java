package in.neuron.ai;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Question9 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 10;

        Producer producer = new Producer(queue, maxSize);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {
    private Queue<Integer> queue;
    private int maxSize;

    public Producer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int number = random.nextInt(100);
                System.out.println("Produced: " + number);
                queue.add(number);
                queue.notifyAll();
            }
        }
    }
}

class Consumer implements Runnable {
    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int sum = 0;
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int number = queue.poll();
                    System.out.println("Consumed: " + number);
                    sum += number;
                }

                System.out.println("Sum: " + sum);
                queue.notifyAll();
            }
        }
    }
}

