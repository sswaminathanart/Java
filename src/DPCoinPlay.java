import java.util.Map;

public class DPCoinPlay {
    static int maxWin(int[] v) {
        final int SIZE =v.length;
        int[][] dpTable = new int[SIZE][SIZE];
        int x,y,z;
        int i,j,gap;
        for(gap=0;gap<SIZE;gap++){
            for(i=0,j=gap;j<SIZE;j++,i++){
                x = (i+2<=j)?dpTable[i+2][j]:0;
                y = (i+1<=j-1)? dpTable[i+1][j-1]:0;
                z = (i<j-2)? dpTable[i][j-2]:0;
                dpTable[i][j] = Math.max(v[i] + Math.min(x,y)
                        ,v[j]+ Math.min(y,z));

                System.out.println("gap: "+gap+" ==> i: " + i + ", j:" + j + ", = " + dpTable[i][j]);
            }
        }
        return dpTable[0][SIZE-1];
    }
    public static void main(String args[]){
      //  int v[]={8, 3, 14, 7};
        int[] v ={2,100,3,6,99};
        System.out.println("maximum possible amount of sum that you can accumulate "+ maxWin(v));
    }
}
