package tester;

import stack.Stack;
import queue.Queue;
import java.util.LinkedList;

public class StackAndQueueTester {
	
	private static int NUM_TESTS = 1000000;

	public static void main(String[] args) {
		
		try {
			/* Two stacks for comparison */
			stack.Stack<Integer> s1 = new Stack<Integer>();
			LinkedList<Integer> s2 = new LinkedList<Integer>();
			
			System.out.println("CHECKING STACK FIRST");
			System.out.println("-------------------------");
			
			System.out.print("Adding items...");
			for(int i=0; i<NUM_TESTS; i++) {
				int toQ = (int)Math.random()*500;
				
				s1.push(toQ);
				s2.push(toQ);
			}
			System.out.println("DONE");
			
			System.out.print("Checking size...");
			if((s1.size() != s2.size())) {
				System.out.println("ERROR: sizes different after adding");
				System.exit(1);
			}
			System.out.println("DONE");
			
			System.out.print("Removing items...");
			for(int i=0; i<NUM_TESTS/2; i++) {
				if(s1.pop() != s2.pop()) {
					System.out.println("ERROR: stack pop() not working, different values removed");
					System.exit(1);
				}
			}
			System.out.println("DONE");
			
			System.out.print("Checking size...");
			if((s1.size() != s2.size())) {
				System.out.println("ERROR: sizes different after enqueueing");
				System.exit(1);
			}
			System.out.println("DONE");
			
			System.out.print("Adding more items...");
			for(int i=0; i<NUM_TESTS; i++) {
				int toQ = (int)Math.random()*500;
				
				s1.push(toQ);
				s2.push(toQ);
			}
			System.out.println("DONE");
			
			System.out.print("Checking size...");
			if(s1.size() != s2.size()) {
				System.out.println("ERROR: sizes different after enqueueing");
				System.exit(1);
			}
			System.out.println("DONE");
			
			System.out.print("Removing everything...");
			while(s2.size() > 0) {
				if(s1.pop() != s2.pop()) {
					System.out.println("ERROR: stack pop() not working, different values removed");
					System.exit(1);
				}
			}
			System.out.println("DONE");
			System.out.println("EVERYTHING LOOKS GOOD!");
			System.out.println("-------------------------");
			
			System.out.println("CHECKING QUEUE NEXT");
			System.out.println("-------------------------");
			
			/* Two queue for comparison */
			queue.Queue<Integer> q1 = new queue.Queue<Integer>();
			java.util.LinkedList<Integer> q2 = new java.util.LinkedList<Integer>();
			
			System.out.print("Adding items...");
			for(int i=0; i<NUM_TESTS; i++) {
				int toQ = (int)Math.random()*500;
				q1.enqueue(toQ);
				q2.add(toQ);
				
			}
			System.out.println("DONE");
			
			System.out.print("Checking size...");
			if(q1.size() != q2.size()) {
				System.out.println("ERROR: sizes different after adding");
				System.exit(1);
			}
			System.out.println("DONE");
			
			System.out.print("Removing items...");
			for(int i=0; i<NUM_TESTS/2; i++) {
				if(q1.dequeue() != q2.poll()) {
					System.out.println("ERROR: dequeueing not working, different values removed");
					System.exit(1);
				}
			}
			System.out.println("DONE");
			
			System.out.print("Checking size...");
			if(q1.size() != q2.size()) {
				System.out.println("ERROR: sizes different after enqueueing");
				System.exit(1);
			}
			System.out.println("DONE");
			
			System.out.print("Adding more items...");
			for(int i=0; i<NUM_TESTS; i++) {
				int toQ = (int)Math.random()*500;
				q1.enqueue(toQ);
				q2.add(toQ);
			}
			System.out.println("DONE");
			
			System.out.print("Checking size...");
			if(q1.size() != q2.size()) {
				System.out.println("ERROR: sizes different after enqueueing");
				System.exit(1);
			}
			System.out.println("DONE");
			
			System.out.print("Removing everything...");
			while(q2.size() > 0) {
				if(q1.dequeue() != q2.poll()) {
					System.out.println("ERROR: dequeueing not working, different values removed");
					System.exit(1);
				}
				
			}
			
			System.out.println("DONE");
			System.out.println("EVERYTHING LOOKS GOOD!");
			System.out.println("-------------------------");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
