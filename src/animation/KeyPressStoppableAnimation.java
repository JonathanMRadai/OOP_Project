package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * KeyPressStoppableAnimation .
 * wrap unstoppable Animations in order to,
 * make them stoppable according to user request.
 * @author Yonatan Mevarech-Radai.
 * @version 17.06.2021.
 */
public class KeyPressStoppableAnimation implements Animation {

    private Animation animation;
    private String key;
    private KeyboardSensor keyboard;
    private boolean running;
    private boolean isAlreadyPressed;

    /**
     * KeyPressStoppableAnimation.
     * @param sensor .
     * @param key - that if pressed, change the running status.
     * @param animation - the unstoppable Animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {

        this.keyboard = sensor;
        this.key = key;
        this.animation = animation;
        this.running = true;
        this.isAlreadyPressed = true;

    }


    @Override
    public void doOneFrame(DrawSurface d) {


        if (this.keyboard.isPressed(this.key)) {
            if (this.isAlreadyPressed) {
                animation.doOneFrame(d);
                return;
            }
            this.running = false;
        }
        else {
            animation.doOneFrame(d);
            this.isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

}

