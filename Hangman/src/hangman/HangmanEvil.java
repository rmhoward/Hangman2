package hangman;

import java.io.File
import java.util.ArrayList;

/**
 * Evil version of Hangman
 * @author 
 */
public class HangmanEvil extends Hangman {

	/**
	 * Create instance of evil hangman with a given list of words.
	 * @param wordlist list of words
	 */
	public HangmanEvil(ArrayList<String> wordList) {
		this.wordList = wordList;
	}
	
	/**
	 * Takes a given word and 
	 * sets the length of the word for Evil Hangman
	 * @param givenWord to use for the game.
	 * @return Selected word represented by "_" String characters.
	 */
	public String pickWord(String givenWord) {
		
		//get random word
		Random random = new Random();
		int randInt = random.nextInt(this.wordList.size());
		this.word = this.wordList.get(randInt).toLowerCase();
		
		this.word = "":
		this.correctLetters = new ArrayList<String>(givenWord.length());
		for (int i = 0; i < givenWord.length(); i++) {
			this.word += Hangman.HIDDEN_LETTER_CHAR;
			this.correctLetters.add(Hangman.HIDDEN_LETTER_CHAR);
		}
		
		//partition word list by length of the selected word
		this.partitionByLength(this.word.length());
		
		return this.pickWord(givenWord);
		
		/**
		 * Filters the word list based on the given word length
		 * @param selectedWordLength to filter words
		 * @return Filtered word list
		 */
		private ArrayList<String> partitionByLength(int selectedWordLength) {
			
			int wordLength;
			ArrayList<String> wordList = new ArrayList<String>();
			
			//for each word in word list
			for (String word : this.wordList) {
				
				//get the length
				wordLength = word.length();
				
				//only map words with the same length
				if (wordLength != selectedWordLength) continue;
				
				wordList.add(word);
			}
			
			this.wordList = new ArrayList<String>(wordList);
			
			return this.wordList;
			}
		}
	}
}
