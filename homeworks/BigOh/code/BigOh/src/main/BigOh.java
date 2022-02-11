package main;

import java.util.Scanner;
import java.util.Vector;

public class BigOh {
	
	/* Binary Search: Should run in Theta(logn) time */
	/* Returns true if item is in the array a */
	public static boolean binarySearch(int[] a, int item) {
		//TODO: IMPLEMENT THIS METHOD
		return false;
	}
	
	/* Max value in array: Should run in Theta(n) time */
	public static int max(int[] a) {
		//TODO: IMPLEMENT THIS METHOD
		return 0;
	}
	
	/* Calls binary search n times. Counts number of successful searches */
	/* You should search for the numbers 1 through n in succession */
	/* Should run in Theta(nlogn) time */
	public static int multipleBinarySearch(int[] a) {
		//TODO: IMPLEMENT THIS METHOD
		return 0;
	}
	
	/* Counts pairs of numbers whose sum is multiple of 5 */
	/* Should run in Theta(n^2) time */
	public static int allPairs(int[] a) {
		//TODO: IMPLEMENT THIS METHOD
		return 0;
	}
	
	/* Counts the pairs of three in the list a,b,c in which a+b=c */
	/* Should run in Theta(n^3) time */
	public static int allTriads(int[] a) {
		//TODO: IMPLEMENT THIS METHOD
		return 0;
	}
	
	
	/* Prints all subsets of a */
	/* Should run in Theta(2^n) time */
	/* e..g, {1,2,3} would print {},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3} */
	public static void allSubsets(int[] a, int i, Vector<Integer> sol) {
		if(i >= a.length) {
			//Found another subset, but not printing because printing is really slow.
			return;
		}		
		allSubsets(a, i+1, sol);
		sol.add(a[i]);
		allSubsets(a, i+1, sol);
		sol.remove(sol.size()-1);
	}

}
