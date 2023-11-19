package semaphoreSolution;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
	
	private Semaphore leftChopstick;
    private Semaphore rightChopstick;
    private String name;

    public Philosopher(String name, Semaphore leftChopstick, Semaphore rightChopstick) {
        this.name = name;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                pickUpChopsticks();
                eat();
                putDownChopsticks();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    private void think() throws InterruptedException {
        System.out.println(name + " is thinking.");
//        Thread.sleep((int) (Math.random() * 1000));
    }

    private void pickUpChopsticks() throws InterruptedException {
        System.out.println(name + " wants to eat.");
        leftChopstick.acquire();
        rightChopstick.acquire();
    }

    private void eat() throws InterruptedException {
        System.out.println(name + " is eating.");
//        Thread.sleep((int) (Math.random() * 1000));
    }

    private void putDownChopsticks() {
        leftChopstick.release();
        rightChopstick.release();
        System.out.println(name + " has finished eating.");
    }
}
