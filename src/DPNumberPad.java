import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DPNumberPad {

    static  int[][] NEIGHBOURS = {
            {8},//0
            {2,4},//1
            {1,3,5},//2
            {2,6},//3
            {1,5,7},//4
            {2,4,6,8},//5
            {3,5,9},//6
            {4,8},//7
            {0,5},//8
            {6,8}//9
            };
    public static void main(String args[]){
        int ways[] = noOfWays(3,10);
        for(int i=1;i<ways.length;i++)
        System.out.println(i+" # of ways"+ways[i]);

    }
    public static int[] noOfWays(int n,int digits){
        int[][] dpTable = new int[n][10];
        for(int d=0;d<10;d++){
            dpTable[0][d] = 1;
        }
        for(int i=1;i<n;i++){
            for(int d=0;d<10;d++){
                for(int j : NEIGHBOURS[d]){
                    dpTable[i][d] += dpTable[i-1][j];
                }
            }
        }
        int sum =0;
        for(int i=0;i<10;i++)
        {
            System.out.println("digit " + (n) + " value "+i+" "+dpTable[n-1][i]);
        }
        return dpTable[n-1];
    }

}
