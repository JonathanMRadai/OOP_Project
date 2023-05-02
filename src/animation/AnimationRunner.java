package animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * AnimationRunner.
 * @author Yonatan Mevarech-Radai.
 * @version 17.06.2021.
 */
public class AnimationRunner {

    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * constructor.
     */
    public AnimationRunner() {


        this.gui = new GUI(new String("Game"), 800, 600);
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();

    }

    /**
     * constructor.
     * @param framesPerSecond .
     */
    public AnimationRunner(int framesPerSecond) {


        this.gui = new GUI(new String("Game"), 800, 600);
        this.framesPerSecond = framesPerSecond;
        this.sleeper = new Sleeper();

    }

    /**
     * getGui.
     * getter.
     * @return gui.
     */
    public GUI getGui() {

        return this.gui;
    }

    /**
     * run.
     * run the given Animation inside of a loop,
     * until the running status of the Animation is changed.
     * @param animation .
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * run.
     * same functionality, ass the run method above but with adaptions,
     * in order to fit CountdownAnimation.
     * @param countdownAnimation .
     */
    public void run(CountdownAnimation countdownAnimation) {

        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!countdownAnimation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            countdownAnimation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if ((!countdownAnimation.shouldStop()) && (milliSecondLeftToSleep > 0)) {
                this.sleeper.sleepFor(100 * milliSecondLeftToSleep);
            }
            else {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }

    }

}
