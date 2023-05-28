package in.neuron.ai;

public class Question8 {
    public static void main(String[] args) {
        Thread evenThread = new Thread(new EvenThread());
        Thread oddThread = new Thread(new OddThread());

        evenThread.start();
        oddThread.start();
    }
}

class EvenThread implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Even number: " + i);

            // Introduce a small delay
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OddThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 9; i += 2) {
            System.out.println("Odd number: " + i);

            // Introduce a small delay
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
