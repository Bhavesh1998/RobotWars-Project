/**
 * Author: Bhavesh Shah
 * Date: October 10, 2023,
 * Description: Project - Robot-Wars.

 * Main class for the Robot Wars program, which allows users to add robots in an arena and
 * give movement instructions.
 */

import exceptions.OutOfArenaBoundsException;
import exceptions.RobotException;
import main.Arena;
import main.Position;
import main.Robot;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Read the arena size from the user
            /*
              It is a good practice to add Additional info to the user, but it was not the part of the problem.
            */
            System.out.println("Enter the arena size in format: x-coordinate y-coordinate): ");

            int maxX = scanner.nextInt();
            int maxY = scanner.nextInt();
            Arena arena = new Arena(maxX, maxY);

            while (true) {
                //Informative Statements, but not the part of the given problem:
                System.out.println("Enter robot Position and Head Direction in format: x y direction: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                char direction = scanner.next().charAt(0);
                if(Robot.isValidPosition(x, y, maxX, maxY)) {
                    System.err.println("Invalid position. Please enter x and y coordinates which are <= Arena Size: " + maxX + " " + maxY);
                    continue;
                }
                if (!Robot.isValidDirection(direction)) {
                    System.err.println("Invalid direction. Please enter N, W, E, or S.");
                    continue;
                }

                Robot robot = new Robot(new Position(x, y, direction), arena);

                System.out.println("Enter robot instructions: ");
                String instructions = scanner.next();

                try {
                    robot.executeSimulation(instructions);
                    Position finalPosition = robot.getPosition();
                    System.out.println(finalPosition.getX() + " " + finalPosition.getY() + " " + finalPosition.getDirection());
                } catch (RobotException e) {
                    System.err.println("Error: " + e.getMessage());
                }

                // Breaking The While block is not the part of the requirement, but it is a good practice to close this block to stop the program

                System.out.println("Do you want to enter another robot? (Y/N): ");
                String choice = scanner.next();
                if (!choice.equalsIgnoreCase("Y")) {
                    break;
                }
            }
        }
    }
}