public class ProxyPattern {
    public static void  main(String args[])
    {
        Greeter gp = new GreeterProxy();
        System.out.println(gp.greet());
    }
}
abstract class Greeter{
    abstract String greet();
}
class RealGreeter extends Greeter{

    @Override
    String greet() {
        return "Hell From Proxy Pattern";
    }
}
class GreeterProxy extends Greeter{
    Greeter g;
    @Override
    String greet() {
        if(g == null ) g = new RealGreeter();
        return g.greet();
    }
}