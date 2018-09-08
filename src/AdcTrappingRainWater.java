public class AdcTrappingRainWater {
    public static void main(String args[]){
        int[] x ={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Rain Water Saved ... "+trappingRainWater(x));
    }
    public static int trappingRainWater(int[] A){
        if (A == null || A.length == 0) return 0;
        int res = 0;
        int start = 0;
        int end = A.length - 1;
        int height = Math.min(A[start], A[end]);
        //Start end records to the right and the left most position
        //Height records the current height, each one, update the largest amount of water.
        while (start <end) {
            if (A[start] <A[end]) {
                res += Math.max(height - A[start+1], 0);
                height = Math.max(height, Math.min(A[start+1], A[end]));
                ++start;
            }
            else {
                res += Math.max(height - A[end-1], 0);
                height = Math.max(height, Math.min(A[start], A[end-1]));
                --end;
            }

        }
        return res;
    }
}
