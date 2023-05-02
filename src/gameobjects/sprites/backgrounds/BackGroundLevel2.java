package gameobjects.sprites.backgrounds;

import biuoop.DrawSurface;

import java.awt.*;

/**
 * BackGroundLevel2.
 * @author Yonatan Mevarech-Radai.
 * @version 21/06/2021.
 */
public class BackGroundLevel2 implements BackGround {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.yellow);
        d.fillRectangle(0, (int) (d.getHeight() * 0.75), d.getWidth(), (int) (d.getHeight() * 0.25));
        d.setColor(Color.blue);
        d.fillRectangle(0, (int) (d.getHeight() * 0.5), d.getWidth(), (int) (d.getHeight() * 0.25));
        d.setColor(Color.cyan);
        d.fillRectangle(0, 0, d.getWidth(), (int) (d.getHeight() * 0.5));
        d.setColor(Color.GRAY);
        d.fillRectangle(25, 200, 5, 350);
        d.setColor(Color.red);
        d.fillRectangle(30, 200, 100,  70);
    }

    @Override
    public void timePassed() {

    }
}
