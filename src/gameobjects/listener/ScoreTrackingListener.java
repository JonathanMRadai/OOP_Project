package gameobjects.listener;
import gameobjects.sprites.ball.Ball;
import gameobjects.sprites.collidables.Block;
/**
 * GameObjects.listener.ScoreTrackingListener.
 * track the score.
 * @author Yonatan Mevarch-Radai.
 * @version 07.06.2021.
 */
public class ScoreTrackingListener implements HitListener {

    private Counter currentScore;

    /**
     * contractor .
     * @param scoreCounter .
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
     this.currentScore.increase(5);
    }
}