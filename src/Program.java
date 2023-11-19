import base.PartyIF;
import dijkstraSolution.Party;

public class Program {

	public static void main(String[] args) throws InterruptedException {

//		PartyIF diningPhilosophers = new lockSolution.Party();
//		PartyIF diningPhilosophers = new semaphoreSolution.Party();
//		PartyIF diningPhilosophers = new synchronizedSolution.Party();
//		PartyIF diningPhilosophers = new dijkstraSolution.Party();
//		PartyIF diningPhilosophers = new resourceHierarchySolution.Party();
		PartyIF diningPhilosophers = new assymetricSolution.Party();
		
		diningPhilosophers.dine();
	}
}