package dijkstraSolution;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {

	private Semaphore leftChopstick;
	private Semaphore rightChopstick;
	private Semaphore room;
	private String name;

	public Philosopher(String name, Semaphore leftChopstick, Semaphore rightChopstick, Semaphore room) {
		this.name = name;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		this.room = room;
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

	private void pickUpChopsticks() throws InterruptedException {
		System.out.println(name + " wants to eat.");
		room.acquire(); // Enter the room
		leftChopstick.acquire(); // Pick up left chopstick
		rightChopstick.acquire(); // Pick up right chopstick
	}

	private void eat() throws InterruptedException {
		System.out.println(name + " is eating.");
//		Thread.sleep((int) (Math.random() * 1000));
	}

	private void putDownChopsticks() {
		leftChopstick.release(); // Put down left chopstick
		rightChopstick.release(); // Put down right chopstick
		room.release(); // Leave the room
		System.out.println(name + " has finished eating.");
	}
}
