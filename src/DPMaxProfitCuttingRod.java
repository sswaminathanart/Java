public class DPMaxProfitCuttingRod {
    static final int lenghtOfRod = 8;
    static int[] profit = {2,5,8,9};
    public static void main(String args[]){
        int profits = maxProfit();
        System.out.println("\nDP Max Prifit" + profits);
        profits = maxProfitRecursion(profit.length);
        System.out.println("\nRecursion Max Prifit" + profits);
       profits = recursiveMaxValue(profit,profit.length);
        System.out.println("\nRecursion Max Prifit" + profits);
    }
    public static int maxProfit() {
        int[] dpTable = new int[lenghtOfRod + 1];
        dpTable[0] = 0;
        for (int i = 1; i < profit.length; i++) {
            dpTable[i] = profit[i - 1];
        }
        for (int i = 1; i <= lenghtOfRod; i++) {
            for (int j = 0; j < i; j++) {
                dpTable[i] = Integer.max(dpTable[i],
                        dpTable[i - j] + dpTable[j]);
            }
        }
        return dpTable[lenghtOfRod];
    }
    public static int maxProfitRecursion(int lenghtOfRod){
        if(lenghtOfRod <= 0) return 0;
        int maxProfit = 0;
        for(int p=0;p<profit.length;p++){
            maxProfit =  Integer.max(maxProfit,(maxProfitRecursion(lenghtOfRod-p-1)+profit[p]) );
        }
        return maxProfit;
    }
    public static int recursiveMaxValue(int price[],int len){
        if(len <= 0){
            return 0;
        }
        int maxValue = 0;
        for(int i=0; i < len;i++){
            int val = price[i] + recursiveMaxValue(price, len-i-1);
            if(maxValue < val){
                maxValue = val;
            }
        }
        return maxValue;
    }
}
