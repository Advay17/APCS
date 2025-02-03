package Pets;
public class Fish extends Pet{
    private double width;

    public Fish(String name, int age, double width){
        super(name, age);
        this.width=width;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String makeSound() {
        return "Blub blub!";
    }

    @Override
    public String getFavoriteActivity() {
        return "staring into the darkness of infinity, wondering if, and when I can escape the shackles that bond me to this mortal plane, you fools don't realize what forces you trifle with, I shall reincarnate and destroy you all.";
    }

    public void swim(){
        System.out.println(getName()+" is swimming through his tank!");
    }
    
}
