/**
 * Test Class for Robot Class.
 */

package test;

import static org.junit.Assert.*;

import main.Arena;
import main.Position;
import main.Robot;
import org.junit.Before;
import org.junit.Test;

public class RobotTest {
    private Robot robot;
    private Arena arena;

    @Before
    public void setUp() {
        arena = new Arena(5, 5);
    }

    @Test
    public void testRotateLeft() {
        robot = new Robot(new Position(2, 3, 'N'), arena);
        char newDirection = robot.rotateLeft('N');
        assertEquals('W', newDirection);

        robot = new Robot(new Position(2, 3, 'W'), arena);
        newDirection = robot.rotateLeft('W');
        assertEquals('S', newDirection);

        robot = new Robot(new Position(2, 3, 'S'), arena);
        newDirection = robot.rotateLeft('S');
        assertEquals('E', newDirection);

        robot = new Robot(new Position(2, 3, 'E'), arena);
        newDirection = robot.rotateLeft('E');
        assertEquals('N', newDirection);
    }

    @Test
    public void testRotateRight() {
        robot = new Robot(new Position(2, 3, 'N'), arena);
        char newDirection = robot.rotateRight('N');
        assertEquals('E', newDirection);

        robot = new Robot(new Position(2, 3, 'E'), arena);
        newDirection = robot.rotateRight('E');
        assertEquals('S', newDirection);

        robot = new Robot(new Position(2, 3, 'S'), arena);
        newDirection = robot.rotateRight('S');
        assertEquals('W', newDirection);

        robot = new Robot(new Position(2, 3, 'W'), arena);
        newDirection = robot.rotateRight('W');
        assertEquals('N', newDirection);
    }

    @Test
    public void testMoveForward() {
        robot = new Robot(new Position(2, 3, 'N'), arena);
        Position newPosition = robot.moveForward(2, 3, 'N');
        assertEquals(2, newPosition.getX());
        assertEquals(4, newPosition.getY());
        assertEquals('N', newPosition.getDirection());

        robot = new Robot(new Position(2, 3, 'W'), arena);
        newPosition = robot.moveForward(2, 3, 'W');
        assertEquals(1, newPosition.getX());
        assertEquals(3, newPosition.getY());
        assertEquals('W', newPosition.getDirection());

        robot = new Robot(new Position(2, 3, 'S'), arena);
        newPosition = robot.moveForward(2, 3, 'S');
        assertEquals(2, newPosition.getX());
        assertEquals(2, newPosition.getY());
        assertEquals('S', newPosition.getDirection());

        robot = new Robot(new Position(2, 3, 'E'), arena);
        newPosition = robot.moveForward(2, 3, 'E');
        assertEquals(3, newPosition.getX());
        assertEquals(3, newPosition.getY());
        assertEquals('E', newPosition.getDirection());
    }
}





//import main.Robot;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class RobotTest {
//
//    @Test
//    public void testIsValidDirection() {
//        Robot robot = new Robot(null, null);
//
//        // Valid directions
//        assertTrue(robot.isValidDirection("N"));
//        assertTrue(robot.isValidDirection("W"));
//        assertTrue(robot.isValidDirection("E"));
//        assertTrue(robot.isValidDirection("S"));
//
//        // Invalid directions
//        assertFalse(robot.isValidDirection("Invalid"));
//        assertFalse(robot.isValidDirection("X"));
//        assertFalse(robot.isValidDirection(""));
//    }
//
//    @Test
//    public void testIsValidCoordinates() {
//        Robot robot = new Robot(null, null);
//
//        // Valid coordinates
//        assertTrue(robot.isValidCoordinates("1"));
//        assertTrue(robot.isValidCoordinates("100"));
//
//        // Invalid coordinates
//        assertFalse(robot.isValidCoordinates("0"));
//        assertFalse(robot.isValidCoordinates("-5"));
//        assertFalse(robot.isValidCoordinates("abc"));
//    }
//
//    @Test
//    public void testMoveForward() {
//        Arena arena = new Arena(5, 5);
//        Robot robot = new Robot(new Position(1, 2, "N"), arena);
//
//        robot.moveForward();
//        assertEquals(1, robot.getPosition().getX());
//        assertEquals(3, robot.getPosition().getY());
//        assertEquals("N", robot.getPosition().getDirection());
//
//        robot.rotateRight();
//        robot.moveForward();
//        assertEquals(2, robot.getPosition().getX());
//        assertEquals(3, robot.getPosition().getY());
//        assertEquals("E", robot.getPosition().getDirection());
//    }
//
//    @Test
//    public void testMoveLeft() {
//        Arena arena = new Arena(5, 5);
//        Robot robot = new Robot(new Position(1, 2, "N"), arena);
//
//        robot.rotateLeft();
//        assertEquals("W", robot.getPosition().getDirection());
//
//        robot.rotateLeft();
//        assertEquals("S", robot.getPosition().getDirection());
//    }
//
//    @Test
//    public void testrotateRight() {
//        Arena arena = new Arena(5, 5);
//        Robot robot = new Robot(new Position(1, 2, "N"), arena);
//
//        robot.rotateRight();
//        assertEquals("E", robot.getPosition().getDirection());
//
//        robot.rotateRight();
//        assertEquals("S", robot.getPosition().getDirection());
//    }
//
//    @Test
//    public void testExecuteInstructions() {
//        Arena arena = new Arena(5, 5);
//        Robot robot = new Robot(new Position(1, 2, "N"), arena);
//
//        robot.executeInstructions("LMRM");
//        assertEquals("W", robot.getPosition().getDirection());
//        assertEquals(0, robot.getPosition().getX());
//        assertEquals(2, robot.getPosition().getY());
//    }
//
//    @Test
//    public void testOutOfArenaBounds() {
//        Arena arena = new Arena(5, 5);
//        Robot robot = new Robot(new Position(5, 5, "N"), arena);
//
//        assertThrows(OutOfArenaBoundsException.class, () -> robot.moveForward());
//    }
//}
