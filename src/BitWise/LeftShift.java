package BitWise;

public class LeftShift {


    public static void main(String[] args) {
        int x=4;
        int y =x<<1; //equal to mul by 2

        System.out.println(y);
        y =x<<2; //equal to mul by 2 power 2

        System.out.println(y);
        x=-1;
        y=x>>>1;
        System.out.println(y);

    }
}
