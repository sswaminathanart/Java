public class AdcMaxSumSubArray {
    class MaxSum{
        int startIdx;
        int endIdx;
        int maxSum;
        MaxSum(int s,int e,int sum){
            startIdx = s;
            endIdx = e;
            maxSum = sum;
        }
    }
    public static void main(String args[]){
        int[] arr={34,23,56,21};
        int maxsum = maxSumSubArray(arr);
        System.out.println("Max Sum is "+ maxsum);
        maxsum = maxSumSubArray1(arr);
        System.out.println("Max Sum is "+ maxsum);
        maxsum=divideAndConquer(arr,0,arr.length-1);
        System.out.println("Max Sum is "+ maxsum);
        maxsum=kadanesalgo(arr);
        System.out.println("Max Sum is "+ maxsum);
    }
    static int maxSumSubArray(int[] arr){
        int maxSum=0;
        for(int start=0;start<arr.length;start++){
            for(int end=start;end<arr.length;end++){
                int sum=0;
                for(int i=start;i<=end;i++){
                    sum += arr[i];
                }
                if(sum>maxSum){
                    maxSum = sum;
                }
            }
        }return maxSum;
    }
    static int maxSumSubArray1(int[] arr){
        int maxSum=0;
        for(int start=0;start<arr.length;start++){
            int sum =0;
            for(int end=start;end<arr.length;end++){
                    sum += arr[end];
                }
                if(sum>maxSum){
                    maxSum = sum;
                }
        }return maxSum;
    }

    static int crossingMid(int[] arr,int start,int mid,int end){
        int leftSum = Integer.MIN_VALUE;
        int sum =0;
        for(int i=start;i<=mid;i++){
            sum +=arr[i];
            if(leftSum<sum){
                leftSum = sum;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for(int i= mid+1;i<=end;i++){
            sum += arr[i];
            if(rightSum<sum){
                rightSum = sum;
            }
        }
        return leftSum+rightSum;

    }
    static int maxCrossingSum(int arr[], int l,
                              int m, int h)
    {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--)
        {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++)
        {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        // Return sum of elements on left
        // and right of mid
        return left_sum + right_sum;
    }

    // Returns sum of maxium sum subarray
    // in aa[l..h]
    static int maxSubArraySum(int arr[], int l,
                              int h)
    {
        // Base Case: Only one element
        if (l == h)
            return arr[l];

        // Find middle point
        int m = (l + h)/2;

    /* Return maximum of following three
    possible cases:
    a) Maximum subarray sum in left half
    b) Maximum subarray sum in right half
    c) Maximum subarray sum such that the
    subarray crosses the midpoint */
        return Math.max(Math.max(maxSubArraySum(arr, l, m),
                                 maxSubArraySum(arr, m+1, h)),
                maxCrossingSum(arr, l, m, h));
    }
    static int divideAndConquer(int[] arr,int start,int end){
        if(start== end) return arr[start];
        int mid = start +(end-start)/2;
        return Math.max(
                Math.max(divideAndConquer(arr,start,mid),
                        divideAndConquer(arr,mid+1,end)),
                crossingMid(arr,start,mid,end));

    }
    public static int kadanesalgo(int[] arr){
        int max_sum_so_for = 0;
        int max_sum_ending_here = 0;
        for(int i=0;i<arr.length;i++){
            max_sum_ending_here += arr[i];
            if(max_sum_ending_here>max_sum_so_for){
                max_sum_so_for = max_sum_ending_here;
            }
            if(max_sum_ending_here<0){
                max_sum_ending_here =0;
            }
        }
        return max_sum_so_for;
    }
}
