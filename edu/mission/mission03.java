package edu.mission;

import java.util.Scanner;

public class mission03 {

	public static void main(String[] args) {
		//메인 메소드에 다 넣는 방법 
		//메소드 만들어서 호출하는 방법
		//클래스를 만들어서 호출하는 방법 -집가서 셋 다 해볼 것
		Scanner kb = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int decimal = kb.nextInt();
		int remainder;
		String binary="";
		
		while(decimal>0) {
			remainder = decimal%2;
			binary = remainder + binary;//String과 int를 붙이면 자바에서는 자동으로 String으로 변환해줌
			decimal = decimal/2;//연산을 한 번 마치고 처음 조건문으로 다시 돌아간다.
			
		}
		System.out.println("2진수로 변환한 값은"+" : "+binary);
	}

}
