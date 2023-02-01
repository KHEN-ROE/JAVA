package testPackage;




import dataStructure.PointQueue.EmptyPointQueueException;
import dataStructure.PointQueue.OverflowPointQueueException;

//Point형 고정 길이 큐

public class PointQueue {
	 private Point[] data;            // 큐용 배열. Point 타입으로 밑에 다 바꿀 것
	 private int capacity;         // 큐의 크기
	 private int front;            // 맨 처음 요소 커서
	 private int rear;             // 맨 끝 요소 커서
	 private int num;           // 현재 데이터 개수

//--- 실행시 예외: 큐가 비어있음 ---//
public class EmptyPointQueueException extends RuntimeException {//내부 클래스
   public EmptyPointQueueException() { }
}

//--- 실행시 예외: 큐가 가득 찼음 ---//
public class OverflowPointQueueException extends RuntimeException {//내부 클래스
   public OverflowPointQueueException() { }
}

//--- 생성자(constructor) ---//
public PointQueue(int capacity) {
   num = front = rear = 0;
   this.capacity = capacity; //큐가 비어있다? front rear 같으면 비어있는것
   try {
       data = new Point[capacity];          // 큐 본체용 배열을 생성
   } catch (OutOfMemoryError e) {        // 생성할 수 없음
       capacity = 0;
   }
}


//--- 큐에 데이터를 인큐 ---//
public Point enque(Point x) throws OverflowPointQueueException {
//	if((rear + 1) % capacity ==front)
   if (num >= capacity)//현재 데이터 개수가 용량과 같으면 예외처리
       throw new OverflowPointQueueException();            // 큐가 가득 찼음
   data[rear++] = x; // rear++시켜서 배열의 인덱스가 다음 인덱스 가리킴. x값을 거기다 저장
   num++;//현재 데이터 개수 증가
   if (rear == capacity) //rear 가 용량과 같으면
       rear = 0; //rear를 배열의 첫 인덱스인 0으로 변경
   return x;
}

//--- 큐에서 데이터를 디큐 ---//
public Point deque() throws EmptyPointQueueException {
   if (num <= 0)
       throw new EmptyPointQueueException();            // 큐가 비어있음
   Point x = data[front++];
   num--;
   if (front == capacity)
       front = 0;
   return x;
}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
public Point peek() throws EmptyPointQueueException {
   if (num <= 0)
       throw new EmptyPointQueueException();            // 큐가 비어있음
   return data[front];
}

//--- 큐를 비움 ---//
public void clear() {
   num = front = rear = 0;
}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
public int indexOf(Point x) {
   for (int i = 0; i < num; i++) {
       int idx = (i + front) % capacity;
       if (data[idx] == x)                // 검색 성공
           return idx;
   }
   return -1;                            // 검색 실패
}

//--- 큐의 크기를 반환 ---//
public int getCapacity() {
   return capacity;
}

//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
public int size() {
   return num;
}

//--- 큐가 비어있는가? ---//
public boolean isEmpty() {
   return num <= 0;
}

//--- 큐가 가득 찼는가? ---//
public boolean isFull() {
   return num >= capacity;
}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
public void dump() {
   if (num <= 0)
       System.out.println("큐가 비어있습니다.");
   else {
       for (int i = 0; i < num; i++)
           System.out.print(data[(i + front) % capacity] + " ");
       System.out.println();
   }
}
}