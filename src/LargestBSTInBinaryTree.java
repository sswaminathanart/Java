public class LargestBSTInBinaryTree {

    public static int largestBST(Node root) {
        MinMax m = largest(root);
        return m.size;
    }

    private static MinMax largest(Node root) {
        //if root is null return min as Integer.MAX and max as Integer.MIN
        if (root == null) {
            return new MinMax();
        }

        //postorder traversal of tree. First visit left and right then
        //use information of left and right to calculate largest BST.
        MinMax leftMinMax = largest(root.left);
        MinMax rightMinMax = largest(root.right);

        MinMax m = new MinMax();

        //if either of left or right subtree says its not BST or the data
        //of this node is not greater/equal than max of left and less than min of right
        //then subtree with this node as root will not be BST.
        //Return false and max size of left and right subtree to parent
        if (leftMinMax.isBST == false || rightMinMax.isBST == false || (leftMinMax.max > root.data || rightMinMax.min <= root.data)) {
            m.isBST = false;
            m.size = Math.max(leftMinMax.size, rightMinMax.size);
            return m;
        }

        //if we reach this point means subtree with this node as root is BST.
        //Set isBST as true. Then set size as size of left + size of right + 1.
        //Set min and max to be returned to parent.
        m.isBST = true;
        m.size = leftMinMax.size + rightMinMax.size + 1;

        //if root.left is null then set root.data as min else
        //take min of left side as min
        m.min = root.left != null ? leftMinMax.min : root.data;

        //if root.right is null then set root.data as max else
        //take max of right side as max.
        m.max = root.right != null ? rightMinMax.max : root.data;

        return m;
    }

    public static void main(String args[]) {
        LargestBSTInBinaryTree lbi = new LargestBSTInBinaryTree();
        //ConstructTreeFromInOrderPreOrder ctf = new ConstructTreeFromInOrderPreOrder();
        //this is just to create a binary tree.
        int inorder[] = {-7, -6, -5, -4, -3, -2, 1, 2, 3, 16, 6, 10, 11, 12, 14};
        int preorder[] = {3, -2, -3, -4, -5, -6, -7, 1, 2, 16, 10, 6, 12, 11, 14};
        Node root = constrctTree(inorder, preorder);
        int largestBSTSize = largestBST(root);
        System.out.println("Size of largest BST  is " + largestBSTSize);
        assert largestBSTSize == 8;
    }

    static Node constrctTree(int[] iInOrderArray, int[] iPreOrderArray) {
        int inOrderlen = iInOrderArray.length;
        int preOrderlen = iPreOrderArray.length;
        Node root = constrctTree(iInOrderArray, 0, inOrderlen - 1, iPreOrderArray, 0, preOrderlen - 1);
        return root;
    }

    static Node constrctTree(int[] iInOrderArray, int inStart, int inEnd, int[] iPreOrderArray, int perStart, int perEnd) {
        if (inStart > inEnd) return null;
        int rootVal = iPreOrderArray[perStart];
        int mid = 0;
        for (int i = 0; i <= inEnd; i++) {
            if (rootVal == iInOrderArray[i]) {
                mid = i;
                break;
            }
        }
        int leftTreeEnd = mid - inStart;
        Node root = new Node(rootVal);
        root.left = constrctTree(iInOrderArray, inStart, mid - 1, iPreOrderArray, perStart + 1, perStart + leftTreeEnd);
        root.right = constrctTree(iInOrderArray, mid + 1, inEnd, iPreOrderArray, perStart + leftTreeEnd + 1, perEnd);
        return root;

    }
}
/**
 * Object of this class holds information which child passes back
 * to parent node.
 */
class MinMax{
    int min;
    int max;
    boolean isBST;
    int size ;

    MinMax(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        isBST = true;
        size = 0;
    }
}
