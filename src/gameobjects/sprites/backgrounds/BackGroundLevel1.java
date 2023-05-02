package gameobjects.sprites.backgrounds;

import biuoop.DrawSurface;

import java.awt.*;

/**
 * BackGroundLevel1.
 * @author Yonatan Mevarech-Radai.
 * @version 21/06/2021.
 */
public class BackGroundLevel1 implements BackGround {


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.yellow);
        d.fillRectangle(0, (int) (d.getHeight() * 0.75), d.getWidth(), (int) (d.getHeight() * 0.25));

        d.setColor(Color.green);
        d.fillCircle(600, 500, 40);
        d.setColor(Color.red);
        d.fillCircle(600, 500, 30);
        d.setColor(Color.black);
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 40; i = i + 5) {
                d.fillCircle(580 + i, 505 + j * 7, 2);
            }
        }
        d.setColor(Color.yellow);
        d.fillRectangle(0, (int) (d.getHeight() * 0.75), d.getWidth(), 50);
        d.setColor(Color.blue);
        d.fillRectangle(0, (int) (d.getHeight() * 0.5), d.getWidth(), (int) (d.getHeight() * 0.25));
        d.setColor(Color.cyan);
        d.fillRectangle(0, 0, d.getWidth(), (int) (d.getHeight() * 0.5));
    }

    @Override
    public void timePassed() {

    }
}
