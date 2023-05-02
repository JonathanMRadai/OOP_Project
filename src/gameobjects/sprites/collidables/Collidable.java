package gameobjects.sprites.collidables;
import gameobjects.sprites.ball.Ball;
import gameobjects.sprites.velocity.Velocity;
import geometry.Point;
import geometry.Rectangle;

/**
 * GameObjects.Sprites.Collidables.Collidable.
 * @author Yonatan Mevarch-Radai.
 * @version 29.04.2021.
 */
public interface Collidable {

    /**
     * getCollisionRectangle.
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * hit.
     * Notify the object that we collided with it at collisionPoint with,
     * a given velocity.
     * @param collisionPoint .
     * @param currentVelocity .
     * @return The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

}
