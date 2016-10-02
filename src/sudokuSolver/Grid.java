package sudokuSolver;

public class Grid {
	private Square squares[][] = new Square[9][9];
	
	public Grid() {
		// TODO : Fill in with an empty grid
	}
	
	public Grid(Square[][] squares) {
		this.squares = squares;
	}

	public Square[][] getSquares() {
		return squares;
	}

	public void setSquares(Square squares[][]) {
		this.squares = squares;
	}

	public boolean isCompleted() {
		for(int i = 0; i < getSquares().length; i++) {
			for(int j = 0; j < getSquares().length; j++) {
				if (getSquares()[i][j].isFound() == 0) {
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
	
	public void printGrid() {
		for (int i = 0; i < 9; i++) {
			if (i%3 == 0) {
				System.out.println("_________________________________________");
				System.out.println("_________________________________________");
			}
			else {
				System.out.println("_________________________________________");
			}
			
			for (int j = 0; j < 9; j ++) {
				if (j%3 == 0) {
					System.out.print("||");
				}
				else {
					System.out.print("|");
				}
				
				System.out.print(" ");
				squares[i][j].printNumber();
				System.out.print(" ");

				if (j == 8) {
					System.out.print("||");
				}
			}
			System.out.println();
			
			if (i == 8) {
				System.out.println("_________________________________________");
				System.out.println("_________________________________________");
			}
		}
	}
}