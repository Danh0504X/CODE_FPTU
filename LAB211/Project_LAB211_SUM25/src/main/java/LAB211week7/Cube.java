package LAB211week7;

public class Cube extends ThreeDimensionalShape {
    private double side;
    public Cube(double side) {
        this.side = side;
    }
    @Override
    public double getArea() {
        return 6 * side * side;
    }
    @Override
    public double getVolume() {
        return side * side * side;
    }
    @Override
    public String getName() {
        return "Cube";
    }
} 