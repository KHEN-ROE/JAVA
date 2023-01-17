package edu;

public class Test6 {

	public static void main(String[] args) {
		int a=10;
		a++;
		System.out.println(a);
		++a;
		System.out.println(a);
		
		int b=10;
		b--;
		System.out.println(b);
		--b;
		System.out.println(b);
		
		int c=10;
		int d=10;
		System.out.println(++c);//먼저 더한다
		System.out.println(d++);//;이 끝나고 난 다음에 1을 더한다
		System.out.println(d);

	}

}
