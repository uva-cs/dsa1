package sorting;

import java.util.HashMap;

public class AdvancedSorts {

	
	public static<T extends Comparable<T>> void mergeSort(T[] list) {
		//TODO: Implement this method
	}
	
	private static<T extends Comparable<T>> void mergeSort(T[] list, int i, int j) {
		//TODO: Implement this method
	}
	
	
	
	
	public static<T extends Comparable<T>> void quickSort(T[] list) {
		//TODO: Implement this method
	}
	
	private static<T extends Comparable<T>> void quickSort(T[] list, int i, int j) {
		//TODO: Implement this method
	}
	
	
	/** EVERYTHING BELOW HERE IS USED FOR TESTING **/
	//------------------------

	
	/* Number of elements to sort */
	private static final int SIZE = 100;

	public static void main(String[] args) {
		
		/* Make an array to sort. Fill with random numbers */
		final Integer[] list = new Integer[SIZE];
		for(int i=0; i<SIZE; i++) list[i] = (int)(Math.random()*SIZE);
		
		/* Make four copies to sort */
		Integer[] mer = list.clone();
		Integer[] qui = list.clone();
		
		System.out.print("Sorting using merge sort...");
		mergeSort(mer);
		System.out.print("Done...checking if sorted correctly...");
		checkSorted(list, mer);
		System.out.println("DONE");
		
		System.out.print("Sorting using quick sort...");
		quickSort(qui);
		System.out.print("Done...checking if sorted correctly...");
		checkSorted(list, qui);
		System.out.println("DONE");

	}
	
	public static<T extends Comparable<T>> boolean checkSorted(T[] orig, T[] sorted) {
		/* Make sure size is the same */
		if(orig.length != sorted.length) {
			System.out.print("ERROR...original list and sorted list have different lengths...");
			return false;
		}
		
		/* Make sure new array is sorted */
		for(int i=1; i<sorted.length; i++) {
			if(sorted[i].compareTo(sorted[i-1])<0) {
				System.out.print("ERROR...the sorted list does not appear to be correctly sorted...");
				return false;
			}
		}
		
		/* Make sure the same elements are in each array */
		HashMap<T, Integer> count = new HashMap<T, Integer>();
		for(int i=0; i<orig.length; i++) {
			if(!count.containsKey(orig[i])) count.put(orig[i], 1);
			else count.put(orig[i], count.get(orig[i])+1);
			
			if(!count.containsKey(sorted[i])) count.put(sorted[i], -1);
			else count.put(sorted[i], count.get(sorted[i])-1);
		}
		for(T key : count.keySet()) {
			if(count.get(key) != 0) {
				System.out.print("ERROR...The sorted list does not contain the same elements that the original list does...");
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Use this printlist method while debugging if helpful
	 * @param list
	 */
	public static<T> void printList(T[] list) {
		for(T x: list) {
			System.out.print(x + ", ");
		}
		System.out.println();
	}

}
