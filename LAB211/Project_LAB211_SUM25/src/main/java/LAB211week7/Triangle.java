package LAB211week7;

public class Triangle extends TwoDimensionalShape {
    private double base;
    private double height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
    @Override
    public String getName() {
        return "Triangle";
    }
} 