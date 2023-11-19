package semaphoreSolution;

import java.util.concurrent.Semaphore;

import base.PartyIF;

public class Party implements PartyIF {

	@Override
	public void dine() {

        Semaphore[] chopsticks = new Semaphore[5];
    	String[] philosophers = { "1-Socrates", "2-John Locke", "3-Avicenna", "4-Confucius", "5-Descartes" };

        for (int i = 0; i < 5; i++) {
            chopsticks[i] = new Semaphore(1);
        }

        for (int i = 0; i < 5; i++) {
            Semaphore left = chopsticks[i];
            Semaphore right = chopsticks[(i + 1) % 5];

            Thread philosopher = new Thread(new Philosopher(philosophers[i], left, right));
            philosopher.start();
        }
	}
}
