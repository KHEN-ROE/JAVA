package edu;

public class Test38 {

	public static void main(String[] args) {
		int[][]a=new int[3][4];
		int[][]b=new int[4][5];
//		int[][]c=new int[3][3];
		int[][]d=new int[a.length][b[0].length];
		
//		int num=1;
		System.out.println("배열 a");
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++){
				
				double rnum = Math.random();
				int num = (int) (rnum * 5);
				a[i][j]=num;
				
				System.out.print(a[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("================================= ");
		System.out.println("배열 b");
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[i].length; j++){
				
				double rnum = Math.random();
				int num = (int) (rnum * 5);
				b[i][j]=num;
				System.out.print(b[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
			
		}
		
//		System.out.println("================================= ");
//		System.out.println("배열 c는 행렬의 합");
//		for(int i=0; i<c.length; i++) {
//			for(int j=0; j<c[i].length; j++){
//				
//				c[i][j]=a[i][j]+b[i][j];
//				System.out.print(c[i][j]);
//				System.out.print("\t");
//			}
//			System.out.print("\n");	
//		}
		System.out.println("================================= ");
		System.out.println("배열 d는 행렬의 곱");
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<b[0].length; j++){//[i]도 됨
				for(int k=0; k<a[0].length; k++) {
					d[i][j] += a[i][k] * b[k][j];//k는 a배열의 행, b배열의 열			
				}
				System.out.print(d[i][j]+"\t");//연산을 마친 후 여기서 최종 출력하고 다시 for문으로 돌아가 반복한다
				
			}
			System.out.print("\n");	
		}	
		//c = a + b
		
		//출력
		// a>b>c
		
		//d = a * b
	}

}
