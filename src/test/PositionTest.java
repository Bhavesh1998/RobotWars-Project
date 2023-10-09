/**
 * Test Class for Position Class.
 */

package test;

import main.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    @Test
    public void testGetX() {
        Position position = new Position(1, 2, 'N');
        assertEquals(1, position.getX());
    }

    @Test
    public void testGetY() {
        Position position = new Position(1, 2, 'N');
        assertEquals(2, position.getY());
    }

    @Test
    public void testGetDirection() {
        Position position = new Position(1, 2, 'N');
        assertEquals('N', position.getDirection());
    }

}
