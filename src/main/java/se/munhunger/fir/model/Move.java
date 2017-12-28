package se.munhunger.fir.model;

/**
 * @author Marcus Münger
 */
public class Move {
    public boolean isX;
    public Point p;

    public Move(){}

    public Move(boolean isX, Point p) {
        this.isX = isX;
        this.p = p;
    }
}
