package dataStructure;

class Point2{
	private int x,y;
	
	//생성자
	public Point2(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString(int x, int y) {
		return "<" + x + "," + y + ">";
	}
	
}

class Stack2 {
	//스택 포인터
	int top;
	//스택용 배열
	Point2 data[];
	
	//생성자
	public Stack2(){
		top =0;
		data=new Point2[100];
	}
	
	public void push(Point2 p) {
		data[top++]=p;
	}
	
	public Point2 pop() {
		return data[--top];
	}
	
	public boolean isEmpty() {
		if (top==0) return true;
		else return false;
	}
}


public class EightQueensPR {
	
	public static void solveQueen2(int row, int col, int arr[][]) {
		
		//초기 위치 0,0으로 세팅
		Point2 p = new Point2(0,0);
		Stack2 st = new Stack2();
		int x = p.getX();
		int y = p.getY();
		int flag = 0;
		
		while(true) {
		//행과열의 인덱스 만큼 반복하므로 2중 반복문
		while(x<row) {
			while(y<col) {
				if(checkMove(x,y,arr)) {
					arr[x][y]=1; //맨 처음에 0,0자리에 1배치.
					st.push(new Point2(x,y)); // x,y가 반복문에 의해 증가될 때마다 새로운 객체 만들어서 스택에 푸시
					y=0;
					break;
				}
				else y++;
			}
			x++;
			
			if(y>=col) {
				if(!st.isEmpty()) {
				p = st.pop();
				x = p.getX();
				y = p.getY();
				arr[x][y]=0;
				y++;
				}
				else {
					flag=1;
					break;
				}
			}
			
		}
		if(flag==1) break;
		printBoard(row,col,arr);
		p = st.pop();
		x = p.getX();
		y = p.getY();
		arr[x][y]=0;
		y++;
		}
	}
	
	//행, 열 대각선을 검사하여 모두 유효하면 퀸을 배치한다.
	public static boolean checkMove(int x, int y, int[][]arr) {
		if(!checkRow(x, arr) || !checkCol(y, arr) || !checkDiagSW(x, y, arr) || !checkDiagSE(x, y, arr)) return false;
		return true;
	}
	
	public static boolean checkRow(int x, int[][]arr) {
		for(int i=0; i<arr.length; i++) {
				if(arr[x][i] ==1) return false;
		}
		return true;
	}
	
	public static boolean checkCol(int y, int[][]arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i][y] ==1) return false;
		}
		return true;
	}
	
	public static boolean checkDiagSW(int x, int y, int[][]arr) {
		int dx=x;
		int dy=y;
		while(dx>=0 && dx<arr.length && dy>=0 && dy<arr.length) {
			if(arr[dx][dy] ==1) return false;
			dx--;
			dy--;
		}
		dx=x;
		dy=x;
		while(dx>=0 && dx<arr.length && dy>=0 && dy<arr.length) {
			if(arr[dx][dy] ==1) return false;
			dx++;
			dy++;
		}
		
		return true;
	}
	
	public static boolean checkDiagSE(int x, int y, int[][]arr) {
		int dx=x;
		int dy=y;
		while(dx>=0 && dx<arr.length && dy>=0 && dy<arr.length) {
			if(arr[dx][dy] ==1) return false;
			dx--;
			dy++;
		}
		dx=x;
		dy=x;
		while(dx>=0 && dx<arr.length && dy>=0 && dy<arr.length) {
			if(arr[dx][dy] ==1) return false;
			dx++;
			dy--;
		}
		return true;
	}
	
	static int num=1;
	
	public static void printBoard(int x, int y, int[][]arr) {
		System.out.println("solution : "+num++);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		//체스판 배열 생성 및 초기화
		int row=8, col=8;
		int board[][] = new int[row][col];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				board[i][j] = 0;
			}
		}
		solveQueen2(row, col, board);
		
		

	}

}
