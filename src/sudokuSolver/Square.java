package sudokuSolver;

public class Square {
	private boolean possibilities[] = {true, true, true, true, true, true, true, true, true};

	public boolean[] getPossibilities() {
		return possibilities;
	}

	public void setPossibilities(boolean possibilities[]) {
		this.possibilities = possibilities;
	}
	
	public boolean isFound() {
		boolean found = false;
		
		for (int i = 0; i < possibilities.length; i++) {
			if (possibilities[i] == true) {
				if (found)
					return false;
				else
					found = true;
			}
		}
		
		// if program comes to here and found is still false, it means there are no possiblities for this square => there is an errror
		
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