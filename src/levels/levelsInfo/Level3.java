package levels.levelsInfo;

import gameobjects.sprites.Sprite;
import gameobjects.sprites.velocity.Velocity;
import gameobjects.sprites.backgrounds.BackGroundLevel3;
import gameobjects.sprites.collidables.Block;
import geometry.Point;
import geometry.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Level3.
 * @author Yonatan Mevarech-Radai.
 * @version 17/06/2021.
 */
public class Level3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 8;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); ++i) {
            list.add(new Velocity(-4 + i, 6));
        }

        return list;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 300;
    }

    @Override
    public String levelName() {
        return "Level 3";
    }

    @Override
    public Sprite getBackground() {
        return new BackGroundLevel3();
    }

    @Override
    public List<Block> blocks() {

        Color[] colors = new Color[15];
        colors[0] = Color.red;
        colors[1] = Color.red;
        colors[2] = Color.orange;
        colors[3] = Color.orange;
        colors[4] = Color.yellow;
        colors[5] = Color.yellow;
        colors[6] = Color.green;
        colors[7] = Color.green;
        colors[8] = Color.green;
        colors[9] = Color.blue;
        colors[10] = Color.blue;
        colors[11] = Color.pink;
        colors[12] = Color.pink;
        colors[13] = Color.cyan;
        colors[14] = Color.cyan;

        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 15; ++i) {

            blocks.add(new Block(new Rectangle(new Point((i * 50.66666) + 20, 300), 51, 20), colors[i]));

        }

        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
