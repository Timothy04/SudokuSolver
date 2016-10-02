package sudokuSolver;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Sudoku Solver !!");
		
		//Grid.printEmptyGrid();
		
		//Grid gridToSolve = new Grid();
		
		Square fictiveSquares[][] = new Square[9][9];
		Square fictiveSquare = new Square(true, false, false, false, false, false, false, false, false);
		
		for (int i = 0; i < fictiveSquares.length; i++) {
			for (int j = 0; j < fictiveSquares.length; j++) {
				fictiveSquares[i][j] = fictiveSquare;
			}
		}
		
		Grid fictiveGrid = new Grid(fictiveSquares);
		fictiveGrid.printGrid();
		
		System.out.println("End of program.");
	}
}