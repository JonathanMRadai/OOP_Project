package levels.levelsInfo;

import gameobjects.sprites.Sprite;
import gameobjects.sprites.velocity.Velocity;
import gameobjects.sprites.backgrounds.BackGroundLevel2;
import gameobjects.sprites.collidables.Block;
import geometry.Point;
import geometry.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Level2.
 * @author Yonatan Mevarech-Radai.
 * @version 17/06/2021.
 */
public class Level2 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(4, 5));
        list.add(new Velocity(2, 3));
        list.add(new Velocity(6, 6));

        return list;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "Level 2";
    }

    @Override
    public Sprite getBackground() {
        return  new BackGroundLevel2();
    }

    @Override
    public List<Block> blocks() {

        List<Block> blocks = new ArrayList<>();
        Color[] colors = new Color[6];
        colors[0] = Color.red;
        colors[1] = Color.ORANGE;
        colors[2] = Color.YELLOW;
        colors[3] = Color.GREEN;
        colors[4] = Color.BLUE;
        colors[5] = Color.MAGENTA;
        for (int i = 0; i < 6; ++i) {

            for (int j = 0; j < 12 - i; j++) {

                blocks.add(
                        new Block(
                        new Rectangle(
                                new Point(180 + (i * 50) + (j * 50), 100 + (i * 20)), 50, 20),
                        colors[i])
                );
            }
        }



        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 59;
    }
}
