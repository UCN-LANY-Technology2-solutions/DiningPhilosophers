package lockSolution;

import java.util.concurrent.locks.Lock;

public class Philosopher implements Runnable {
	
	private Lock leftChopstick;
	private Lock rightChopstick;
	private String name;

	public Philosopher(String name, Lock leftChopstick, Lock rightChopstick) {
		this.name = name;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
	}

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
		//Thread.sleep((int) (Math.random() * 1000));
	}

	private void pickUpChopsticks() {
		System.out.println(name + " wants to eat.");
		leftChopstick.lock();
		rightChopstick.lock();
	}

	private void eat() throws InterruptedException {
		System.out.println(name + " is eating.");
		//Thread.sleep((int) (Math.random() * 1000));
	}

	private void putDownChopsticks() {
		leftChopstick.unlock();
		rightChopstick.unlock();
		System.out.println(name + " has finished eating.");
	}
}
