package gameobjects.listener;
import levels.gamelevel.GameLevel;
import gameobjects.sprites.ball.Ball;
import gameobjects.sprites.collidables.Block;
/**
 * GameObjects.listener.BallRemover.
 * remove the ball from game .
 * @author Yonatan Mevarch-Radai.
 * @version 07.06.2021.
 */
public class BallRemover implements HitListener {

    private GameLevel game;
    private Counter remainingBalls;

    /**
     * contractor .
     * @param game .
     * @param remainingBalls .
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {

        this.game = game;
        this.remainingBalls = remainingBalls;

    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {

        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);

    }
}
