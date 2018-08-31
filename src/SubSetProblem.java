public class SubSetProblem {
    public static void subsetMani(int[] arr){
        int[] subarr = new int[arr.length];
        subSet(arr,subarr,0,0);
    }
    public static void subSet(int[] arr,int[] subarr,int i,int j){
        if(i>=arr.length){
            System.out.println();
            System.out.print("{");
            for(int k=0;k<j;k++){
                System.out.print(subarr[k]);
                if(k<j-1){
                    System.out.print(",");
                }
            }
            System.out.print("}");
            return;
        }
        subSet(arr,subarr,i+1,j);
        subarr[j] = arr[i];
        subSet(arr,subarr,i+1,j+1);
    }
    public static void main(String args[]){
        int[] arr ={1,2,3};
        subsetMani(arr);
    }
}
