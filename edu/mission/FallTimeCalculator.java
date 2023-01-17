package edu.mission;

import java.util.Scanner;

public class FallTimeCalculator {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the height in meters: ");
        double distance = input.nextDouble(); // distance in meters
        System.out.print("Enter the time interval in seconds: ");
        double timeInterval = input.nextDouble();
        double gravity = 9.81; // acceleration due to gravity in m/s^2
        double initialVelocity = 0; // initial velocity in m/s
        double initialPosition = 0; // initial position in meters
        double time = 0; // travel time
        double currentPosition = initialPosition;
        
        // use a while loop to iterate until the current position is greater than or equal to the distance fallen
        while (currentPosition < distance) {
            currentPosition = 0.5 * gravity * time * time + initialVelocity * time + initialPosition;
            time += timeInterval; 
        }
        System.out.println("Time to hit the ground: " + time + " seconds");
        input.close();
    }

}
