import java.util.HashMap;

public class FactoryPattern {
    public static void main(String args[]){
        ShapFactory factory = new ShapFactory("Circle");
        Shape q = factory.s;
        q.draw();
        factory = new ShapFactory("Square");
        q = factory.s;
        q.draw();
    }


}
class ShapFactory{
    String type;
    Shape s;
    HashMap<String,Shape> shapeLookup = new HashMap<>();
    public ShapFactory(String type){
        shapeLookup.put("Circle",new Circle());
        shapeLookup.put("Square",new Square());
        shapeLookup.put("Triangle",new Triangle());
        this.type = type;
        this.s = shapeLookup.get(type);
    }
}
interface Shape{
    public void draw();
}
class Circle implements Shape{


    @Override
    public void draw() {
        System.out.println("This is Circle");
    }
}
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("This is Square");
    }
}
class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("This is Trangle");
    }
}
