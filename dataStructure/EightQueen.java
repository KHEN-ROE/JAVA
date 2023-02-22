package dataStructure;

class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}

class MyStack {
	private int top;
	private Point[] data;
	
	public MyStack() {
		top = 0;
		data = new Point[100];
	}
	
	public void push(Point p) {
		data[top++] = p; //넣고 증가. 첫 포인터가 0 가리키므로
	}
	
	public Point pop() {
		return data[--top];
	}
	
	public boolean isEmpty() {
		if(top ==0) return true;
		else return false;
	}
	
}


public class EightQueen {
	
	
	
	
	public static boolean checkMove(int x, int y, int[][]arr) {
		if(!checkRow(x,arr)) return false;
		if(!checkCol(y,arr)) return false;
		if(!checkDiagSW(x,y,arr)) return false;
		if(!checkDiagSE(x,y,arr)) return false;
		
		return true;
	}
	
	public static boolean checkRow(int x, int arr[][]) {
		for(int i=0; i<arr.length; i++) {
			if(arr[x][i]==1) return false;
		}
		return true;
	}
	
	public static boolean checkCol(int y, int arr[][]) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i][y]==1) return false;
		}
		return true;
	}
	
	
	
	public static boolean checkDiagSW(int x, int y, int arr[][]) {
		int dx=x;
		int dy=y;
		while(dx>=0 && dx<arr[y].length && dy>=0 && dy< arr[x].length) {
			if(arr[dx][dy]==1) 
				return false;
				dx--;
				dy--;
			
			
		}
		dx=x; //제자리로 돌아와서 다시 체크함.
		dy=y;
		while(dx>=0 && dx<arr[y].length && dy>=0 && dy< arr[x].length) {
			if(arr[dx][dy]==1) 
				return false;
				dx++;
				dy++;
			
	}
		return true;
}
	
	
	public static boolean checkDiagSE(int x, int y, int arr[][]) {
		int dx=x;
		int dy=y;
		while(dx>=0 && dx<arr.length && dy>=0 && dy<arr.length) {
			if(arr[dx][dy]==1) return false;
			dx--;
			dy++;
			
			
		}
		dx=x;
		dy=y;
		
		while (dx>=0 && dx< arr.length && dy>=0 && dy < arr.length) {
			if (arr[x][y] == 1)
				return false;
			dx++;
			dy--;
		}
		return true;
	}
	
	
	
	public static void solveQueen(int row, int col, int[][]arr) {
		MyStack s = new MyStack();
		Point p = new Point(0,0); //0,0으로 초기화 
		int x = p.getX();
		int y = p.getY();
		int flag = 0;
		while(true) {
			while(x<row) {
				while(y<col) {
					if(checkMove(x,y, arr)) {
						arr[x][y] = 1;
						s.push(new Point(x,y));
						y = 0; //밑에 칸 맨 첫번 째 열로 가겠다
						break; //남은 y를 검사할 필요가 없으므로 브레이크
					}
					y++;//유효한 포지션 아니면 다음 컬럼으로 감. 모든 컬럼 검사했는데 유효한 자리 없다? 이전에 찍은 포인트 pop하고 그 옆을 컬럼을 검사한다. 찍었던 그 자리가 맞는 자리가 아니라는 뜻
				}
				x++; //다음 행 검사. 
				if(y>=col) { //컬럼의 포인터가 체스판 벗어나면 팝을 함.
					if(!s.isEmpty()) {//들어 있으면 실행
						p = s.pop();//이전 포지션 팝
						x = p.getX();//x좌표
						y = p.getY();//y좌표
						arr[x][y]=0;//1 이었던 걸 다시 0으로 바꿔줌
						y++; //이전 포지션의 다음 컬럼 검사
					}
					else {
						flag=1;
						break;
					}
					
				}
			}
//			if(s.isEmpty()) break; //이렇게 해도 됨
			if(flag==1) break;
			printBoard(row, col, arr);
			p = s.pop();//이전 포지션 팝
			x = p.getX();//x좌표
			y = p.getY();//y좌표
			arr[x][y]=0;//1 이었던 걸 다시 0으로 바꿔줌
			y++; //이전 포지션의 다음 컬럼 검사
		}
	}
	
	static int num = 0; //전역변수 static 이유? static 안붙이면 1 계속 나옴
	
	public static void printBoard(int row, int col, int[][]arr) {
		System.out.println(++num);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int row=8;
		int col=8;
		int [][]arr = new int [row][col];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				arr[i][j]=0;
			}
		}
		
		solveQueen(row, col, arr);
		
	}
}
