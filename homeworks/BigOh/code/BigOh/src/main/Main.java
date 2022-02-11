package main;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main {

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
				Arrays.sort(a);
				int rand = (int)(Math.random()*a[a.length-1]);
				System.out.println("Result of binarySearch(): " + BigOh.binarySearch(a, rand));
				break;
			case 2:
				System.out.println("Calling max()");
				System.out.println("Result of max(): " + BigOh.max(a));
				break;
			case 3:
				System.out.println("Calling multipleBinarySearch()");
				System.out.println("binarySearch() found this many items: " + BigOh.multipleBinarySearch(a));
				break;
			case 4:
				System.out.println("Calling allPairs()");
				System.out.println("allPairs() returned: " + BigOh.allPairs(a));
				break;
			case 5:
				System.out.println("Calling allTriads()");
				System.out.println("allTriads() returned: " + BigOh.allTriads(a));
				break;
			case 6:
				System.out.println("Calling allSubsets()");
				BigOh.allSubsets(a, 0, new Vector<Integer>());
				System.out.println("allSubsets() is done");
				break;
			}
			
			long t2 = System.currentTimeMillis();
			System.out.println("DONE - Total Time (ms): " + (t2-t1));
		}
		
	}

}
