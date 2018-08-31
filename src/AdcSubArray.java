public class AdcSubArray {
    public static void main(String args[]){
        int[] arr = {1,2,3,4};
        System.out.println("All Sub Arrays");
        for(int start=0;start<arr.length;start++){
            for(int end=start;end<arr.length;end++){
                System.out.println();
                for(int i=start;i<end;i++) {
                    System.out.print(arr[i]);
                }
            }
        }
    }
}
