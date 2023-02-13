package dataStructure;

import java.util.Scanner;

public class EuclidGCD {

	public static int gcd(int x, int y) {
		if(y==0) {
			return x;
		}else {
			return gcd(y, x%y); //y가 0 이 나올때까지 재귀 반복 22, 8 받으면 처음 계산에서 8,6 리턴 이제 x가 8이되고 y가 6이 됨. 이걸 반복하면 gcd는 2가 됨
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수1 입력");
		int x = sc.nextInt();
		System.out.println("정수2 입력");
		int y = sc.nextInt();
		
		System.out.println("최대공약수는 " + gcd(x, y) + "입니다");
	}

}
