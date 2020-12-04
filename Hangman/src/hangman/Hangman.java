package hangman;
import java.util.ArrayList;

/**
 * Defines functionality for different versions of Hangman.
 */
public class Hangman {
	
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
	 * Correctly indentified letters in current word, otherwise "_".
	 */
	public ArrayList<String> correctLetters:
		
	/**
	 * total number of guesses.
	 */
	public int guessCount

	/**
	 * List incorrectly guessed letters.
	 * 
	 */
	public ArrayList<String> incorrectGusses = new ArrayList<String>();
	
	/**
	 * Method for initially selecting a word in a game.
	 * @return Selected word
	 */
	abstract public String pickWord();
	
	/**
	 * Locate given letter and marke as correctly identified letter
	 * @param letter to search for
	 * @return true if letter was found and marked, otherwise false
	 * 
	 */
	abstract public boolean findAndMarkLetter(String letter);
	
	/**
	 * Returns true if the given letter has been gussed (correctly or incorrectly).
	 * @param letter that was guessed
	 * @return true if letter was guessed
	 */
	public boolean guessed(String letter) {
		return this.guessedIncorrectly(letter) || this.guessedCorrectly(letter);
	}
	
	/**
	 * Returns true if the givern letter has been guessed and was incorrect/
	 * @param letter that was guessed
	 * @return true if letterwas guessed as incorrect guess
	 */
	
	private boolean guessedIncorrectly(String letter) {
		return this.incorrectGuesses.contains(letter);
	}
	
	/**
	 * determines if every letter of the random word has been guessed correctly. 
	 * Checks the letters guessed by the user against the letters of the random word. 
	 * @return true if every letter has been guessed
	 */
	
	public boolean checkLetters() {
		boolean lettersAllCheck = True;
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
		 return this.getNumberIncorrectGuesses().size();
		}
	 /**
	  * For debugging only
	  * Prints the current word.
	  */
	 public void printWord() {
		 System.out.println("Current word: " + this.word);
	 }
	 
	 /**
	  * For deugging only
	  * Prints the current word list.
	  */
	 public void printWordList() {
		 System.out.println("word list: " + this.wordList);
	 }
	}
