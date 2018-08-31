public class SumSum {
    static boolean check_if_sum_possible(long[] arr, long k) {
        if(arr.length==0) return false;
        return groupSum(0,arr,k,false);
    }
    public static boolean groupSum(int start, long[] nums, long target,boolean at_lest_one_included) {
        if(start>=nums.length) return (target==0 && at_lest_one_included);
        if(groupSum(start+1,nums,target-nums[start],true))
            return true;
        return groupSum(start+1,nums,target,at_lest_one_included);
    }


    public static void main(String args[]){
        long[] arr ={1,1};
        long k = 0;
        if(check_if_sum_possible(arr,k)){
            System.out.println("Possible");
        }
        else {
            System.out.println("Not Possible");
        }

    }
}
