package recursion;

public class DoublePower {
    public static void main(String[] args){
        double x =10;
        int n1= 3;
        int n2 = -9;
        System.out.println(power(x,n1));
        System.out.println(power(x,n2));
    }
    public static double power(double x,int n){
        if(n==1) return x;
        if(n== -1) return 1/x;
        if(n>1) return x * power(x,n-1);
        if(n<0) return (1/x * power(x,n+1));
        return 1;
    }
}
