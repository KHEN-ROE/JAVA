package dataStructure;

import java.util.Scanner;

public class ex1_3 {//책에 있는 코드

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("input num1");
		int n1 = kb.nextInt();
		System.out.println("input num2");
		int n2 = kb.nextInt();
		System.out.println("input num3");
		int n3 = kb.nextInt();
		
		int max=n1;
		if(n2>max) {
			max = n2;
		}
		if(n3>max) {
			max = n3;
		}
		System.out.println(max);

	}

}
