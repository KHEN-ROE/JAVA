package edu.mission;

import java.util.Scanner;

public class Gugudan2 {

	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
	        int column = 0;
	        boolean valid = false;
	        while(!valid){
	            System.out.print("Enter column number: ");
	            if(sc.hasNextInt()) {
	                column = sc.nextInt();
	                valid = true;
	            } else {
	                System.out.println("Please enter a valid integer value");
	                sc.next();
	            }
	        }
	        sc.close();

	        System.out.println("Multiplication table for column " + column + ":");
	        for (int i = 1; i <= 10; i++) {
	            System.out.println(column + " x " + i + " = " + (column * i));
	        }
	    }
	}


