package PointInRectangle;

public class Rectangle {
    private final Point a;
    private final Point c;

    public Rectangle(Point a, Point c) {
        this.a = a;
        this.c = c;
    }

    /**
     * Checks if the point is inside the rectangle or not.
     *
     * @return {@code True} - if the point is inside / {@code False} - if the point is outside
     * <p>
     * See {@link Point#isLesserThanOrEqual(Point) isLesserThanOrEqual} and {@link Point#isGreaterThanOrEqual(Point) isLesserThanOrEqual} methods for more info
     */
    public boolean contains(Point p) {
        return a.isLesserThanOrEqual(p) && c.isGreaterThanOrEqual(p);
    }
}
