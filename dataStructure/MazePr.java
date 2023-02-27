package dataStructure;

class Items1 { //스택에 푸쉬할 좌표값을 위한 클래스
	public int x; //private으로 선언하면 게터와 세터 필요
	public int y;
	public int dir;
	//생성자
	public Items1(int x, int y, int dir){
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
	
	@Override
	public String toString() {
		return x + "," + y +"," + dir;
	}
}

class Stack1 { // 쥐가 다녀간 길 push, pop 할  스택
	
	//스택용 배열
	private Items1 data[];
	
	//스택 포인터
	private int top;
	
	//생성자
	public Stack1() {
		top=0;
		data=new Items1[100];
	}
	
	//푸쉬 메소드
	public void push(Items1 it) {
		data[top++] = it;
	}
	
	//팝 메소드
	public Items1 pop() {
		return data[--top];
	}
	
	//스택이 비어있으면
	public boolean isEmpty() {
		if(top==0) return true;
		else  return false;
	}
}

public class MazePr {//미로찾기 연습

	public static void path(int m, int p, int input[][]) {
		//방향 탐색 배열
				int moves[][] = {{0,1}, // e
								 {1,1}, // se
								 {1,0}, // s
								 {1,-1}, // sw
								 {0,-1}, // w
								 {-1,-1},// nw
								 {-1,0}, // n
								 {-1,1} // ne
								 };
		//파라미터 받아서 배열 두 개 생성
		//mark는 쥐가 지나간 경로
		//maze는 input에다가 테두리 친 배열
		int mark[][] = new int[m+2][p+2];
		int maze[][] = new int[m+2][p+2];
		
		
		
		//maze, mark 배열 초기화
		for(int i=0; i<14; i++) {
			for(int j=0; j<17; j++) {
				if(i==0 || j==0 || i==13 || j==16) {
					maze[i][j]=1;
					mark[i][j]=1;
				}
				else {
					maze[i][j]=input[i-1][j-1];
					mark[i][j]=0;
				}
			}
		}
		
		//시작점을 줌
		mark[1][1] = 4;
		maze[1][1] = 4;
		//stack 생성해서 좌표값 푸시
		Stack1 st = new Stack1();
		
		//Items 객체 생성해서 좌표값 저장
		//1,1에서 시작. 다음 경로 dir은 왜 0? 그냥..
		Items1 it = new Items1(1,1,0); //Items1은 좌표를 저장하는 객체
		st.push(it);
		
		
		//경로 검사하는 반복문. 8방향 검사
		while(!st.isEmpty()) {
			it=st.pop(); //왜 바로 pop하는가? 앞에서 push해서 스택 포인터가 1을 가리킨 상태였음. 여기서 pop을 해서 포인터(top)를 0으로 만들어주고 좌표값을 반환하게 하는 거임. pop의 역할 : 8방위 검사하다가 유효한 곳 갔는데 길 막히면 여기로 돌아옴. 마지막 위치 pop하고 마지막 좌표값을 i,j,d에 저장. 그 후 다시 방위 검사. 이게 백트래킹. 갔던 곳은 4로 표시하고 다시 안 감.
			int i = it.x; //시작 점의 좌표를 i,j,d에 저장
			int j = it.y;
			int d = it.dir;
			
			//방향 검사
			while(d<moves.length) {//8방위 검사하고 출구에 못가면 위의 while문으로 간다
				//이동하려면 처음 좌표에서 +를 해줘야함. 일단 이동하고
				int g = i+moves[d][0]; //d는 행. 뒤에는 열
				int h = j+moves[d][1];
				
				//이동한 위치가 유효한지 검사 후 참이면 push
				if(maze[g][h]==0 && mark[g][h]==0) {
					mark[g][h]=4; maze[g][h]=4;
					Items1 it1 = new Items1(i,j,d);
					st.push(it1);
					i = g;
					j = h;
					d = 0; //d가 왜 0? 다음 방향 초기화 하려고?
					
				}
				//유효하지 않으면 다음 방위 검사
				else d++;
				
				//지나온 길은 그냥 0으로 하고 출구만 4로 표시하고 싶은 경우
//				if((g==m-1) && (h==p-1)) {
//					maze[g][h]=4;
//				}
				
				//정답 출력
				if((g == m-1) && (h == p-1)) { //왜 m-1, p-1 이 출구인가? 1,1에서 시작했기 떄문
					System.out.println("출구 :" + g + "," + h);
					System.out.println("1은 막힌 길");
					System.out.println("미로에서 쥐가 간 경로 : 4");
					//미로와 쥐가 간 경로 같이 출력
					for(int i1 =0; i1<maze.length; i1++) {
						for(int j1=0; j1<maze[0].length; j1++) {
							System.out.print(maze[i1][j1]);
						}
						System.out.println();
					}
					System.out.println();
					//쥐가 간 경로(mark)만 출력
					System.out.println("쥐가 간 경로만 4로 출력");
					for(int i2 =0; i2<mark.length; i2++) {
						for(int j2=0; j2<mark[0].length; j2++) {
							System.out.print(mark[i2][j2]);
						}
						System.out.println();
					}
					return;
				}
		
			}
			
		}
		System.out.println("no path in maze");
	}
	
	
	public static void main(String[] args) {
		//미로판
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
		
		
		//메소드 호출
		path(input.length, input[0].length, input);

	}

}
