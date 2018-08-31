import java.util.Deque;
import java.util.LinkedList;

public class SlackMaxSlidingWindow {
    public static void main(String args[]){
        int x[] = {1,3,-1,-3,5,3,6,7};
        int w = 3;
        int ans[] = maxSlidingWindow(x,w);
        for(int i: ans){
            System.out.print(i+"   ");
        }
    }
    static int[] maxSlidingWindow(int[] x,int w){
        int winSize = x.length-w+1;
        int[] ret = new int[winSize];
        Deque<Integer> deque = new LinkedList<>();
        int i=0;
        for(i=0;i<w;i++){
            if (!deque.isEmpty() && x[i]>=x[deque.peekLast()]){
                deque.removeLast();
            }
            ((LinkedList<Integer>) deque).add(i);
        }
        for(;i<x.length;i++){
            ret[i-w] = x[deque.peek()];
            if (!deque.isEmpty() && deque.peek()<=i-w) deque.remove();
            while (!deque.isEmpty() && x[i]>=x[deque.peekLast()]){
                deque.removeLast();
            }
            ((LinkedList<Integer>) deque).add(i);
        }
        ret[winSize-1] = x[deque.peek()];
        return ret;
    }
}
