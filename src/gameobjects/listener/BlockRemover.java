package gameobjects.listener;

import levels.gamelevel.GameLevel;
import gameobjects.sprites.ball.Ball;
import gameobjects.sprites.collidables.Block;

/**
 * GameObjects.listener.BlockRemover.
 * remove the block from game .
 * @author Yonatan Mevarch-Radai.
 * @version 07.06.2021.
 */
public class BlockRemover implements HitListener {

    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor .
     * @param game .
     * @param removedBlocks .
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {

        this.game = game;
        this.remainingBlocks = removedBlocks;


    }


    @Override
    public void hitEvent(Block beingHit, Ball hitter) {

        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);

    }
}