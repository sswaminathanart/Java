import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Adc2Sum {
    public static void main(String args[]){
        int[] arr ={3,4,5,4};
        int k = 8;
        sumtok(arr,k);
        System.out.println("Second Method");
        sumtok2(arr,k);
    }
    public static void sumtok(int[] arr,int k){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains((k-arr[i])))
                System.out.println("Sum to "+k+"  "+arr[i]+"   "+(k-arr[i]));
            set.add(arr[i]);
        }
    }
    public static void sumtok2(int[] arr,int k){
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            if(arr[start]+arr[end]==k){
                System.out.println("Sum to "+k+"  "+arr[start]+"   "+(arr[end]));
                start++;
                end--;
            }
            else if (arr[start]+arr[end]>k){
                end--;
            }
            else if(arr[start]+arr[end]<k){
                start++;
            }
        }
    }
}
