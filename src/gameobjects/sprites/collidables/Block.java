package gameobjects.sprites.collidables;
import levels.gamelevel.GameLevel;
import gameobjects.listener.HitListener;
import gameobjects.listener.HitNotifier;
import gameobjects.sprites.ball.Ball;
import gameobjects.sprites.Sprite;
import gameobjects.sprites.velocity.Velocity;
import geometry.Point;
import geometry.Rectangle;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * GameObjects.Sprites.Collidables.Block.
 * @author Yonatan Mevarch-Radai.
 * @version 29.04.2021.
 */
public class Block extends Rectangle implements Collidable, Sprite, HitNotifier {

    private GameLevel game;
    private List<HitListener> hitListeners;


    /**
     * contractor.
     * @param rect .
     * @param color .
     */
    public Block(Rectangle rect, Color color) {

        super(rect.getUpperLeft(), rect.getWidth(), rect.getHeight(), color);
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

        if ((collisionPoint.getX() == getUpperLeft().getX())
            || (collisionPoint.getX() == getUpperLeft().getX() + getWidth())) {

            currentVelocity = new Velocity((-1) * currentVelocity.getDx(), currentVelocity.getDy());
        }
        if ((collisionPoint.getY() == getUpperLeft().getY())
            || (collisionPoint.getY() == getUpperLeft().getY() + getHeight())) {

            currentVelocity = new Velocity(currentVelocity.getDx(), (-1) * currentVelocity.getDy());

        }
        this.notifyHit(hitter);
        return currentVelocity;
    }
    @Override
    public void drawOn(DrawSurface d) {

        super.drawOn(d);
    }

    @Override
    public void timePassed() {

    }

    /**
     * addToGame.
     * add the block yo the game.
     * @param g game.
     */
    public void addToGame(GameLevel g) {

        g.addSprite(this);
        g.addCollidable(this);
        this.game = g;
    }

    /**
     * removeFromGame .
     * @param g .
     */
    public void removeFromGame(GameLevel g) {

        g.removeCollidable(this);
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
     * notifyHit
     * notify the listeners when hit .
     * @param hitter .
     */
    protected void notifyHit(Ball hitter) {

        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

}
