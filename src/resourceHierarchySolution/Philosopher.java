package resourceHierarchySolution;

public class Philosopher implements Runnable {

	private final Chopstick leftChopstick;
	private final Chopstick rightChopstick;
	private final String name;

	public Philosopher(String name, Chopstick leftChopstick, Chopstick rightChopstick) {
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
//		Thread.sleep((int) (Math.random() * 1000));
	}

	private void eat() throws InterruptedException {

		System.out.println(name + " is eating.");
//		Thread.sleep((int) (Math.random() * 1000));
	}

	private void pickUpChopsticks() {
		System.out.println(name + " wants to eat.");
		// Pick up the chopstick with the lowest id first
		if (leftChopstick.getId() < rightChopstick.getId()) {
			leftChopstick.pickUp();
			rightChopstick.pickUp();
		} else {
			rightChopstick.pickUp();
			leftChopstick.pickUp();
		}
	}

	private void putDownChopsticks() {
		// The order of putting chopsticks down doesn't matter
		leftChopstick.putDown();
		rightChopstick.putDown();
		System.out.println(name + " has finished eating.");
	}
}
