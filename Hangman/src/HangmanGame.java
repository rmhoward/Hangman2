import java.util.ArrayList

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
	}

}
