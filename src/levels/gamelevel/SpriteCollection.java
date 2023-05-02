package levels.gamelevel;

import gameobjects.sprites.Sprite;
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
/**
 * Game.SpriteCollection.
 * @author Yonatan Mevarch-Radai.
 * @version 29.04.2021.
 */
public class SpriteCollection {

    private  java.util.List<Sprite> spriteCollection;

    /**
     * constructor.
     * @param spriteCollection .
     */
    public SpriteCollection(java.util.List<Sprite> spriteCollection) {

        if (spriteCollection == null) {

            spriteCollection = new ArrayList<>();
        }

        this.spriteCollection = spriteCollection;

    }

    /**
     * contractor.
     */
    public SpriteCollection() {

        spriteCollection = new ArrayList<>();
    }

    /**
     * addSprite .
     * @param s .
     */
    public void addSprite(Sprite s) {

        if ((s == null) || (spriteCollection == null)) {

            return;
        }
        spriteCollection.add(s);
    }

    /**
     *  call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {

        if (spriteCollection == null) {

            return;
        }
        List<Sprite> collection = new ArrayList<Sprite>(this.spriteCollection);
        for (Sprite s : collection) {

            s.timePassed();
        }
        return;

    }

    /**
     * call drawOn(d) on all sprites.
     * @param d DrawSurface that the Sprites are drawn on.
     */
    public void drawAllOn(DrawSurface d) {

        if ((spriteCollection == null) || (d == null)) {
            return;
        }

        for (Sprite s : spriteCollection) {

            s.drawOn(d);
        }
        return;
    }

    /**
     * getter .
     * @return spriteCollection .
     */
    public java.util.List<Sprite> getList() {

        return spriteCollection;
    }
}
