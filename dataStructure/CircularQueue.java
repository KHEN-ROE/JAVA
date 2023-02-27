//package dataStructure;
////원형큐 - 선형큐의 문제점 보완
////선형큐의 문제점? - rear가 가르키는 포인터가 배열의 마지막 인덱스를 가르키고 있을 때
////앞쪽에서 디큐로 발생한 배열의 빈 공간을 활용 할 수가 없음
//import dataStructure.CircularQueue.EmptyCircularQueueException;
//
//public class CircularQueue {
//
//	private Point[] data; //큐용 배열선언. 생성은 아직
//	private int capacity; // 큐의 크기
//	private int front; //맨 처음 요소 커서
//	private int rear; //맨 끝 요소 커서
//	private int num; // 현재 데이터 개수
//	private int cnt;
//	
//	
//	//--- 실행시 예외: 큐가 비어있음 ---//
//	public class EmptyCircularQueueException extends RuntimeException {//내부 클래스
//	   public EmptyCircularQueueException() { }
//	}
//
//	//--- 실행시 예외: 큐가 가득 찼음 ---//
//	public class OverflowCircularQueueException extends RuntimeException {//내부 클래스
//	   public OverflowCircularQueueException() { }
//	}
//	
//	//--- 생성자(constructor) ---//
//	public CircularQueue(int capacity) {
//	   num = front = rear = 0; //큐가 비어있을 때
//	   this.capacity = capacity; 
//	   try {
//	       data = new Point[capacity];          // 큐 본체용 배열을 생성
//	   } catch (OutOfMemoryError e) {        // 생성할 수 없음
//	       capacity = 0;
//	   }
//	}
//	
//	//원형큐에 데이터 인큐//
//	public Point enque(Point x) throws OverflowCircularQueueException{
//		if((rear+1) % capacity == front) { //가득찬 경우
//			throw new OverflowCircularQueueException();
//		}
//		else {
//			rear = (rear+1) % capacity;
//			data[rear] = x;
//			num++;
//			cnt++;
//		}
//		return x;
//	}
//	
//	//원형큐에서 데이터 디큐//
//	public Point deque() throws EmptyCircularQueueException{
//		if(front == rear) {//큐가 비어있는 경우
//			throw new EmptyCircularQueueException();
//		}
//		else {
//			Point x;
//			x = data[front];
//			front = (front+1) % capacity; 
//        	num--;
//        	cnt--;
//            return x;    //디큐는 맞는 것 같은데 덤프하면 이상하게 나옴. 덤프 코드가 잘못된 듯
//		}
//	}
//	
//	//원형큐에서 데이터를 피크(프런트 데이터를 들여다봄)
//	public Point peek() throws EmptyCircularQueueException{
//		if(front == rear) {//큐가 비어있는 경우
//			throw new EmptyCircularQueueException();
//		}
//		else {
//			System.out.println("현재 포인터는 :" + cnt);
//			return data[rear-1];
//			
//		}
//	}
//	
//	//--- 큐를 비움 ---//
//	public void clear() {
//	   num = front = rear = 0;
//	}
//	
//	//--- 큐의 크기를 반환 ---//
//	public int getCapacity() {
//	   return capacity;
//	}
//	
//	//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
//	public int size() {
//	   return num;
//	}
//	
//
//	//--- 큐가 비어있는가? ---//
//	public boolean isEmpty() {
//	   return num <= 0;
//	}
//
//	//--- 큐가 가득 찼는가? ---//
//	public boolean isFull() {
//	   return num >= capacity;
//	}
//	
//	//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
//	public void dump() {
//		   if (num <= 0)
//		       System.out.println("큐가 비어있습니다.");
//		   else {
//		       for (int i = 0; i < num; i++)
//		           System.out.print(data[(i + front) % capacity] + " "); //i + rear 하면 디큐한 데이터가 출력되는데? 다시 짤것
//		       System.out.println();
//		   }
//	}
//	
//}