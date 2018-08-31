import java.lang.reflect.Array;

class MergeSort{
    public static void main(String args[]){
        int x[] =new int[10];
        for(int i=0;i<x.length;i++){
            x[i] = (int)(Math.random()*10)+10;
        }
        MergeSort(x);
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
    }
    static void MergeSort(int[] intArr){
        int[] auxArr = intArr.clone();
        mergeSort(intArr,0,intArr.length-1,auxArr);
    }
    static void mergeSort(int[]intArr,int start,int end,int[] auxArr){
        if(start>= end) return;
        int mid = start +(end-start)/2;
        mergeSort(auxArr,start,mid,intArr);
        mergeSort(auxArr,mid+1,end,intArr);
        merge(intArr,start,mid,end,auxArr);

    }
    static void merge(int[] arr,int start,int mid,int end,int[] aux){
        int i = start, j = mid + 1, k = start;
        while (i <= mid || j <= end) {
            if (i > mid) {
                arr[k++] = aux[j++];
            } else if (j > end) {
                arr[k++] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
            }
        }
    }
    /*
    static int[] MergeSort(int[] intArr) {
        mergeSort(intArr,0,intArr.length-1);
        return intArr;
    }
    static void mergeSort(int[] intArr,int start,int end){
        if(start>= end) return;
        int mid = start +(end-start)/2;
        mergeSort(intArr,start,mid);
        mergeSort(intArr,mid+1,end);
        merge(intArr,start,mid,end);
    }
    static void merge(int[] intArr,int start,int mid,int end){
        int leftlen = mid-start+1;
        int rightlen = end-mid;
        int[] left = new int[leftlen];
        int[] right = new int[rightlen];
        for(int i=0;i<leftlen;i++){
            left[i] = intArr[start+i];
        }
        for(int i=0;i<rightlen;i++){
            right[i] = intArr[mid+i+1];
        }
        int i=0;
        int j=0;
        int k=start;
        while (i<leftlen && j<rightlen){
            if(left[i]<=right[j]){
                intArr[k] = left[i];
                i++;
            }
            else {
                intArr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i<leftlen){
            intArr[k] = left[i];
            i++;
            k++;
        }
        while (j<rightlen){
            intArr[k] = right[j];
            j++;
            k++;
        }
    }*/

}