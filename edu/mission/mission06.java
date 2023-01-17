package edu.mission;

import java.util.Scanner;

public class mission06 {//유클리드 호재법 이용하여 최대공약수 최소공배수 구하기
	//혼자 다시 풀어보고, 메소드, 클래스 이용하여 다시 풀어보라

	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("input two numbers:");
		int num1 = kb.nextInt();
		int num2 = kb.nextInt();
		
		int min = (num1<num2)?num1:num2;//삼항연산자 안쓰고 다른 방법은?
		int gcd=0;
		
		for(int i=1; i<=min; i++) {//int i는 왜 1부터 시작하나?//while 루프로 돌려보면?
			if(num1%i ==0 && num2%i ==0) {
				gcd=i;
			}
		}
		System.out.println("최대공약수 : "+gcd);
		System.out.println("최소공배수 : "+num1*num2/gcd);
		
	}

}
