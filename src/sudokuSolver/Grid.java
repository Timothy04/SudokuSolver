package sudokuSolver;

public class Grid {
	private Square grid[][] = new Square[9][9];
	
	public boolean isCompleted() {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
				if (!grid[i][j].isFound()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void printEmptyGrid() {
		System.out.println("_________________________________________");
		System.out.println("_________________________________________");
		System.out.println("||   |   |   ||   |   |   ||   |   |   ||");
		System.out.println("_________________________________________");
		System.out.println("||   |   |   ||   |   |   ||   |   |   ||");
		System.out.println("_________________________________________");
		System.out.println("||   |   |   ||   |   |   ||   |   |   ||");
		System.out.println("_________________________________________");
		System.out.println("_________________________________________");
		System.out.println("||   |   |   ||   |   |   ||   |   |   ||");
		System.out.println("_________________________________________");
		System.out.println("||   |   |   ||   |   |   ||   |   |   ||");
		System.out.println("_________________________________________");
		System.out.println("||   |   |   ||   |   |   ||   |   |   ||");
		System.out.println("_________________________________________");
		System.out.println("_________________________________________");
		System.out.println("||   |   |   ||   |   |   ||   |   |   ||");
		System.out.println("_________________________________________");
		System.out.println("||   |   |   ||   |   |   ||   |   |   ||");
		System.out.println("_________________________________________");
		System.out.println("||   |   |   ||   |   |   ||   |   |   ||");
		System.out.println("_________________________________________");
		System.out.println("_________________________________________");
	}
}