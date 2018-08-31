public class LinkedListReverseGroupsOfk {
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
    static node reverse_linked_list_in_groups_of_k(node h, int k) {
        if(h==null || h.next ==null)return h;
        node p = null;
        node c = h;
        node n = null;
        int count =0;
        while (count<k && c !=null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
            count++;
        }
        if(n != null)
        h.next = reverse_linked_list_in_groups_of_k(n,k);
        return p;
    }
    public static void main(String[] args)
    {

        LinkedListReverseGroupsOfk li = new LinkedListReverseGroupsOfk();
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
        li.head = li.reverse_linked_list_in_groups_of_k(li.head,3);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.head);
    }
}
