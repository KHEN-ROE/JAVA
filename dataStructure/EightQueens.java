package dataStructure;

import dataStructure.MyStack.EmptyMyStackException;
import dataStructure.MyStack.OverflowMyStackException;

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

public class EightQueens {//열을 바꿔가면서 하면 여러개의 해를 구할 수 있다 
	//체스판을 그려놓고 이해할 것
	//92개의 해를 보여주려면???
	public static void SolveQueen(int[][] d, int row, int col) {
		
		int count = 0; //스택에 있는 퀸의 개수 카운트. 퀸은 8개까지 배치가능
		int ix=row;
		int iy=col; //열의 값이 바뀌면 여러 해를 구할 수 있다.

		MyStack st = new MyStack(100);
		Point p = new Point(ix, iy);//Point 객체 생성하고 생성자에 초깃값 0,0 전달
		d[ix][iy] = 1; // 체스판 0,0에 퀸 배치하고 1로 저장
//		System.out.println("처음 퀸의 위치 : " + p);
		st.push(p); //퀸을 배치하면 스택에 저장
		count++; // 스택에 배치한 퀸의 개수(Point type)
//		System.out.println("스택에 있는 첫 퀸의 개수 : " + count);


		// count가 8이 될때까지 반복
		while (count < d.length) { //count < 8 이면 8회 밖에 못 찍는데
			ix++; // 행변경
			int cy = 0; // 행변경 후 항상 0번째 열부터 체크 필요 //cy는 행에 해당하는 열을 의미하는 변수
			
			// 행 반복하며 퀸 배치가능여부 판단
			while (ix < d.length) {//행을 순회하면서 체크하겠다는 의미
				cy = NextMove(d, ix, cy); // 배치가능: 열 인덱스 반환. 배치불가 팝. / 체스판, 현재행, 현재열 전달. NextMove 한번 호출하면 아래에 있는 모든 메소드 다 실행함. 즉 한 행에 해당하는 모든 열 체크. 모든 메소드 조건 충족하면 nextCol 반환하고 그걸 받아서 cy에 저장
				if (cy < d[0].length) {
					Point px = new Point(ix, cy); //다시 Point 객체 생성하여 생성자에 현재의 ix, cy값(퀸의 좌표) 전달
					st.push(px); // 스텍에 퀸의 좌표 저장
//					System.out.println("퀸의 위치 좌표값 : "+px);
					count++; // 현재 퀸의 개수 카운트
//					System.out.println("퀸의 개수: "+count);
					d[ix][cy] = 1; // 현재 좌표에 1저장. 즉 퀸 배치
					break; //퀸 배치하면 브레이크하고 다음행 체크
				}
				else{//cy가 8이면(범위 벗어나면) 이전에 배치했던 퀸을 pop한다. cy가 8이 되는 경우? 유효한 포지션이 없어서 nextCol이 계속 ++되는 경우임.
					p = st.pop();
					ix = p.getX();
					cy = p.getY();
					count--;
					d[ix][cy] = 0; //0으로 만들고
					cy++; //다음 컬럼으로 포인터 이동. 다시 체크
				}	
			}

		}
		
        if (count == d.length) {
        	for(int i=0; i<d.length; i++) {
        		for(int j=0; j<d.length; j++) {
        			System.out.print(d[i][j]);
        		}
        		System.out.println();
        	}
        	System.out.println();
        }
     
		

}

	public static int NextMove(int[][] d, int row, int col) {// 다음 row에 대하여 이동할 col을 조사하는 메소드
		int nextCol = col; // 다음 col로 넘어가기 위한 선언
		while (nextCol < d[0].length) // 인덱스 수만큼 반복
			if (CheckMove(d, row, nextCol)) // 현재 셀 체크가능여부 판단. checkMove가 true면 nextCol 리턴. 그걸 cy에 저장
				return nextCol; // 체크할 수 있으면 col 반환
			else
				nextCol++; //배치 불가하면 옆의 열을 체크하는 것임. 그리고 다시 배치가능 여부 판단.
		return d[0].length; // 체크할 수 있는 셀 없으면 -1 반환?
	}
	
	public static boolean CheckMove(int[][] d, int x, int y) {// 모든 조건을 만족할 때 true 리턴.
		
		if (checkRow(d, x, y) && checkCol(d, x, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y)) {
			return true; //NextMove 사실 필요 없다? 여기서 그냥 바로 리턴해도 되지않나?
		}
		return false;//기본적으로 false 리턴하는데 if절 만족해야만 true 리턴함
	}
	
	public static boolean checkRow(int[][] d, int cx, int cy) {//행에서 1이 있는지 체크
		for (int i = 0; i < d.length; i++) // i < cy인 이유? 해당하는 열의 값 만큼 반복. 열이 2면 2번만 실행
			if (d[cx][i] == 1)
				return false;
		return true;
	}

	public static boolean checkCol(int[][] d, int cx, int cy) {//열에서 1이 있는지 체크
		for (int i = 0; i < d.length; i++) { //i < cx인 이유? 해당하는 행의 값만큼 반복. 1행이면 1번만 실행 
			if (d[i][cy] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		int x = cx, y = cy;
		while (x>=0 && x< d.length && y>=0 && y < d.length) {
			if (d[x][y] == 1)
				return false;
			x++;
			y--;
		}
		x = cx;
		y = cy;
		while (x>=0 && x< d.length && y>=0 && y < d.length) {
			if (d[x][y] == 1)
				return false;
			x--;
			y++;
		}
		return true;
	}

	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
		int x = cx, y = cy;
		while (x>=0 && x< d.length && y>=0 && y < d.length) {
			if (d[x][y] == 1)
				return false;
			x++;
			y++;
		}
		x = cx;
		y = cy;
		while (x>=0 && x< d.length && y>=0 && y < d.length) {
			if (d[x][y] == 1)
				return false;
			x--;
			y--;
		}
		return true;
	}

	
	public static void main(String[] args) {
		int n=8;
		int[][] data = new int[n][n];
		
		for(int k=0; k<data.length; k++) {
			System.out.println((k+1)+"번째 정답");
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				data[i][j]=0;
			}
		}
				SolveQueen(data, 0, k);
				
		}
	}
}

