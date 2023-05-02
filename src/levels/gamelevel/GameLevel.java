package levels.gamelevel;
import animation.*;
import gameobjects.listener.*;
import levels.levelsInfo.LevelInformation;
import biuoop.KeyboardSensor;
import gameobjects.sprites.ball.Ball;
import gameobjects.sprites.velocity.Velocity;
import gameobjects.sprites.collidables.*;
import gameobjects.sprites.collidables.ScoreIndicator;
import gameobjects.sprites.Sprite;
import geometry.Point;
import geometry.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;

/**
 * Game.Game.
 * @author Yonatan Mevarch-Radai.
 * @version 29.04.2021.
 */
public class GameLevel implements Animation {


    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter ballCounter;
    private Counter scoreCounter;
    private Counter blockCounter;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private Sprite background;
    private LevelInformation levelInfo;


    /**
     * contractor.
     * @param levelInfo .
     * @param ar .
     * @param ks .
     * @param scoreCounter .
     */
    public GameLevel(LevelInformation levelInfo, AnimationRunner ar, KeyboardSensor ks, Counter scoreCounter) {

        this.levelInfo = levelInfo;
        this.runner = ar;
        this.keyboard = ks;
        this.scoreCounter = scoreCounter;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.background = this.levelInfo.getBackground();

        setBounds();
        setScoreIndicator();

    }


    /**
     * setter.
     */
    private void setBounds() {

        (new Bound(new Rectangle(new Point(0, 20), 800, 20), Color.gray)).addToGame(this);
        (new Bound(new Rectangle(new Point(0, 20), 20, 580), Color.gray)).addToGame(this);
        (new Bound(new Rectangle(new Point(780, 20), 20, 600), Color.gray)).addToGame(this);
        //death zone.
        (new DeathZone(new Rectangle(new Point(0, 600), 800, 20), Color.gray)).addToGame(this);

        (new DeathZone(new Rectangle(new Point(0, 0), 800, 20), Color.gray)).addToGame(this);
        (new DeathZone(new Rectangle(new Point(0, 0), 20, 600), Color.gray)).addToGame(this);
        (new DeathZone(new Rectangle(new Point(800, 0), 20, 600), Color.gray)).addToGame(this);
    }
    
    /**
     * setScoreIndicator.
     * setter .
     */
    private void setScoreIndicator() {
        new ScoreIndicator(new Rectangle(new Point(0, 0), 800, 20),
                Color.WHITE, this.scoreCounter, this.levelInfo.levelName()).addToGame(this);

    }

    /**
     * getSoreCounter .
     * getter .
     * @return scoreCounter.
     */
    public Counter getSoreCounter() {

        return scoreCounter;
    }

    /**
     *  addCollidable.
     * @param c GameObjects.Sprites.Collidables.Collidable.
     */
    public void addCollidable(Collidable c) {

        if ((c == null) || (environment == null)) {

            return;
        }

        environment.addCollidable(c);
    }

    /**
     * addSprite.
     * @param s GameObjects.Sprites.Sprite.
     */
    public void addSprite(Sprite s) {

      if ((s == null) || (sprites == null)) {

          return;

      }

      sprites.addSprite(s);
    }

    /**
     * getter.
     * @return environment.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * getter.
     * @return sprites.
     */
    public SpriteCollection getSprites() {
        return sprites;
    }


    /**
     * initialize.
     * Initialize a new game: create the Blocks and GameObjects.Sprites.Ball,
     * (and GameObjects.Sprites.Collidables.Paddle).
     * and add them to the game..
     */
    public void initialize() {

        Paddle paddle = new Paddle(this,
                new Rectangle(
                new Point((780 - this.levelInfo.paddleWidth()) / 2, 570),
                this.levelInfo.paddleWidth(),
                20
        ),
                Color.black
        );
        paddle.setVelocity(this.levelInfo.paddleSpeed());
        paddle.setLimits(780, 20);

        this.ballCounter = new Counter(this.levelInfo.numberOfBalls());
        BallRemover ballRemover = new BallRemover(this, this.ballCounter);
        List<Velocity> velocities = this.levelInfo.initialBallVelocities();
        for (int i = 0; i < this.levelInfo.numberOfBalls(); ++i) {

            Ball ball = new Ball(new Point(400, 350), 8, Color.WHITE);
            ball.setVelocity(velocities.get(i).getDx(), velocities.get(i).getDy());
            ball.addToGame(this);
            ball.addHitListener(ballRemover);

        }

        List<Block> blocks = this.levelInfo.blocks();
        this.blockCounter = new Counter(this.levelInfo.numberOfBlocksToRemove());
        BlockRemover blockRemover = new BlockRemover(this, this.blockCounter);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.scoreCounter);
        Block previous = blocks.get(0);
        BlockLineListener blockLineListener = new BlockLineListener(this, new Counter(0));
        for (Block block : blocks) {
            if (previous.getUpperLeft().getY() != block.getUpperLeft().getY()) {
                blockLineListener = new BlockLineListener(this, new Counter(0));
            }
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            blockLineListener.getRemainingBlocks().increase(1);
            block.addHitListener(blockLineListener);
            previous = block;

        }

    }

    /**
     * removeCollidable .
     * @param c the removed collidable.
     */

    public void removeCollidable(Collidable c) {

        this.environment.getList().remove(c);

    }

    /**
     * removeSprite .
     * @param s the removed sprite.
     */
    public void removeSprite(Sprite s) {

        this.sprites.getList().remove(s);
    }

    /**
     * run.
     * Run the game -- start the animation loop.
     */
    public void run() {

        this.running = true;
        this.runner.run(new CountdownAnimation(2, 3, this.sprites,
                this.keyboard, this.levelInfo.getBackground(), this.runner));
        // countdown before turn starts.
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
        if ((this.ballCounter.getValue() > 0) && (this.blockCounter.getValue() > 0))  {
            this.background.drawOn(d);
            this.sprites.drawAllOn(d);
            this.sprites.notifyAllTimePassed();
        }
        else {

            this.running = false;
        }

    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * getRunner.
     * @return this.runner.
     */
    public AnimationRunner getRunner() {

       return this.runner;
    }
    /**
     * getter.
     * @return ballCounter .
     */
    public Counter getBallCounter() {
        return this.ballCounter;
    }
}
