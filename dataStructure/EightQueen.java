package dataStructure;

class MyStack {
	public Point []data; // 스택용 배열 선언. 생성은 아직 안함
	public int capacity; // 스택 용량
	int top; // 스택 포인터
	
	//--- 실행시 예외: 스택이 비어있음 ---//
	public class EmptyMyStackException extends RuntimeException {//내부 클래스
	   public EmptyMyStackException() { }
	}

	//--- 실행시 예외: 스택이 가득 찼음 ---//
	public class OverflowMyStackException extends RuntimeException {//내부 클래스
	   public OverflowMyStackException() { }
	}
	
	//--- 생성자(constructor) ---//
	public MyStack(int capacity) {
	   top = 0;
	   this.capacity = capacity; 
	   try {
	       data = new Point[capacity];          // 스택 본체용 배열을 생성
	   } catch (OutOfMemoryError e) {        // 생성할 수 없음
	       capacity = 0;
	   }
	}
	
	//--- 스택에 x를 푸시 ---//
    public Point push(Point x) throws OverflowMyStackException {
        if (top >= capacity)                                    // 스택이 가득 참
            throw new OverflowMyStackException();
        return data[top++] = x;
    }
    
  //--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
    public Point pop() throws EmptyMyStackException {
        if (top <= 0)                                          // 스택이 빔
            throw new EmptyMyStackException();
        return data[--top];
    }
    
    //--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
    public Point peek() throws EmptyMyStackException {
        if (top <= 0)                                        // 스택이 빔
            throw new EmptyMyStackException();
        return data[top - 1];
    }

    //--- 스택을 비움 ---//
    public void clear() {
    	top = 0;
    }
 
    //--- 스택의 크기를 반환 ---//
    public int getCapacity() {
        return capacity;
    }

    //--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
    public int size() {
        return top;
    }

    //--- 스택이 비어있는가? ---//
    public boolean isEmpty() {
        return top <= 0;
    }

    //--- 스택이 가득 찼는가? ---//
    public boolean isFull() {
        return top >= capacity;
    }
	
  //--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
    public void dump() {
        if (top <= 0)
            System.out.println("스택이 비어있습니다.");
        else {
            for (int i = 0; i < top; i++)
                System.out.print(data[i] + " ");
            System.out.println();
        }
    }
}

class Point {
	
	private int ix;
	private int iy;
	
	public Point(int x, int y) {
		ix = x;
		iy = y;
	}
	
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}
	
	public int getX() {
		return ix;
	}
	
	public int getY() {
		return iy;
	}
	
	public void setX(int x) {
		ix = x;
	}
	
	public void setY(int y) {
		iy = y;
	}
}

public class EightQueen {

	
	public static void solveQueen(int [][]data){
		
		
	}
	
	public static void main(String[] args) {
		int [][]data = new int[8][8];
		//배열 초기화 어떻게 할건지? 초기값 뭘로?
		
		
		solveQueen(data);

	}

}
