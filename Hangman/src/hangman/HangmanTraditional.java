package hangman;

import java.util.ArrayList;
import java.util.Random;

/**
 * Traditional version of Hangman.
 * @author ...
 * 
 */
public class HangmanTraditional extends Hangman {
	
	/**
	 * Create instance of traditional hangman with given list of words. 
	 * @param wordList of words
	 */
	public HangmanTraditional(ArrayList<String> wordList) {
		this.wordList = wordList;
	}
	
	/**
	 * Picks a random word in the word list and sets the word for Traditional Hangman
	 * @return selected word
	 */
	@Override
	public String pickWord() {
	
		//get random word
		Random random = new Random();
		int randInt = random.nextInt(this.wordList.size());
		
		//gets word and changes it to lowercase (there shouldn't be any uppercase, but just for posterity).
		this.word = this.wordList.get(randInt).toLowerCase();
		
		//set correctly identified letters of word
		//default to "_"
		this.correctLetters = new ArrayList<String>(this.word.length());
		for (int i = 0; i < this.word.length(); i++) {
			this.correctLetters.add(Hangman.HIDDEN_LETTER_CHAR);
		}
		
		return this.word;
	}
	
	/**
	 * Locate given letter in current word and mark as correctly identified letter.
	 * @param letter to search for
	 * @return true if letter was found and marked otherwise false
	 */
	@Override
	public boolean findAndMarkLetter(String letter) {
		
		boolean foundLetter = false;
		
		//if letter is not single character, ignore it, and simply return false
		if (letter.length() != 1) return foundLetter;
		
		//convert to lowercase
		letter = letter.toLowerCase();
		
		for (int i = 0; i < this.word.length(); i++ ) {
			if (letter.equals(this.word.charAt(i) + "")) {
				//every position letter is located, mark as correctly identified letter
				this.correctLetters.set(i, letter);
				foundLetter = true;
			}
		}
		
		//if letter wasn't found
		if (!foundLetter) {
			//add to list of incorrrectGuesses
			if (!this.incorrectGuesses.contains(letter)) {
				this.incorrectGuesses.add(letter);
			}
		}
		
		//increment number of guesses
		this.guessCount++;
		
		return foundLetter;
		
		}

	/**
	 * WILL NOT BE USED, AS TRADITIONAL HANGMAN ONLY PICKS A WORD ONCE
	 * added for implementation reasons in hangmanGame
	 */
	@Override
	public String pickWord(String givenWord) {
		return null;
	}
	
	
	}
