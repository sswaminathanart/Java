package recursion;

public class HowManyBSTCatalanNumber {
    public static void main(String[] args) {
        int n = 3;
        int[] T = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                T[i] += T[j] * T[i - j - 1];
            }
        }
        System.out.println(T[n]);
    }
    ///2n! /(n+1)!*n!
}
