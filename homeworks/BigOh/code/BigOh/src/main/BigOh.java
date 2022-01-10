package main;

import java.util.Scanner;
import java.util.Vector;

public class BigOh {
	
	/* Binary Search: Should run in Theta(logn) time */
	/* Returns true if item is in the array a */
	public static boolean binarySearch(int[] a, int item) {
		//TODO: Implement this method
		return false;
	}
	
	/* Max value in array: Should run in Theta(n) time */
	public static int max(int[] a) {
		//TODO: Implement this method
		return 0;
	}
	
	/* Calls binary search n times. Counts number of successful searches */
	/* Should run in Theta(nlogn) time */
	public static int multipleBinarySearch(int[] a) {
		//TODO: Implement this method
		return 0;
	}
	
	/* Counts pairs of numbers whose sum is multiple of 5 */
	/* Should run in Theta(n^2) time */
	public static int allPairs(int[] a) {
		//TODO: Implement this method
		return 0;
	}
	
	/* Counts the pairs of three in the list a,b,c in which a+b=c */
	/* Should run in Theta(n^3) time */
	public static int allTriads(int[] a) {
		//TODO: Implement this method
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
	

	public static void main(String[] args) {
		
		/* This main function generates a sorted array of random numbers given an array size */
		/* You will call various methods with increasing array sizes to see scalability working in action */
		Scanner in = new Scanner(System.in);
		
		while(true) {
			/* Choose a method to call */
			System.out.println("Choose a method to call:");
			System.out.println("\t1: Binary Search ( log n time )");
			System.out.println("\t2: Max ( n time )");
			System.out.println("\t3: Multiple Binary Search ( n log n time )");
			System.out.println("\t4: All Pairs ( n^2 time )");
			System.out.println("\t5: All Triads ( n^3 time )");
			System.out.println("\t6: All Subsets ( 2^n time )");
			System.out.println("Any other number to exit.");
			int method = in.nextInt();
			
			if(method < 1 || method > 6) {
				System.out.println("Exiting");
				System.exit(2);
			}
			
			System.out.println("Enter size of input: ");
			int size = in.nextInt();
			
			if(size <=0) {
				System.out.println("Size must be positive");
				System.exit(3);
			}
			
			/* Create array and fill with random numbers */
			int[] a = new int[size];	
			int gap = 3;
			a[0] = (int)(1 + Math.random()*gap);
			for(int i=1; i<a.length; i++) {
				a[i] = a[i-1] + (int)(1 + Math.random()*gap);
			}
			
			long t1 = System.currentTimeMillis(); //start timer
			switch(method) {
			case 1:
				System.out.println("Calling binarySearch() with a random number.");
				int rand = (int)(Math.random()*a[a.length-1]);
				System.out.println("Result of binarySearch(): " + binarySearch(a, rand));
				break;
			case 2:
				System.out.println("Calling max()");
				System.out.println("Result of max(): " + max(a));
				break;
			case 3:
				System.out.println("Calling multipleBinarySearch()");
				System.out.println("binarySearch() found this many items: " + multipleBinarySearch(a));
				break;
			case 4:
				System.out.println("Calling allPairs()");
				System.out.println("allPairs() returned: " + allPairs(a));
				break;
			case 5:
				System.out.println("Calling allTriads()");
				System.out.println("allTriads() returned: " + allTriads(a));
				break;
			case 6:
				System.out.println("Calling allSubsets()");
				allSubsets(a, 0, new Vector<Integer>());
				System.out.println("allSubsets() is done");
				break;
			}
			
			long t2 = System.currentTimeMillis();
			System.out.println("DONE - Total Time (ms): " + (t2-t1));
		}
		
	}

}
