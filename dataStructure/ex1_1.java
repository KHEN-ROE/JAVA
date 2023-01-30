package dataStructure;

import java.util.Scanner;

public class ex1_1 {//네 값 중 최댓값 구하기 다른 방법

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("input num1");
		int n1 = kb.nextInt();
		System.out.println("input num2");
		int n2 = kb.nextInt();
		System.out.println("input num3");
		int n3 = kb.nextInt();
		System.out.println("input num4");
		int n4 = kb.nextInt();
		
		int max=0;
		if(n1<n2) {
			max = n2;
		}
		if(n2<n3) {
			max = n3;
		}
		if(n3<n4) {
			max = n4;
		}
		if(n1>n3) {
			max = n1;
		}
		if(n1>n4) {
			max = n1;
		}
		System.out.println("maximum value is : "+max);

	}

}
