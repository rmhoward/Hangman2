package hangman;
import java.util.ArrayList;

/**
 * Defines functionality for different versions of Hangman.
 */
public abstract class Hangman {
	
	/**
	 * Character displayed for a hidden single letter of current word.
	 */
	public static final String HIDDEN_LETTER_CHAR = "_";
	
	/**
	 * Stores list of all words
	 */
	public ArrayList<String> wordList = new ArrayList<String>();
	
	/**
	 * Current word
	 */
	public String word;
	
	/**
	 * Correctly identified letters in current word, otherwise "_".
	 */
	public ArrayList<String> correctLetters;
		
	/**
	 * total number of guesses.
	 */
	public int guessCount;

	/**
	 * List incorrectly guessed letters.
	 */
	public ArrayList<String> incorrectGuesses = new ArrayList<String>();
	
	/**
	 * Method for initially selecting a word in a game.
	 * @return Selected word
	 */
	abstract public String pickWord();
	
	/**
	 * Locate given letter and marked as correctly identified letter
	 * @param letter to search for
	 * @return true if letter was found and marked, otherwise false
	 * 
	 */
	abstract public boolean findAndMarkLetter(String letter);
	
	/**
	 * Returns true if the given letter has been guessed and was incorrect/
	 * @param letter that was guessed
	 * @return true if letter was guessed as incorrect guess
	 */
	private boolean guessedIncorrectly(String letter) {
		return this.incorrectGuesses.contains(letter);
	}
	
	/**
	 * Returns true if the given letter is contained in the correct letters array
	 * @param letter that was guessed
	 * @return true if letter that was guessed is in the correct letters
	 */
	private boolean guessedCorrectly(String letter) {
		return this.correctLetters.contains(letter);
	}
	
	/**
	 * Returns true if the given letter has been guessed (correctly or incorrectly).
	 * @param letter that was guessed
	 * @return true if letter was guessed
	 */
	public boolean guessed(String letter) {
		return this.guessedIncorrectly(letter) || this.guessedCorrectly(letter);
	}
	
	
	
	/**
	 * determines if every letter of the random word has been guessed correctly. 
	 * Checks the letters guessed by the user against the letters of the random word. 
	 * @return true if every letter has been guessed
	 */
	
	public boolean checkLetters() {
		boolean lettersAllCheck = true;
		for (int i = 0; i < this.correctLetters.size(); i++) {
			String correctLetter = this.correctLetters.get(i);
			if (Hangman.HIDDEN_LETTER_CHAR.equals(correctLetter)) {
				lettersAllCheck = false;
				break;
			}
		}
		
		return lettersAllCheck;
	}
	
	/**
	 * Returns the total number of guesses
	 * @return number of guesses
	 */
	public int getNumberGuesses() {
		return this.guessCount;
	}
	
	/**
	 * Returns the number of incorrect guesses.
	 * @return number of incorrect guesses.
	 */
	 public int getNumberIncorrectGuesses() {
		 return this.getNumberIncorrectGuesses();
		}
	 /**
	  * For debugging only
	  * Prints the current word.
	  */
	 public void printWord() {
		 System.out.println("Current word: " + this.word);
	 }
	 
	 /**
	  * For debugging only
	  * Prints the current word list.
	  */
	 public void printWordList() {
		 System.out.println("word list: " + this.wordList);
	 }
	}
