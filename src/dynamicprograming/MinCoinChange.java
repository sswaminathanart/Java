package dynamicprograming;

import java.util.HashMap;
import java.util.Map;

public class MinCoinChange {
    static int[] coins ={2,3,5};
    static int A =10;
    public static void main(String args[]) {
        Map<Integer, Integer> map = new HashMap<>();
        int noOfCoin = minCoinChange(A, map);
        System.out.println("# of Coins "+noOfCoin);
        noOfCoin = dpMinCoinChange();

    }
    public static int minCoinChange(int amount,Map<Integer,Integer> map){
        if(amount == 0 ) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if(map.containsKey(amount)) return map.get(amount);
        int min_coin = Integer.MAX_VALUE -1 ;
        for(int c=0;c<coins.length;c++){
            min_coin = Integer.min(min_coin,minCoinChange(amount-coins[c],map));

        }
        map.put(amount,min_coin+1);
        return min_coin+1;

    }
    public static int dpMinCoinChange(){
        int[] dp =new int [A+1];
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE-1;
            for(int c=0;c<coins.length;c++) {
                if (i >= coins[c]){
                    if(dp[i-coins[c]]<dp[i]){
                        dp[i] = dp[i-coins[c]];
                    }
                }
            }
            dp[i] +=1;
        }
        for(int i=0;i<dp.length;i++){
            System.out.println(i+" --> "+dp[i]);
        }
        return dp[A];
    }
}
