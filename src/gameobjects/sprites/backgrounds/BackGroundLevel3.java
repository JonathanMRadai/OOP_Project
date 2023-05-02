package gameobjects.sprites.backgrounds;

import biuoop.DrawSurface;
import java.awt.*;

/**
 * BackGroundLevel3.
 * @author Yonatan Mevarech-Radai.
 * @version 20/06/2021.
 */
public class BackGroundLevel3 implements BackGround{
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.yellow);
        d.fillRectangle(0,(int)(d.getHeight() * 0.75), d.getWidth(), (int)(d.getHeight() * 0.25));
        d.setColor(Color.blue);
        d.fillRectangle(0,(int)(d.getHeight() * 0.5),d.getWidth(),(int)(d.getHeight() * 0.25));
        d.setColor(Color.cyan);
        d.fillRectangle(0,0, d.getWidth(), (int)(d.getHeight() * 0.5));
        d.setColor(Color.yellow);
        d.fillCircle(0,0,200);
        d.setColor(Color.LIGHT_GRAY);
        for(int i = 0; i < 6; ++i){
            d.fillCircle(600 + i * 30,200,30);
        }
        for(int i = 0; i < 6; ++i){
            d.fillCircle(520 + i * 15,250,15);
        }
        for(int i = 0; i < 6; ++i){
            d.fillCircle(20 + i * 15,200,15);
        }
        for(int i = 0; i < 6; ++i) {
            d.fillCircle(15 + i * 30,150,30);
        }
        for(int i = 0; i < 6; ++i) {
            d.fillCircle(70 + i * 10,70,10);
        }
        for(int i = 0; i < 6; ++i) {
            d.fillCircle(70 + i * 10,70,10);
        }
        for(int i = 0; i < 6; ++i) {
            d.fillCircle(180 + i * 40,100,40);
        }
    }

    @Override
    public void timePassed() {

    }
}
