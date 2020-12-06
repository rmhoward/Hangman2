package dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Class which handles I/O for the dictionary. Reads the file and creates an array for the main game file to use.
 * @author --UPDATE THIS---
 *
 */
public class DictionaryReader {
	
	public static ArrayList<String> readWordsFromDictionary(String fileName) {
		
		//initializes a string to output the words for hangman
		ArrayList<String> hangmanWords = new ArrayList<String>();
		
		//initialize all file-reading implements
		File file = new File(fileName);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		//regex used - any spaces, capital letters, numbers, periods, apostrophes, or hyphens will be matched.
		String regex = "([\\sA-Z0-9.'-])";

		//compiling the pattern
		Pattern p = Pattern.compile(regex);
		
		
		try {
			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			//line in which each line from the text file will be read
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				
				Matcher m = p.matcher(line);
				
				//if the above regex is NOT found, it will be added to the arraylist of hangman words
				if (!m.find()) {
					hangmanWords.add(line);
				}
			}
	
			
			//all exceptions caught here
		} catch (FileNotFoundException e) {
			//gets and  prints filename
			System.out.println("No file found: " + file.getName());
		} catch (IOException e) {
			// print the stack trace
			e.printStackTrace();
		} finally {
			try {
				//close file and buffer readers
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				//print the stack trace if IOException thrown.
				e.printStackTrace();
			}
			
		}
		
		return hangmanWords;
	}
	
	
	
}
