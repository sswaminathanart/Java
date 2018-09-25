package desaignPattern.structuralPatterns;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightPattern {
    public static void main(String args[]){
        for(int i=0;i<1000;i++){
            if(i%2==0){
                Number e = new EvenNumber();
                e.print();
            }
            else {
                Number o = new OddNumber();
                o.print();
            }
        }
        System.out.println("Total 500 odd number objects and 500 even number objects created");
        Map<String, Number> numberlookup = new HashMap<>();
        String style;
        for(int i=0;i<1000;i++){
            if(i%2==0){
                style ="Even";
                Number n =numberlookup.get(style);
                if(n==null){
                    n = new EvenNumber();
                    numberlookup.put(style,n);

                }
                n.print();
            }
            else {
                style ="Odd";
                Number n =numberlookup.get(style);
                if(n==null){
                    n = new OddNumber();
                    numberlookup.put(style,n);
                }
                n.print();
            }
        }
    }

}

abstract class Number{
    public abstract void print();
}

class OddNumber extends Number {
    @Override
    public void print(){
        System.out.println("I am Odd");
    }
}

class EvenNumber extends Number {
    @Override
    public void print(){
        System.out.println("I am Even");
    }
}
