package desaignPattern.creationalPatterns;

import java.util.HashMap;
import java.util.Map;

public class AbstractFactory {
    public static void main(String args[]){
        MyAbstractFactory factory = new LabtopBrowserFactory();
        factory.createLaptopwithBrowser("Apple");
        ((LabtopBrowserFactory) factory).l.createLaptop();
        ((LabtopBrowserFactory) factory).b.createBrowser();
        factory.createLaptopwithBrowser("HP");
        ((LabtopBrowserFactory) factory).l.createLaptop();
        ((LabtopBrowserFactory) factory).b.createBrowser();
        factory.createLaptopwithBrowser("Google");
        ((LabtopBrowserFactory) factory).l.createLaptop();
        ((LabtopBrowserFactory) factory).b.createBrowser();
    }
}
interface Laptop {
    public void createLaptop();
}
class HPLaptop implements Laptop {

    @Override
    public void createLaptop() {
        System.out.println("HP Laptop");
    }
}
class MacLaptop implements Laptop {

    @Override
    public void createLaptop() {
        System.out.println("Map Laptop");
    }
}
class ChromBook implements Laptop {

    @Override
    public void createLaptop() {
        System.out.println("ChromBook");
    }
}
interface Browser{
    public void createBrowser();
}
class InternetExplore implements Browser {

    @Override
    public void createBrowser() {
        System.out.println("Internet Explore");
    }
}
class Safari implements Browser {

    @Override
    public void createBrowser() {
        System.out.println("Apple Safari");
    }
}
class GoogleChrome implements Browser {

    @Override
    public void createBrowser() {
        System.out.println("Google Chrome");
    }
}
class AppleFactory{
    Laptop l;
    Browser b;
    AppleFactory(){
        l = new MacLaptop();
        b = new Safari();
    }
}
class HPFactory{
    Laptop l;
    Browser b;
    HPFactory()
    {
        l = new HPLaptop();
        b = new InternetExplore();
    }
}
class GoogleFactory{
    Laptop l;
    Browser b;
    GoogleFactory(){
        l = new ChromBook();
        b = new GoogleChrome();
    }
}
abstract class MyAbstractFactory
{
    public abstract void createLaptopwithBrowser(String type);

}

class LabtopBrowserFactory extends MyAbstractFactory {
    String type;
    Laptop l;
    Browser b;
    Map<String, Laptop> laptoplookup = new HashMap<>();
    Map<String, Browser> browserLookup = new HashMap<>();
    LabtopBrowserFactory() {
        laptoplookup.put("Apple", new MacLaptop());
        laptoplookup.put("Google", new ChromBook());
        laptoplookup.put("HP", new HPLaptop());
        browserLookup.put("Apple", new Safari());
        browserLookup.put("Google", new GoogleChrome());
        browserLookup.put("HP", new InternetExplore());

    }
    @Override
    public void createLaptopwithBrowser(String type) {
        l = laptoplookup.get(type);
        b = browserLookup.get(type);

    }
}
