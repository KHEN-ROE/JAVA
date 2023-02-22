package dataStructure;

//셸 정렬(버전 1)

import java.util.Scanner;

public class ShellSort {
 //--- 셸 정렬 ---//
 static void shellSort(int[] a, int n) {
     for (int h = n / 2; h > 0; h /= 2)
         for (int i = h; i < n; i++) {
        	 
             int j;
             int tmp = a[i];
             for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
                 a[j + h] = a[j];
             a[j + h] = tmp;
             System.out.println("");
             System.out.println("h = " + h); //h는 떨어져있는 칸 수 를 의미
        	 for(int num : a) System.out.print(" "+num);
        	 System.out.println();
        	 System.out.println("");
         }
 }

 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.println("셸 정렬(버전 1)");
//     System.out.print("요솟수: ");
//     int nx = stdIn.nextInt();
//     int[] x = new int[nx];
//
//     for (int i = 0; i < nx; i++) {
//         System.out.print("x[" + i + "]: ");
//         x[i] = stdIn.nextInt();
//     }
     
     int []x = {8,1,4,2,7,6,3,5};
     int nx=8;
     for(int num : x) {
    	 System.out.print(" "+num);
    	
     }
     System.out.println("");
     shellSort(x, nx);         // 배열 x를 셸정렬
     
     System.out.println("오름차순으로 정렬했습니다.");
     for (int i = 0; i < nx; i++)
         System.out.print(" " + x[i]);
 }
}

