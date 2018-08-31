public class DecarativePattern {
    public static void main(String args[]){
        ShapD shap = new CircleD();
        System.out.println(shap.draw());
        ShapD redCircle = new ColorShapDecarater(shap,"Red");
        System.out.println(redCircle.draw());
        ShapD dotedCircle = new BorderDecarater(redCircle,"Dot");
        System.out.println(dotedCircle.draw());
    }
}
interface ShapD{
    public String draw();
}
class CircleD implements ShapD{

    @Override
    public String draw() {
        return "Circle";
    }
}

class SquareD implements ShapD{

    @Override
    public String draw() {
        return "Square";
    }
}
abstract class ShapDecarater implements ShapD{
    ShapD shapD;

    public ShapDecarater(ShapD shapD) {
        this.shapD = shapD;
    }
}
class ColorShapDecarater extends ShapDecarater{
    String color;

    public ColorShapDecarater(ShapD shapD,String c) {
        super(shapD);
        this.color =c;
    }

    @Override
    public String draw() {
        return color + " "+ shapD.draw() ;
    }
}
class BorderDecarater extends ShapDecarater{
    String broder;

    public BorderDecarater(ShapD shapD,String b) {
        super(shapD);
        broder = b;
    }

    @Override
    public String draw() {
        return broder + " "+shapD.draw();
    }
}