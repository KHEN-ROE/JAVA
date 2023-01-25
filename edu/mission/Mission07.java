package edu.mission;

import java.util.Scanner;

public class Mission07 {//소수 판단 문제. //소수?  1과 자기 자신만을 약수로 가지는 수 ex)5, 7 ...
	public void prime(int num) {//static을 없애고 어떻게 작성?static에서 static이 아닌 메소드 호출하면 오류. 객체를 만들어주면 됨. 참조변수.메소드 이렇게 호출
		System.out.println("입력 숫자 : " + num);
		for(int i=2; i<num; i++ ) {
			if(num%i==0) {
				System.out.println("소수가 아닙니다");
				break;
			}
			else {
				System.out.println("소수입니다");
				break;
			}
		}
		
	}
	public static void main(String[] args) {//루프를 돌면서 값을 입력
		
		Mission07 ss = new Mission07();//자기 자신의 객체 생성 static이 없을 떄 이렇게 만듦
		
		 try (Scanner kb = new Scanner(System.in)) {
			System.out.println("input number");
			 int num;
			 while((num=kb.nextInt())!=0) {//()로 한번 더 감싸줘야하네			 
				 ss.prime(num);
			 }
		}
	}
}
