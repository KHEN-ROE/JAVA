package edu.mission;

import java.util.Scanner;

public class Mission07_3 {//arguments 받아서 소수 판별
	public static boolean prime(int num) {
		
		for(int i=2; i<num; i++ ) {
			if(num%i==0) return false;
		}	
		return true;
	}
	
	public static void main(String[] args) {
		
		int num=Integer.parseInt(args[0]);			 
		if(prime(num)==true) System.out.println("prime");
		else				 System.out.println("not prime");
		
		System.out.println("done");
	}
}
