package dataStructure;

import java.util.Scanner;

public class Factorial {

	public static int factorial(int n) {
//		if(n>0) {
//			return n * factorial(n-1);
//		}else {
//			return 1;
//		}
		//삼항연산자로 작성하면
		return n>0? n* factorial(n-1) : 1 ;
	}
	
	public static void main(String[] args) {
		
		try (Scanner kb = new Scanner(System.in)) {
			System.out.println("숫자를 입력하세요");
			int n = kb.nextInt();
			System.out.println(n+"의 팩토리얼은 " + factorial(n));
			
			
		}

	}

}
