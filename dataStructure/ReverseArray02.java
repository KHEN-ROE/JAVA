package dataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray02 {

	public static void swap(int[]a, int idx1, int idx2) {//배열, i, n-i-1. 뒤에 두 매개변수는 서로 바꿀 값
		int t = a[idx1];//임시 변수 t에 a[0]번지에 있는 값 저장
		a[idx1] = a[idx2];//a[0]번지에 a[6]번지에 있는 값 저장
		a[idx2] = t;//t에 저장돼있는 a[0]번지의 값을 a[6]번지에 저장
	}
	
	public static void reverse(int[]a) {
		for(int i=0; i<a.length/2; i++) {
			swap(a, i, a.length-i-1);//배열, i, n-i-1 뒤에 두개는 서로 바꿀 값
		}
	}
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("요소수");
		int num = kb.nextInt();
		
		int[]x = new int[num];
		
		for(int i=0; i< num; i++) {
			System.out.println("x[" + i + "]: ");
			x[i] = kb.nextInt();
		}
		
		reverse(x);
		
		System.out.println("요소를 역순으로 정렬");
		System.out.println("x = " + Arrays.toString(x));//Arrays.toString메소드는 ,로 구분되며 []로 둘러싼 문자열 리턴

	}

}
