package gameobjects.sprites.collidables;

import levels.gamelevel.GameLevel;
import gameobjects.listener.HitListener;
import gameobjects.sprites.ball.Ball;
import geometry.Rectangle;
import java.awt.Color;
/**
 * GameObjects.Sprites.Collidables.Bound.
 * the blocks at the side of the screen.
 * @author Yonatan Mevarch-Radai.
 * @version 07.06.2021.
 */
public class Bound extends Block {
    /**
     * contractor.
     * @param rect  .
     * @param color .
     */
    public Bound(Rectangle rect, Color color) {

        super(rect, color);
    }
    @Override
    public void removeFromGame(GameLevel game) {
        return;

    }
    @Override
    public void addHitListener(HitListener hl) {
        return;

    }

    @Override
    public void removeHitListener(HitListener hl) {
        return;

    }

    @Override
    protected void notifyHit(Ball hitter) {
        return;
    }
}
