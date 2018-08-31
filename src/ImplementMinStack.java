import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ImplementMinStack {
    static Node head =null;

    public static void main(String args[]) {
        int[] x={1,
                2,
                3,
                4,
                5,
                0,
                        -1,
                0,
                        -1,
                0,
                        -1,
                0,
                        -1,
                0,
                        -1,
                0,
                        -1};
      int[] result =min_stack(x);
      for(int i=0;i<result.length;i++){
          System.out.print(result[i]+"    ");
      }
    }
    static int[] min_stack(int[] operations) {
        List<Integer> result = new ArrayList<>();
        ImplementMinStack minStack = new ImplementMinStack();

        for(int i=0;i<operations.length;i++){
            if(operations[i]==0){
                if(minStack.isEmpty(head)) result.add(-1);
                else result.add(minStack.getMin());
            }
            else if(operations[i]==-1){
                minStack.pop();
            }
            else {
                minStack.push(operations[i]);
            }
        }
        int[] intoutput = new int[result.size()];
        int j=0;
        for(Integer i : result){
            intoutput[j] =i;
            j++;
        }
        return intoutput;
    }
    class Node {
        int val;
        int min;
        Node next;

        Node(int v, int m) {
            val = v;
            min = m;
        }
    }
        void push(int val) {
            if(head == null){
                head = new Node(val,val);
            }
            else {
                Node temp = new Node(val,Math.min(val,head.min));
                temp.next = head;
                head = temp;
            }

        }

        int getMin() {
            return head.min;
        }

        int pop() {
        if(head == null) return 0;
        if(head != null && head.next ==null) {
            int v = head.val;
            head = null;
            return v;

        }
        else if(head.next != null){
            Node temp = head.next;
            int v = head.val;
            head.next = null;
            head = temp;
            return v;
        }
        else return 0;

        }

        int peek() {
            return head.val;
        }

        boolean isEmpty(Node h) {
            if (h == null) return true;
            else return false;
        }
    }


