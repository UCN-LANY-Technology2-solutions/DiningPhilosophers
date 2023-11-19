package synchronizedSolution;

import base.PartyIF;

public class Party implements PartyIF {
	
	@Override
	public void dine() {
		
        Chopstick[] chopsticks = new Chopstick[5];
		String[] philosophers = { "1-Socrates", "2-John Locke", "3-Avicenna", "4-Confucius", "5-Descartes" };

        for (int i = 0; i < 5; i++) {
            chopsticks[i] = new Chopstick();
        }

        for (int i = 0; i < 5; i++) {
            Chopstick left = chopsticks[i];
            Chopstick right = chopsticks[(i + 1) % 5];

            Thread philosopher = new Thread(new Philosopher(philosophers[i], left, right), "Philosopher "+ i);
            
            philosopher.start();
        }
	}
}
