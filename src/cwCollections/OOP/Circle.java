package cwCollections.OOP;

public class Circle {
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }


    public double getArea(){
        return Math.PI * radius * radius;
    }
    public static void main(String[] args){
        Circle c = new Circle(3.0);
        System.out.println("面积" + c.getArea());
    }
}
