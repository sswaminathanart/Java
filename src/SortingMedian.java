import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortingMedian {
    private Queue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder());
    private Queue<Integer> high = new PriorityQueue<>();

    public void add(int number) {
        Queue<Integer> target = low.size() <= high.size() ? low : high;
        target.add(number);
        balance();
    }

    private void balance() {
        while(!low.isEmpty() && !high.isEmpty() && low.peek() > high.peek()) {
            Integer lowHead= low.poll();
            Integer highHead = high.poll();
            low.add(highHead);
            high.add(lowHead);
        }
    }

    public double median() {
        if(low.isEmpty() && high.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        } else {
            return low.size() == high.size() ? (low.peek() + high.peek()) / 2.0 : low.peek();
        }
    }
    public static void main(String[] args) {
        SortingMedian sm = new SortingMedian();
        int[] a ={1,2,3,4,5,6,7,8,9,10};
        for(int i=0;i<a.length;i++){
            sm.add(a[i]);
            System.out.println(sm.median());
        }

    }

    }