/**
 * Class having all the logics for simulating robots according to user inputs.
 */

package main;


import exceptions.OutOfArenaBoundsException;
import exceptions.RobotException;

public class Robot {
    private Position position;
    private Arena arena;

    public Robot(Position position, Arena arena) {
        this.position = position;
        this.arena = arena;
    }

    public void executeSimulation(String instructions) throws RobotException {
        for (char instruction : instructions.toCharArray()) {
            performSimulation(instruction);
        }
    }

    /**
     * Perform a single movement instruction.
     *
     * @param instruction The movement information ('L', 'R', 'M')
     * @throws RobotException If any exception occurs
     */
    public void performSimulation(char instruction) throws RobotException {
        int x = position.getX();
        int y = position.getY();
        char direction = position.getDirection();

        if (instruction == 'L') {
            position= new Position(x,y,rotateLeft(direction));
        } else if (instruction == 'R') {
            position = new Position(x,y,rotateRight(direction));
        } else if (instruction == 'M') {
            position = moveForward(x, y, direction);
        }

        // Check for boundaries and handle exceptions
        if (x < 0 || x > arena.getMaxX() || y < 0 || y > arena.getMaxY()) {
            throw new OutOfArenaBoundsException("Robot is out of arena bounds");
        }
    }

    /**
     * Method to Update the Robot's Head in the Left of the Current Direction if users gives "L" as input
     *
     * @param direction The current direction.
     * @return The updated direction after moving Left.
     */
    public char rotateLeft(char direction) {
        switch (direction) {
            case 'N':
                return 'W';
            case 'W':
                return 'S';
            case 'S':
                return 'E';
            case 'E':
                return 'N';
        }
        return direction;
    }

    /**
     * Method to Update the Robot's Head in the Right of the Current Direction if users gives "R" as input
     *
     * @param direction The current direction.
     * @return The updated direction after moving right.
     */
    public char rotateRight(char direction) {
        switch (direction) {
            case 'N':
                return 'E';
            case 'E':
                return 'S';
            case 'S':
                return 'W';
            case 'W':
                return 'N';
        }
        return direction;
    }

    /**
     * Method to move forward if users gives 'M' input.
     *
     * @param x         Current X-coordinate.
     * @param y         Current Y-coordinate.
     * @param direction Current direction.
     * @return The updated position after moving forward.
     */
    public Position moveForward(int x, int y, char direction) {
        int newX = x;
        int newY = y;

        switch (direction) {
            case 'N':
                newY = Math.min(y + 1, arena.getMaxY());
                break;
            case 'S':
                newY = Math.max(y - 1, 0);
                break;
            case 'E':
                newX = Math.min(x + 1, arena.getMaxX());
                break;
            case 'W':
                newX = Math.max(x - 1, 0);
                break;
        }
        return new Position(newX, newY, direction);
    }

    /**
     * Get current position of the robot.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Check if the given direction is valid.
     *
     * @param direction The Given direction.
     * @return true if the direction is valid, false otherwise.
     */
    public static boolean isValidDirection(char direction) {
        return direction == 'N' || direction == 'W' || direction == 'E' || direction == 'S';
    }

    /**
     * Check if the given direction is valid.
     *
     * @param x,y,maxX,maxY The Starting coordinates and the arena size.
     * @return true if the position is not valid, false otherwise.
     */
    public static boolean isValidPosition(int x, int y, int maxX, int maxY) {
        return (x > maxX || y > maxY);
    }
}
