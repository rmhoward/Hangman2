package hangman;
import java.util.ArrayList;

/**
 * Defines functionality for different versions of Hangman.
 */
public abstract class Hangman {
	
	//character displayed for any hidden character
	public static final String HIDDEN_LETTER_CHAR = "_";
	
	//Arraylist used for the wordlist
	public ArrayList<String> wordList = new ArrayList<String>();
	
	//current word
	public String word;
	
	//arraylist of correctly identified letters - if not yet identified will simply show "_"
	public ArrayList<String> correctLetters;
		
	//total number of guesses
	public int guessCount;

	//list of incorrectly guessed letters
	public ArrayList<String> incorrectGuesses = new ArrayList<String>();
	
	/**
	 * Abstract method for initially selecting a word in a game.
	 * @return Selected word
	 */
	abstract public String pickWord();
	
	/**
	 * Locate a given letter (or letters) in a word and mark them as correctly identified
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
	 * Determines if every letter of the random word has been guessed correctly. 
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
	 * prints the total number of guesses
	 * @return number of guesses
	 */
	public int getNumberGuesses() {
		return this.guessCount;
	}
	
	/**
	 * prints the number of incorrect guesses.
	 * @return number of incorrect guesses.
	 */
	 public int getNumberIncorrectGuesses() {
		 return this.getNumberIncorrectGuesses();
		}
	 /**
	  * debug method
	  * Prints the current word.
	  */
	 public void printWord() {
		 System.out.println("Current word: " + this.word);
	 }
	 
	 /**
	  * debug method
	  * Prints the current word list.
	  */
	 public void printWordList() {
		 System.out.println("word list: " + this.wordList);
	 }

	/**
	 * Takes a given word and sets the length of the word for Evil Hangman
	 *
	 * @param givenWord to use for the game.
	 * @return Selected word, however represented by "_" during the actual game
	 */
	public abstract String pickWord(String givenWord);
	}
