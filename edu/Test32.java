package edu;

public class Test32 {

	public static void main(String[] args) {
//		int[]arr= new int[6];
//		for(int i=1; i<6; i++)
//			arr[i]=i*10;
		int[]score;
		score=new int[]{1,2,3,4,5};
		for(int i=0; i<score.length; i++) {//배열의 길이 : 배열명.length
			score[i]=i*10;
		}
//		arr[0]=10;
//		arr[1]=20;
//		arr[2]=30;
//		arr[3]=40;
//		arr[4]=50;
		
		for(int i=0; i<score.length; i++)
		System.out.print(score[i]+" ");
		
	}

}
