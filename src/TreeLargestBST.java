public class TreeLargestBST {
    public static void main(String args[]) {
        Node root = new Node(15);
        root.left = new Node(25);
        root.right = new Node(57);
        root.left.left = new Node(5);
        root.left.right = new Node(95);
        root.right.right = new Node(15);
        SizeMinMAX resutl = largestBST(root);
        System.out.println(resutl.count);

    }
    static SizeMinMAX largestBST(Node root){
        if(root == null) return new SizeMinMAX();
        SizeMinMAX left = largestBST(root.left);
        SizeMinMAX right = largestBST(root.right);
        SizeMinMAX resut = new SizeMinMAX();
        if(left.isBST ==false || right.isBST == false ||
                (left.max > root.data || right.min <= root.data)){
            resut.isBST =false;
            resut.count = Integer.max(left.count,right.count);
            return resut;
        }
        else{
            resut.isBST =true;
            resut.min = (root.left!= null)? resut.min:root.data;
            resut.max = (root.right!= null)? resut.max:root.data;
            return resut;
        }
    }
    static class SizeMinMAX{
        boolean isBST;
        int count =0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
        static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data = d;

        }
    }
}
