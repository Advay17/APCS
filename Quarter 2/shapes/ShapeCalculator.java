package shapes;

public class ShapeCalculator {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(24), new Rectangle(1.125,134.51), new Triangle(912.1, 2345), new Triangle(321.1432, 2), new Circle(12.1234), new Rectangle(1, 5.3)};
        printAllShapes(shapes);
        System.out.println("Total area of all shapes: "  + getTotalArea(shapes) + " square units");
    }
    /**
     * Prints out info about all shapes in an array
     * @param shapes Array of shapes
     */
    public static void printAllShapes(Shape[] shapes){
        System.out.println("Shape Information");
        for(Shape shape: shapes) {shape.printInfo(); System.out.println("Area: " + shape.area() + " square units\n");} 
    }
    /**
     * Gets sum of areas of all the shapes in an array
     * @param shapes Array of shapes
     * @return Sum of areas
     */
    public static double getTotalArea(Shape[] shapes){
        double s = 0;
        for(Shape shape: shapes) s+=shape.area();
        return s;
    }
}
