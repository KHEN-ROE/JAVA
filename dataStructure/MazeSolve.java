package dataStructure;

class Items {
public int x, y, dir;

public Items(int x, int y, int dir) {
    this.x = x;
    this.y = y;
    this.dir = dir;   
}

@Override
public String toString() {
    return x + "," + y + "," + dir;
	}
}

class MyStack1 {
	private int top; //스택 포인터
	private Items[] data; //스택용 배열
	
	public MyStack1() {
		top = 0;
		data = new Items[100];
	}
	
	public void push(Items I) {
		data[top++] = I; //넣고 증가. 첫 포인터가 0 가리키므로
	}
	
	public Items pop() {
		return data[--top];
	}
	
	public boolean isEmpty() {
		if(top ==0) return true;
		else return false;
	}
	
}


public class MazeSolve {

	public static void path(int m, int p, int input[][]) {
		int moves[][] = {{0,1}, // e
						 {1,1}, // se
						 {1,0}, // s
						 {1,-1}, // sw
						 {0,-1}, // w
						 {-1,-1},// nw
						 {-1,0}, // n
						 {-1,1}};// ne
		int maze[][] = new int[m+2][p+2];
		int mark[][] = new int[m+2][p+2];
		
	
		for(int i=0; i<14; i++) {
			for(int j=0; j<17; j++) {
				if(i==0 || j==0 || i==13 || j==16) {
					maze[i][j]=1;
					mark[i][j]=1;
				}
				else {
					maze[i][j] = input[i-1][j-1];
					mark[i][j]=0;
				}
			}
		}
		
		//(1,1)에서 시작
		mark[1][1]=1;
		MyStack1 s = new MyStack1();
		
		Items temp = new Items(1, 1, 0);//dir을 뭘로 줌?
		s.push(temp);
		maze[1][1]=4;

		while(!s.isEmpty()) {
			temp = s.pop();
			int i = temp.x; //pop을 한 x좌표
			int j = temp.y; //pop을 한 x좌표
			int d = temp.dir; // 
			
			while(d<moves.length) {
				int g = i+moves[d][0];
				int h = j+moves[d][1];
				
				if((g==m-1) && (h==p-1)) {
	                System.out.println("exit: " + (m - 1) + " " + (p - 1));
	                System.out.println("쥐가 간 경로 : 4");
	                System.out.println("1은 원래 막혀 있던 곳");
	                
	                for(int i1=0; i1<mark.length; i1++) {
	                	for(int j1=0; j1<mark[0].length; j1++) {
	                		System.out.print(maze[i1][j1]);
	                	}
	                	System.out.println();
	                }
	                return;
				}
				
				if((maze[g][h]==0) && (mark[g][h])==0) {
					mark[g][h]=1; maze[g][h]=4;
					Items temp1 = new Items(i,j,d);
					s.push(temp1);
					i=g;
					j=h;
					d=0;
				}
				else d++;
			}
			
		}
		System.out.println("no path in maze");
	}
	
	
	public static void main(String[] args) {
		int input[][] = {
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }
				};
		

			path(input.length, input[0].length, input);
	}

		
	}
