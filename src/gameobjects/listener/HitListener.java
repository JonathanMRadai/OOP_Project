package gameobjects.listener;

import gameobjects.sprites.ball.Ball;
import gameobjects.sprites.collidables.Block;
/**
 * GameObjects.listener.HitListener.
 * @author Yonatan Mevarch-Radai.
 * @version 07.06.2021.
 */
public interface HitListener {

    /**
     * hitEvent .
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit .
     * @param hitter .
     */
    void hitEvent(Block beingHit, Ball hitter);

}
