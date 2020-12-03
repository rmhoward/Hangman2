import java.util.ArrayList;


import dictionary.DictionaryReader;


/**
 * All functionality for the hangman game included here.
 * Will draw upon other packages and classes to run the game correctly
 * @author ben
 *
 */
public class HangmanGame {

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
