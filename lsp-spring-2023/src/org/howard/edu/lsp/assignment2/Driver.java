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
	
	public static List<String> formatString(String input) {
		String[] splited = input.split("\\s+");
		List<String> formatted = new ArrayList<>();
		for (String word: splited) {
			try {
				int number = Integer.parseInt(word);
			} catch (Exception e) {
				formatted.add(word);
			}
		}
		
		return formatted;
	}
	
	public static List<String> removeTrivialWords(List<String> formattedString) {
		List<String> nonTrivialWords = new ArrayList<>();
		for (String word: formattedString) {
			if (word.length() > 3) {
				nonTrivialWords.add(word);
			}
		}
		
		return nonTrivialWords;
	}
	
	public static Hashtable<String, Integer> getWordOccurances(String string) {
		// This function will take a string and remove anything that is not 
		// a string and store it in a hashtable

		// Removes all newlines from string
		string = string.replace("\n", " ");
		
		// removes all numbers and returns a list of strings
		List<String> formattedString = formatString(string);
		
		// removed 'trivial' words from list first
		List<String> nonTrivialWords = removeTrivialWords(formattedString);

		Hashtable<String, Integer> wordOccurances = new Hashtable<String, Integer>();
		for (String word: nonTrivialWords) {
			String lowercasedWord = word.toLowerCase();
			if (wordOccurances.containsKey(lowercasedWord)) {
				int currentNumberOfOccurances = wordOccurances.get(lowercasedWord);
				wordOccurances.put(lowercasedWord, currentNumberOfOccurances+1);
			} else {
				wordOccurances.put(lowercasedWord, 1);
			}
		}
		
		return wordOccurances;
	}

}
