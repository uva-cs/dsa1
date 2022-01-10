package tester;

public class MainTester {

	public static void main(String[] args) {
		
		System.out.println("RUNNING SEQUENTIAL TEST");
		System.out.println("------------------------------------");
		long t1 = System.currentTimeMillis();
		SequentialTester.runSequentialTest();
		long time = System.currentTimeMillis() - t1;
		System.out.println("------------------------------------");
		System.out.println("SEQUENTIAL TEST COMPLETE");
		System.out.println("TIME TO COMPLETE SEQUENTIAL TEST: " + time + " ms");
		
		System.out.println("\n\n");
		
		
		System.out.println("RUNNING CONCURRENT TEST");
		System.out.println("------------------------------------");
		
		ConcurrentTester ct1 = new ConcurrentTester();
		ct1.add = true; ct1.remove = false; ct1.threadNumber = 1;
		Thread th1 = new Thread(ct1);
		
		ConcurrentTester ct2 = new ConcurrentTester();
		ct2.add = false; ct2.remove = true; ct2.threadNumber = 2;
		Thread th2 = new Thread(ct2);
		
		th1.start();
		th2.start();
		try {
		th1.join(); th2.join();
		}
		catch(Exception e) {e.printStackTrace();}
		System.out.println("------------------------------------");
		System.out.println("CONCURRENT TEST COMPLETE");
		System.out.println("TIME TO COMPLETE CONCURRENT TEST: " + Math.max(ct1.time,ct2.time) + " ms");
	}

}
