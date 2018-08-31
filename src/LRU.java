import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class LRU {
    private static class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
        public void setValue(int value){
            this.value=value;
        }
    }
    private static HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
    static Node head = null;
    static Node tail = null;

    static Node deleteNode( int key) {
        if(head == null) return head;
        //if(head ==head.next) head=head.next;
        if(head.key==key){
            if(head.next != null){
                head.next.prev =null;
                head = head.next;
            }
            return head;
        }
        Node node = head;
        while (node !=null){
            if(node.key == key){
                break;
            }
            node =node.next;
        }
        if(node == null)return head;
        if(node.next != null) node.next.prev = node.prev;
            node.prev.next = node.next;
     return  head;
    }

    /* UTILITY FUNCTIONS */
    /* Function to insert a node at the beginning of the Doubly Linked List */
    static void push(int new_key,int new_data) {

        /* allocate node */
        Node new_node = new Node(new_key,new_data);

        /* since we are adding at the begining,
         prev is always NULL */
        new_node.prev = null;

        /* link the old list off the new node */
        new_node.next = (head);

        /* change prev of head node to new node */
        if ((head) != null) {
            (head).prev = new_node;
        }

        /* move the head to point to the new node */
        (head) = new_node;
        if((head) !=null && head.next == null)
            tail=head;

    }
    public static int[] implement_LRU_cache(int c,int[] querytye,int[] key,int[] val){
        int capacity=c;
        int size =0;
        ArrayList<Integer> lruList = new ArrayList<>();
        int[] lru = new int[size];
        for(int i=0,j=0;i<querytye.length;i++){
            if(querytye[i]== 1){
                set(head,key[i],val[i],capacity);
            }
            else{
                lruList.add(get(head,key[i],val[i],c));
                j++;

            }
        }
        int[] x={1,2};
        return x;
       // return (int[])lruList.toArray(int[lruList.size()]);
    }
    public static Node evict(int c){
        Node n=head;
        Node n1=head;
        System.out.println("\nSIZE "+hm.size());
        if (c ==1 && n != null && hm.size() != 1) {
            if(n.next != null) {
                System.out.print("\nRemoved " +n.key);
                hm.remove(n.next.key);
            }
            n.next = null;
        }

        System.out.println("\n Tail "+ tail.key);

        System.out.println("\n Node");
        while (n.next!=null && c >0){
            System.out.print( n.key +" ");
            n=n.next;
            c--;
        }
        if(n.prev !=null && c==0 ) {
            n.prev.next=null;
            hm.remove(n.key);
            System.out.print("\nRemoved " +n.key );
        }
        System.out.print("\nLast :"+n.key+"    "+n.value+" cap "+ c);
        return head;
    }
    public static void set(Node root,int key, int value,int capacity) {
        boolean keyExist = hm.containsKey(key);
        Node valNode = new Node(key,value);
        if(keyExist){
            deleteNode(key);
        }
        hm.put(key,valNode);
        push(key,value);
        evict(capacity);
    }
    public static int get(Node root,int key,int value,int capacity) {
        if (!hm.containsKey(key)) {return -1;
        }
        Node current = hm.get(key);
        deleteNode(key);
        push(key,current.value);
        evict(capacity);
        return (!hm.containsKey(key))?-1:hm.get(key).value;
    }

    public static void main(String args[]){
        int capacity = 3;
        int[] querytype =  {1
                ,1
                ,0
                ,1
                ,1
                ,0
                ,1
                ,0
                ,1
                ,0
};
        int[] key =        {5//1
                ,4//1
                ,1//0
                ,2//1
                ,2//1
                ,2//0
                ,3//1
                ,2//0
                ,5//1
                ,4//0
};
        int[] val =        {5
                ,3
                ,4
                ,4
                ,1
                ,4
                ,5
                ,1
                ,2
                ,1
        };
        int lru[] = implement_LRU_cache(capacity, querytype, key, val);
        for(int i=0;i<lru.length;i++){
            System.out.print("\nLRU "+lru[i]+"    ");
        }
    }
}
