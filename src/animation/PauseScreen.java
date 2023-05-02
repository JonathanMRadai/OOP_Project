package animation;
import biuoop.DrawSurface;
import gameobjects.sprites.backgrounds.BackGround;
import gameobjects.sprites.backgrounds.BackGroundPauseScreen;
import java.awt.Color;

/**
 * PauseScreen .
 * need to be wrap by KeyPressStoppableAnimation,
 * in order to gain the ability to stop.
 * @author Yonatan Mevarech-Radai.
 * @version 17.06.2021.
 */
public class PauseScreen implements Animation {

    private BackGround backGround;

    /**
     * constructor.
     */
    public PauseScreen() {

        this.backGround = new BackGroundPauseScreen();
    }

    @Override
    public void doOneFrame(DrawSurface d) {

        this.backGround.drawOn(d);
        d.setColor(Color.black);
        d.drawText(d.getWidth() / 4, d.getHeight() / 2, "paused -- press space to continue", 32);


    }

    @Override
    public boolean shouldStop() {
        return true;
    }
}
