import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String args[]){
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.registor(new MobileApp());
        mobilePhone.move();
        mobilePhone.move();
        mobilePhone.move();
    }
}
class MobilePhone{
    double lon,lat;
    List<Observer> os = new ArrayList<>();

    void move(){
        lon += 3.0;
        lat += 5.0;
        notifylocationChanged();
    }
    void registor(Observer o){
        os.add(o);

    };
    private void notifylocationChanged(){
        os.forEach(o -> o.update(lon,lat));

    }

}
abstract class Observer{
    abstract void update(double lon,double lat);
}
class MobileApp extends Observer{

    @Override
    void update(double lon, double lat) {
        System.out.println(lon +" - "+ lat);
    }
}
