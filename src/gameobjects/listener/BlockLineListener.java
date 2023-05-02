package gameobjects.listener;
import levels.gamelevel.GameLevel;
import gameobjects.sprites.ball.Ball;
import gameobjects.sprites.collidables.Block;
/**
 * GameObjects.listener.BlockLineListener.
 * remove the ball from game .
 * @author Yonatan Mevarch-Radai.
 * @version 07.06.2021.
 */
public class BlockLineListener implements HitListener {

    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * contractor .
     * @param game .
     * @param remainingBlocks .
     */
    public BlockLineListener(GameLevel game, Counter remainingBlocks) {

    this.game = game;
    this.remainingBlocks = remainingBlocks;

    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(1);
        if (this.remainingBlocks.getValue() == 0) {
            this.game.getSoreCounter().increase(100);
            return;
        }

    }

    /**
     * getRemainingBlocks.
     * getter.
     * @return this.remainingBlocks counter.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }
}
