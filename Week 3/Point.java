/*************************************************************************
 * Name: Luka Rajcevic
 * Email: N/A
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;
import java.util.Arrays;
public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();
   
    private class SlopeOrder implements Comparator<Point>
    {  
        public int compare(Point a, Point b)
        {
            if (slopeTo(b) > slopeTo(a))
                return -1;
            if (slopeTo(b) < slopeTo(a))
                return 1;
            return 0;
        };
    }
    
    

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

  
    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.point(x, y);
        //StdDraw.setPenRadius(); // reset to line width
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        if ((this.x == that.x) && (this.y == that.y))
            return Float.NEGATIVE_INFINITY;
        if (that.x - this.x == 0)
            return Float.POSITIVE_INFINITY;
        if (that.y - this.y == 0)
        {
            return 0.0;
        }
        return (double) (that.y-this.y)/(that.x-this.x);       
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) 
    {
        if (this.y == that.y && this.x == that.x)
            return 0;
        if ((this.y < that.y) || (this.y == that.y && this.x < that.x))
            return -1;
        return 1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        Point origin = new Point(0, 0);
        Point[] pts = new Point[]{
            new Point(1, 1),
                new Point(1, 0),
                new Point(1, -1),
                new Point(0, 1),
                origin,
                new Point(0, -1),
                new Point(-1, 1),
                new Point(-1, 0),
                new Point(-1, -1)
        };
        Arrays.sort(pts, origin.SLOPE_ORDER);
        for (int i = 0; i < pts.length; ++i) {
            StdOut.println(pts[i] +": "+ origin.slopeTo(pts[i]));
        }
        Point p1 = new Point(216, 352);
        Point p2 = new Point(169, 311);
        StdOut.println(p1.slopeTo(p2));
        StdOut.println(p2.slopeTo(p1));
    }
}
