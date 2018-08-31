public class AdcArrayproduct {
    static int[] getProductArray(int[] nums) {
        long product =1;
        long nonzeroproduct =1;
        int firstzero =0;
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            product *= nums[i];
            if(nums[i] != 0 ){
                nonzeroproduct *= nums[i];
            }
            else if(nums[i] == 0 && firstzero ==1){
                nonzeroproduct = 0;
            }
            else {
                firstzero =1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                result[i] =(int) (product/nums[i]);
            if(nums[i] ==0 && product == 0 ) result[i] =(int) nonzeroproduct;
        }
        return result;

    }
    public static void main(String args[]){
        int[] x={1,
                2,
                0,
                3,
                5};
        int[] result =getProductArray(x);
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }

}
