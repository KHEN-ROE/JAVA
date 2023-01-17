package edu;

public class Test35 {

	public static void main(String[] args) {
		int[]arr= new int[6];
		for(int i=1; i<arr.length; i++)
		{
			arr[i]=i*10;
		}
		for(int num:arr) {
			System.out.println(num);
		}

	}

}
