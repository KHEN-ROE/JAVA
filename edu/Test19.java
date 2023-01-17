package edu;

public class Test19 {//조건문

	public static void main(String[] args) {
		int score=90;
		String result="";
		
		if(score>=60) {//중괄호는 코드 한 줄(;하나) 밖에 없으면 생략가능
			result="합격";
		}
		else {
			result="불합격";
		}
		System.out.println(result);
		System.out.println(score>=60?"합격":"불합격");
	}

}
