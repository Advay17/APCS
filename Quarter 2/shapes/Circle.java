package shapes;

public class Circle extends Shape {
    private double radius;

    /**
     * Creates a Circle
     * @param radius Radius of the circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    String getDescription() {
        return "Circle with radius " + radius;
    }
}
