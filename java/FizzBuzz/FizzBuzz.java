import java.io.*;

public class FizzBuzz {

	public static void main(String[] args) {
		
		for(int i=1; i<=1000; i++) {
			String out = "";
			
			if(i%3 == 0) {
				out += "fizz ";
			}
			
			if(i%5 == 0) {
				out += "buzz";
			}
			
			if(out.length() == 0) {
				out = "" + i;
			}
			
			System.out.println(out);
		}
		
	}

}
