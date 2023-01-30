/**
*  Name: Ivan Stewart
*/

package org.howard.edu.lsp.assignment2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Driver {

	public static void main(String[] args) {        
		try {
		    FileReader fr = new FileReader();    
		    Hashtable<String, Integer> wordOccurancesHashTable = getWordOccurances(fr.readToString("main/java/resources/words.txt"));
		    printOutput(wordOccurancesHashTable);
			} catch (FileNotFoundException e) {
				System.out.println("Unable to open resource");
			}
	}
	
	public static void printOutput(Hashtable<String, Integer> wordOccurancesHashTable) {
		wordOccurancesHashTable.forEach((key, value) -> {
			System.out.println(key + "\t\t" + value);
		});
	}
	
	public static String formatString(String input) {
		String formattedString = "";
		for (int index = 0; index < input.length(); index++) {
			char lowercased = Character.toLowerCase(input.charAt(index));
			int ascii = lowercased;
			if (ascii >= 97 && ascii <= 122) {
				formattedString += lowercased;
			} else if (ascii == 32) {
				// to account for spaces
				formattedString += input.charAt(index);
			} else if (ascii == 39) {
				// to account for apostrophe
				formattedString += " ";
			}
		}
		
		return formattedString;
	}
	
	public static List<String> removeTrivialWords(String[] inputList) {
		List<String> nonTrivialWords = new ArrayList<>();
		for (String word: inputList) {
			if (word.length() > 3) {
				nonTrivialWords.add(word);
			}
		}
		
		return nonTrivialWords;
	}
	
	public static Hashtable<String, Integer> getWordOccurances(String string) {
		// This function will take a string and remove anything not alphabetic and
		// store it in a list

		// Removes all newlines from string
		string = string.replace("\n", " ");
		
		// removes everything that isn't a space or
		// character from string
		String formattedString = formatString(string);

		// creates a list of each word separated by space
		String[] splited = formattedString.split("\\s+");
		
		// removed 'trivial' words from list first
		List<String> nonTrivialWords = removeTrivialWords(splited);

		Hashtable<String, Integer> wordOccurances = new Hashtable<String, Integer>();
		for (String word: nonTrivialWords) {
			if (wordOccurances.containsKey(word)) {
				int currentNumberOfOccurances = wordOccurances.get(word);
				wordOccurances.put(word, currentNumberOfOccurances+1);
			} else {
				wordOccurances.put(word, 1);
			}
		}
		
		return wordOccurances;
	}

}
