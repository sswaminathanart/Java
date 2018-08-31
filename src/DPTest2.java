import java.util.Random;

public class DPTest2 {
    public static void main(String args[]){
        int[][] x = new int [10][10];
        Random random = new Random();
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
               x[i][j]=1;
            }
        }

        int r =numberOfPaths(x);
        System.out.println("Ways "+Integer.MAX_VALUE);
        }
    static int numberOfPaths(int[][] a) {
        int N= a.length;
        int M =a[0].length;
        double[][] DP = new double[N+1][M+1];
        a[0][0]=1;
        DP[1][1] = (double)a[0][0];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print(a[i][j]);
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (a[i-1][j-1] != 0) {
                    DP[i][j] += DP[i-1][j];
                    DP[i][j] += DP[i][j-1];
                }
            }
        }

        if(DP[N][M]<Integer.MAX_VALUE){
            return (int)DP[N][M];
        }
        else
            return -1;
    }
}
