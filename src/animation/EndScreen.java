package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gameobjects.sprites.backgrounds.BackGround;
import gameobjects.sprites.backgrounds.BackGroundEndScreenLose;
import gameobjects.sprites.backgrounds.BackGroundEndScreenWin;

/**
 * EndScreen .
 * need to be wrap by KeyPressStoppableAnimation,
 * in order to gain the ability to stop.
 * @author Yonatan Mevarech-Radai.
 * @version 17.06.2021.
 */
public class EndScreen implements Animation {

    private KeyboardSensor keyboard;
    private String endMessage;
    private int score;
    private BackGround backGround;

    /**
     * contactor.
     * @param endMessage .
     * @param score .
     * @param win .
     */
    public EndScreen(String endMessage, int score, boolean win) {

        this.endMessage = endMessage;
        this.score = score;
        if (win) {
            this.backGround = new BackGroundEndScreenWin();
        }
        else {
            this.backGround = new BackGroundEndScreenLose();
        }


    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.backGround.drawOn(d);
        d.drawText(d.getHeight() / 2, d.getHeight() / 4, this.endMessage, 32);
        d.drawText(d.getHeight() / 2, d.getHeight() / 4 + 33, "Your score: " + this.score + ".", 32);
        d.drawText(d.getHeight() / 2, d.getHeight() / 2, "press space to close the game", 32);

    }

    @Override
    public boolean shouldStop() {
        return true;
    }
}
