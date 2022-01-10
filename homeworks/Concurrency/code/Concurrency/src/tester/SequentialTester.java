package tester;

import queue.ConcurrentQueue;
import java.util.LinkedList;

/**
 * Tests the concurrent queue without utilizing parallelism
 * @author Mark Floryan
 *
 */
public class SequentialTester {
	
	private static int NUM_TESTS = 10000000;

	public static void runSequentialTest(){
		
		try {
			/* Make two queues */
			ConcurrentQueue<Integer> studQ = new ConcurrentQueue<Integer>();
			LinkedList<Integer> compQ = new LinkedList<Integer>();
			
			System.out.print("Adding items...");
			for(int i=0; i<NUM_TESTS; i++) {
				int toQ = (int)Math.random()*500;
				studQ.enqueue(toQ);
				compQ.add(toQ);
			}
			System.out.println("DONE");
			
			System.out.print("Checking size...");
			if((studQ.size() != compQ.size())) {
				System.out.println("ERROR: sizes different after adding");
				System.exit(1);
			}
			System.out.println("DONE");
			
			System.out.print("Removing items...");
			for(int i=0; i<NUM_TESTS/2; i++) {
				if(studQ.dequeue() != compQ.poll()) {
					System.out.println("ERROR: dequeueing not working, different values removed");
					System.exit(1);
				}
			}
			System.out.println("DONE");
			
			System.out.print("Checking size...");
			if((studQ.size() != compQ.size())) {
				System.out.println("ERROR: sizes different after enqueueing");
				System.exit(1);
			}
			System.out.println("DONE");
			
			System.out.print("Adding more items...");
			for(int i=0; i<NUM_TESTS; i++) {
				int toQ = (int)Math.random()*500;
				studQ.enqueue(toQ);
				compQ.add(toQ);
			}
			System.out.println("DONE");
			
			System.out.print("Checking size...");
			if((studQ.size() != compQ.size())) {
				System.out.println("ERROR: sizes different after enqueueing");
				System.exit(1);
			}
			System.out.println("DONE");
			
			System.out.println("Removing everything...");
			while(studQ.size() > 0) {
				if(studQ.dequeue() != compQ.poll()) {
					System.out.println("ERROR: dequeueing not working, different values removed");
					System.exit(1);
				}
			}
			System.out.println("DONE");
			
			System.out.println("EVERYTHING LOOKS GOOD!");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
