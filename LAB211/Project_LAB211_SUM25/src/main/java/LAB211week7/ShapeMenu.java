package LAB211week7;

import java.util.Scanner;

public class ShapeMenu {
    public static void start(Scanner sc) {
        Shape[] shapes = new Shape[] {
            new Circle(3),
            new Square(4),
            new Triangle(3, 5),
            new Sphere(2),
            new Cube(2),
            new Tetrahedron(2)
        };
        for (Shape s : shapes) {
            if (s instanceof TwoDimensionalShape) {
                System.out.printf("%s: Area = %.2f\n", s.getName(), ((TwoDimensionalShape)s).getArea());
            } else if (s instanceof ThreeDimensionalShape) {
                System.out.printf("%s: Area = %.2f, Volume = %.2f\n", s.getName(), ((ThreeDimensionalShape)s).getArea(), ((ThreeDimensionalShape)s).getVolume());
            }
        }
    }
} 