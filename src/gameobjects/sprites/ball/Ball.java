package gameobjects.sprites.ball;
import gameobjects.sprites.Sprite;
import gameobjects.sprites.velocity.Velocity;
import levels.gamelevel.GameLevel;
import gameobjects.listener.HitListener;
import gameobjects.listener.HitNotifier;
import gameobjects.sprites.collidables.Block;
import gameobjects.sprites.collidables.Collidable;
import gameobjects.sprites.collidables.CollisionInfo;
import geometry.Line;
import geometry.Point;
import geometry.Circle;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * GameObjects.Sprites.Ball.
 * @author Yonatan Mevarch-Radai.
 * @version 29.04.2021.
 */
public class Ball extends Circle implements Sprite, HitNotifier {



    private Velocity v;
    private GameLevel game;
    private List<HitListener> hitListeners;

    /**
     * constructors.
     * @param center the GameObjects.Sprites.Ball's center Geometry.Point.
     * @param r the GameObjects.Sprites.Ball's radius.
     * @param color the GameObjects.Sprites.Ball's color.
     */
    public Ball(Point center, int r, Color color) {
        super(center, r, color);
    }
    /**
     * constructors.
     * @param x the x value of the center.
     * @param y the y value of the center.
     * @param r the GameObjects.Sprites.Ball's radius.
     * @param color the GameObjects.Sprites.Ball's color.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {

        super(x, y, r, color);
    }

    /**
     * drawOn.
     * draw the GameObjects.Sprites.Ball on the given DrawSurface.
     * @param surface the given DrawSurface.
     */
    public void drawOn(DrawSurface surface) {


        if ((surface == null) || (center == null)) {


            return;

        }

        surface.setColor(this.color);
        surface.fillCircle(((int) this.center.getX()), ((int) this.center.getY()), this.r);

        return;

    }

    @Override
    public void timePassed() {
        moveOneStep();
    }
    /**
     * setAngleAndSpeed.
     * set the GameObjects.Sprites.Ball's GameObjects.Sprites.Velocity according to angle and speed representation.
     * @param angle the wanted GameObjects.Sprites.Ball's angle.
     * @param speed the wanted GameObjects.Sprites.Ball's speed.
     */
    public void setAngleAndSpeed(double angle, double speed) {


        this.v = Velocity.fromAngleAndSpeed(angle, speed);
        return;

    }

    /**
     * setVelocity.
     * set GameObjects.Sprites.Velocity according to (dx, dy) representation.
     * @param dx GameObjects.Sprites.Velocity.
     * @param dy GameObjects.Sprites.Velocity.
     */
    public void setVelocity(double dx, double dy) {

        this.v = new Velocity(dx, dy);
        return;

    }

    /**
     * getVelocity.
     * accessor.
     * @return the GameObjects.Sprites.Ball's GameObjects.Sprites.Velocity.
     */
    public Velocity getVelocity() {


        return v;

    }

    /**
     * moveOneStep.
     * apply velocity on the ball.
     * or changing its velocity and adopt the center if needed.
     */
    public void moveOneStep() {

        if ((game.getEnvironment() == null) || (v == null)) {

            return;
        }

        CollisionInfo info = game.getEnvironment().getClosestCollision(new Line(center, v.applyToPoint(center)));
        if (info == null) {
            center = v.applyToPoint(center);
            return;
        }
        center = setCenter(info.collisionPoint(), info.collisionObject());
        v = info.collisionObject().hit(this, info.collisionPoint(), v);

    }

    /**
     * setCenter.
     * help to set a new center after a hit happened.
     * @param collisionPoint .
     * @param collisionObject .
     * @return new center point.
     */
    private Point setCenter(Point collisionPoint, Collidable collisionObject) {


        if ((collisionPoint == null) || (collisionObject == null)) {

            return null;
        }

        if (collisionPoint.getY() == collisionObject.getCollisionRectangle().getUpperLeft().getY()) {

            collisionPoint = new Point(collisionPoint.getX(), collisionPoint.getY() - 0.05);
        }
        if (collisionPoint.getY() == collisionObject.getCollisionRectangle().getUpperLeft().getY()
                + collisionObject.getCollisionRectangle().getHeight()) {

            collisionPoint = new Point(collisionPoint.getX(), collisionPoint.getY() + 0.05);

        }
        if (collisionPoint.getX() == collisionObject.getCollisionRectangle().getUpperLeft().getX()) {

            collisionPoint = new Point(collisionPoint.getX() - 0.05, collisionPoint.getY());
        }
        if (collisionPoint.getX() == collisionObject.getCollisionRectangle().getUpperLeft().getX()
                + collisionObject.getCollisionRectangle().getWidth()) {

            collisionPoint =  new Point(collisionPoint.getX() + 0.05, collisionPoint.getY());

        }

        return collisionPoint;
    }

    /**
     * addToGame.
     * add the ball to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {

        if (g == null) {

            return;
        }
        g.addSprite(this);
        this.game = g;

    }

    /**
     * removeFromGame .
     * @param g .
     */
    public void removeFromGame(GameLevel g) {

        g.removeSprite(this);

    }

    @Override
    public void addHitListener(HitListener hl) {

        if (hl == null) {

            return;
        }
        if (this.hitListeners == null) {

            this.hitListeners = new ArrayList<HitListener>();
        }
        this.hitListeners.add(hl);

    }

    @Override
    public void removeHitListener(HitListener hl) {

        if ((hl == null) || (this.hitListeners == null)) {

            return;
        }
        this.hitListeners.remove(hl);
    }

    /**
     * notifyHit .
     * notify the hit listeners .
     * @param deathZone .
     */
    public void notifyHit(Block deathZone) {
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(deathZone, this);
        }
    }
}

