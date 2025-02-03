package shapes;

public class Triangle extends Shape {
    private double base, height;
    /**
     * Creates a Triangle
     * @param base Length of triangle base
     * @param height Altitude of triangle
     */
    public Triangle(double base, double height){
        this.base=base;
        this.height=height;
    }
    @Override
    double area() {
        return 0.5*base*height;
    }

    @Override
    String getDescription() {
        return "Triangle with base " + base + " and height " + height;
    }
    
}
