package dataStructure;

import java.util.Random;
import java.util.Scanner;

public class CircularQueueTester {

	public static void main(String[] args) {
		 Scanner kb = new Scanner(System.in);
	     CircularQueue c = new CircularQueue(8);    // 최대 8개를 인큐할 수 있는 큐
	     Random random = new Random();
	     int rndx = 0, rndy = 0;
	     Point p = null;
	     
	     while (true) {
	      	System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
	          System.out.printf("현재 데이터 개수: %d / %d\n", c.size(), c.getCapacity());
	          System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");

	          int menu = kb.nextInt();
	          if (menu == 0) break; //종료조건

	          
	          switch (menu) {
	           case 1:                                // 인큐
	              System.out.print("데이터: ");
	              rndx = random.nextInt() % 20;
	 			 rndy = random.nextInt() % 20;
	              p = new Point(rndx, rndy);
	              try {
	                  c.enque(p);
	               } catch (CircularQueue.OverflowCircularQueueException e) {
	                  System.out.println("큐가 가득 찼습니다.");
	              }
	              break;

	           case 2:                                // 디큐
	              try {
	                   p = c.deque();
	                  System.out.println("디큐한 데이터는 " + p + "입니다.");
	               } catch (CircularQueue.EmptyCircularQueueException e) {
	                  System.out.println("큐가 비어 있습니다.");
	              }
	              break;

	           case 3:                                // 피크
	              try {
	                   p = c.peek();
	                  System.out.println("피크한 데이터는 " + p + "입니다.");
	               } catch (CircularQueue.EmptyCircularQueueException e) {
	                  System.out.println("큐가 비어 있습니다.");
	              }
	              break;

	           case 4:                                // 덤프
	              c.dump();
	              break;
	          }
	      }

	}

}
