public class TreeCountUnivalSubTree {
    public static void main(String args[]) {
        Node root = new Node(15);
        root.left = new Node(25);
        root.right = new Node(57);
        root.left.left = new Node(25);
        root.left.right = new Node(25);
        root.right.right = new Node(15);
        int[] cc = {0};
        univalCount(root,cc);
        System.out.println(cc[0]);
    }
    static boolean univalCount(Node root,int[] count){
        if(root== null) return true;
        boolean left =univalCount(root.left,count);
        boolean right= univalCount(root.right,count);
        if(right==false || left== false) return false;
        if(root.right != null && root.data != root.right.data) return false;
        if(root.left != null && root.data != root.left.data) return false;
        count[0]++;
        return true;


    }
        static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;

        }
    }
    static class Count{
        int c = 0;
    }
}
