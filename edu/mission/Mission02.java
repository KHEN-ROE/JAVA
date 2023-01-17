package edu.mission;

import java.util.Scanner;

public class Mission02 {
//최소 지폐 수 계산
//상품 가격 152,365원을 지불하기 위해 필요한 최소 지폐 장수는 아래와 같다
//5만원*3장, 1만원*0장, 5천원*0장, 1천원*2장
//천 원 미만은 할인하고 임의의 금액을 지불하기 위해 필요한 지폐 장수를 구하는 프로그램 작성
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("금액을 입력하세요.");
		int total = kb.nextInt();
		
//		int total = 152000;
		int m5 = 50000; //이 변수들을 배열로 만들어서 루프를 돌리면? 4개 짜리 배열로 만들고 for each 문 써서 작성
		int m1 = 10000;
		int t5 = 5000;
		int t1 = 1000;
		
		int a = total/m5; // 5만원 권 개수 반환
		System.out.println(m5+"원 권"+" : "+a+"장");
		
		int total1 = total - (m5*a);// 161000 - 150000 = 11000원 남는다
		int b = total1/m1; //1만원권 개수 반환하고 1천원 남음
		System.out.println(m1+"원 권"+" : "+b+"장");
		
		int total2 = total1 - (m1*b);
		int c = total2/t5;
		System.out.println(t5+"원 권"+" : "+c+"장");
		
		int total3 = total2 - (t5*c);
		int d = total3/t1;
		System.out.println(t1+"원 권"+" : "+d+"장");
		
		//배열을 만들어서 반복문으로 작성해볼것 값을 입력받는 while, 잔돈을 계사하는 for loop 두개 만들기?
		
		

	}

}
