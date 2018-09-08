package recursion;

public class SubSet {
    public static void main(String args[]){
        int[] x = {1,2,3};
        int[] subsetx = new int[x.length];
        subset(x,subsetx,0,0);
    }
    public static void subset(int[] arr,int[] subarr,int i,int j){
        //Base Case
        if(i==arr.length){
            for(int k=0;k<j;k++){
                System.out.print(subarr[k]);
            }
            System.out.println();
            return;
        }
        subset(arr,subarr,i+1,j);
        subarr[j] = arr[i];
        subset(arr,subarr,i+1,j+1);
    }
}
