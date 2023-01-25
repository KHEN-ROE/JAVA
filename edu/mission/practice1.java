package edu.mission;

import java.util.Scanner;

public class practice1 {

	public static void prime(int num) {
		System.out.println("입력숫자 : "+num);
		boolean isPrime=true;
		if(num<=1) {
			isPrime=false;
		}
		else {
			for(int i=2; i<num; i++) {
				if(num%2==0) {
					isPrime=false;
					System.out.println("소수가 아닙니다");
					break;
				}
				else {
					isPrime=true;
					System.out.println("소수입니다");
					break;
				}	
			}	
		}
	}
	
	public static void main(String[] args) {
		try (Scanner kb = new Scanner(System.in)) {
			System.out.println("input number");
			int num;
			while((num=kb.nextInt())!=0) {
				prime(num);
			}
		}
			
	}
}
