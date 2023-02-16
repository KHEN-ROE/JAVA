package dataStructure;

import java.util.Scanner;

public class Hanoi { //dd

	public static void move(int n, int x, int y) {
		if(n>1) {
			move(n-1, x, 6-x-y);
		}
		System.out.printf("원반[%d]를 %d번 기둥에서 %d번 기둥으로 옮김\n", n, x, y);
		if(n>1){
			move(n-1, 6-x-y, y);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("하노이의 탑");
		System.out.println("원반의 개수");
		int n = kb.nextInt();
		
		move(n, 1, 3); //n개의 원반을 1번 기둥에서 3번 기둥으로 옮김

	}

}
