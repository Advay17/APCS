package shapes;

public abstract class Shape {
    /**
     * Calculates the area of the shape
     * @return The area of the shape
     */
    abstract double area();
    /**
     * Gets the description of a shape
     * @return The description of a shape
     */
    abstract String getDescription();
    /**
     * Prints description and area of a shape
     */
    public void printInfo(){
        System.out.println(getDescription()+" has an area of " + area());
    }
}
