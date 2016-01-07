package chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChessGame {
	public static void main(String[] args) throws java.io.IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean exit = false;
		String consoleIn = "consoleIn";

		System.out.println("Welcome to Console Chess!");
		System.out.println("Enter your commands or 'help' for help: ");
		do {
			consoleIn = br.readLine();
			exit = handleConsoleInput(consoleIn);
		} while(!consoleIn.equals("exit"));
		
		System.out.println("Thank you for playing!");
		System.out.println("Console Chess will now exit");
		
	}

	private static boolean handleConsoleInput(String inputString) {
		System.out.println("Console Input was: " + inputString);
		return inputString.equals("exit");
	}
	
}
