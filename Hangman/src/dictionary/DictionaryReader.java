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
 * @author ben
 *
 */
public class DictionaryReader {
	
	public static ArrayList<String> readWordsFromDictionary(String fileName) {
		
		ArrayList<String> hangmanWords = new ArrayList<String>();
		
		File file = new File(fileName);
		
		FileReader fileReader = null;
		
		BufferedReader bufferedReader = null;
		
		String regex = "([\\sA-Z0-9.'-])";
		
//		String regex = "([a-zA-Z0-9._%+-]+)";
		
		Pattern p = Pattern.compile(regex);
		
		
		try {
			
			fileReader = new FileReader(file);
			
			bufferedReader = new BufferedReader(fileReader);
			
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				
				Matcher m = p.matcher(line);
				
				if (!m.find()) {
					hangmanWords.add(line);
				}
			}
	
		} catch (FileNotFoundException e) {
			//gets and  prints filename
			System.out.println("No file found: " + file.getName());
		} catch (IOException e) {
			// print the stack trace
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return hangmanWords;
	}
	
	
	
}
