package assymetricSolution;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import base.PartyIF;

public class Party implements PartyIF {

	@Override
	public void dine() {

		Lock[] chopsticks = new ReentrantLock[5];
		String[] philosophers = { "1-Socrates", "2-John Locke", "3-Avicenna", "4-Confucius", "5-Descartes" };

		for (int i = 0; i < 5; i++) {
			chopsticks[i] = new ReentrantLock();
		}

		for (int i = 0; i < 5; i++) {
			Lock left = chopsticks[i];
			Lock right = chopsticks[(i + 1) % 5];
			Thread philosopher;
			if (i % 2 == 0)
				philosopher = new Thread(new Philosopher(philosophers[i], left, right, "left"), "Philosopher " + i);
			else
				philosopher = new Thread(new Philosopher(philosophers[i], left, right, "right"), "Philosopher " + i);
			philosopher.start();
		}
	}

}
