public class AdcMaxSumSubArrayKadane {
    public static void main(String args[]){
        int[] x ={3,5,2,1,-12,4,5,3};
        int maxSum = kadanesalgo(x);
        System.out.println(maxSum);
    }
    public static int kadanesalgo(int[] arr){
        int max_sum_so_for = 0;
        int start=-1,end=-1,s=-1;
        int max_sum_ending_here = 0;
        if(arr.length>0) s =0;
        for(int i=0;i<arr.length;i++){
            max_sum_ending_here += arr[i];
            if(max_sum_ending_here>max_sum_so_for){
                max_sum_so_for = max_sum_ending_here;
                end = i;
                start =s;
            }
            if(max_sum_ending_here<0){
                max_sum_ending_here =0;
                s = i+1;
            }
        }
        System.out.println("Start "+(start+1) + " "+ (end+1));
        return max_sum_so_for;
    }

}
