package desaignPattern.behavioralPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Observable;

public class ObserverPattern {
}
class User implements Observer{
    private Observable observable = null;
    User(Observable o){
        this.observable = o;
    }
    @Override
    public void update(Observable o, Object arg) {
        buyDeress();
        unSubscribe();

    }
    public void buyDeress(){
        System.out.println("Got my new Red Dress");
    }
    public void unSubscribe(){
        observable.deleteObserver(this);
    }
}
class RedDress extends Observable{
    private List<Observer> users = new ArrayList<>();
    private boolean inStock = true;
    public boolean isInStock(){
        return inStock;
    }
    public void setStock(boolean inStock){
        this.inStock = inStock;
        notifyObservers();
    }
    public void addObserver(Observer o){
        users.add(o);
    }
    public void deleteObserver(Observer o){
        users.remove(o);
    }
    public void notifyObservers(){
        for(Observer user : users){
            user.update(this,user);
        }
    }

}