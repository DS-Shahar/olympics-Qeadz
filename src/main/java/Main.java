import java.util.*;
class Main {
	public static void main(String[] args) {
		runq2();
	}
	
	public static void runq2() {
		Group group = new Group("Olympics Group", 2);

		group.addAthlete("A", 3);
		group.addAthlete("B", 2);

		group.addGrade("A", "Floor Exercise", 9.5);
		group.addGrade("A", "Balance Beam", 8.7);
		group.addGrade("B", "Vault", 7.8);

		System.out.println("Best athlete: " + group.getBestAthleteName());

		group.addGrade("B", "Floor Exercise", 100.5);
		group.addGrade("A", "Uneven Bars", 9.0);

		System.out.println("Best athlete: " + group.getBestAthleteName());
	}
}





}
