package tester;

import queue.ConcurrentQueue;

public class ConcurrentTester implements Runnable{
	
	public static ConcurrentQueue<Integer> q = new ConcurrentQueue<Integer>();
	public static int NUM_TESTS = 10000000;
	
	/* Counter of what integer to add to the queue next */
	public static int toAdd = 1;
	
	/* last removed int. Used to make sure we are removing things in order */
	public static int lastRemoved = -1;
	
	/* Booleans determining whether this particular thread adds, removes, or both */
	public boolean add = false;
	public boolean remove = false;
	
	/* Thread number */
	public int threadNumber = -1;
	
	/* Time it took this thread to complete */
	public long time = -1;
	
	@Override
	public void run() {
		
		long t1 = System.currentTimeMillis();
		
		/* Add a bunch of things */
		if(add) {
			System.out.print("Thread " + threadNumber + " adding items to queue...");
			for(int i=0; i<NUM_TESTS; i++) {
				//System.out.println("Adding: " + toAdd);
				q.enqueue(toAdd);
				toAdd++;
			}
			System.out.println("DONE");
		}
		
		
		if(remove) {	
			System.out.print("Thread " + threadNumber + " removing items from queue...");
			for(int i=0; i<NUM_TESTS; i++) {
				int rem = q.dequeue();
				//System.out.println("Removed: " + rem);
				if(lastRemoved != -1 && rem != lastRemoved+1) {
					System.out.println("ERROR: REMOVED SOMETHING OUT OF ORDER. Expecting: " + (lastRemoved-1) + ". Dequeued: " + rem); 
				}
				lastRemoved = rem;
			}
			System.out.println("DONE");
		}
		
		this.time = System.currentTimeMillis() - t1;
	}

}
