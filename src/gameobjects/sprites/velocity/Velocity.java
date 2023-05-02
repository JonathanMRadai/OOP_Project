package gameobjects.sprites.velocity;
import gameobjects.sprites.ball.Ball;
import geometry.Point;
import java.util.Random;
/**
 * GameObjects.Sprites.Velocity.
 * GameObjects.Sprites.Velocity specifies the change in position on the `x` and the `y` axes.
 * GameObjects.Sprites.Velocity changes the potion of a GameObjects.Sprites.Ball by changing its center point.
 * dx and dy specify the distance between the current x and y.
 * to the next center x and y.
 * current center x + dx = next center x.
 * current center y + dy = next center y.
 * @version 29.04.2021.
 * @author Yonatan Mevarch-Radai.
 */
public class Velocity {


    private double dx;
    private double dy;

    /**
     * constructor.
     * @param dx distance between the current center x and next center x.
     * @param dy distance between the current center y and next center y.
     */
    public Velocity(double dx, double dy) {


        this.dx = dx;
        this.dy = dy;

    }

    /**
     * getDx.
     * accessor.
     * @return this.dx.
     */
    public double getDx() {


        return this.dx;

    }

    /**
     * getDy.
     * accessor.
     * @return this.dy.
     */
    public double getDy() {


        return this.dy;

    }

    /**
     * applyToPoint.
     * changes the GameObjects.Sprites.Ball's center Geometry.Point by adding dx to it's x and dy to it's y.
     * @param p current GameObjects.Sprites.Ball's current center Geometry.Point.
     * @return GameObjects.Sprites.Ball next Geometry.Point.
     * Take a point with position (x,y) and return a new point.
     * with position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {


        if (p == null) {

            return null;

        }

       return new Point(p.getX() + dx, p.getY() + dy);

    }

    /**
     * fromAngleAndSpeed
     * change the given argument to (dx,dy) representation.
     * then crate a new GameObjects.Sprites.Velocity by this (dx,dy) representation.
     * @param angle between the GameObjects.Sprites.Ball's line Axis and X-Axis.
     * @param speed distance between the current center x and next center x.
     * @return new GameObjects.Sprites.Velocity represented by (dx,dy) representation.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {


        if (angle == 90) {


            return new Velocity(0, speed);

        }

        if (angle == 0) {


            return new Velocity(speed, 0);


        }


        return new Velocity(speed,
                Math.abs(speed) * (Math.tan(Math.toRadians(angle))));

    }

    /**
     * velocityAdapter.
     * @param ball .
     * velocityAdapter gives a GameObjects.Sprites.Ball a velocity according to it's size.
     */
    public static void velocityAdapter(Ball ball) {


        Random rand = new Random();

        if (ball.getSize() >= 50) {
            ball.setAngleAndSpeed(rand.nextInt(45) + 1, 1);
        }
        else {

            ball.setAngleAndSpeed(rand.nextInt(45) + 1,
                    ((50 - ball.getSize()) / 2));

        }
    }

}
