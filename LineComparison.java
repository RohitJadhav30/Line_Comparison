import java.util.Objects;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        Line line = (Line) obj;
        return (start.equals(line.start) && end.equals(line.end)) ||
               (start.equals(line.end) && end.equals(line.start));
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end) + Objects.hash(end, start);
    }
}

public class LineComparison {
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(0, 0);
        Point p4 = new Point(1, 1);

        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p3, p4);

        System.out.println("Line 1 equals Line 2: " + line1.equals(line2));
    }
}

