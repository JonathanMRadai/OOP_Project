package geometry;
/**
 * Geometry.Point.
 * x specifies the x value of the Geometry.Point.
 * y specifies the y value of the Geometry.Point.
 * @author Yonatan Mevarch-Radai.
 * @version 17.04.2021.
 */
public class Point {

    private double x;
    private double y;

    /**
     * constructor.
     * @param x the x value of the point.
     * @param y the y value of the Geometry.Point.
     */
    public Point(double x, double y) {

        this.x = x;
        this.y = y;

    }

    /**
     * distance.
     * calculate the distance between two Points according to distance equation.
     * @param other the other Geometry.Point.
     * @return the distance of this Geometry.Point to the other Geometry.Point.
     */
    public double distance(Point other) {

        if (other == null) {

            return 0;
        }

        double base = Math.pow((this.x - other.getX()), 2)
                + Math.pow((this.y - other.getY()), 2);

        if (base < 0) {
            base = (-1) * base;
        }

        return Math.sqrt(base);

    }

    /**
     * equals.
     * check if the Points are equal by comparison the Points x and y values.
     * @param other the other Geometry.Point.
     * @return return true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {

        if (other == null) {

            return false;

        }

        if ((this.x != other.getX()) || (this.y != other.getY())) {

            return false;

        }

        return true;

    }

    /**
     * getX.
     * accessor.
     * @return Return the x of this Geometry.Point.
     */
    public double getX() {

        return this.x;
    }

    /**
     * getY.
     * accessor.
     * @return Return the y of this Geometry.Point.
     */
    public double getY() {

        return this.y;

    }
}
