package recursion;

public class Permutation {
    public static void main(String[] args){
        int[] x = {1,2,3};
        permutation(x,0);
    }
    public static void permutation(int[] arr,int i){
        //Base Case
        if(i==arr.length){
            for(int k=0;k<arr.length;k++){
                System.out.print(arr[k]+"   ");
            }
            System.out.println();
        }
        for(int j=i;j<arr.length;j++){
            swap(arr,i,j);
            permutation(arr,i+1);
            swap(arr,i,j);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
