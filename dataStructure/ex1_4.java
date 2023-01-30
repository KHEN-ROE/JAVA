package dataStructure;

import java.util.Scanner;

public class ex1_4 {//세 값 중 최솟값 구하기

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("input num1");
		int n1 = kb.nextInt();
		System.out.println("input num2");
		int n2 = kb.nextInt();
		System.out.println("input num3");
		int n3 = kb.nextInt();
		
		int min=n1;
		if(min>n2) {
			min = n2;
		}
		if(min>n3) {
			min = n3;
		}
		System.out.println(min);

	}

}
