package edu.mission;

public class mission04 {

	public static void printArray(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[][] b = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		int[][] c = new int[a.length][b[0].length];
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<b[0].length; j++) {
				for(int k=0; k<a[0].length; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}	
			}
		}
		printArray(c);//되도록이면 메소드를 만들어서 사용하는 버릇을 들이면 좋다

	}

}
