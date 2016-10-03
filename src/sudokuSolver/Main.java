package sudokuSolver;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Sudoku Solver !!");
		
		Square fictiveSquares[][] = new Square[9][9];
		
		for (int i = 0; i < fictiveSquares.length; i++) {
			for (int j = 0; j < fictiveSquares.length; j++) {
				fictiveSquares[i][j] = new Square(true, true, true, true, true, true, true, true, true);
			}
		}
		
		Grid fictiveGrid = new Grid(fictiveSquares);
		fictiveGrid.printGrid();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Do you want to initialize the grid? (y/n) ");
		String choice = sc.next();
		
		while (choice.equals("y")) {
			System.out.println("Give the x coordinate of the square : ");
			int x = sc.nextInt();
			
			System.out.println("Give the y coordinate of the square : ");
			int y = sc.nextInt();
			
			System.out.println("Give the number of the square : ");
			int number = sc.nextInt();
			
			fictiveGrid.setNumber(x - 1, y - 1, number);
			fictiveGrid.printGrid();
			
			System.out.println("Do you want to continue initializing the grid? (y/n) ");
			choice = sc.next();
		}
		
		while (!fictiveGrid.isCompleted()) {
			fictiveGrid.update();
			fictiveGrid.printGrid();
		}
		
		System.out.println("Goodbye !");
	}
}