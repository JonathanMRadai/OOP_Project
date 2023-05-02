package levels.levelsInfo;


import gameobjects.sprites.Sprite;
import gameobjects.sprites.velocity.Velocity;
import gameobjects.sprites.backgrounds.BackGroundLevel1;
import gameobjects.sprites.collidables.Block;
import geometry.Point;
import geometry.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Level1.
 * @author Yonatan Mevarech-Radai.
 * @version 17/06/2021.
 */
public class Level1 implements LevelInformation  {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {

        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); ++i) {
            list.add(new Velocity(4, 5));
        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return new String("Level 1");
    }

    @Override
    public Sprite getBackground() {
        return new BackGroundLevel1();
    }

    @Override
    public List<Block> blocks() {

        Color[] colors = new Color[7];
        colors[0] = Color.gray;
        colors[1] = Color.red;
        colors[2] = Color.yellow;
        colors[3] = Color.green;
        colors[4] = Color.WHITE;
        colors[5] = Color.pink;
        colors[6] = Color.CYAN;

        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 7; ++i) {

            for (int j = 0; j < 15; ++j) {

                blocks.add(new Block(
                        new Rectangle(new Point((j * 50.66666) + 20, (i * 20) + 100),
                                51,
                                20),
                        colors[i]));
            }

        }

        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
