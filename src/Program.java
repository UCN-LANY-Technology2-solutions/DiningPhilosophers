import base.PartyIF;

public class Program {

	public static void main(String[] args) throws InterruptedException {

		//PartyIF diningPhilosophers = new lockSolution.Party();
		PartyIF diningPhilosophers = new semaphoreSolution.Party();
		//PartyIF diningPhilosophers = new synchronizedSolution.Party();
		
		diningPhilosophers.dine();
	}
}