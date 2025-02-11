package PointInRectangle;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * Checks if the point which calls the method is greater than or equal to another point's coordinates.
     * @param p point to be compared to.
     */
    public boolean isGreaterThanOrEqual(Point p) {
        return p.x <= this.x && p.y <= this.y;
    }

    /**
     * Checks if the point which calls the method is lesser than or equal to another point's coordinates.
     * @param p point to be compared to.
     */
    public boolean isLesserThanOrEqual(Point p) {
        return p.x >= this.x && p.y >= this.y;
    }
}
