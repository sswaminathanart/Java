public class Permutation {
    public static void permMain(int[] arr){
        perm(arr,0);
    }
    public static void perm(int[] arr,int i){
        if(i==arr.length){
            for(int k=0;k<arr.length;k++){
                System.out.print(arr[k]);
            }
            System.out.println();
        }
        for(int j=i;j<arr.length;j++){
            swap(arr,i,j);
            perm(arr,i+1);
            swap(arr,i,j);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String args[]){
        int[] arr ={1,2,3};
        permMain(arr);
    }
}
