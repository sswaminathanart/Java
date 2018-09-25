package BitWise;

public class CountNoOfSetBits {
    public static void main(String[] args) {
        int x=10;
        int count=0;
        while(x>0){
            count +=x&1;
            x=x>>1;
        }
        System.out.println(count);
        x=10;
        count=0;
        while (x>0){
            x&=x-1;
            System.out.println(x);
            count++;
        }
        System.out.println(count);
    }
}
