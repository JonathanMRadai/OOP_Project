package gameobjects.sprites.backgrounds;
import biuoop.DrawSurface;
import java.awt.Color;

public class BackGroundLevel4 implements BackGround {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.yellow);
        d.fillRectangle(0, (int) (d.getHeight() * 0.75), d.getWidth(), (int) (d.getHeight() * 0.25));
        d.setColor(Color.BLUE);
        d.fillRectangle(0, 0, d.getWidth(), (int) (d.getHeight() * 0.5));
        d.setColor(Color.orange);
        d.fillCircle(400, 300, 100);
        d.setColor(Color.CYAN);
        d.fillRectangle(0, 300, d.getWidth(), 150);
    }

    @Override
    public void timePassed() {

    }
}
