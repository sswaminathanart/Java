public class TreeCloneABTree {
    public static void main(String args[]) {
        Node root = new Node(15);
        root.left = new Node(25);
        root.right = new Node(57);
        root.left.left = new Node(25);
        root.left.right = new Node(25);
        root.right.right = new Node(15);
        preOrderTravel(root);
        Node clone= cloneATree(root);
    }
    static void preOrderTravel(Node root){
        if(root== null) return;
        System.out.println(root.data);
        preOrderTravel(root.left);
        preOrderTravel(root.right);
    }
    static Node cloneATree(Node root){
        if(root==null) return root;
        Node clone = new Node(root.data);
        clone.left = cloneATree(root.left);
        clone.right = cloneATree(root.right);
        return clone;
    }
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;

        }
    }
}
