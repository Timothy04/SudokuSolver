package sudokuSolver;

public class Grid {
	private Square squares[][] = new Square[9][9];
	
	public Grid() {
		// Fill with empty squares
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				squares[i][j] = new Square();
			}
		}
	}
	
	public Grid(Square[][] squares) {
		this.squares = squares;
	}

	public Square[][] getSquares() {
		return squares;
	}

	public int[][] toIntTable() {
		int[][] t = new int[squares.length][squares.length];
		
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				t[i][j] = squares[i][j].isFound();
			}
		}
		
		return t;
	}
	
	public void setSquares(Square squares[][]) {
		this.squares = squares;
	}
	
	public void setNumber(int x, int y, int number) {
		squares[x][y].setNumber(number);
	}
	
	public void checkArea(int x, int y, int number) {
		// change possibilities for the horizontal row
		for (int i = 0; i < squares.length; i++) {
			if (i != y){
				squares[x][i].setPossibility(number, false);
			}
		}
		
		// change possibilities for the vertical column
		for (int i = 0; i < squares.length; i++) {
			if (i != x) {
				squares[i][y].setPossibility(number, false);
			}
		}
		
		// change possibilities for the big square
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (((x/3) * 3 + i) != x || ((y/3) * 3 + j) != y) {
					squares[(x/3) * 3 + i][(y/3) * 3 + j].setPossibility(number, false);
				}
			}
		}
	}
	
	public void update() {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				int n = squares[i][j].isFound();
				if (n != 0) {
					checkArea(i, j, n);
				}
			}
		}
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
	
	public boolean solve() {
		int i = 0;
		
		while (!isCompleted()) {
			i++;
			update();
			if (i > 50)
				return false;
		}
		
		return true;
	}
}