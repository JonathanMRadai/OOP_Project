package gameobjects.sprites.collidables;
import levels.gamelevel.GameLevel;
import gameobjects.sprites.ball.Ball;
import gameobjects.sprites.Sprite;
import gameobjects.sprites.velocity.Velocity;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * GameObjects.Sprites.Collidables.Paddle.
 * @author Yonatan Mevarch-Radai.
 * @version 29.04.2021.
 */
public class Paddle extends Rectangle implements Sprite, Collidable {

    private biuoop.KeyboardSensor keyboard;
    private GameLevel game;
    private Velocity rightVelocity;
    private Velocity leftVelocity;
    private double leftLimit;
    private double rightLimit;



    /**
     * contractor.
     * @param game the game .
     * @param rect  the paddle rect.
     * @param color the paddle color.
     */
    public Paddle(GameLevel game, Rectangle rect, Color color) {

        super(rect.getUpperLeft(), rect.getWidth(), rect.getHeight(), color);

        if (rect == null) {

            return;
        }
        // 1 as a default GameObjects.Sprites.Velocity.
        this.setVelocity(1);
        addToGame(game);
    }

    /**
     * contractor.
     * @param rect  the paddle wanted rectangle.
     * @param color the GameObjects.Sprites.Collidables.Paddle color.
     */
    public Paddle(Rectangle rect, Color color) {

        super(rect.getUpperLeft(), rect.getWidth(), rect.getHeight(), color);
        // 1 as a default GameObjects.Sprites.Velocity.
        this.setVelocity(1);
    }

    /**
     * setVelocity.
     * set the GameObjects.Sprites.Velocity of the GameObjects.Sprites.Collidables.Paddle.
     * by default its GameObjects.Sprites.Velocity is dx = 1.
     * @param dx the velocity dx, (the dy isn't changing)
     */
    public void setVelocity(double dx) {

        if (dx < 0) {

            dx = (-1) * dx;
        }

        this.rightVelocity = new Velocity(dx, 0);
        this.leftVelocity = new Velocity((-1) * dx, 0);

    }

    /**
     * setLimits.
     * set the limitation movement of the GameObjects.Sprites.Collidables.Paddle.
     * @param rightL the paddle right limit.
     * @param leftL  the paddle left limit.
     */
    public void setLimits(double rightL, double leftL) {

        this.rightLimit = rightL;
        this.leftLimit = leftL;


    }

    /**
     * setVelocityAndLimit.
     * set the GameObjects.Sprites.Velocity and the limits all together.
     * @param dx the GameObjects.Sprites.Velocity.
     * @param rightL the paddle right limit.
     * @param leftL  the paddle left limit.
     */
    public void setVelocityAndLimit(double dx, double rightL, double leftL) {

        setLimits(rightL, leftL);
        setVelocity(dx);

    }

    /**
     * getter.
     * @return rightVelocity.
     */
    public Velocity getRightVelocity() {
        return rightVelocity;
    }

    /**
     * getter.
     * @return leftVelocity.
     */
    public Velocity getLeftVelocity() {
        return leftVelocity;
    }

    /**
     * moveRight.
     * make the GameObjects.Sprites.Collidables.Paddle move right by applying it's rightVelocity.
     */
    public void moveRight() {

        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY) && (!(checkRightLimit(upperLeft)))) {

            super.setUpperLeft(rightVelocity.applyToPoint(upperLeft));

        }

    }

    /**
     * moveLeft.
     * make the GameObjects.Sprites.Collidables.Paddle move right by applying it's rightVelocity.
     */
    public void moveLeft() {

        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY) && (!(checkLeftLimit(upperLeft)))) {

            super.setUpperLeft(leftVelocity.applyToPoint(upperLeft));
        }

    }

    /**
     * checkLeftLimit.
     * check if the paddle will cross it's left limit.
     * if it is crating a new rectangle to make the GameObjects.Sprites.Collidables.Paddle stay in game bound.
     * @param p the upperLeft point of the paddle after applying velocity.
     * @return true if cross, false otherwise.
     */
    private boolean checkLeftLimit(Point p) {

        if (p.getX() <= leftLimit) {

            upperLeft = new Point(leftLimit, upperLeft.getY());
            return true;
        }

        return false;


    }


    /**
     * checkRightLimit.
     * check if the paddle will cross it's left limit.
     * if it is crating a new rectangle to make the GameObjects.Sprites.Collidables.Paddle stay in game bound.
     * @param p the upperLeft point of the paddle after applying velocity.
     * @return true if cross, false otherwise.
     */
    private boolean checkRightLimit(Point p) {

        if (p.getX() + width >= rightLimit) {

            upperLeft = new Point(rightLimit -  width, upperLeft .getY());
            return true;
        }

        return false;


    }


    @Override
    public void timePassed() {

        moveRight();
        moveLeft();
    }

    @Override
    public void drawOn(DrawSurface d) {

        if (d == null) {
            return;
        }
        super.drawOn(d);
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if ((collisionPoint == null) || (currentVelocity == null)) {


            return null;
        }
        if (collisionPoint.getY() == getUpperLeft().getY()) {

            currentVelocity = adaptVelocityByHitLocation(getTop(), collisionPoint, currentVelocity);
        }
        if ((collisionPoint.getX() == getUpperLeft().getX())
                || (collisionPoint.getX() == getUpperLeft().getX() + getWidth())) {

            currentVelocity = new Velocity((-1) * currentVelocity.getDx(), currentVelocity.getDy());
        }
        if ((collisionPoint.getY() == getUpperLeft().getY() + getHeight())) {

            currentVelocity = new Velocity((-1) * currentVelocity.getDx(), (-1) * currentVelocity.getDy());

        }


        return currentVelocity;
    }

    /**
     * addToGame.
     * @param g the game the paddle is being added on.
     */
    public void addToGame(GameLevel g) {

        g.addSprite(this);
        g.addCollidable(this);
        this.game = g;
        this.keyboard = g.getRunner().getGui().getKeyboardSensor();

    }

    /**
     * adaptVelocityByHitLocation.
     * in order to make the game "fun", XD .
     * @param line between the the hit point to the upperLeft point.
     * @param hitPoint the point the ball hit.
     * @param currentVelocity in order to change the velocity.
     * @return the new velocity.
     */
    private Velocity adaptVelocityByHitLocation(Line line, Point hitPoint, Velocity currentVelocity) {

        if ((line == null) || (hitPoint == null)) {

            return null;
        }
        if(currentVelocity.getDx() == 0) {
           return velocityDxIs0(line, hitPoint,currentVelocity);
        }
        if (currentVelocity.getDx() > 0) {

            currentVelocity = new Velocity((-1) * currentVelocity.getDx(), currentVelocity.getDy());
        }
        double length = line.length();
        double distance = line.start().distance(hitPoint);
        //left
        if (distance <= (length / 5)) {

            return Velocity.fromAngleAndSpeed(150, currentVelocity.getDx());
        }
        //middle left
        else if (distance <= ((length / 5) * 2)) {

            return Velocity.fromAngleAndSpeed(120, currentVelocity.getDx());
        }
        //middle
        else if (distance <= ((length / 5) * 3)) {

            return new Velocity(currentVelocity.getDx(), (-1) * currentVelocity.getDy());
        }
        //middle right
        else if (distance <= ((length / 5) * 4)) {

            return Velocity.fromAngleAndSpeed(120, (-1) * currentVelocity.getDx());
        }
        //right
        else {

            return Velocity.fromAngleAndSpeed(150, (-1) * currentVelocity.getDx());
        }
    }

    /**
     * velocityDxIs0.
     * In case velocity dx is 0.
     * @return new ball velocity.
     */
    private Velocity velocityDxIs0(Line line, Point hitPoint, Velocity currentVelocity) {

        double length = line.length();
        double distance = line.start().distance(hitPoint);
        //left
        if (distance <= (length / 5)) {

            return Velocity.fromAngleAndSpeed(150, -2);
        }
        //middle left
        else if (distance <= ((length / 5) * 2)) {

            return Velocity.fromAngleAndSpeed(120, -2);
        }
        //middle
        else if (distance <= ((length / 5) * 3)) {

            return new Velocity(currentVelocity.getDx(), (-1) * currentVelocity.getDy());
        }
        //middle right
        else if (distance <= ((length / 5) * 4)) {

            return Velocity.fromAngleAndSpeed(120, 2);
        }
        //right
        else {

            return Velocity.fromAngleAndSpeed(150, 2);
        }



    }
}
