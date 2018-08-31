public class SplitList {
    static class Node{
        int data;
        Node next;
        Node(int d){
           data = d;
           next = null;
        }
    }
    public static Node[] splitList(Node root){

        if(root == null || root.next == null) {
            Node[] lists = {root,null};
            return lists;
        };
        Node slow = root;
        Node fast = root.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node nexttomid=slow.next;
        slow.next = null;
        Node[] lists = {root,nexttomid};
        return lists;
    }
    public static Node reverse(Node root){
        if(root ==null || root.next==null)return root;
        Node prev = null;
        Node curr = root;
        Node next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static Node merge(Node n1,Node n2){
       Node re =null;
        if(n1 == null) return n2;
        if(n2 == null) return n1;
        while (n1 != null && n2 != null) {
            if(n1 != null) {
                Node temp = n1.next;
                n1.next = re;
                re = n1;
                n1 = temp;
            }
            if(n2 != null){
                Node temp = n2.next;
                n2.next = re;
                re = n2;
                n2 = temp;
            }
        }
        while (n1 != null) {
            Node temp = n1.next;
            n1.next = re;
            re = n1;
            n1 = temp;
        }
        while (n2 != null) {
            Node temp = n2.next;
            n2.next = re;
            re = n2;
            n2 = temp;
        }
        return reverse(re);
    }
    public static void main(String args[]){
        Node root=new Node(1);
        Node n=root;
        for(int i=2;i<12;i++){
            n.next=new Node(i);
            n=n.next;
        }
        Node[] lists=splitList(root);
        Node r = reverse(lists[1]);
        Node z = merge(lists[0],r);

        System.out.println();
        while (z !=null){
            System.out.print(z.data+"    ");
            z = z.next;
        }

    }

}
