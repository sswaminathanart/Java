import java.util.Random;

public class AdcEqualyLikely {
    public static void main(String args[]){
        int[] x = {1,2,3,4};
        for(int i : x)
        System.out.print(i+"  ");
        System.out.println();
        int[] y= equalyLikely(x);
        for(int i : y)
            System.out.print(i+"  ");
    }
    static int[] equalyLikely(int[] x){
        for(int i=x.length-1;i>=0;i--){
            int randomidx = getRandomNumberInRange(0,i);
            swap(x,randomidx,i);
        }
        return x;
    }
    static void swap(int[] x,int i,int j){
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
    private static int getRandomNumberInRange(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
