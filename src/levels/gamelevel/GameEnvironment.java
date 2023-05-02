package levels.gamelevel;
import gameobjects.sprites.collidables.Collidable;
import gameobjects.sprites.collidables.CollisionInfo;
import geometry.Line;
import geometry.Point;

import java.util.ArrayList;

/**
 * Game.GameEnvironment.
 * @author Yonatan Mevarch-Radai.
 * @version 29.04.2021.
 */
public class GameEnvironment {

     private  java.util.List<Collidable> collidableList;


    /**
     * contractor.
     * @param collidableList .
     */
     public GameEnvironment(java.util.List<Collidable> collidableList) {

         this.collidableList = collidableList;

     }

    /**
     * contractor.
     */
    public GameEnvironment() {

        this.collidableList = new ArrayList<>();

    }

    /**
     * GetList.
     * @return collidableList.
     */
    public java.util.List<Collidable> getList() {

        return this.collidableList;
    }

    /**
     * addCollidable.
     * add the given collidable to the environment.
     * @param c the added GameObjects.Sprites.Collidables.Collidable.
     **/
    public void addCollidable(Collidable c) {

        if (c == null) {
            return;
        }
        if (collidableList == null) {

            this.collidableList = new ArrayList<>();

        }
        collidableList.add(c);
    }


    /**
     * getClosestCollision.
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables.
     * in this collection, return null. Else, return the information.
     * about the closest collision that is going to occur.
     * @param trajectory .
     * @return GameObjects.Sprites.Collidables.CollisionInfo about the hit.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

         if ((trajectory == null) || (collidableList == null)) {

             return null;
         }

         Point collision = null;
         Collidable collides = null;
         for (Collidable c : collidableList) {

             Point temp = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());

             if (temp == null) {

                 continue;
             }

             if (
                     (collision == null)
                     || (trajectory.start().distance(temp) < trajectory.start().distance(collision))
             ) {

                 collision = temp;
                 collides = c;

             }
         }
         if (collision == null) {

             return null;
         }
         return new CollisionInfo(collision, collides);
    }

}
