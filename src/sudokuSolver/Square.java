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

	public boolean[] getPossibilities() {
		return possibilities;
	}

	public void setPossibilities(boolean possibilities[]) {
		this.possibilities = possibilities;
	}
	
	public int isFound() { // returns the found number for this square. returns 0 if not found.
		int found = 0;
		
		for (int i = 0; i < possibilities.length; i++) {
			if (possibilities[i] == true) {
				if (found != 0)
					return 0;
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
	
	public void printNumber() {
		if (isError())
			System.out.print("x");
		else
			System.out.print(isFound());
	}
}