public class TreeInOrderTravel {
    public static void main(String args[]) {
        Node root = new Node(15);
        root.left = new Node(25);
        root.right = new Node(57);
        root.left.left = new Node(85);
        root.left.right = new Node(95);
        root.right.right = new Node(15);
        inOrderTravel(root);


    }

    public static void inOrderTravel(Node root) {
        if (root == null) return;
        inOrderTravel(root.left);
        System.out.println(root.data);
        inOrderTravel(root.right);
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

