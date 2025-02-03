package shapes;

public class Rectangle extends Shape{
    private double width, height;
    public Rectangle(double width, double height){
        this.width=width;
        this.height=height;
    }
    @Override
    double area() {
        return width*height;
    }

    @Override
    String getDescription() {
        return "Rectangle with width " + width + " and height " + height;
    }
    
}
