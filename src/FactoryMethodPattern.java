import java.util.HashMap;
import java.util.Map;

public class FactoryMethodPattern {
    public static void main(String args[]){
        PizzaFactory p = new PizzaFactory();
        Pizza pizza = p.createPiza("Veg");
        pizza.addIngredients();
    }

}
abstract class Pizza {
    public abstract void addIngredients();

    public void bakePizza() {
        System.out.println("Pizza baked at 400 for 20 minutes.");
    }
}
class VegPizza extends Pizza{

    @Override
    public void addIngredients() {
        System.out.println("Added Ingredients Veg");
    }
}
class CheesePiza extends Pizza {

    @Override
    public void addIngredients() {
        System.out.println("Added Ingredients Cheese");
    }
}
class PannerPiza extends Pizza {

    @Override
    public void addIngredients() {
        System.out.println("Added Ingredients Panner");
    }
}
abstract class  BasePizzaFactory {
    public abstract Pizza createPiza(String type);
    Map<String,Pizza> pizzalookup= new HashMap<>();

    BasePizzaFactory(){
        pizzalookup.put("Veg",new VegPizza());
        pizzalookup.put("Cheese",new CheesePiza());
        pizzalookup.put("Panner", new PannerPiza());
    }
}
class PizzaFactory extends BasePizzaFactory {

    @Override
    public Pizza createPiza(String type) {
        return pizzalookup.get(type);
    }
}