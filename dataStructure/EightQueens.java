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
	
	public int ix;
	public int iy;
	
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

public class EightQueens {

	public boolean Checkmove() {
	        
	    }
	
	public void nextMove(int []d, x, y) {
		
	}
		
	
	
	
	public static void solveQueen(int [][]data){
//backTracking 이용
//void NextMove(int[] d, x, y);    // current row에 대한 다음 배치 가능한 모든 column을 조사하고 move[]에 1로 설정
		
//boolean CheckMove(int currentRow, int row, int col)    //currentRow에 대하여 queen을 (x,y)에 배치 가능하면 true
//
//  => backtracking을 stack을 이용하여 push/pop으로 해결하는 것을 보이는 것임
//
// -> 가로, 세로, 대각선에 대한 충돌 체크 함수 코딩
//  boolean CheckMove(x,y) {
//	checkRow(x);
//	checkCol(y);
//	checkDiagSW(x,y); //x++, y-- or x--, y++ where 0<= x,y <= 7
//	checkDiagSE(x,y); //x++, y++ or x--, y--
//단위 함수를 만들어서 생각을 해야지 한꺼번에 하면 안되고. nextmove가 checkmove 부르고?. checkmove가 checkDiagSw 부른다.
	//체크는 true, false 로한다. 
	int count=0;
	
		
	while(count<8) {
		
		//퀸을 배치하고 스택에 (Point 타입)푸시.
		s.push();
		
		
	}
	
	public static void main(String[] args) {
		int [][]data = new int[8][8];
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[0].length; j++) {
				data[i][j] = 0;
			}
		}
		
		MyStack s = new MyStack(8);
		
		solveQueen(data);

	}

}
