public class LinkedListReverse {
    static node head =null;
    class node{
        int val;
        node next;
        node(int d){
            val =d;
            next =null;
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
    void printList(node headref)
    {
        while (headref != null)
        {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }
    node reverse(node h){
        if(h == null || h.next == null) return h;
        node pre = null;
        node curr = h;
        node nxt = null;
        while (curr != null){
            nxt = curr.next;
            curr.next = pre;
            pre = curr;
            curr =nxt;
        }
        return pre;

    }
    static node reverse_given_linked_list(node h){
        if(h == null || h.next == null) return h;
        node reverse = reverse_given_linked_list(h.next);
        h.next.next = h;
        h.next = null;
        return reverse;
        //return head;

    }
    public static void main(String[] args)
    {

        LinkedListReverse li = new LinkedListReverse();
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
        li.head = li.reverse_given_linked_list(li.head);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.head);
    }
}
