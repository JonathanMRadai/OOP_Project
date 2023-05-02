package geometry;

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Geometry.Line.
 * @version third version at 27.04.2021 12:08.
 * @author Yonatan Mevarch-Radai.
 */

public class Line {


    private Point start;
    private Point end;
    private boolean vertical = false;

    /**
     * constructor.
     * @param start the start Geometry.Point of the line.
     * @param end   the and point of the line.
     */
    public Line(Point start, Point end) {

        //check if vertical
        if (start.getX() == end.getX()) {
            setVerticalLine(start, end);

        }
        else if (start.getX() > end.getX()) {

            this.start = end;
            this.end = start;

        }
        else {

            this.start = start;
            this.end = end;

        }
    }

    /**
     * constructor.
     * @param x1 the start Geometry.Point x.
     * @param y1 the start Geometry.Point y.
     * @param x2 the end Geometry.Point x.
     * @param y2 the end Geometry.Point y.
     */
    public Line(double x1, double y1, double x2, double y2) {

      Point nStart = new Point(x1, y1);
      Point nEnd = new Point(x2, y2);

      if (nStart.getX() == nEnd.getX()) {
            setVerticalLine(nStart, nEnd);

      }
      else if (nStart.getX() > nEnd.getX()) {

          this.start = nEnd;
          this.end = nStart;

      }
      else {

            this.start = nStart;
            this.end = nEnd;

      }

    }

    /**
     * setVerticalLine
     * set a Vertical Geometry.Line and change the Geometry.Line's Vertical to true.
     * @param vStart .
     * @param vEnd .
     */
    private void setVerticalLine(Point vStart, Point vEnd) {

        vertical = true;

        if (vStart.getY() > vEnd.getY()) {

            this.start = vEnd;
            this.end = vStart;

        }
        else {

            this.start = vStart;
            this.end = vEnd;

        }

    }

    /**
     * accessor .
     * @return true if vertical, false otherwise.
     */
    public boolean isVertical() {

        return this.vertical;
    }

    /**
     * length.
     * using Geometry.Point method "distance" of Geometry.Point start on end,
     * this method calculate the length of the line.
     * @return length of the line.
     */
    public double length() {

        return this.start.distance(this.end);

    }

    /**
     * middle.
     * calculate the middle Geometry.Point of the line.
     * @return the middle point of the line.
     */
    public Point middle() {

        return new Point(((this.start.getX() + this.end.getX()) / 2),
                ((this.start.getY() + this.end.getY()) / 2));

    }

    /**
     * start.
     * accessor.
     * @return the start point of the line.
     */
    public Point start() {

        return this.start;

    }

    /**
     * end.
     * accessor.
     * @return the end point of the line.
     */
    public Point end() {

        return this.end;

    }

    /**
     * isIntersecting
     * check if a two line is intersecting or not:
     * by check if the  intersection Geometry.Point is not null.
     * @param other Geometry.Line.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {

        if (other == null) {

            return false;

        }

        if (intersectionWith(other) != null) {

            return true;

        }

        return false;

    }

    /**
     * intersectionWith.
     * check the Lines intersection Geometry.Point by compering the Geometry.Line equation of both.
     * @param other Geometry.Line.
     * @return the intersection Geometry.Point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {

        if (other == null) {

            return null;

        }
        if (this.equals(other)){

            return null;
        }

        if (this.start.equals(other.end())) {

            return this.start;
        }

        if (other.start().equals(this.end)) {

            return other.start();
        }

        if (other.isVertical()) {

           return other.theOneIsVerticalCase(this);

        }
        if (vertical) {

            return theOneIsVerticalCase(other);
        }

        double a1 = (this.start.getY() - this.end.getY())
                / (this.start.getX() - this.end.getX());
        double b1 = this.start.getY() - (a1 * this.start.getX());

        double a2 = (other.start().getY() - other.end().getY())
                / (other.start().getX() - other.end().getX());
        double b2 = other.start().getY() - (a2 * other.start().getX());

        double x = (b2 - b1) / (a1 - a2);
        if ((this.start.getX() <= x) && (x <= this.end.getX())
                && (other.start().getX() <= x) && (x <= other.end().getX())) {

            return new Point(x, (a1 * x) + b1);

        }

        return null;

    }

    /**
     * theVerticalCase
     * help "intersectionWith" method.
     * in a case that one of the lines is Vertical
     * @param other .
     * @return interaction point.
     */
    private Point theOneIsVerticalCase(Line other) {


        //the other line x rang dose not include the vertical line x value.
        if (!((other.start().getX() <= start.getX()) && (start.getX() <= other.end().getX()))) {
            return null;
        }

        double a = (other.start().getY() - other.end().getY())
                / (other.start().getX() - other.end().getX());
        double b = other.start().getY() - (a * other.start().getX());

        // yI is the value of y in the Interaction Geometry.Point.
        //put the x value of the parallel Geometry.Line in the Geometry.Line equation.
        double yI = (a * start.getX()) + b;

        //check if the if yI is in bounds.
        if ((start.getY() <= yI) && (yI <= end.getY())) {

            return new Point(start.getX(), yI);
        }
        //yI is out of bounds.
        else {

            return null;
        }

    }

    /**
     * equals.
     * check if the Lines are equal by compering the start and end Geometry.Point.
     * @param other Geometry.Line.
     * @return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {

        if (other == null) {

            return false;

        }

        if ((other.start().equals(start)) && (other.end().equals(end))) {

            return true;
        }

        return false;
    }

    /**
     * closestIntersectionToStartOfLine.
     * search the closest intersection to start of Geometry.Line with the Geometry.Rectangle.
     * @param rect .
     * @return closest intersection to start of Geometry.Line. null otherwise - there is not intersection Points.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {

        if (rect == null) {

            return null;
        }

        java.util.List<Point> points = rect.intersectionPoints(this);
        Point closest = null;

        for (Point p : points) {

            if (closest == null) {
                closest = p;
            }
            else if (start.distance(p) < start.distance(closest)) {

                closest = p;
            }
        }

        return closest;

    }

    /**
     * drawOn.
     * @param d DrawSurface.
     */
    public void drawOn(DrawSurface d) {

        if (d == null) {

            return;
        }
        d.setColor(Color.black);
        d.drawLine(((int) this.start.getX()), ((int) this.start.getY()),
                ((int) this.end.getX()), ((int) this.end.getY()));

    }
}