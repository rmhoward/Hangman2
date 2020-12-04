import java.util.ArrayList;


import dictionary.DictionaryReader;


/**
 * All functionality for the hangman game included here.
 * Will draw upon other packages and classes to run the game correctly
 * @author ben
 *
 */
public class HangmanGame {

	/**
	 * Play Hangman with a dictionary file of words
	 * with the given fileName.
	 * @param fileName for the dictionary file
	 */
	private void playGame(String fileName) {
		
		//create hangman directory
		ArrayList<String> wordList = HangmanDictionaryReader.readDictionary(fileName);
		
		boolean gameOver = false;
		Scanner scanner = new Scanner (System.in);
		
		while (!gameOver) {
			
			Hangman hangman = this.getHanmanVersion(wordlist);
			
			System.out.println("Play again? Y/N");
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("Crickets chirping.");
		System.out.println("No game here yet, bub.");
    
		System.out.println("This looks different");

		System.out.println("Testing...");
		
		//name of file to read
		//WARNING, THIS IS READING IN THE FULL WORD FILE. IT MAY TAKE TIME TO LOAD IT ALL.
		//IF YOU WANT TO TEST EARLY FUNCTIONALITY, COMMENT THIS OUT AND UNCOMMENT THE NEXT LINE
		String fileName = "words.txt";
		
		//UNCOMMENT THIS FOR FASTER CHECKING
//		String fileName = "words_clean.txt";
		

		ArrayList<String> words = DictionaryReader.readWordsFromDictionary(fileName);
		
		System.out.println(words);
		
		System.out.println(words.get(0));

		
		
	}

}
