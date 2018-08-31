public class LinkedListFlatten {
    Node head =null;
    class Node{
        int data;
        Node right;
        Node down;

        Node(int d){
            data = d;
            right = null;
            down = null;
        }
    }
    Node push(Node head_ref, int data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(data);

        /* 3. Make next of new Node as head */
        new_node.down = head_ref;

        /* 4. Move the head to point to new Node */
        head_ref = new_node;

        /*5. return to link it back */
        return head_ref;
    }
    public static Node getTail(Node head){
        if(head == null)return  head;
        while (head.right!= null){
            head = head.right;
        }
        return head;
    }
    public static Node flattenList(Node node){
        Node curr = node;
        Node tail = getTail(node);
        while (node != null){
            if(node.down!=null)
            {
                tail.right = node.down;
                tail = getTail(node.right);
            }
            node = node.right;
        }
        return curr;
    }
public static void main(String args[]){
    LinkedListFlatten L = new LinkedListFlatten();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

    L.head = L.push(L.head, 30);
    L.head = L.push(L.head, 8);
    L.head = L.push(L.head, 7);
    L.head = L.push(L.head, 5);

    L.head.right = L.push(L.head.right, 20);
    L.head.right = L.push(L.head.right, 10);

    L.head.right.right = L.push(L.head.right.right, 50);
    L.head.right.right = L.push(L.head.right.right, 22);
    L.head.right.right = L.push(L.head.right.right, 19);

    L.head.right.right.right = L.push(L.head.right.right.right, 45);
    L.head.right.right.right = L.push(L.head.right.right.right, 40);
    L.head.right.right.right = L.push(L.head.right.right.right, 35);
    L.head.right.right.right = L.push(L.head.right.right.right, 20);
    Node ll= flattenList(L.head);
    while (ll.right != null){
        System.out.println(ll.data);
        ll = ll.right;
    }
}
}
