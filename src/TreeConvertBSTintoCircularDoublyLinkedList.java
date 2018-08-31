public class TreeConvertBSTintoCircularDoublyLinkedList {

    public static void main(String args[])
    {
        Node root = new Node(15);
        root.left = new Node(5);
        root.right = new Node(57);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(115);
        BSTtoLL(root);

    }
    static void BSTtoLL(Node root) {
        Node dll = null;
        BSTtoLL(root,dll);
        printList(dll);
    }
    static void BSTtoLL(Node curr,Node dll){
        if(curr == null) return;
        Node pre = null;
        BSTtoLL(curr.left,dll);
        if(pre == null){
            dll = curr;
        }
        else{
            curr.left = pre;
            pre.right = curr;
        }
        pre = curr;
        BSTtoLL(curr.right,dll);
        printList(dll);

    }
    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(Integer.toString(current.data));
            current = current.right;
            if (current == head) break;
            else System.out.print(" ");
        }

        System.out.println();
    }


}
