package gameobjects.sprites.collidables;

import gameobjects.sprites.ball.Ball;
import geometry.Rectangle;
import java.awt.Color;
/**
 * GameObjects.Sprites.Collidables.DeathZone.
 * the block blow the paddle.
 * @author Yonatan Mevarch-Radai.
 * @version 07.06.2021.
 */
public class DeathZone extends Bound {
    /**
     * contractor.
     * @param rect  .
     * @param color .
     */
    public DeathZone(Rectangle rect, Color color) {

        super(rect, color);
    }

    @Override
    protected void notifyHit(Ball hitter) {

      hitter.notifyHit(this);
    }


}
