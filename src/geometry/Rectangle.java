package geometry;
import biuoop.DrawSurface;


import java.awt.Color;
import java.util.ArrayList;
/**
 * rectangle.
 * x specifies the x value of the Geometry.Point.
 * y specifies the y value of the Geometry.Point.
 * @author Yonatan Mevarch-Radai.
 * @version 17.04.2021.
 */
public class Rectangle {

    protected Point upperLeft;
    protected double width;
    protected double height;
    protected Line[] lines;
    private java.awt.Color color;

    /**
     * contractor.
     * @param upperLeft .
     * @param width .
     * @param height .
     * @param color .
     */
   public Rectangle(Point upperLeft, double width, double height, java.awt.Color color) {

       this.upperLeft = upperLeft;
       this.width = width;
       this.height = height;
       this.color = color;
       crateLines();

   }
    /**
     * contractor.
     * @param upperLeft .
     * @param width .
     * @param height .
     */
    public Rectangle(Point upperLeft, double width, double height) {

        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        crateLines();

    }

    /**
     * crateLines .
     * crate the border line of the rectangle.
     */
    private void crateLines() {

        //top to left
        lines = new Line[4];
        lines[0] = new Line(upperLeft.getX(), upperLeft.getY(),
                upperLeft.getX() + width, upperLeft.getY());
        lines[1] = new Line(upperLeft.getX() + width, upperLeft.getY(),
                upperLeft.getX() + width, upperLeft.getY() + height);
        lines[2] = new Line(upperLeft.getX() + width, upperLeft.getY() + height,
                upperLeft.getX(), upperLeft.getY() + height);
        lines[3] = new Line(upperLeft.getX(), upperLeft.getY() + height,
                upperLeft.getX(), upperLeft.getY());

    }

    /**
     * intersectionPoints .
     * @param line that crosses the rectangle.
     * @return list of the coalition points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {

        java.util.List<Point> points = new ArrayList<>();
        for (int i = 0; i < lines.length; ++i) {

            Point temp = lines[i].intersectionWith(line);

            if (temp != null) {

                points.add(temp);
            }

        }

        return points;


    }

    /**
     * getter.
     * @return width.
     */
    public double getWidth() {

        return width;
    }

    /**
     * getter.
     * @return height.
     */
    public double getHeight() {

        return height;
    }

    /**
     * getter.
     * @return upperLeft.
     */
    public Point getUpperLeft() {
     return upperLeft;
    }

    /**
     * getter.
     * @return getTop.
     */
    public Line getTop() {

        return lines[0];
    }

    /**
     * getter.
     * @return right.
     */
    public Line getRight() {

        return lines[1];
    }

    /**
     * getter.
     * @return bottom.
     */
    public Line getBottom() {

        return lines[2];
    }

    /**
     * getter.
     * left.
     * @return line 3 .
     */
    public Line getLeft() {


        return lines[3];
    }

    /**
     * setUpperLeft
     * upperLeft point.
     * @param newUpperLeft the wanted upperLeft point.
     */
    protected void setUpperLeft(Point newUpperLeft) {

        this.upperLeft = newUpperLeft;
        crateLines();
    }

    /**
     * drawOn .
     * @param surface .
     */
    public void drawOn(DrawSurface surface) {


        if ((surface == null) || (upperLeft == null)) {


            return;

        }
        if (color == null) {

            //Default color.
            color = Color.darkGray;
        }
        surface.setColor(color);
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
        surface.setColor(Color.black);
        for (Line l  : lines) {

            l.drawOn(surface);
        }

        return;

    }
}
