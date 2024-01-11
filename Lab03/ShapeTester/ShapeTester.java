import java.util.Scanner;

public class ShapeTester {
    public static void main(String[] args) {
        // Variables
        ShapeContainer shapes = new ShapeContainer();
        Scanner scan = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Enter shape name (x to terminate):");
            choice = scan.next();

            if (choice.equalsIgnoreCase("rectangle")) {
                System.out.println("Enter the width and height of rectangle by leaving a space between them:");
                shapes.add(new Rectangle(scan.nextInt(), scan.nextInt()));
            }
            else if (choice.equalsIgnoreCase("circle")) {
                System.out.println("Enter the radius of circle:");
                shapes.add(new Circle(scan.nextInt()));
            }
            else if (choice.equalsIgnoreCase("square")) {
                System.out.println("Enter the side length of square:");
                shapes.add(new Square(scan.nextInt()));
            }
            else if (choice.equalsIgnoreCase("contains")) {
                System.out.println("Enter a location point (x, y) by leaving a space between them to find shape containing (x, y):");

                Shape shapeContains;
                shapeContains = shapes.contains(scan.nextInt(), scan.nextInt());
                if (shapeContains instanceof Circle) {
                    ((Circle) shapeContains).setSelected(true);
                }
                else {
                    ((Rectangle) shapeContains).setSelected(true);
                }
            }
            else if (choice.equalsIgnoreCase("remove")) {
                shapes.removeSelected();
            }

        } while (!choice.equalsIgnoreCase("x"));

        System.out.println("Total area of the shapes is: " + shapes.getArea());
        System.out.println(shapes);
    }
}
