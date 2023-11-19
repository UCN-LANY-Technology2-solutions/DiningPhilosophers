package resourceHierarchySolution;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	// A Chopstick is represented by an instance of the Chopstick class, which internally uses a Lock to control access.
	private final Lock lock = new ReentrantLock();
	// The id keeps track of the order of the chopstick
	private final int id;

	public Chopstick(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void pickUp() {
		lock.lock();
	}

	public void putDown() {
		lock.unlock();
	}
}
