package dataStructure;

import java.util.Random;
import java.util.Scanner;



public class RandomEx {

	static int maxOf(int[]a) {
		int max = 0;
//		int index = 0; //인덱스 값 리턴하고 싶을 때
//		int mh[]=new int[index];
		for(int i=0; i<a.length; i++) {
			if(max<a[i]) {
				max = a[i];
//				index=i;
			}
		}
//		for(int k : mh) {
//			System.out.println(k);//인덱스 값 리턴하고 싶을 때
//		}
		return max;
		
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가장 큰 키 구하기");
		System.out.println("사람 수 : ");
		int num = sc.nextInt();
		
		int[]height = new int[num];
		
		System.out.println("키값");
		for(int i=0; i<num; i++) {
			height[i] = 120 + rand.nextInt(90);//0부터 89까지 수 반환
			System.out.println("height[" + i + "]: " + height[i]);
		}
		System.out.println(maxOf(height));
		

	}

}
