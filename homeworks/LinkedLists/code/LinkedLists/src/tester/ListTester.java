package tester;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Mark Floryan
 * @version 1.0
 * This class tests a custom built linked list by comparing it with java built in Linked List
 */
public class ListTester {
	
	public static int NUM_TESTS = 5000;
	
	
	private static <T> boolean compareLists(java.util.LinkedList<T> list1, list.LinkedList<T> list2) {
		Iterator<T> it1 = list1.iterator();
		list.ListIterator<T> it2 = list2.front();
		
		if(list1.size() != list2.size()) return false;
		while(!it2.isPastEnd()) {
			if(!it1.next().equals(it2.value())) return false;
			it2.moveForward();
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		/* Test the two lists by inserting and removing stuff and checking equality as we go */
		
		/* A list to compare with for correctness */
		java.util.LinkedList<Integer> compList = new LinkedList<Integer>();
		
		/* The custom list built by the student */
		list.LinkedList<Integer> studList = new list.LinkedList<Integer>();
		
		/* Insert a bunch of random integers into the list */
		System.out.print("Checking inserting at tail of list...");
		for(int i=0; i<NUM_TESTS; i++) {
			int rand = (int)Math.floor(Math.random()*1000);
			compList.add(rand);
			studList.insertAtTail(rand);
			if(!compareLists(compList, studList)) {
				System.out.println("ERROR: Inserting at tail failed OR .get() failed (when comparing)");
				System.exit(1);
			}
		}
		System.out.println("Done. Looks good");
		
		/* Insert a bunch of things at the head */
		System.out.print("Checking inserting at head of list...");
		for(int i=0; i<NUM_TESTS; i++) {
			int rand = (int)Math.floor(Math.random()*1000);
			compList.addFirst(rand);
			studList.insertAtHead(rand);
			if(!compareLists(compList, studList)) {
				System.out.println("ERROR: Inserting at head failed");
				System.out.println(compList);
				System.out.println(studList);
				System.exit(1);
			}
		}
		System.out.println("Done. Looks good");
		
		/* remove some things */
		System.out.print("Checking remove at tail...");
		for(int i=0; i<NUM_TESTS; i++) {
			compList.removeLast();
			studList.removeAtTail();
			
			if(!compareLists(compList, studList)) {
				System.out.println("ERROR: removing from the tail failed.");
				System.exit(1);
			}
		}
		System.out.println("Done. Looks good");
		
		System.out.print("Checking remove at head...");
		for(int i=0; i<NUM_TESTS; i++) {
			compList.removeFirst();
			studList.removeAtHead();

			if(!compareLists(compList, studList)) {
				System.out.println("ERROR: removing from the head failed.");
				System.exit(1);
			}
		}
		System.out.println("Done. Looks good");
		
		/*Call the generic insertAt() method a bunch of times*/
		System.out.print("Checking inserting at generic index of list...");
		for(int i=0; i<NUM_TESTS; i++) {
			int rand = (int)Math.floor(Math.random()*10);
			int ind = (int)(Math.random()*compList.size());
			compList.add(ind, rand);
			studList.insertAt(ind, rand);
			if(!compareLists(compList, studList)) {
				System.out.println("ERROR: Inserting at generic index (i.e, insertAt()) failed");
				System.exit(1);
			}
		}
		System.out.println("Done. Looks good");
		
		/*Check the find method*/
		System.out.print("Checking find in the list...");
		for(int i=0; i<NUM_TESTS; i++) {
			int rand = (int)Math.floor(Math.random()*10);

			int ind1 = compList.indexOf(rand);
			int ind2 = studList.find(rand);
			if(!(ind1 == ind2)) {
				System.out.println("ERROR: find() method failed");
				System.exit(1);
			}
		}
		System.out.println("Done. Looks good");
		
		/*Check the get method*/
		System.out.print("Checking get in the list...");
		for(int i=0; i<NUM_TESTS; i++) {
			int rand = (int)Math.floor(Math.random()*compList.size());

			int ind1 = compList.get(rand);
			int ind2 = studList.get(rand);
			if(!(ind1 == ind2)) {
				System.out.println("ERROR: get() method failed");
				System.exit(1);
			}
		}
		System.out.println("Done. Looks good");
		
		/*Check the remove by iterator method*/
		System.out.print("Checking remove by iterator (iterating  backward) in the list...");
		list.ListIterator<Integer> studIt = studList.back();
		for(int i=compList.size()-1; i>0; i--) {
			/* Remove 1/4 of the time */
			boolean remove = (int)(Math.random()*4) == 0;

			if(remove && !studIt.isPastBeginning()) {
				studList.remove(studIt);
				compList.remove(i);
			}
			
			studIt.moveBackward();
			
			if(!(compareLists(compList, studList))) {
				System.out.println("ERROR: remove by iterator method failed. This could also be because your iterator is not iterating backwards through the list correctly.");
				System.exit(1);
			}
		}
		System.out.println("Done. Looks good");
		
		/*Check the insert by iterator method*/
		System.out.print("Checking insert by iterator (iterating  backward) in the list...");
		studIt = studList.back();
		for(int i=compList.size()-2; i>0; i--) {
			/* Remove 1/4 of the time */
			boolean add = (int)(Math.random()*4) == 0;
			int rand = (int)Math.floor(Math.random()*10);

			if(add && !studIt.isPastBeginning()) {
				studList.insert(studIt, rand);
				compList.add(i+2, rand);
			}
			
			studIt.moveBackward();
			
			if(!(compareLists(compList, studList))) {
				System.out.println("ERROR: insert by iterator method failed. This could also be because your iterator is not iterating backwards through the list correctly.");
				System.exit(1);
			}
		}
		System.out.println("Done. Looks good");
		
		/* Clear the list */
		System.out.print("Checking clearing the list...");
		compList.clear();
		studList.clear();
		if(!(compareLists(compList, studList))) {
			System.out.println("ERROR: clearing the list failed");
			System.exit(1);
		}
		System.out.println("DONE");
		
		System.out.println("EVERYTHING LOOKS GOOD!!");
	}

}
