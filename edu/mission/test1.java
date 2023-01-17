package edu.mission;

import java.util.Arrays;

public class test1 {

	public static void main(String[] args) {
		int[] a = {1,3,5,7};
		int[] b = {2,4,6,8};
		int[] c = new int[a.length + b.length];
		int index = 0;

		for (int i = 0; i < a.length; i++) {
		    c[index] = a[i];
		    index++;
		}
		for (int i = 0; i < b.length; i++) {
		    c[index] = b[i];
		    index++;
		}

		Arrays.sort(c);
		for(int result : c) {//배열을 반복문 바깥에서 출력하려면 for each문을 쓰면 되네?
			System.out.print(result+" ");
		}

	}

}
