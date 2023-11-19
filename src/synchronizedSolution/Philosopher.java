package synchronizedSolution;

public class Philosopher implements Runnable {
	private Chopstick leftChopstick;
    private Chopstick rightChopstick;
    private String name;

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
                eat();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    private void think() throws InterruptedException {
        System.out.println(name + " is thinking.");
//        Thread.sleep((int) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println(name + " wants to eat.");
        synchronized (leftChopstick) {
            synchronized (rightChopstick) {
                System.out.println(name + " is eating.");
//                Thread.sleep((int) (Math.random() * 1000));
            }
        }
        System.out.println(name + " has finished eating.");
    }
}
