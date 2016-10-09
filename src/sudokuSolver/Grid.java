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
		for(int i = 0; i < this.squares.length; i++)
			for(int j = 0; j < this.squares[i].length; j++)
				this.squares[i][j] = new Square(squares[i][j]);
	}
	
	public Grid(Grid g) {
		for(int i = 0; i < this.squares.length; i++)
			for(int j = 0; j < this.squares[i].length; j++)
				this.squares[i][j] = new Square(g.getSquares()[i][j]);
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
		for(int i = 0; i < this.squares.length; i++)
			for(int j = 0; j < this.squares[i].length; j++)
				this.squares[i][j] = new Square(squares[i][j]);
	}
	
	public void setNumber(int x, int y, int number) {
		squares[x][y].setNumber(number);
	}
	
	public boolean checkArea(int x, int y, int number) {
		boolean changed = false;
		
		// change possibilities for the horizontal row
		for (int i = 0; i < squares.length; i++) {
			if (i != y){
				if (squares[x][i].setPossibility(number, false))
					changed = true;
			}
		}
		
		// change possibilities for the vertical column
		for (int i = 0; i < squares.length; i++) {
			if (i != x) {
				if (squares[i][y].setPossibility(number, false))
					changed = true;
			}
		}
		
		// change possibilities for the box
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (((x/3) * 3 + i) != x || ((y/3) * 3 + j) != y) {
					if (squares[(x/3) * 3 + i][(y/3) * 3 + j].setPossibility(number, false))
						changed = true;
				}
			}
		}
		
		return changed;
	}
	
	public boolean update() {
		boolean changed = false;
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				int n = squares[i][j].isFound();
				if (n != 0) {
					if (checkArea(i, j, n))
						changed = true;
				}
			}
		}
		return changed;
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
	
	public boolean isFalse() {
		for(int i = 0; i < getSquares().length; i++) {
			for(int j = 0; j < getSquares().length; j++) {
				if (getSquares()[i][j].isError()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean solve() {
		while (!isCompleted() && !isFalse()) { 
			if (!update()) {
				GridCoords gc = new GridCoords(getNextEmptySquare());
				
				while ((squares[gc.x][gc.y].isFound() == 0)) { 
					Grid test = new Grid(this); 
					int n = test.insertNextNumber(gc.x, gc.y); 
					
					if(test.solve()) { 
						this.squares = test.getSquares();
						return true;
					}
					else { 
						this.squares[gc.x][gc.y].setPossibility(n, false);
					}
				} 
			}
		}
		
		if (isCompleted()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int insertNextNumber(int i, int j) {
		return squares[i][j].setFirstPossibility();
	}
	
	public GridCoords getNextEmptySquare() {
		GridCoords gc = new GridCoords();
		
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				if (squares[i][j].isFound() == 0) {
					gc.x = i;
					gc.y = j;
					
					return gc;
				}
			}
		}
		
		return gc;
	}
	
	public class GridCoords {
		public int x;
		public int y;
		
		public GridCoords() {
			x = 0;
			y = 0;
		}
		
		public GridCoords(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public GridCoords(GridCoords gc) {
			this.x = gc.x;
			this.y = gc.y;
		}
	}
}