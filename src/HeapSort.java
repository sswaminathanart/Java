import java.util.Map;

public class HeapSort {
    public static void main(String args[]){
        int[] x = new int[5];
        for(int i=0;i<x.length;i++){
            x[i] = (int)(Math.random() * 100) + 10;
        }
        for(int i=0;i<x.length;i++){
            System.out.print(x[i]+" ");
        }
        heapSort(x);
        System.out.println("\n ");
        for(int i=0;i<x.length;i++){
            System.out.print(x[i]+" ");
        }

    }
    static void swap(int[] x,int i,int j){
        int temp = x[i];
        x[i] = x[j];
        x[j] =  temp;
    }
    static void heapSort(int[] x){
        int n = x.length;
        for(int i= n/2-1;i>=0;i--){
            heapify(x,i,n);
        }
        for(int i=n-1;i>=0;i--){
            swap(x,0,i);
            heapify(x,0,i);
        }

    }
    static void heapify(int[] x,int i,int n){
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if(left < n &&  x[left] > x[largest]) largest = left;
        if(right < n && x[right] > x[largest]) largest= right;
        if(largest != i) {swap(x,i,largest); heapify(x,largest,n);};
    }
}
