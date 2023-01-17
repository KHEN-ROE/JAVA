package edu;

public class Test28 {

	public static void main(String[] args) {
		int cnt=0;
		while(true) {
			System.out.println("ok");
			cnt=cnt+2;
			if(cnt==10) {//2,4,6,8,10에서 멈춤 따라서 5회 출력
				break;
			}
		}

	}

}
