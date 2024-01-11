import java.util.Scanner;

/**
 * Pi Calculator creates a dart with help of Point, Circle and Rectangle class.
 * Then simulates a dart game with input attempts in order to approximate pi's value.
 *
 * @author 	Arda Iynem
 * @version 1.00 11.10.2021
 */
public class PiCalculator {
    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle rectangle;
        Circle circle;
        Point corner;
        Point center;
        int hits;
        int trials;

        corner = new Point(1, 1);
        rectangle = new Rectangle(corner, 10000, 10000);
        // Initialize center a point which is exactly middle point of the rectangle
        center = new Point((rectangle.getCorner().getX() + rectangle.getWidth()) / 2,
                (rectangle.getCorner().getY() + rectangle.getHeight()) / 2);
        // Initialize the circle with the center above and half of the rectangles height since it's a square
        circle = new Circle(center, rectangle.getHeight() / 2);

        System.out.print("Enter the trial number: ");
        trials = sc.nextInt();
        sc.close();

        // Make throws input times then prints the ratio
        hits = 0;
        for (int i = 0; i < trials; i++) {
            if (circle.contains(rectangle.getRandomPoint())) {
                hits++;
            }
        }

        // Print the result
        System.out.print("Hits/Trials ratio is: " + ((double) hits / trials) + "\n"
                + "Pi estimation according to this ratio is: " + ((double) 4 * hits / trials));
    }
}
