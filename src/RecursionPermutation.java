public class RecursionPermutation {
    public static void main(String args[]) {
        int[] arr = {1,2,3};
        permutation(arr);
    }
    public static void permutation(int[] arr){
        permutationutil(arr,0);
    }
    public static void permutationutil(int[] arr,int i){
        if(i== arr.length){
            for(int k=0;k<arr.length;k++){
                System.out.print(arr[k]);
            }
            System.out.println();
        }
        for(int l=i;l<arr.length;l++){
            swap(arr,i,l);
            permutationutil(arr,i+1);
            swap(arr,i,l);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
