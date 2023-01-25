package edu.mission;

import java.util.Scanner;

public class Gugudan {//다시 해볼것

	public static void main(String[] args) {
		//구구단을 출력하는 메소드를 구현
				//Gugudan gg = new Gugudan();
				//gg.printGugudan(2);
				
				Scanner kb = new Scanner(System.in);
				System.out.println("input column");
				int column = kb.nextInt();
				
				System.out.println("=".repeat(40));
				
				
				for(int i=2; i<10; i+=column) {
					for(int j=1; j<10; j++) {
						for(int k=0; k<column; k++) {
							
							if(10<= i+k) {//10단 되면 중단
								System.out.print("\n");
								break;
							}
							System.out.printf("%d*%d=%2d", (i+k), j, (i+k)*j);//%2하면 2칸 확보
							
							if(k<column-1) System.out.print("\t");
							else 			System.out.print("\n");
							
						}
					}
					System.out.println("-".repeat(40));
					
				}
				
			}

	}


