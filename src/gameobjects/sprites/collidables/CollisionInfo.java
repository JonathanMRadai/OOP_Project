package gameobjects.sprites.collidables;

import geometry.Point;
/**
 * @author Yonatan Mevarch-Radai.
 * ID: 207017443.
 */
public class CollisionInfo {
    /**
     * GameObjects.Sprites.Collidables.CollisionInfo.
     * @author Yonatan Mevarch-Radai.
     * @version 29.04.2021.
     */
   private Point collisionPoint;
   private Collidable collisionObject;

    /**
     * contractor .
     * @param collisionPoint .
     * @param collisionObject .
     */
   public CollisionInfo(Point collisionPoint, Collidable collisionObject) {

       this.collisionPoint = collisionPoint;
       this.collisionObject = collisionObject;

   }

    // the point at which the collision occurs.

    /**
     * getter.
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {

        return collisionPoint;
    }

    /**
     * getter.
     * @return  the collidable object involved in the collision.
     */
    public Collidable collisionObject() {

        return collisionObject;
    }

}
