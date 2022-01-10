package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import hash.HashTable;

public class WordPuzzleSolver {
	
	/* The files we will use for this execution */
	/* Change these to try different inputs */
	private static final String DICTIONARY_FILE = "./input/words.txt";
	private static final String GRID_FILE = "./input/3x3.grid.txt";

	public static void main(String[] args) {
		
		/* Kick everything off by calling solve() */
		try {
			new WordPuzzleSolver().solve(DICTIONARY_FILE, GRID_FILE);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/* Solve the puzzle */
	private void solve(String dictFile, String gridFile) throws IOException {
			
		//TODO: Read in the files given as params above and solve the word puzzle
		//prints out the words found in the correct format along with time taken
		//we recommend writing and calling the getWordInGrid and readInGrid methods below.
	}
	
	/* This enum might be useful when looping through directions to search for words */
	enum Direction{
		North, NorthWest, West, SouthWest, South, SouthEast, East, NorthEast;
	}
	
	
	/**
	  * This method returns the word in the grid given the following:
	  * i,j: The starting location in the grid
	  * dir: The direction from i,j the word is read in
	  * len: The length of the word to be returned (note that len may run you off the end of the grid! Need to account for this)
	  */
	private String getWordInGrid(char[][] grid, int i, int j, Direction dir, int len) {	
		//TODO: Write this method
	}
	
	/**
	  * This method reads in the grid file for you and returns the grid that is read in.
	  */
	private char[][] readInGrid(String gridFile) throws IOException{	
		//TODO: Write this method
	}
}
