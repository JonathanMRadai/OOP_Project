package gameflow;
import animation.EndScreen;
import animation.KeyPressStoppableAnimation;
import levels.levelsInfo.LevelInformation;
import animation.AnimationRunner;
import biuoop.KeyboardSensor;
import levels.gamelevel.GameLevel;
import gameobjects.listener.Counter;
import java.util.List;

/**
 * GameFlow.
 * run the transition between levels and the end screen.
 * @author Yonatan Mevarech-Radai.
 * @version 17/06/2021.
 */
public class GameFlow {

    private Counter score;
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;

    /**
     * contractor.
     * @param ar . 
     * @param ks . 
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {

        this.score = new Counter(0);
        this.animationRunner = ar;
        this.keyboardSensor = ks;


    }

    /**
     * runLevels .
     * @param levels .
     */
    public void runLevels(List<LevelInformation> levels) {

        boolean win = true;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.animationRunner, this.keyboardSensor, this.score);
            level.initialize();
            do {
                level.run();
            } while (!level.shouldStop());

            if (level.getBallCounter().getValue() <= 0) {
                win = false;
                break;
            }
        }
        if (win) {

            this.animationRunner.run(
                    new KeyPressStoppableAnimation(
                    this.keyboardSensor,
                            KeyboardSensor.SPACE_KEY,
                    new EndScreen("YOU WIN !", this.score.getValue(), true)
            )
            );

        }
        else {

            this.animationRunner.run(
                    new KeyPressStoppableAnimation(
                    this.keyboardSensor,
                            KeyboardSensor.SPACE_KEY,
                    new EndScreen("Game Over .", this.score.getValue(), false)
                    )

            );
        }
        this.animationRunner.getGui().close();
    }
}


