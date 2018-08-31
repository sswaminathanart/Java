public class RecursionSubSet {
    public static void main(String args[]){
        int[] arr ={1,2,3};
        subSet(arr);
    }
    public static void subSet(int[] arr){
        int[] subArr = new int[arr.length];
        subSetUtil(arr,subArr,0,0);
    }
    public static void subSetUtil(int[] arr,int[] subArr,int i,int j){
        //BaseCase
        if(i==arr.length){
            System.out.print("{");
            for(int k=0;k<j;k++){
                System.out.print(subArr[k]);
            }
            System.out.print("}\n");
            return;
        }
        subSetUtil(arr,subArr,i+1,j);//without i
        subArr[j] = arr[i];
        subSetUtil(arr,subArr,i+1,j+1);
    }
}
