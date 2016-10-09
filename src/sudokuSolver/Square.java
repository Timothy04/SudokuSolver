package sudokuSolver;

public class Square {
	private boolean possibilities[] = {true, true, true, true, true, true, true, true, true};

	public Square(boolean one, boolean two, boolean three, boolean four, boolean five, boolean six, boolean seven, boolean eight, boolean nine) {
		this.possibilities[0] = one;
		this.possibilities[1] = two;
		this.possibilities[2] = three;
		this.possibilities[3] = four;
		this.possibilities[4] = five;
		this.possibilities[5] = six;
		this.possibilities[6] = seven;
		this.possibilities[7] = eight;
		this.possibilities[8] = nine;
	}
	
	public Square() {
		
	}
	
	public Square(Square s) {
		for(int i = 0; i< possibilities.length; i++)
			possibilities[i] = s.possibilities[i];
	}

	public boolean[] getPossibilities() {
		return possibilities;
	}

	public void setPossibilities(boolean possibilities[]) {
		this.possibilities = possibilities;
	}
	
	public boolean setPossibility(int number, boolean p) { // return true if something has changed
		if (possibilities[number - 1] != p) {
			possibilities[number - 1] = p;
			return true;
		}
		else {
			return false;
		}
	}
	
	public int setFirstPossibility() {
		for (int i = 0; i < possibilities.length; i++) {
			if (possibilities[i] == true) {
				setNumber(i + 1);
				return i + 1;
			}
		}
		
		return 0;
	}
	
	public int getFirstPossibility() {
		for (int i = 0; i < possibilities.length; i++) {
			if (possibilities[i] == true)
				return i;
		}
		return 0;
	}
	
	public void setNumber(int n) {
		if (n <= possibilities.length && n > 0) {
			for (int i = 0; i < possibilities.length; i++) {
				if (i == (n - 1)) {
					possibilities[i] = true;
				}
				else {
					possibilities[i] = false;
				}
			}
		}
	}
	
	public int isFound() { // returns the found number for this square. returns 0 if not found.
		int found = 0;
		
		for (int i = 0; i < possibilities.length; i++) {
			if (possibilities[i] == true) {
				if (found != 0)
					return 0; // this means there are still multiple possibilities
				else
					found = i + 1;
			}
		}
		
		// if program comes to here and found is still 0, it means there are no possibilities for this square => there is an error
		return found;
	}
	
	public boolean isError() {
		for (int i = 0; i < possibilities.length; i++) {
			if (possibilities[i] == true) {
				return false;
			}
		}
		
		return true;
	}
}