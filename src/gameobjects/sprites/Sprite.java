package gameobjects.sprites; /**
 * @author Yonatan Mevarch-Radai.
 * ID: 207017443.
 */
import biuoop.DrawSurface;
/**
 * GameObjects.Sprites.Sprite.
 * @author Yonatan Mevarch-Radai.
 * @version 29.04.2021.
 */
public interface Sprite {

    /**
     *  drawOn.
     * draw the sprite to the screen.
     * @param d DrawSurface.
     */
    void drawOn(DrawSurface d);

    /**
     * timePassed.
     * notify the sprite that time has passed.
     */
    void timePassed();


}
