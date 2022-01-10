package test;

/**
 * THIS IS A SANITY CHECK. NOT MEANT TO BE A THOROUGH TEST OF YOUR HASH TABLE
 * @author floryan
 *
 */
public class HashTableTester {

	public static void main(String[] args) {
		/* Num Tests */
		final int NUM_TESTS = 1000;
		
		/* Make two hashmaps */
		java.util.HashMap<Integer, Integer> cmp = new java.util.HashMap<Integer, Integer>();
		hash.HashTable<Integer, Integer> stud = new hash.HashTable<Integer, Integer>();
		
		System.out.print("Inserting...");
		for(int i=0; i<NUM_TESTS; i++) {
			Integer key = (int)(Math.random()*NUM_TESTS);
			Integer value = (int)(Math.random()*NUM_TESTS);
			
			cmp.put(key, value);
			stud.insert(key, value);
		}
		System.out.println("DONE");
		
		System.out.print("Checking if inserted items present...");
		for(Integer k : cmp.keySet()) {
			if(!cmp.get(k).equals(stud.retrieve(k))) {
				System.out.println("ERROR: Key " + k + " was inserted but not found OR has incorrect value in your hash table");
				System.exit(-1);
			}
		}
		System.out.println("DONE");
		
		System.out.print("Changing Values...");
		for(Integer k : cmp.keySet()) {
			Integer value = (int)(Math.random()*NUM_TESTS);
			
			cmp.put(k, value);
			stud.insert(k, value);
		}
		System.out.println("Done");
		
		System.out.print("Checking changes by retrieving items again...");
		for(Integer k : cmp.keySet()) {
			if(!cmp.get(k).equals(stud.retrieve(k))) {
				System.out.println("ERROR: Key " + k + " was inserted and updated but not found OR has incorrect value in your hash table");
				System.exit(-1);
			}
		}
		System.out.println("DONE");
		
		/*REMOVE*/
		System.out.print("Removing all items and checking...");
		for(Integer k : cmp.keySet()) {
			stud.remove(k);
			
			if(stud.retrieve(k) != null) {
				System.out.println("ERROR: Key " + k + " was removed but did not return null upon calling retrieve()");
			}
		}
		System.out.println("DONE");
		
	}

}
