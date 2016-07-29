import java.util.*;
//dario vitorte
public class connectFour {
	private static boolean foundWinner = false;
	private static boolean SP = false;

	public static void main(String[] args) {
		//board
		String[][] board = new String[6][7];
		//menu
		Scanner menu = new Scanner (System.in);
		boolean ans = false;
		int x = 0;
		while (ans == false) {
			System.out.println("type 1 for player vs player");
			System.out.println("type 2 for player vs ez comp");
			System.out.println("type 3 for player vs hard comp");
			System.out.println("type 4 for comp vs comp");
			System.out.println("type 5 to quit");
			System.out.print("enter your answer: ");

			String v = menu.nextLine();
			if (v.equals("1") || v.equals("2") || v.equals("3") || v.equals("4") || v.equals("5")) {
				x = Integer.parseInt(v); // converting to integer

				System.out.println();
				ans = true;
			}
			else {
				System.out.println("INVALID ANSWER!");
			}

		}
		// tests to see what player wants to play.
		if (x == 1) {
			human(board);
		}
		if (x == 2) {
			ezComp(board);
		}
		if (x == 3) {
			hardComp(board);
		}
		if (x == 4) {
			compVScomp(board);
		}
		else {
			System.out.println("INVALID ANSWER!");
		}

	}
	//methods
	public static void printBoard(String board[][]) {
		System.out.println();
		System.out.println("1 2 3 4 5 6 7");
		System.out.println("+ + + + + + +");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);

			}
			System.out.println();

		}
	}
	public static void human(String board[][]) {
		//sets up the board
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = "~ ";
			}
		}
		//prints the board
		printBoard(board);

		//play
		Scanner play = new Scanner (System.in);
		while (foundWinner == false) {
			
			boolean has = false;
			int col = 0;
			while (has == false) {
				//player1 plays
				System.out.print("P1: Type the column to play in: ");
				String col1 = play.nextLine();

				if (col1.equals("1") || col1.equals("2") || col1.equals("3") || col1.equals("4") || col1.equals("5")|| col1.equals("6") || col1.equals("7")) {
					col = Integer.parseInt(col1);
					has = true;
				}
				else {
					System.out.println("INVALID ANSWER!");
				}
			}
			for (int row = 5; row >= 0; row--) {
				if (board[row][col-1] == "~ ") {
					board[row][col-1] = "O ";
					break;

				}


			}
			//runs methods to see if game needs to be stopped.
			cats(board);
			checkWinner(board);
			printBoard(board);
			if (foundWinner == true) {
				break;
			}

			//player2 plays
			boolean has2 = false;
			int col2 = 0;
			while (has2 == false) {
				System.out.print("P2: Type the column to play in: ");
				String col12 = play.nextLine();

				if (col12.equals("1") || col12.equals("2") || col12.equals("3") || col12.equals("4") || col12.equals("5")|| col12.equals("6") || col12.equals("7")) {
					col2 = Integer.parseInt(col12);
					has2 = true;
				}
				else {
					System.out.println("INVALID ANSWER!");
				}
			}
			for (int row = 5; row >= 0; row--) {
				if (board[row][col2-1] == "~ ") {
					board[row][col2-1] = "C ";
					break;

				}


			}
			//runs methods to see if game needs to be stopped.
			cats(board);
			checkWinner(board);
			printBoard(board);
			if (foundWinner == true) {
				break;
			}

		}
		//if game is over or cats game run main menu
		if (foundWinner == true ) {
			Scanner newGame = new Scanner (System.in);
			System.out.println("Do you want to play again?");
			System.out.print("Type 1 for yes, 2 for quit, and 3 for main menu: ");
			int s = newGame.nextInt();
			if (s == 1) {
				foundWinner = false;
				human(board);
			}
			else if (s == 2) {
				System.exit(0);
			}
			else if(s == 3) {
				Scanner menu = new Scanner (System.in);
				boolean ans = false;
				int x = 0;
				while (ans == false) {
					System.out.println("type 1 for player vs player");
					System.out.println("type 2 for player vs ez comp");
					System.out.println("type 3 for player vs hard comp");
					System.out.println("type 4 for comp vs comp");
					System.out.println("type 5 to quit");
					System.out.print("enter your answer: ");
					String v = menu.nextLine();
					if (v.equals("1") || v.equals("2") || v.equals("3") || v.equals("4") || v.equals("5")) {
						x = Integer.parseInt(v);

						System.out.println();
						ans = true;
					}
					else {
						System.out.println("INVALID ANSWER!");
					}

				}
				if (x == 1) {
					foundWinner = false;
					human(board);
				}
				if (x == 2) {
					foundWinner = false;
					ezComp(board);
				}
				if (x == 3) {
					foundWinner = false;
					hardComp(board);
				}
				if (x == 4) {
					foundWinner = false;
					compVScomp(board);
				}

			}
			else {
				System.out.print("Invalid Answer!!");
			}

		}

	}
	public static void ezComp(String board[][]) {
		//sets up the board
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = "~ ";
			}
		}
		//prints the board
		printBoard(board);

		//play
		Scanner play = new Scanner (System.in);
		while (foundWinner == false) {
			//player1 plays
			boolean has = false;
			int col = 0;
			while (has == false) {
				System.out.print("P1: Type the column to play in: ");
				String col1 = play.nextLine();

				if (col1.equals("1") || col1.equals("2") || col1.equals("3") || col1.equals("4") || col1.equals("5")|| col1.equals("6") || col1.equals("7")) {
					col = Integer.parseInt(col1);
					has = true;
				}
				else {
					System.out.println("INVALID ANSWER!");
				}
			}
			for (int row = 5; row >= 0; row--) {
				if (board[row][col-1] == "~ ") {
					board[row][col-1] = "O ";
					break;

				}


			}
			//runs methods to see if game needs to be stopped.
			cats(board);
			checkWinner(board);
			printBoard(board);
			if (foundWinner == true) {
				break;
			}

			//computer plays
			System.out.println("Computers Turn");
			int col2 = 1 + (int)(Math.random() * 7); 
			for (int row = 5; row >= 0; row--) {
				if (board[row][col2-1] == "~ ") {
					//adds a delay so its not instant
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					board[row][col2-1] = "C ";
					break;

				}



			}
			//runs methods to see if game needs to be stopped.
			cats(board);
			checkWinner(board);
			printBoard(board);
			if (foundWinner == true) {
				break;
			}

		}
		//if winner is found
		if (foundWinner == true ) {
			Scanner newGame = new Scanner (System.in);
			System.out.println("Do you want to play again?");
			System.out.print("Type 1 for yes, 2 for quit, and 3 for main menu: ");
			int s = newGame.nextInt();
			if (s == 1) {
				foundWinner = false;
				ezComp(board);
			}
			else if (s == 2) {
				System.exit(0);
			}
			else if(s == 3) {
				Scanner menu = new Scanner (System.in);
				boolean ans = false;
				int x = 0;
				while (ans == false) {
					System.out.println("type 1 for player vs player");
					System.out.println("type 2 for player vs ez comp");
					System.out.println("type 3 for player vs hard comp");
					System.out.println("type 4 for comp vs comp");
					System.out.println("type 5 to quit");
					System.out.print("enter your answer: ");
					String v = menu.nextLine();
					if (v.equals("1") || v.equals("2") || v.equals("3") || v.equals("4") || v.equals("5")) {
						x = Integer.parseInt(v);

						System.out.println();
						ans = true;
					}
					else {
						System.out.println("INVALID ANSWER!");
					}
				}
				if (x == 1) {
					foundWinner = false;
					human(board);
				}
				if (x == 2) {
					foundWinner = false;
					ezComp(board);
				}
				if (x == 3) {
					foundWinner = false;
					hardComp(board);
				}
				if (x == 4) {
					foundWinner = false;
					compVScomp(board);
				}

			}
			else {
				System.out.print("Invalid Answer");
			}

		}


	}
	public static void hardComp(String board[][]) {
		//sets up the board
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = "~ ";
			}
		}
		//prints the board
		printBoard(board);

		//play
		Scanner play = new Scanner (System.in);
		while (foundWinner == false) {
			//player1 plays
			boolean has = false;
			int col = 0;
			while (has == false) {
				System.out.print("P1: Type the column to play in: ");
				String col1 = play.nextLine();

				if (col1.equals("1") || col1.equals("2") || col1.equals("3") || col1.equals("4") || col1.equals("5")|| col1.equals("6") || col1.equals("7")) {
					col = Integer.parseInt(col1);
					has = true;
				}
				else {
					System.out.println("INVALID ANSWER!");
				}
			}
			for (int row = 5; row >= 0; row--) {
				if (board[row][col-1] == "~ ") {
					board[row][col-1] = "O ";
					break;

				}


			}
			//runs methods to see if game needs to be stopped.
			SP = false;
			cats(board);
			checkWinner(board);
			printBoard(board);
			if (foundWinner == true) {
				break;
			}
			//hard computer plays
			SC(board);
			if (SP == false) {
				int col2 = 1 + (int)(Math.random() * 7); 
				for (int row = 5; row >= 0; row--) {
					if (board[row][col2-1] == "~ ") {
						//adds a delay so its not instant
						try {
							Thread.sleep(450);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						board[row][col2-1] = "C ";
						break;

					}

				}
			}
			//runs methods to see if game needs to be stopped.
			cats(board);
			SP = false;
			checkWinner(board);
			printBoard(board);
			if (foundWinner == true) {
				break;
			}

		}
		if (foundWinner == true) {
			Scanner newGame = new Scanner (System.in);
			System.out.println("Do you want to play again?");
			System.out.print("Type 1 for yes, 2 for quit, and 3 for main menu: ");
			int s = newGame.nextInt();
			if (s == 1) {
				foundWinner = false;
				hardComp(board);
			}
			else if (s == 2) {
				System.exit(0);
			}
			else if(s == 3) {
				Scanner menu = new Scanner (System.in);
				boolean ans = false;
				int x = 0;
				while (ans == false) {
					System.out.println("type 1 for player vs player");
					System.out.println("type 2 for player vs ez comp");
					System.out.println("type 3 for player vs hard comp");
					System.out.println("type 4 for comp vs comp");
					System.out.println("type 5 to quit");
					System.out.print("enter your answer: ");
					String v = menu.nextLine();
					if (v.equals("1") || v.equals("2") || v.equals("3") || v.equals("4") || v.equals("5")) {
						x = Integer.parseInt(v);

						System.out.println();
						ans = true;
					}
					else {
						System.out.println("INVALID ANSWER!");
					}
				}
				if (x == 1) {
					foundWinner = false;
					human(board);
				}
				if (x == 2) {
					foundWinner = false;
					ezComp(board);
				}
				if (x == 3) {
					foundWinner = false;
					hardComp(board);
				}
				if (x == 4) {
					foundWinner = false;
					compVScomp(board);
				}

			}
			else {
				System.out.print("Invalid Answer");
			}

		}

	}


	public static void compVScomp(String board[][]) {
		//sets up the board
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = "~ ";
			}
		}
		//prints the board
		printBoard(board);

		//play
		while (foundWinner == false) {

			//computer1 plays
			System.out.println("Computer1 Turn");
			int col = 1 + (int)(Math.random() * 7); 
			for (int row = 5; row >= 0; row--) {
				if (board[row][col-1] == "~ ") {
					//adds a delay so its not instant
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					board[row][col-1] = "O ";
					break;

				}




			}
			//runs methods to see if game needs to be stopped.
			cats(board);
			checkWinner(board);
			printBoard(board);
			if (foundWinner == true) {
				break;
			}

			//computer2 plays
			System.out.println("Computer2 Turn");
			int col2 = 1 + (int)(Math.random() * 7); 
			for (int row = 5; row >= 0; row--) {
				if (board[row][col2-1] == "~ ") {
					//adds a delay so its not instant
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) { 
						e.printStackTrace();
					}
					board[row][col2-1] = "C ";
					break;

				}



			}
			//runs methods to see if game needs to be stopped.
			cats(board);
			checkWinner(board);
			printBoard(board);
			if (foundWinner == true) {
				break;
			}

		}
		//if winner is found
		if (foundWinner == true) {
			Scanner newGame = new Scanner (System.in);
			System.out.println("Do you want to play again?");
			System.out.print("Type 1 for yes, 2 for quit, and 3 for main menu: ");
			int s = newGame.nextInt();
			if (s == 1) {
				foundWinner = false;
				compVScomp(board);
			}
			else if (s == 2) {
				System.exit(0);
			}
			else if(s == 3) {
				Scanner menu = new Scanner (System.in);
				boolean ans = false;
				int x = 0;
				while (ans == false) {
					System.out.println("type 1 for player vs player");
					System.out.println("type 2 for player vs ez comp");
					System.out.println("type 3 for player vs hard comp");
					System.out.println("type 4 for comp vs comp");
					System.out.println("type 5 to quit");
					System.out.print("enter your answer: ");
					String v = menu.nextLine();
					if (v.equals("1") || v.equals("2") || v.equals("3") || v.equals("4") || v.equals("5")) {
						x = Integer.parseInt(v);

						System.out.println();
						ans = true;
					}
					else {
						System.out.println("INVALID ANSWER!");
					}
				}
				if (x == 1) {
					foundWinner = false;
					human(board);
				}
				if (x == 2) {
					foundWinner = false;
					ezComp(board);
				}
				if (x == 3) {
					foundWinner = false;
					hardComp(board);
				}
				if (x == 4) {
					foundWinner = false;
					compVScomp(board);
				}

			}
			else {
				System.out.print("Invalid Answer");
			}

		}

	}
	//VERY LONG CODE TO CHECK FOR WINNER
	//checkWinner code! help from dad with math and keyboard with c+p
	public static void checkWinner(String[][] board) {      
		foundWinner = false;
		//diagonal checks
		for (int i = 5; i > 2; i-- ) {
			for(int j = 0; j < 4; j++) {
				if (   board[i][j] == "O " &&
						board[i-1][j+1] == "O " &&
						board[i-2][j+2] == "O " &&
						board[i-3][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i-1][j+1] == "C " &&
						board[i-2][j+2] == "C " &&
						board[i-3][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
				else {
					break;
				}
			}
		}

		//runs in column 1
		for (int i = 5; i > 2; i--) {
			for (int j = 1; j < 4; j++) {
				if (board[i][j] == "O " &&
						board[i-1][j+1] == "O " &&
						board[i-2][j+2] == "O " &&
						board[i-3][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i-1][j+1] == "C " &&
						board[i-2][j+2] == "C " &&
						board[i-3][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}
		//running from the top to the bottom
		for (int i = 0; i <= 2; i++) {
			for (int j = 4; j < 7; j++) {
				if (   board[i][j] == "O " &&
						board[i+1][j-1] == "O " &&
						board[i+2][j-2] == "O " &&
						board[i+3][j-3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j-1] =="C " &&
						board[i+2][j-2] =="C " &&
						board[i+3][j-3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}
		//runs from bottom to top right side
		for (int i = 1; i < 2; i++) {
			for (int j = 6; j > 5; j--) {
				if (   board[i][j] == "O " &&
						board[i+1][j-1] == "O " &&
						board[i+2][j-2] == "O " &&
						board[i+3][j-3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j-1] == "C " &&
						board[i+2][j-2] == "C " &&
						board[i+3][j-3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}
		//left side
		for (int i = 4; i < 5; i++){
			for (int j = 2; j < 3; j++){
				if (board[i][j] == "O " &&
						board[i-1][j+1] == "O " &&
						board[i-2][j+2] == "O " &&
						board[i-3][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i-1][j+1] == "C " &&
						board[i-2][j+2] == "C " &&
						board[i-3][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}
		//left side top bottom
		for (int i = 0; i <= 2; i++) {
			for (int j = 3; j > 0; j--) {
				if (board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C " &&
						board[i+3][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}
		
		for(int i =0; i < 1; i++) {
			for (int j = 0; j <1; j++) {
				if (board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C " &&
						board[i+3][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int j = 0; j < 1; j++) {
			for(int i =1 ; i < 3; i++) {
				if (board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C " &&
						board[i+3][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int j = 3; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				if (board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C " &&
						board[i+3][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 2; i < 3; i++) {
			for (int j = 2; j > 0; j--) {
				if (board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] =="C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C " &&
						board[i+3][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 2; j < 3; j++){
				if (board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C " &&
						board[i+3][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 1; j < 2; j++){
				if (board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				} 
				else if (board[i][j] =="C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C " &&
						board[i+3][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		//vertical checks

		for (int i = 5; i > 2; i-- ) {
			for(int j = 0; j < 4; j++) {
				if (   board[i][j] == "O " &&
						board[i-1][j] == "O " &&
						board[i-2][j] == "O " &&
						board[i-3][j] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i-1][j] == "C " &&
						board[i-2][j] == "C " &&
						board[i-3][j] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}


		for (int i = 5; i > 1; i--) {
			for (int j = 1; j < 4; j++) {
				if (board[i][j] == "O " &&
						board[i-1][j] == "O " &&
						board[i-2][j] == "O " &&
						board[i-3][j] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i-1][j] == "C " &&
						board[i-2][j] == "C " &&
						board[i-3][j] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 0; i <= 2; i++) {
			for (int j = 4; j < 7; j++) {
				if (   board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j] =="C " &&
						board[i+2][j] =="C " &&
						board[i+3][j] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 6; j > 5; j--) {
				if (   board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 4; i < 5; i++){
			for (int j = 2; j < 3; j++){
				if (board[i][j] == "O " &&
						board[i-1][j] == "O " &&
						board[i-2][j] == "O " &&
						board[i-3][j] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i-1][j] == "C " &&
						board[i-2][j] == "C " &&
						board[i-3][j] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 0; i <= 2; i++) {
			for (int j = 3; j > 0; j--) {
				if (board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for(int i =0; i < 1; i++) {
			for (int j = 0; j <1; j++) {
				if (board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int j = 0; j < 1; j++) {
			for(int i =1 ; i < 3; i++) {
				if (board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int j = 3; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				if (board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 2; i < 3; i++) {
			for (int j = 2; j > 0; j--) {
				if (board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] =="C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 2; j < 3; j++){
				if (board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 1; j < 2; j++){
				if (board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				} 
				else if (board[i][j] =="C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}
		//horizontal checks

		for (int i = 5; i >= 0; i-- ) {
			for(int j = 0; j < 4; j++) {
				if (   board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}


		for (int i = 5; i > 1; i--) {
			for (int j = 1; j < 4; j++) {
				if (board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 4; j < 7; j++) {
				if (   board[i][j] == "O " &&
						board[i][j-1] == "O " &&
						board[i][j-2] == "O " &&
						board[i][j-3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i][j-1] =="C " &&
						board[i][j-2] =="C " &&
						board[i][j-3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 6; j > 5; j--) {
				if (   board[i][j] == "O " &&
						board[i][j-1] == "O " &&
						board[i][j-2] == "O " &&
						board[i][j-3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i][j-1] == "C " &&
						board[i][j-2] == "C " &&
						board[i][j-3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 4; i < 5; i++){
			for (int j = 2; j < 3; j++){
				if (board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 3; j > 0; j--) {
				if (board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for(int i =0; i < 1; i++) {
			for (int j = 0; j <1; j++) {
				if (board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int j = 0; j < 1; j++) {
			for(int i =1 ; i < 3; i++) {
				if (board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int j = 3; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				if (board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 2; i < 3; i++) {
			for (int j = 2; j > 0; j--) {
				if (board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] =="C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 2; j < 3; j++){
				if (board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				}
				else if (board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 1; j < 2; j++){
				if (board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "O ") {
					System.out.println("Player 1 Wins!");
					foundWinner = true;
					break;
				} 
				else if (board[i][j] =="C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "C ") {
					System.out.println("Player 2 Wins!");
					foundWinner = true;
					break;
				}
			}
		}
	}

	//smart computer play. help from checkWinner method
	public static void SC(String[][] board) {      
		//diagonal checks
		//while (SP = false) {
		for (int i = 5; i > 1; i-- ) {
			for(int j = 0; j < 4; j++) {
				if ( board[i][j] == "O " &&
						board[i-1][j+1] == "O " &&
						board[i-2][j+2] == "O " &&
						board[i-3][j+3] == "~ " 

				) {
					board[i-3][j+3] = "C ";
					SP = true;
					break;
				}

				else if (board[i][j] == "C " &&
						board[i-1][j+1] == "C " &&
						board[i-2][j+2] == "C " &&
						board[i-3][j+3] == "~ " 

				) {
					board[i-3][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}



		for (int i = 5; i > 1; i--) {
			for (int j = 1; j < 4; j++) {
				if (
						board[i][j] == "O " &&
						board[i-1][j+1] == "O " &&
						board[i-2][j+2] == "O " && 
						board[i-3][j+3] == "~ " 

				) {
					board[i-3][j+3] = "C ";
					SP = true;
					break;
				}
				else if ( board[i][j] == "C " &&
						board[i-1][j+1] == "C " &&
						board[i-2][j+2] == "C " &&
						board[i-3][j+3] == "~ " 

				) {
					board[i-3][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 0; i <= 2; i++) {
			for (int j = 4; j < 7; j++) {
				if (
						board[i][j] == "O " &&
						board[i+1][j-1] == "O " &&
						board[i+2][j-2] == "O " &&
						board[i+3][j-3] == "~ " 

				) {
					board[i+3][j-3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i+1][j-1] =="C " &&
						board[i+2][j-2] =="C " &&
						board[i+3][j-3] == "~ " 

				) {
					board[i+3][j-3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 6; j > 5; j--) {
				if (
						board[i][j] == "O " &&
						board[i+1][j-1] == "O " &&
						board[i+2][j-2] == "O " &&
						board[i+3][j-3] == "~ " &&
						board[i+4][j-3] == "O " || board[i+4][j-3] == "C "
				) {
					board[i+3][j-3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i+1][j-1] == "C " &&
						board[i+2][j-2] == "C " &&
						board[i+3][j-3] == "~ " &&
						board[i+4][j-3] == "O " || board[i+4][j-3] == "C "
				) {
					board[i+3][j-3] = "C ";

					SP = true;
					break;
				}
			}
		}

		for (int i = 4; i < 5; i++){
			for (int j = 2; j < 3; j++){
				if (
						board[i][j] == "O " &&
						board[i-1][j+1] == "O " &&
						board[i-2][j+2] == "O " &&
						board[i-3][j+3] == "~ " 

				) {
					board[i-3][j+3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i-1][j+1] == "C " &&
						board[i-2][j+2] == "C " &&
						board[i-3][j+3] == "~ " 

				) {
					board[i-3][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 0; i <= 2; i++) {
			for (int j = 3; j > 0; j--) {
				if (
						board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "~ " 

				) {
					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
				else if ( board[i][j] == "C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C " &&
						board[i+3][j+3] == "~ " 

				) {
					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for(int i =0; i < 1; i++) {
			for (int j = 0; j <1; j++) {
				if (
						board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "~ " 

				) {
					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
				else if ( board[i][j] == "C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C " &&
						board[i+3][j+3] == "~ " 

				) {

					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int j = 0; j < 1; j++) {
			for(int i =1 ; i < 3; i++) {
				if (
						board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "~ " 

				) {

					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
				else if ( board[i][j] == "C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C " &&
						board[i+3][j+3] == "~ " 

				) {
					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int j = 3; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				if (
						board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "~ " 

				) {
					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C " &&
						board[i+3][j+3] == "~ " 
				) {

					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 2; i < 3; i++) {
			for (int j = 2; j > 0; j--) {
				if (
						board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "~ " 

				) {
					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] =="C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C "&&
						board[i+3][j+3] == "~ " 
				) {

					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 2; j < 3; j++){
				if (
						board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "~ " 
				) {

					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C "&& board[i+3][j+3] == "~ " 
				) {
					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 1; j < 2; j++){

				if (  board[i][j] == "O " &&
						board[i+1][j+1] == "O " &&
						board[i+2][j+2] == "O " &&
						board[i+3][j+3] == "~ " 
				) {
					board[i+3][j+3] = "C ";
					SP = true;

					break;
				} 
				else if (  board[i][j] =="C " &&
						board[i+1][j+1] == "C " &&
						board[i+2][j+2] == "C "&&
						board[i+3][j+3] == "~ " 
				) {

					board[i+3][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		//vertical checks

		for (int i = 5; i > 2; i-- ) {
			for(int j = 0; j < 4; j++) {
				if (
						board[i][j] == "O " &&
						board[i-1][j] == "O " &&
						board[i-2][j] == "O " &&
						board[i-3][j] == "~ "
				) {
					board[i-3][j] = "C ";
					SP = true;
					break;
				}
				else if (   board[i][j] == "C " &&
						board[i-1][j] == "C " &&
						board[i-2][j] == "C " && 
						board[i-3][j] == "~ ") {

					board[i-3][j] = "C ";
					SP = true;
					break;
				}
			}
		}


		for (int i = 5; i > 1; i--) {
			for (int j = 1; j < 4; j++) {
				if (
						board[i][j] == "O " &&
						board[i-1][j] == "O " &&
						board[i-2][j] == "O " &&
						board[i-3][j] == "~ ") {

					board[i-3][j] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i-1][j] == "C " &&
						board[i-2][j] == "C " &&
						board[i-3][j] == "~ ") {

					board[i-3][j] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 0; i <= 2; i++) {
			for (int j = 4; j < 7; j++) {
				if (
						board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "~ ") {
					board[i+3][j] = "C ";
					SP = true;

					break;
				}
				else if (  board[i][j] == "C " &&
						board[i+1][j] =="C " &&
						board[i+2][j] =="C " && board[i+3][j] == "~ " ) {
					board[i+3][j] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 6; j > 5; j--) {
				if (
						board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "~ ") {
					board[i+3][j] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " && board[i+3][j] == "~ ") {
					board[i+3][j] = "C ";
					SP = true;

					break;
				}
			}
		}

		for (int i = 4; i < 5; i++){
			for (int j = 2; j < 3; j++){
				if (
						board[i][j] == "O " &&
						board[i-1][j] == "O " &&
						board[i-2][j] == "O " &&
						board[i-3][j] == "~ ") {
					board[i-3][j] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i-1][j] == "C " &&
						board[i-2][j] == "C " &&
						board[i-3][j] == "~ ") {

					board[i-3][j] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 0; i <= 2; i++) {
			for (int j = 3; j > 0; j--) {
				if (
						board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "~ ") {
					board[i+3][j] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "~ ") {
					board[i+3][j] = "C ";
					SP = true;
					break;
				}
			}
		}

		for(int i =0; i < 1; i++) {
			for (int j = 0; j <1; j++) {
				if (
						board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "~ ") {
					board[i+3][j] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "~ ") {

					board[i+3][j] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int j = 0; j < 1; j++) {
			for(int i =1 ; i < 3; i++) {
				if (
						board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "~ ") {

					board[i+3][j] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "~ ") {

					board[i+3][j] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int j = 3; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				if (
						board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "~ ") {

					board[i+3][j] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "~ ") {
					board[i+3][j] = "C ";
					SP = true;

					break;
				}
			}
		}

		for (int i = 2; i < 3; i++) {
			for (int j = 2; j > 0; j--) {
				if (
						board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "~ ") {

					board[i+3][j] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] =="C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "~ ") {

					board[i+3][j] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 2; j < 3; j++){
				if (
						board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "~ "  ) {

					board[i+3][j] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C " &&
						board[i+3][j] == "~ ") {

					board[i+3][j] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 1; j < 2; j++){
				if (
						board[i][j] == "O " &&
						board[i+1][j] == "O " &&
						board[i+2][j] == "O " &&
						board[i+3][j] == "~ ") {

					board[i+3][j] = "C ";
					SP = true;
					break;
				} 
				else if ( board[i][j] =="C " &&
						board[i+1][j] == "C " &&
						board[i+2][j] == "C "&&
						board[i+3][j] == "~ ") {

					board[i+3][j] = "C ";
					SP = true;
					break;
				}
			}
		}
		//horizontal checks

		for (int i = 5; i >= 0; i-- ) {
			for(int j = 0; j < 4; j++) {
				if (
						board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "~ "
				) {
					board[i][j+3] = "C ";
					SP = true;
					break;
				}
				else if (   board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "~ ") {
					board[i][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}


		for (int i = 5; i > 1; i--) {
			for (int j = 1; j < 4; j++) {
				if (
						board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 4; j < 7; j++) {
				if (
						board[i][j] == "O " &&
						board[i][j-1] == "O " &&
						board[i][j-2] == "O " &&
						board[i][j-3] == "~ ") {

					board[i][j-3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i][j-1] =="C " &&
						board[i][j-2] =="C " &&
						board[i][j-3] == "~ ") {

					board[i][j-3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 6; j > 5; j--) {
				if (
						board[i][j] == "O " &&
						board[i][j-1] == "O " &&
						board[i][j-2] == "O " &&
						board[i][j-3] == "~ ") {

					board[i][j-3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i][j-1] == "C " &&
						board[i][j-2] == "C " && board[i][j-3] == "~ ") {

					board[i][j-3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 4; i < 5; i++){
			for (int j = 2; j < 3; j++){
				if (
						board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 3; j > 0; j--) {
				if (
						board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "~ ") {
					board[i][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for(int i =0; i < 1; i++) {
			for (int j = 0; j <1; j++) {
				if (
						board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int j = 0; j < 1; j++) {
			for(int i =1 ; i < 3; i++) {
				if (
						board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int j = 3; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				if (
						board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "~ ") {
					board[i][j+3] = "C ";
					SP = true;

					break;
				}
				else if (  board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 2; i < 3; i++) {
			for (int j = 2; j > 0; j--) {
				if (
						board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "~ ") {
					board[i][j+3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] =="C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 2; j < 3; j++){
				if (
						board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
				else if (  board[i][j] == "C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 1; j < 2; j++){
				if (
						board[i][j] == "O " &&
						board[i][j+1] == "O " &&
						board[i][j+2] == "O " &&
						board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				} 
				else if (  board[i][j] =="C " &&
						board[i][j+1] == "C " &&
						board[i][j+2] == "C " && board[i][j+3] == "~ ") {

					board[i][j+3] = "C ";
					SP = true;
					break;
				}
			}
		}
		//}
	}


	public static void cats(String[][] board) {
		boolean catss = true;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == "~ ") {
					catss = false;
					break;

				}
			}
		}
		if (catss == true) {
			System.out.println("CATS GAME!");
			printBoard(board);
			Scanner menu = new Scanner (System.in);
			boolean ans = false;
			int x = 0;
			while (ans == false) {
				System.out.println("type 1 for player vs player");
				System.out.println("type 2 for player vs ez comp");
				System.out.println("type 3 for player vs hard comp");
				System.out.println("type 4 for comp vs comp");
				System.out.println("type 5 to quit");
				System.out.print("enter your answer: ");

				String v = menu.nextLine();
				if (v.equals("1") || v.equals("2") || v.equals("3") || v.equals("4") || v.equals("5")) {
					x = Integer.parseInt(v); // converting to integer

					System.out.println();
					ans = true;
				}
				else {
					System.out.println("INVALID ANSWER!");
				}

			}
			// tests to see what player wants to play.
			if (x == 1) {
				human(board);
			}
			if (x == 2) {
				ezComp(board);
			}
			if (x == 3) {
				hardComp(board);
			}
			if (x == 4) {
				compVScomp(board);
			}
			else {
				System.out.println("INVALID ANSWER!");
			}
			
			
		}
	}
}




