//package dataStructure;
//
//import java.util.*;
//
//class Items1 {
//public int x, y, dir;
//
//public Items1(int x, int y, int dir) {
//    this.x = x;
//    this.y = y;
//    this.dir = dir;
//}
//
//@Override
//public String toString() {
//    return x + "," + y + "," + dir;
//	}
//}
//
//class Offsets1 {
//public int a, b;
//
//public Offsets1(int a, int b) {
//    this.a = a;
//    this.b = b;
//	}
//}
//
//enum Directions {
//N, NE, E, SE, S, SW, W, NW
//}
//
//public class Maze{
//private static Offsets[] moves;
//private static int[][] maze;
//private static int[][] mark;
//
//public static void path(int m, int p) {
//    mark = new int[m][p];
//
//    // start at (1,1)
//    mark[0][0] = 1;
//    Stack<Items> stack = new Stack<>();
//    Items temp = new Items(0, 0, Directions.E.ordinal());
//    stack.push(temp);
//
//    while (!stack.isEmpty()) {
//        temp = stack.pop();
//        int i = temp.x;
//        int j = temp.y;
//        int d = temp.dir;
//
//        while (d < 8) {
//            int g = i + moves[d].a;
//            int h = j + moves[d].b;
//
//            if ((g == m - 1) && (h == p - 1)) { // reached exit
//                // output path
//                System.out.println(stack);
//
//                System.out.println("the term near the exit: " + i + " " + j);
//                System.out.println("exit: " + (m - 1) + " " + (p - 1));
//                return;
//            }
//
//            if ((maze[g][h]==0) && (mark[g][h] == 0)) { // new position
//                mark[g][h] = 1;
//                temp = new Items(i, j, d + 1);
//                stack.push(temp);
//                i = g;
//                j = h;
//                d = Directions.N.ordinal();
//            } else {
//                d++; // try next direction
//            }
//        }
//    }
//    System.out.println("no path in maze");
//	}
//
//
//public static void main(String[] args) {
//	int input[][] = {
//			{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
//			{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
//			{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
//			{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
//			{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
//			{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
//			{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
//			{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
//			{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
//			{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
//			{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
//			{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 },
//			};
//	for (int i = 0; i < input.length; i++) {
//	    for (int j = 0; j < input[0].length; j++) {
//	        maze[i][j] = input[i][j];
//	        mark[i][j] = 0;
//	    }
//	}
//
//	path(maze.length, maze[0].length);
//
//}
//}