package edu.mission;

import java.util.Scanner;

public class mission01 {//자유 낙하 물체의 위치 구하기
//등가속 운동 물체의 위치 공식은 아래와 같다
// x(t)=1/2at^2 + v0t + x0 (x(t):위치 / a:가속도 / t:time interval / v0:초기 속도 / x0:초기위치	
//1000m 상공에서 물체를 정지상태에서 가만히 놓아 자유 낙하 시키려한다. 출력 예와 같은 결과를 얻으세요(저항은 없고, 중력 가속도는 9.81m/s로 한다)
//출력 예) 5초 후 위치 : 877.38m
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("input height");
		double height = kb.nextInt();
		System.out.println("input time interval");
		double timeInterval = kb.nextDouble();
		
		double a = 9.81;
		double v0 = 0;
		double x0 = 0;
		double initialPosition= x0;
		double time=0;
		double currentPosition=initialPosition;
			
		while(currentPosition<height) {
			currentPosition=0.5*a*time*time+v0*time+x0;
			time+=timeInterval;
		}
		System.out.println(time+"초 후 충돌");
		kb.close();
	


	}

}
