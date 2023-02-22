//package dataStructure;
//
////퀵 정렬(비재귀 버전)
//
//import java.util.Scanner;
//
//public class QuickSort2 {
// //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
// static void swap(int[] a, int idx1, int idx2) {
//     int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
// }
//
// //--- 퀵 정렬(비재귀 버전)---//
// static void quickSort(int[] a, int left, int right) {
//     MyStack lstack = new MyStack(right - left + 1); //스택 하나만 쓸것(포인트 타입으로)
//     MyStack rstack = new MyStack(right - left + 1);
//     Point p = new Point(left, right);
////     lstack.push(left);
////     rstack.push(right);
//     s.push(p);
//     while (lstack.isEmpty() != true) {
//         int pl = left  = lstack.pop();        // 왼쪽 커서
//         int pr = right = rstack.pop();        // 오른쪽 커서
//         p = s.pop();
//         int x = a[(left + right) / 2];        // 피벗은 가운데 요소
//         left = p.getX();
//
//         do {
//             while (a[pl] < x) pl++;
//             while (a[pr] > x) pr--;
//             if (pl <= pr)
//                 swap(a, pl++, pr--);
//         } while (pl <= pr);
//
//         if (left < pr) {
//             lstack.push(left);           // 왼쪽 그룹 범위의
//             rstack.push(pr);             // 인덱스를 푸시
//         }
//         if (pl < right) {
//             lstack.push(pl);             // 오른쪽 그룹 범위의
//             rstack.push(right);          // 인덱스를 푸시
//         }
//     }
// }
//
// public static void main(String[] args) {
//     Scanner stdIn = new Scanner(System.in);
//
//     System.out.println("퀵 정렬");
//     System.out.print("요솟수: ");
//     int nx = stdIn.nextInt();
//     int[] x = new int[nx];
//
//     for (int i = 0; i < nx; i++) {
//         System.out.print("x[" + i + "]: ");
//         x[i] = stdIn.nextInt();
//     }
//
//     quickSort(x, 0, nx - 1);            // 배열 x를 퀵정렬
//
//     System.out.println("오름차순으로 정렬했습니다.");
//     for (int i = 0; i < nx; i++)
//         System.out.println("x[" + i + "]=" + x[i]);
// }
//}
