package hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

/**
 * Evil version of Hangman
 * @author 
 */
public class HangmanEvil extends Hangman {

	/**
	 * Create instance of evil hangman
	 *
	 * @param wordlist pf wprds
	 */
	public HangmanEvil(ArrayList<String> wordList) {
		this.wordList = wordList;
	}

	/**
	 * Takes a given word and sets the length of the word for Evil Hangman
	 *
	 * @param givenWord to use for the game.
	 * @return Selected word, however represented by "_" during the actual game
	 */
	public String pickWord(String givenWord) {

		//get random word
		Random random = new Random();
		int randInt = random.nextInt(this.wordList.size());
		this.word = this.wordList.get(randInt).toLowerCase();

//		this.word = "";
		this.correctLetters = new ArrayList<String>(givenWord.length());
		for (int i = 0; i < givenWord.length(); i++) {
			this.word += Hangman.HIDDEN_LETTER_CHAR;
			this.correctLetters.add(Hangman.HIDDEN_LETTER_CHAR);
		}

		//partition word list by length of the selected word
		this.partitionByLength(this.word.length());

		return this.pickWord(givenWord);
	}

	/**
	 * Filters the word list based on the given word length
	 *
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
			if (wordLength != selectedWordLength)
				continue;

			wordList.add(word);
		}

		this.wordList = new ArrayList<String>(wordList);

		return this.wordList;
	}

	/**
	 * Locates Given letter in largest word group and mark as correctly identified letter. Partitions the word list
	 * into
	 * word groups based on the position of the given letter or if it can't be found Gets the largest of these word
	 * groups and sets that to the word list.
	 *
	 * @param letter to search for
	 * @return true if letter was found an d marked
	 */
	@Override
	public boolean findAndMarkLetter(String letter) {
		boolean foundLetter = false;

		//if letter is not single character, ignore
		if (letter.length() != 1)
			return foundLetter;

		//convert to lowercase
		letter = letter.toLowerCase();

		for (int i = 0; i < this.word.length(); i++) {
			if (letter.equals(this.word.charAt(i) + "")) {
				foundLetter = true;
			}
		}
		//if letter wasn't found
		if (!foundLetter) {
			//add to list of incorrect guesses
			if (!this.incorrectGuesses.contains(letter)) {
				this.incorrectGuesses.add(letter);
			}
		}
		//increment number of guesses
		this.guessCount++;

		//return true or false based on whether the letter was found or not
		return foundLetter;
	}

	/**
	 * Partitions the word list into word groups based on the position of the given letter, or it can't be found.
	 *
	 * @param letter to search for and partition on
	 * @return the key of the largest word group
	 */
	private String partitionByLetter(String letter) {

		//to store word groups
		TreeMap<String, ArrayList<String>> wordGroups = new TreeMap<String, ArrayList<String>>();

		//to generate key for word groups
		StringBuilder keySb = new StringBuilder();

		//iterate over list of words in list
		for (String w : this.wordList) {
			//create a key based on the letters that are currently selected
			keySb = this.getKeySb(this.correctLetters);

			//compare the letter guessed by the user to each letter in the word
			for (int i = 0; i <= w.length() - 1; i++) {
				if (letter.equals(w.charAt(i) + "")) {
					keySb.setCharAt(i, w.charAt(i));
				}
			}

			//add the word and list of words to a group
			ArrayList<String> wList;
			if (wordGroups.containsKey(keySb.toString())) {
				wList = new ArrayList<String>();
				wList.add(w);
				wordGroups.put(keySb.toString(), wList);
			} else {
				wList = wordGroups.get(keySb.toString());
				wList.add(w);
				wordGroups.replace(keySb.toString(), wList);
			}
		}
		//update word list
		return this.updateWordList(wordGroups);
	}


	//THIS IS STUDENT WORK FROM 12.5 OH @65:46. VERY EVIL.

	/**
	 * this updates the word list to the largest word group
	 *
	 * @param wordGroups
	 * @return the key of the largest word group
	 */
	private String updateWordList(TreeMap<String, ArrayList<String>> wordGroups) {
		//look at all groups and iterate over treemap
		//list of words per key + size
		int maxSize = 0;
		String maxKey = "";

		for (String key : wordGroups.keySet()) {
			int listSize = wordGroups.get(key).size();
			if (listSize > maxSize) {
				maxSize = listSize;
				maxKey = key;
			}
		}
		return maxKey;
	}

	/**
	 * NOT SURE IF THIS IS RIGHT:
	 * Getter for the StringBuilder KeySb
	 * @param correctLetters to output
	 * @return correct letters
	 */
	private StringBuilder getKeySb(ArrayList<String> correctLetters) {
		
		StringBuilder outString = new StringBuilder();
		
		for (String s: correctLetters) {
			outString.append(s);
		}
		
		return outString;
	}
				

	//NOTE: NOT SURE IF THIS IS RIGHT YET: SIMPLY COPY AND PASTED FROM HANGMAN TRADITIONAL
	@Override
	public String pickWord() {
		//get random word
		Random random = new Random();
		int randInt = random.nextInt(this.wordList.size());
		this.word = this.wordList.get(randInt).toLowerCase();
			
		//set correctly identified letters of word
		//default to "_"
		this.correctLetters = new ArrayList<String>(this.word.length());
		for (int i = 0; i < this.word.length(); i++) {
			this.correctLetters.add(Hangman.HIDDEN_LETTER_CHAR);
		}
		
		return this.word;
	}

	
}
