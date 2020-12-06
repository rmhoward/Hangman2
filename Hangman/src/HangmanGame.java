import dictionary.DictionaryReader;
import hangman.Hangman;
import hangman.HangmanEvil;
import hangman.HangmanTraditional;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * All functionality for the hangman game included here.
 * Will draw upon other packages and classes to run the game correctly
 * @author ---UPDATE THIS---
 */
public class HangmanGame {

	/**
	 * Method which returns a version of hangman to play randomly
	 * @param wordList to use in the version of hangman
	 * @return version of hangman to play
	 */
	private Hangman getHangmanVersion(ArrayList<String> wordList) {
		
		//randomly determine which version to play
		boolean game = new Random().nextBoolean();
		Hangman hangman = game ? new HangmanTraditional(wordList)
					: new HangmanEvil(wordList);
		
		return hangman;
	}
	
	
	
	/**
	 * Play Hangman with a dictionary file of words with the given textfile (one for debug)
	 * @param fileName for the dictionary file
	 */
	private void playGame(String fileName) {
		
		//create hangman directory -WE NEED TO CHANGE TO DICTIONARY READER
		ArrayList<String> wordList = DictionaryReader.readWordsFromDictionary(fileName);
		
		boolean gameOver = false;
		Scanner scanner = new Scanner(System.in);
		
		while (!gameOver) {
			
			Hangman hangman = this.getHangmanVersion(wordList);
			
			System.out.println("Welcome to Hangman!");
			
			this.playGame(hangman, scanner);
			
			System.out.println("Play again? Y/N");
			String choice = scanner.nextLine();
			if (choice.equalsIgnoreCase("N")) {
				gameOver = false;
			} else {
				gameOver = true;
			}
		}
	}


	
	/**
	 * Play a single game of the given hangman
	 * IS THIS DEBUG?? -Ben
	 * @param hangman to play
	 * @param scanner for user input
	 */
	private void playGame(Hangman hangman, Scanner scanner) {

		boolean gameWon = false;
		String chosenLetter;
		
		hangman.pickWord();
		
		//I'M REALLY NOT SURE WHAT THIS DOES - Ben
		this.printRound(hangman, "Guess a letter");
		
		while(!gameWon) {
			if (scanner.hasNext()) {
				chosenLetter = scanner.nextLine();
				chosenLetter = chosenLetter.trim();
				
				if (chosenLetter.length() != 1
					|| !Pattern.matches("[a-z]",  chosenLetter)) {
				this.printRound(hangman, "Please guess a single lower-case letter.");
				} else {
					if (hangman.guessed(chosenLetter)) {
						System.out.println("You already guessed that letter!");
					} else {
						hangman.findAndMarkLetter(chosenLetter);
					}
					
					gameWon = hangman.checkLetters();
					
					if (gameWon) {
						System.out.println("You guessed the word correctly!");
						this.printRound(hangman);
						//TODO: print the version of hangman that the player was playing
					} else {
						this.printRound(hangman, "Guess a letter");
					}
				}
			}
		}
	}

	/**
	 * Prints information about the current round of the given game of hangman
 	 * @param hangman game for round
	 */
	private void printRound(Hangman hangman) {
		this.printRound(hangman, "");
	}



	public static void main(String[] args) {
		String wordsClean = "words_clean.txt";
		String words = "words.txt";
		HangmanGame hangmanGame = new HangmanGame();
		hangmanGame.playGame(wordsClean);
		hangmanGame.playGame(words);
	}

}

