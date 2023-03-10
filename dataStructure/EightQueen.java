package dataStructure;
//디버깅을 하라!!
class Point3 {
	private int x;
	private int y;
	
	public Point3(int x, int y) {
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

class MyStack3 {
	private int top; //스택 포인터
	private Point3[] data; //스택용 배열
	
	public MyStack3() {
		top = 0;
		data = new Point3[100];
	}
	
	public void push(Point3 p) {
		data[top++] = p; //넣고 증가. 첫 포인터가 0 가리키므로
	}
	
	public Point3 pop() {
		return data[--top];
	}
	
	public boolean isEmpty() {
		if(top ==0) return true;
		else return false;
	}
	
}


public class EightQueen {
	
	public static void solveQueen(int row, int col, int[][]arr) {
		MyStack3 s = new MyStack3();
		Point3 p = new Point3(0,0); //0,0으로 초기화 
		int x = p.getX(); //초깃값 0
		int y = p.getY(); //초깃값 0
		int flag = 0; //true 탈출하기 위해 나중에 선언했다.
		while(true) {
			while(x<row) { //2중 for문과 같은 의미라고 생각하면 된다
				while(y<col) { //2중 for문과 같은 의미라고 생각하면 된다
					if(checkMove(x,y,arr)) {
						arr[x][y] = 1;
						s.push(new Point3(x,y));
						y = 0; //밑에 칸 맨 첫번 째 열로 가겠다
						break; //남은 y를 검사할 필요가 없으므로 브레이크. 열 검사 while문 탈출
					}
					else y++;//유효한 포지션 아니면 다음 컬럼으로 감. 모든 컬럼 검사했는데 유효한 자리 없다? 이전에 찍은 포인트 pop하고 그 옆을 컬럼을 검사한다. 찍었던 그 자리가 맞는 자리가 아니라는 뜻
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
//			if(s.isEmpty()) break; //이렇게 해도 됨. true를 빠져나오기 위해서 정답 다출력하고, 모든 포지션 pop하고 나서 탈출
			if(flag==1) break; //true를 빠져나오기 위해서 정답 다출력하고, 모든 포지션 pop하고 나서 탈출
			printBoard(row, col, arr); //정답을 출력하고 체스판을 초기화해야하므로 아래의 코드실행
			p = s.pop();//이전 포지션 팝
			x = p.getX();//x좌표
			y = p.getY();//y좌표
			arr[x][y]=0;//1 이었던 걸 다시 0으로 바꿔줌
			y++; //이전 포지션의 다음 컬럼 검사
		}
	}
	
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
		int dx=x; //밑에 dx=x 쓰려고 dx선언한 듯
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
