package edu.mission;

public class ex1 {

	public static void main(String[] args) {
		String s = "have a good day!";
		
		int length = s.length();
		char c;
		
		for(int i=0; i<length; i++) {
			c = s.charAt(i);
			if(c ==' ') {
				System.out.println();
			}
			else {
				System.out.print(c);
			}
		}
				

	}

}
