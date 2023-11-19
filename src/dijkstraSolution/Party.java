package dijkstraSolution;

/* To implement Dijkstra's solution to the Dining Philosophers problem in Java, we use semaphores to 
 * prevent deadlock. This solution introduces an additional semaphore (often called a "room" semaphore) 
 * to limit the number of philosophers that can try to pick up chopsticks at the same time. This 
 * strategy prevents the circular wait condition, which is one of the necessary conditions for a 
 * deadlock.
 * */

import java.util.concurrent.Semaphore;

import base.PartyIF;

public class Party implements PartyIF {

	@Override
	public void dine() {

		Semaphore[] chopsticks = new Semaphore[5];
		Semaphore table = new Semaphore(4);
		String[] philosophers = { "1-Socrates", "2-John Locke", "3-Avicenna", "4-Confucius", "5-Descartes" };

		for (int i = 0; i < 5; i++) {
			chopsticks[i] = new Semaphore(1);
		}

		for (int i = 0; i < 5; i++) {
			Semaphore left = chopsticks[i];
			Semaphore right = chopsticks[(i + 1) % 5];

			Thread philosopher = new Thread(new Philosopher(philosophers[i], left, right, table));
			philosopher.start();
		}
	}
}
