/**
 * Class which represents the arena in which robots are deployed.
 */

package main;

public class Arena {
    private int maxX;
    private int maxY;

    public Arena(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
