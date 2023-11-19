package resourceHierarchySolution;

/* The resource hierarchy solution is another approach to solve the Dining Philosophers 
 * problem, which avoids deadlock by imposing a total ordering on the resources (in this 
 * case, chopsticks) and ensuring that each philosopher always picks up the lower-numbered 
 * chopstick first.
 * */

import base.PartyIF;

public class Party implements PartyIF {

	@Override
	public void dine() {

		Chopstick[] chopsticks = new Chopstick[5];
		String[] philosophers = { "1-Socrates", "2-John Locke", "3-Avicenna", "4-Confucius", "5-Descartes" };

		for (int i = 0; i < 5; i++) {
			chopsticks[i] = new Chopstick(i);
		}

		for (int i = 0; i < 5; i++) {
			Chopstick leftChopstick = chopsticks[i];
			Chopstick rightChopstick = chopsticks[(i + 1) % 5];

			Thread philosopher = new Thread(new Philosopher(philosophers[i], leftChopstick, rightChopstick),
					"Philosopher " + i);
			philosopher.start();
		}
	}

}
