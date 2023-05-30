import java.util.Scanner;

public class Main {
	// player one and two pieces (Tanish)

	public static void main(String[] args) {
		// create a new instance of the Gomoku game (Tanish - made changes to User Experience by accepting playernames and give a feeling of game loading/progression)
		GoMoKu game = new GoMoKu();
		//creates a scanner object (Tanish)
		Scanner scanner = new Scanner(System.in);
		//asks the user to enter the name of the player1 (Tanish)
		System.out.println("Enter the name of Player1: ");
		//accept the name of player1 (Tanish)
		String player1 = scanner.next();
		//asks the user to enter the name of the player2 (Tanish)
		System.out.println("Enter the name of Player2: ");
		//accept the name of player2 (Tanish)
		String player2 = scanner.next();
		//Starts with player1 (Tanish)
		char currentPlayer = 'X';
		String player = player1;
		//the main game loop (Tanish)
		while (true) {
			//prints the current board
			System.out.println("Current board:");
			game.print();

			// Prompt the player to place their stone (Tanish)
			System.out.println("Loading...");
			System.out.println(player
					+ ", enter the (X,Y) coordinates to place your stone and make sure it's seperated by a space (EX: 1 1). Now good luck you do it:");
			//accept the x coordinate
			int x = scanner.nextInt() - 1;
			//accept the y coordinate
			int y = scanner.nextInt() - 1;

			// Place the stone and check for a win (Ryan and Tanish)
			if (game.placeStone(y, x, currentPlayer)) {
				if (game.winner(currentPlayer)) {
					System.out.println(player + " wins!");
					//checks who won by playername (Tanish)
					break;
				} else {
				//switches the player (Tanish - Prompt using playernames)
					if(currentPlayer == 'X') {
						player = player2;
						currentPlayer = 'O';
					}
					else {
						player = player1;
						currentPlayer = 'X';
					}
				}
			} else {
			//prints the message if the player entered a pre-occupied spot! (Tanish)
				System.out.println("This place has already been occupied. Please select a different spot!");
			}
		}
		//closes the scanner object
		scanner.close();
	}
}