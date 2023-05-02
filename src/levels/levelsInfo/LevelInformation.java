package levels.levelsInfo;
import gameobjects.sprites.Sprite;
import gameobjects.sprites.velocity.Velocity;
import gameobjects.sprites.collidables.Block;
import java.util.List;

/**
 * LevelInformation.
 * @author Yonatan Mevarech-Radai.
 * @version 17/06/2021.
 */
public interface LevelInformation {
    /**
     * numberOfBalls.
     * @return The num of balls.
     */
    int numberOfBalls();
    /**
     * initialBallVelocities.
     * @return The initial velocity of each ball.
     */
    List<Velocity> initialBallVelocities();

    /**
     * paddleSpeed.
     * @return paddleSpeed.
     */
    int paddleSpeed();

    /**
     * paddleWidth.
     * @return paddleWidth.
     */
    int paddleWidth();
    /**
     * levelName.
     * @return the level name will be displayed at the top of the screen.
     */
    String levelName();
    /**
     * getBackground.
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();
    /**
     * blocks.
     * @return The Blocks that make up this level, each block contains.
     * its size, color and location.
     */
    List<Block> blocks();
    /**
     * numberOfBlocksToRemove.
     *  before the level is considered to be "cleared".
     *  This number should be <= blocks.size();
     * @return Number of blocks that should be removed.
     */
    int numberOfBlocksToRemove();
}
