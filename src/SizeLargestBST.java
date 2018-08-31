public class SizeLargestBST
{
    class Result{
        int min;
        int max;
        boolean isBST;
        int maxCountBST;
        Result(){
            min = 0;
            max = 0;
            isBST = false;
            maxCountBST = 0;
        }
    }
    class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int x)
        {
            this.data = x;
        }
    }

    TreeNode root;
    Result r = new Result();

    private int minimum(int a, int b)
    {
        if (a < b) return a;
        return b;
    }

    private int maximum(int a, int b)
    {
        if (a > b) return a;
        return b;
    }


    /*
                            10
                      6             12
                  7      4       9       14
                                      13    16
    */
    private TreeNode createTree()
    {
        this.root = new TreeNode(10);
        TreeNode n1   = new TreeNode(6);
        TreeNode n2   = new TreeNode(12);
        TreeNode n3   = new TreeNode(7);
        TreeNode n4   = new TreeNode(4);
        TreeNode n5   = new TreeNode(9);
        TreeNode n6   = new TreeNode(14);
        TreeNode n7   = new TreeNode(13);
        TreeNode n8   = new TreeNode(16);

        root.left  = n1;
        root.right = n2;

        n1.left  = n3;
        n1.right = n4;

        n2.left  = n5;
        n2.right = n6;

        n6.left = n7;
        n6.right = n8;

        return root;
    }


    private int findSizeOfLargestBST(TreeNode currentNode, Result r)
    {
        r.min = Integer.MAX_VALUE;
        r.max = Integer.MIN_VALUE;

        if (currentNode == null)
        {
            r.isBST = true;
            return 0;
        }

        // in this call, min[0] and max[0] would be updated
        // isBST[0] would be updated if left sub-tree is BST
        int leftTreeSize = findSizeOfLargestBST(currentNode.left,r);

        // check if left sub-tree is a BST and no node in left sub-tree is greater than current node
        boolean isLeftValid = r.isBST && (r.max < currentNode.data);

        // before updating min[0] and max[0] in right sub-tree save min and max values seen so far
        int tempMin = minimum(currentNode.data, r.min);
        int tempMax = maximum(currentNode.data, r.max);

        // in this call, min[0] and max[0] would be updated
        // isBST[0] would be updated if right sub-tree is BST
        int rightTreeSize = findSizeOfLargestBST(currentNode.right, r);

        // check if right sub-tree is a BST and no node in right sub-tree is less than current node
        boolean isRightValid = r.isBST && (currentNode.data < r.min);

        // before returning update min[0] which would be the minimum value seen in this sub-tree with root as currentNode
        // and update max[0] which would be the maximum value seen in this sub-tree before
        r.min = minimum(tempMin, r.min);
        r.max = maximum(tempMax, r.max);

        // if this tree with root as currentNode is a valid BST
        if (isLeftValid && isRightValid)
        {
            // this sub-tree at currentNode is also a BST
            r.isBST = true;

            // update max BST size accordingly
            if ((1 + leftTreeSize + rightTreeSize) > r.maxCountBST)
            {
                r.maxCountBST = (1 + leftTreeSize + rightTreeSize);
            }

            return r.maxCountBST;
        }

        // if this tree is not BST, we don't really use the value returned by it. Return -1.
        r.isBST = false;
        return -1;
    }

    public void findLargestBST(Result r)
    {


        findSizeOfLargestBST(root, r);
    }


    public static void main(String[] args)
    {
        SizeLargestBST solution = new SizeLargestBST();

        /*
                                10
                          6             12
                      7      4       9       14
                                          13    16
        */
        solution.createTree();



        solution.findLargestBST(solution.r);

        System.out.println(solution.r.maxCountBST);
    }
}