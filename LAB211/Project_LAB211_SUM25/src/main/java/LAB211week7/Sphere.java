package LAB211week7;

public class Sphere extends ThreeDimensionalShape {
    private double radius;
    public Sphere(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return 4 * Math.PI * radius * radius;
    }
    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
    @Override
    public String getName() {
        return "Sphere";
    }
} 