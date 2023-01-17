package edu;

public class Test22 {//switch ~ case 문은 범위나 조건보다 특정 값을 출력하고 싶을 때 사용

	public static void main(String[] args) {
		int a=12;
		int b=2;
		char op='+';
		
		switch(op) {
		case '+':
			System.out.println(a+b); 
			
		case '-':
			System.out.println(a-b); break;
			
		case '*':
			System.out.println(a*b); 
		
		case '/':
			System.out.println(a/b);  
		
		default :
			System.out.println("??");
		}
		
		

	}

}
