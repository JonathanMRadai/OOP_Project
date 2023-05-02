package geometry;

/**
 * Geometry.Circle.
 * @version 07.06.2021 .
 * @author Yonatan Mevarch-Radai.
 */
public class Circle {

    protected Point center;
    protected int r;
    protected java.awt.Color color;

    /**
     * constructors.
     * @param center the GameObjects.Sprites.Ball's center Geometry.Point.
     * @param r the GameObjects.Sprites.Ball's radius.
     * @param color the GameObjects.Sprites.Ball's color.
     */
    public Circle(Point center, int r, java.awt.Color color) {


        this.center = center;
        this.r = r;
        this.color = color;

    }

    /**
     * constructors.
     * @param x the x value of the center.
     * @param y the y value of the center.
     * @param r the GameObjects.Sprites.Ball's radius.
     * @param color the GameObjects.Sprites.Ball's color.
     */
    public Circle(int x, int y, int r, java.awt.Color color) {


        this.center = new Point(x, y);
        this.r = r;
        this.color = color;

    }

    /**
     * getX.
     * accessor.
     * @return the y value of the GameObjects.Sprites.Ball's center.
     */
    public int getX() {


        return ((int) this.center.getX());

    }

    /**
     * getY.
     * accessor.
     * @return the y value of the GameObjects.Sprites.Ball's center.
     */
    public int getY() {


        return ((int) this.center.getY());
    }

    /**
     * getSize.
     * accessor.
     * @return the radius of the GameObjects.Sprites.Ball.
     */
    public int getSize() {


        return r;

    }

    /**
     * getColor.
     * accessor.
     * @return the color of the GameObjects.Sprites.Ball.
     */
    public java.awt.Color getColor() {


        return this.color;

    }


}
