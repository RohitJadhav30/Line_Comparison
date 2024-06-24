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

class Line implements Comparable<Line> {
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

    public double length() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
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
        return Objects.hash(start, end);
    }

    @Override
    public int compareTo(Line other) {
        double thisLength = this.length();
        double otherLength = other.length();

        if (thisLength < otherLength) {
            return -1;
        } else if (thisLength > otherLength) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class LineComparison {
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(0, 0);
        Point p4 = new Point(2, 2);

        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p3, p4);

        System.out.println("Length of line1: " + line1.length());
        System.out.println("Length of line2: " + line2.length());

        int comparisonResult = line1.compareTo(line2);
        if (comparisonResult < 0) {
            System.out.println("line1 is shorter than line2");
        } else if (comparisonResult > 0) {
            System.out.println("line1 is longer than line2");
        } else {
            System.out.println("line1 is equal in length to line2");
        }
    }
}
