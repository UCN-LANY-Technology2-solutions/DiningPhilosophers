package assymetricSolution;

import java.util.concurrent.locks.Lock;

public class Philosopher implements Runnable {

	private final Lock leftChopstick;
	private final Lock rightChopstick;
	private final String name;
	private final String dominantHand;

	public Philosopher(String name, Lock leftChopstick, Lock rightChopstick, String dominantHand) {
		this.name = name;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		this.dominantHand = dominantHand;
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
//		Thread.sleep((int) (Math.random() * 1000));
	}

	private void eat() throws InterruptedException {

		System.out.println(name + " is eating.");
//		Thread.sleep((int) (Math.random() * 1000));
	}

	private void pickUpChopsticks() {
		System.out.println(name + " wants to eat.");
		// Pick up the chopstick with the dominant hand first
		switch (this.dominantHand) {
		case "left":
			leftChopstick.lock();
			rightChopstick.lock();
			break;
		case "right":
			rightChopstick.lock();
			leftChopstick.lock();
			break;
		}
	}

	private void putDownChopsticks() {
		// The order of putting chopsticks down doesn't matter
		leftChopstick.unlock();
		rightChopstick.unlock();
		System.out.println(name + " has finished eating.");
	}

}
