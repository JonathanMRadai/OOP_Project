package levels.levelsInfo;

import gameobjects.sprites.Sprite;
import gameobjects.sprites.velocity.Velocity;
import gameobjects.sprites.backgrounds.BackGroundLevel4;
import gameobjects.sprites.collidables.Block;
import geometry.Point;
import geometry.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Level4.
 * @author Yonatan Mevarech-Radai.
 * @version 17/06/2021.
 */
public class Level4 implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(4, 5));
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return new String("Level 4");
    }

    @Override
    public Sprite getBackground() {

        return new BackGroundLevel4();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>(numberOfBlocksToRemove());
        blocks.add(new Block(new Rectangle(new Point(375, 280), 51, 20), Color.RED));
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
