package gameobjects.sprites.collidables;
import gameobjects.listener.Counter;
import gameobjects.sprites.collidables.Bound;
import geometry.Rectangle;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * GameObjects.Sprites.ScoreIndicator.
 * the score indicator display the score at the top of the screen .
 * @author Yonatan Mevarch-Radai.
 * @version 7.06.2021.
 */
public class ScoreIndicator extends Bound {

    private Counter scoreCounter;
    public String levelName;

    /**
     * contractor.
     * @param rect  .
     * @param color .
     * @param scoreCounter .
     */
    public ScoreIndicator(Rectangle rect, Color color, Counter scoreCounter, String levelName) {
        super(rect, color);
        this.scoreCounter = scoreCounter;
        this.levelName = levelName;

    }
    @Override
    public void drawOn(DrawSurface d) {

        super.drawOn(d);
        d.drawText(340, 18, "Score:" + scoreCounter.getValue(), 20);
        d.drawText(0, 18, "Level name: " + levelName, 20);

    }
    @Override
    public void timePassed() {


    }
}
