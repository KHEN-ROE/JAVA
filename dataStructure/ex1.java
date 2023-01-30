package dataStructure;

import java.util.Scanner;

public class ex1 {//3개의 정수 입력받아서 최댓값 구하기. 나는 배열에다가 입력받는값 저장했다. 반복문 돌려서 값들을 비교하여 최댓값 출력

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("input num1");
		int n1 = kb.nextInt();
		System.out.println("input num2");
		int n2 = kb.nextInt();
		System.out.println("input num3");
		int n3 = kb.nextInt();
		
		int []arr = new int[3];
		arr[0] = n1;
		arr[1] = n2;
		arr[2] = n3;
		
		int max=0;
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("maximum number is : " + max);
	}

}
