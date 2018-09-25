package Sorting;

class QuickSort {
    public static void main(String args[]){
        int SIZE = 5;
        int[] x = {6,3,5,7,1};
        quickSort(x,0,x.length-1);
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
    }
    public static void swap(int[] x,int i,int j){
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
    public static void quickSort(int[] arr,int start,int end){

        if(start >= end) return;
        int pivot = choosePivot(start,end);
        int p = partition(arr,start,end,pivot);
        quickSort(arr,start,p-1);
        quickSort(arr,p+1,end);
    }
    public static int choosePivot(int start,int end){
        int pivot = start;
        return pivot;
    }
    public static int partition(int[] arr,int start,int end,int pivot){
        swap(arr,pivot,end);
        int i = start;
        for(int curr = start;curr<end;curr++){
            if(arr[curr]<arr[end]){
                swap(arr,curr,i);
                i++;
            }
        }
        swap(arr,i,end);
        return i;
    }
}