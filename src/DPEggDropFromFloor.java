public class DPEggDropFromFloor {
    public static void main(String args[]){
        int minatt=minattempt(3,100);
        System.out.println("Min Attempt to know 3 eggs to break from 100 floors "+minatt);
    }
    public static int minattempt(int eggs,int floors){
        int[][] dpTable = new int[eggs+1][floors+1];
        int count =0;
        for(int i=0;i<=floors;i++){
            dpTable[1][i] = i;
        }
        for(int e=2;e<=eggs;e++){
            for(int f=1;f<=floors;f++){
                dpTable[e][f] = Integer.MAX_VALUE;
                for(int k=1;k<=f;k++) {
                    count = 1 + Math.max(dpTable[e-1][k-1],dpTable[e][f-k]);
                    if(count <dpTable[e][f]) dpTable[e][f] = count;
                }
            }
        }
        return dpTable[eggs][floors];
    }
}
