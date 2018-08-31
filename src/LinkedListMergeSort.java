public class LinkedListMergeSort {
    static node head =null;
 class node{
    int val;
    node next;
    node(int d){
        val =d;
        next =null;
    }
}
     void printList(node headref)
    {
        while (headref != null)
        {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }
     void push(int new_data)
    {
        /* allocate node */
        node new_node = new node(new_data);

        /* link the old list off the new node */
        new_node.next = head;

        /* move the head to point to the new node */
        head = new_node;
    }
    node mergeSort(node h){
        if(h == null || h.next == null) return h;
     node mid =getMiddle(h);
     node nexttoMid = mid.next;
     mid.next =null;
     node left = mergeSort(h);
     node right = mergeSort(nexttoMid);
     return sortedMerge(left,right);
   //  return sorted;
    }
    node sortedMerge(node left,node right){
     node result;
     if(left == null) return right;
     if(right == null) return left;
     if(left.val<=right.val){
         result = left;
         result.next=sortedMerge(left.next,right);
     }
     else {
         result = right;
         result.next = sortedMerge(left,right.next);

     }
     return result;
    }
    node getMiddle(node h){
     if(h == null || h.next == null) return h;
     node fast = h.next;
     node slow = h;
     while(fast.next != null){
         fast = fast.next;
         slow = slow.next;
         if(fast.next != null) fast = fast.next;
     }
     return slow;
    }
    public static void main(String[] args)
    {

        LinkedListMergeSort li = new LinkedListMergeSort();
        /*
         * Let us create a unsorted linked lists to test the functions Created
         * lists shall be a: 2->3->20->5->10->15
         */
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);
        System.out.println("Linked List without sorting is :");
        li.printList(li.head);

        // Apply merge Sort
        li.head = li.mergeSort(li.head);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.head);
    }
}
