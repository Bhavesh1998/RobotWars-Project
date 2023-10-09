/**
 * Test Class for Arena Class.
 */

package test;
import main.Arena;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArenaTest {
    @Test
    public void testGetMaxX() {
        Arena arena = new Arena(5, 5);
        assertEquals(5, arena.getMaxX());
    }

    @Test
    public void testGetMaxY() {
        Arena arena = new Arena(5, 5);
        assertEquals(5, arena.getMaxY());
    }
}
