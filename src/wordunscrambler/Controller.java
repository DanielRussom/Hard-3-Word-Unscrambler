package wordunscrambler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
	public static void main(String args[]) throws IOException {
		// Declare scrambled words
		String[] scrambledWords = new String[] { "mkeart", "sleewa", "edcudls", "iragoge", "usrlsle", "nalraoci",
				"nsdeuto", "amrhat", "inknsy", "iferkna" };
		// Read in unscrambled word list
		String[] wordList = readLines("bin/WordList.txt");
		// Iterate through word list
		for (int i = 0; i < wordList.length; i++) {
			// Iterate through scrambled words
			for (int j = 0; j < scrambledWords.length; j++) {
				// Ignores words without the same length
				if (wordList[i].length() != scrambledWords[j].length()) {
					continue;
				}				
				// Compares words with the same length
				if (compareWords(scrambledWords[j], wordList[i])) {
					// If words match, they are output
					System.out.println(wordList[i] + " matches " + scrambledWords[j]);
					
				}
			}
		}
	}

	// Handles reading lines from a file
	public static String[] readLines(String filename) throws IOException {
		FileReader fileReader = new FileReader(filename);

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
		}

		bufferedReader.close();

		return lines.toArray(new String[lines.size()]);
	}

	// Compares two words
	public static boolean compareWords(String word1, String word2) {
		// Iterates through each char in word1
		for (int i = 0; i < word1.length(); i++) {
			// Iterates through each char in word2
			for (int j = 0; j < word2.length(); j++) {
				// If the chars match, replace with a space
				if (word1.charAt(i) == word2.charAt(j)) {
					word2 = word2.substring(0, j) + " " + word2.substring(j+1);
					break;
				}
				// If words don't contain same char, return false
				if (j == word2.length() - 1) {
					return false;
				}
			}
		}
		// Return true if words match
		return true;
	}
}
