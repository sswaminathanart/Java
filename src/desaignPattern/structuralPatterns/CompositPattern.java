package desaignPattern.structuralPatterns;

import java.util.ArrayList;
import java.util.List;

public class CompositPattern {    public static void main(String args[]){
    Menu m = new Menu("File");
    m.components.add(new Menu("New"));
    Menu newMenu = (Menu)m.components.get(0);
    newMenu.components.add(new MenuItem("New New"));
    Menu edit = new Menu("Edit");

}
}
abstract class MenuComponent{
    String text;
    MenuComponent(String txt){
        text =txt;
    }
}
class MenuItem extends MenuComponent {

    MenuItem(String txt) {
        super(txt);
    }
}
class Menu extends MenuComponent {
    List<MenuComponent> components = new ArrayList<>();

    Menu(String txt) {
        super(txt);
    }
}
