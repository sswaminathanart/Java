package dynamicprograming;

public class DPProductionPlan {
    static int[] APlan = {5,2,11,9,10};
    static int[] BPlan = {10,4,6,10,19};
    static int time =5;
    public static void main(String args[]){
        String res = dutch_flag_sort("GBGGRBRG");
        System.out.println(res);
        int maxproduct = dpProductionPlan();
        System.out.println("Max Product "+maxproduct);
    }
    public static int dpProductionPlan(){
        int[] ADpTable = new int[time+1];
        int[] BDpTable = new int[time+1];

        ADpTable[0] = APlan[0];
        BDpTable[0] = BPlan[0];
        ADpTable[1] = APlan[0] + APlan[1];
        BDpTable[1] = BPlan[0] + BPlan[1];
        for(int t=2;t<time;t++){
            ADpTable[t] = Integer.max(ADpTable[t-1]+APlan[t],
                    BDpTable[t-2]+APlan[t]);
            BDpTable[t]= Integer.max(BDpTable[t-1]+BPlan[t],
                    ADpTable[t-2]+BPlan[t]);
        }
        trackback(ADpTable,BDpTable);
        return Integer.max(ADpTable[time-1],BDpTable[time-1]);
    }
    public static boolean isAtA(int aValue,int bValue,int idx){
        return Integer.max(aValue,bValue)==APlan[idx];
    }
    public static void trackback(int[] ADpTable,int[] BDpTable){


    }
    static void swap(char[] charr,int i,int j){
        char temp = charr[i];
        charr[i] = charr[j];
        charr[j] = temp;

    }

    static String dutchNatFlag(String arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length() - 1;
        char[] charballs = arr.toCharArray();
        // one pass through the array swapping
        // the necessary elements in place
        while (mid <= high) {
            if      (charballs[mid] == 'R') { swap(charballs, low++, mid++); }
            else if (charballs[mid] == 'B') { swap(charballs, mid, high--); }
            else if (charballs[mid] == 'G') { mid++; }
        }

        return new String(charballs);

    }
    static String dutch_flag_sort(String balls) {
        char[] charballs = balls.toCharArray();
        int start = 0;
        int mid = 0;
        int end = charballs.length-1;
        while (mid<=end){
            if(charballs[mid] =='R'){
                swap(charballs,start++,mid++);
            }
            else if(charballs[mid]=='G'){
                mid++;
            }
            else if(charballs[mid]=='B'){
                swap(charballs,mid,end--);
            }
        }
        return new String(charballs);
    }
}

