package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import levels.gamelevel.SpriteCollection;
import gameobjects.sprites.Sprite;
import java.awt.Color;

/**
 * CountdownAnimation .
 * @author Yonatan Mevarech-Radai
 * @version 17.06.2021.
 */
public class CountdownAnimation implements Animation {

    private AnimationRunner runner;
    private Sprite backGround;
    private KeyboardSensor keyboard;
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean running;

    /**
     * constructor.
     * @param numOfSeconds .
     * @param countFrom .
     * @param gameScreen .
     * @param keyboard .
     * @param background .
     * @param runner .
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen,
                              KeyboardSensor keyboard, Sprite background, AnimationRunner runner) {

        this.runner = runner;
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.keyboard = keyboard;
        this.backGround = background;
        this.running = true;
    }
    @Override
    public void doOneFrame(DrawSurface d) {

        if (this.numOfSeconds >= 0)  {
            this.backGround.drawOn(d);
            this.gameScreen.drawAllOn(d);
            d.setColor(Color.black);
            d.drawText(d.getWidth() / 2, d.getHeight() / 2, String.valueOf(countFrom), 70);

            --this.numOfSeconds;
            --this.countFrom;
        }
        else {

            this.running = false;
        }

    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

}
