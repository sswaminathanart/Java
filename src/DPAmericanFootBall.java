public class DPAmericanFootBall {
    static  final int SCORE = 8;
    static int[] w ={2,3,6};
    public static void main(String args[]){
        int noWays=makeChange(w,SCORE);
        System.out.println("\nNo of ways "+noWays);
        noWays =dpNumberOfWaysSaveMemory();
        System.out.println("\nNo of ways "+noWays);
    }
    public static int dpNumberOfWaysSaveMemory(){
        int[] dpTable = new int[7];
        dpTable[0] = 1;
        System.out.print(" "+0 +"--->"+dpTable[0]);
        for(int s=1;s<=SCORE;s++){
            dpTable[s%7] =
                    (s >= 2 ? dpTable[ (s-2+7)%7]:0) +
                    (s >= 3 ? dpTable[ (s-3+7)%7]:0) +
                    (s >= 6 ? dpTable[ (s-6+7)%7]:0);
            System.out.print(" "+s +"--->"+dpTable[s%7]);
        }

        return dpTable[SCORE%7];
    }
   public static int makeChange(int[] coins, int money) {
       int[] DP = new int[money + 1]; // O(N) space.
       DP[0] = 1; 	// n == 0 case.
       for(int coin : coins) {
           for(int j = coin; j < DP.length; j++) {
               // The only tricky step.
               DP[j] += DP[j - coin];
           }
       }
       return DP[money];
   }
    public static int dpNumberOfWays(){
        int[] dpTable = new int[SCORE+1];
        for(int i=0;i<dpTable.length;i++){
            dpTable[i] = 0;
        }
        dpTable[0] = 1;
        for(int s=1;s<dpTable.length;s++){
            for(int i=0;i<w.length;i++){
                if(s>=w[i]){
                    dpTable[s] += dpTable[(s-w[i])];
                }
            }
            //dpTable[s] = ( s>=2 ? dpTable[s-2] : 0 )+ (s>=4 ? dpTable[s-4] : 0 )+ (s>=6 ? dpTable[s-6] : 0);
        }
        for(int i=0;i<dpTable.length;i++) {
            System.out.print(" "+i +"--->"+dpTable[i]);
        }
        return dpTable[SCORE];
    }
}
