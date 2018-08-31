import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    public static int[] slidingwin(int[] arr,int w){
        int warrSize = arr.length - (w-1);
        int[] warr = new int[warrSize];
        Deque<Integer> de = new LinkedList<>();
        int i=0;
        for(;i<w;i++){
            while (!de.isEmpty()&& arr[i]>=arr[de.peekLast()]) de.removeLast();
            de.add(i);
        }
        for(;i<arr.length;i++){
            warr[i-w]=arr[de.peek()];
            while (!de.isEmpty() && de.peek() <= i-w) de.remove();
            while (!de.isEmpty() && arr[i]>=arr[de.peekLast()]) de.removeLast();
            de.add(i);
        }
        warr[i-w] = arr[de.peek()];
        return warr;
    }
    public static void main(String args[]){
        int arr[]={1,3,-1,-3,5,3,6,7};
        int warr[] =slidingwin(arr,3);
        for(int i=0;i<warr.length;i++)
            System.out.print(warr[i]+"    ");
    }
}
