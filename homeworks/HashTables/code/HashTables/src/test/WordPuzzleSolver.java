package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import hash.HashTable;

public class WordPuzzleSolver {

	public static void main(String[] args) {
		
		/* Kick everything off by calling solve() */
		try {
			Scanner in = new Scanner(System.in);
			String dicFile = in.next();
			String gridFile = in.next();
			in.close();
			new WordPuzzleSolver().solve(dicFile, gridFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/* Solve the puzzle */
	private void solve(String dictFile, String gridFile) throws IOException {
			
		/* Implement this method. Open the files and solve the word puzzle!! */
	}
	
	
}
