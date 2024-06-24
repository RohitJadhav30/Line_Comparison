import java.util.Scanner;

public class LineComparison{

    public static double calculateLength(double x1, double x2, double y1, double y2){
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the x1 and x2 coordinates: ");
        double x1 = sc.nextDouble();
        double x2 = sc.nextDouble();

        System.out.println("Enter the y1 and y2 coordinates: ");
        double y1 = sc.nextDouble();
        double y2 = sc.nextDouble();
        sc.close();

        double length = calculateLength(x1, x2, y1, y2);
        System.out.println("The length of the line is: " + String.format("%.2f", length));

    }
}