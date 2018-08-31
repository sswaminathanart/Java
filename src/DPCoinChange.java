import java.util.HashMap;
import java.util.Map;

public class DPCoinChange {
    static int[] coins ={2,3,5};
    static int A =10;
    public static void main(String args[]){
        Map<Integer,Integer> map = new HashMap<>();
        int noOfCoin =minCoinChange(A,map);
       // System.out.println(noOfCoin);
       noOfCoin = minimumCoinBottomUp(A,coins);
        System.out.println("\n"+noOfCoin);
        noOfCoin = mincooo();
        System.out.println("\n"+noOfCoin);
    }
    public static int mincooo(){
        int[] dp =new int [A+1];
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int c=0;c<coins.length;c++) {
                if (i >= coins[c]){
                    if(dp[i-coins[c]]<dp[i]){
                        dp[i] = dp[i-coins[c]];
                    }
                }
            }
            dp[i] +=1;
        }
        return dp[A];
    }
    public static int minimumCoinLessMemory(){
        int[] dpTable = new int[6];
        for(int i=0;i<dpTable.length;i++){
            dpTable[i] = Integer.MAX_VALUE-1;
            for(int c=0;c<coins.length;c++){
                if(i>=coins[c]){
                     dpTable[i] =Integer.min(dpTable[i],dpTable[(i-coins[c])]+1);

                }

            }
            //System.out.print(" "+ +"--->"+dpTable[a%6]);
        }
        return dpTable[A];
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
    public static int minimumCoinBottomUp(int amount,int[] coins){
        int[] dpTable = new int[amount+1];
        int[] backtrack = new int[amount+1];
        for(int i=0;i<dpTable.length;i++){
            dpTable[i] = Integer.MAX_VALUE-1;
            backtrack[i] = -1;
        }
        dpTable[0] = 0;
        //System.out.print(" "+0 +"--->"+dpTable[0]);
        for(int a=1;a<dpTable.length;a++){
            for(int c=0;c<coins.length;c++){
                if(a >=coins[c]){
                    dpTable[a] = Integer.min(dpTable[a],(dpTable[a-coins[c]]+1));
                    backtrack[a] = c;
                }
            }//System.out.print(" "+a +"--->"+dpTable[a]);

        }
        printCoinCombination(backtrack,coins);
        return dpTable[amount];
    }

    private static void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        for(int s=0;s<R.length;s++)
        {
            System.out.println("Latest "+s +"  "+R[s]);
        }
        int start = R.length - 1;
        System.out.print("\n Coins used to form total ");
        while ( start != 0 ) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
        for(int i=0;i<R.length/2;i++){
            System.out.println(coins[i]+","+coins[coins.length-1-i]);
        }
    }



   /* public static int minimumCoinBottomUp(int total, int coins[]){
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }

            for(int amt=1; amt <= total; amt++){
                for(int c=0; c < coins.length; c++){
                if(amt >= coins[c]){
                        T[amt] = Integer.min(1 + T[amt - coins[c]],T[amt]);
                        R[amt] = c;
                }
            }
        }
        for(int i=0;i<T.length;i++)
        System.out.println(T[i]);
        printCoinCombination(R, coins);
        return T[total];
    }
    private static void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        System.out.print("Coins used to form total ");
        while ( start != 0 ) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }
    public static int minCoinChange(int amout,Map<Integer,Integer> map){
        if(amout<0) return Integer.MAX_VALUE;
        if(amout==0) return 0;
        if(map.containsKey(amout)){
            return map.get(amout);
        }
        int min = Integer.MAX_VALUE-1;
        for(int i=0;i<coins.length;i++) {
            min = Integer.min(minCoinChange(amout-coins[i],map),min);
        }
        map.put(amout,min+1);
        if(min == Integer.MAX_VALUE) return min;
        return 1+min;
    }*/
}
