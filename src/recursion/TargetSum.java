package recursion;

public class TargetSum {
    public static void main(String[] args){
        int[] arr = {2,4,8};
        int k = 6;
        boolean res =check_if_sum_possible(arr,k);
        System.out.println(res);

    }
    public static boolean check_if_sum_possible(int[] arr,int target){
        boolean atleast_one_included = false;
        return helper(arr,target,0,atleast_one_included);
    }
    public static boolean helper(int[] arr,int target,int i,boolean atleast_one_included){
        //base case
        if(i>= arr.length){
            return (target==0 && atleast_one_included);
        }
        if(helper(arr,target-arr[i],i+1,true))
            return true;
        return helper(arr,target,i+1,atleast_one_included);
    }
}
