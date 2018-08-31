import java.util.Stack;

public class TreePostOrderTraversalwithoutrecursion {
    public static void main(String args[]) {
        Node root = new Node(15);
        root.left = new Node(25);
        root.right = new Node(57);
        root.left.left = new Node(25);
        root.left.right = new Node(25);
        root.right.right = new Node(15);
        postOrderTraversalwithoutrecursion(root);
    }
    static void postOrderTraversalwithoutrecursion(Node root){
        if(root== null) return;
        Stack<Node> stack = new Stack<>();
        Stack<Node> output = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr =stack.peek();
            output.push(curr);
            stack.pop();
            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }
        while (!output.isEmpty()){
            System.out.println(output.pop().data);
        }
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
