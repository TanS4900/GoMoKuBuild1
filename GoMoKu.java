public class GoMoKu {
	//setting the board size as 19 instead of 15(Tanish)
	private static final int SIZE = 19;
	//creating a 2D character array as board (Ryan)
	private char[][] board;

	//constructor (Ryan & Tanish)
	public GoMoKu() {
		//create a board of size of 19x19 (Tanish made it 19x19 and more efficient by using loop)
		board = new char[SIZE][SIZE];
		//fills the board with the hyphens (Ryan)
		for (int row = 0; row < board.length; row++) {
		//for loop for the entire row (Tanish & Ryan)
			for (int col = 0; col < board[row].length; col++) {
			//loop for the entire columns in the row (Tanish did the board[row].length but Ryan did main coding)
				board[row][col] = '-';
				//assigns hyphens to each cell of the board (Ryan)
			}
		}
	}

	// prints the entire board (Inital: Ryan & Changes: Tanish)
	public void print() {
		//for loop for the entire row (Tanish modified "for loop" & cleaned it up)
		for (int row = 0; row < board.length; row++) {
			//loop for the entire columns in the row (Tanish edited & cleaned it up)
			for (int col = 0; col < board[row].length; col++) { 
				//prints the rows & columns of the board separated by space (Ryan)
				System.out.print(board[row][col] + " ");
			}
			//prints the new line after each row (Ryan)
			System.out.println();
		}
	}

	// place a stone based on row and column (Tanish redid this part & cleaned it up)
	public boolean placeStone(int r, int c, char placeholder) {
		//checks for the given row & column is empty (Tanish)
		if (board[r][c] == '-') {
			//if it's empty it places a stone and returns true (Tanish)
			board[r][c] = placeholder;
			return true;
		}
		//returns false if it's not empty
		return false;
	}

	//this checks the different types of wins on the board (Tanish reworked/modified this section. Ryan has slightly different version of this)
	public boolean winner(char stone) {
		//Checks for a horizontal win (Tanish edited/cleaned it up)
		for (int row = 0; row < board.length; row++) {
			//stores the count as 0 (Tanish)
			int count = 0;
			//checks the column in that row (Tanish edited/cleaned it up)
			for (int col = 0; col < board[row].length; col++) {
				//counts the number of stones (Tanish edited/cleaned it up)
				if (board[row][col] == stone) {
					count++;
				} else {
					count = 0;
				}
				//if number of stones is 5 it shows a win (Ryan/Tanish maintained same count)
				if (count == 5) {
					return true;
				}
			}
		}

		//Checks for a vertical win (Tanish reworked/modified this section. Ryan has slightly different version of this)
		for (int row = 0; row < board.length; row++) {
			int count = 0;
			//goes to each row (Tanish)
			for (int col = 0; col < board[row].length; col++) {
			//goes to each column (Tanish)
				//checks for the number of stones column wise (Tanish)
				if (board[col][row] == stone) {
					count++;
				} else {
					count = 0;
				}
				//if the stone count is equal to 5 it returns a win! (Ryan & Tanish maintained same winner count)
				if (count == 5) {
					return true;
				}
			}
		}

		//Checks for a diagonal win (Top left to Bottom) (Tanish reworked/modified this section. Ryan has slightly different version of this)
		for (int row = 0; row < board.length - 4; row++) {
		//goes by each row  (Tanish)
			for (int col = 0; col < board[row].length - 4; col++) {
			//goes by each column (Tanish)
				int count = 0; 
				//check for the number of stones in the left diagonal (Tanish)
				for (int d = 0; d < 5; d++) {
					if (board[row + d][col + d] == stone) {
						count++;
					} else {
						count = 0;
					}
					//if the stone count is equal to 5 it returns a win! (Ryan and Tanish maintain same winner count)
					if (count == 5) {
						return true;
					}
				}
			}
		}

		// Check for diagonal win (bottom left to top right) (Tanish modified/redid the section different from Ryan) 
		for (int row = 0; row < board.length - 4; row++) {
		//goes by each row (Tanish)
			for (int col = board[row].length - 1; col >= 4; col--) {
			//goes by each column (Tanish)
				int count = 0;
				//check for the number of stones in the left diagonal (Tanish)
				for (int d = 0; d < 5; d++) {
					if (board[row + d][col - d] == stone) {
						count++;
					} else {
						count = 0;
					}
					//if the stone count is equal to 5 it returns a win! (Ryan & Tanish have the same winner count)
					if (count == 5) {
						return true;
					}
				}
			}
		}
		//if no win then it returns false 
		return false;
	}
}