public class TreeisBST {
    static Count ct = new Count();
    static boolean isBST(Node node,int min,int max){
        if(node == null) return true;
        return (min< node.data && node.data<max && isBST(node.left,min,node.data) &&
                                isBST(node.right,node.data,max));

    }
    static boolean isBST(Node root){
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }
    static boolean unival(Node node,Count count){
        if(node == null) return true;
        boolean left = unival(node.left,count);
        boolean right = unival(node.right,count);
        if(!left || !right){
            return false;
        }
        if(node.right!=null&& node.data != node.right.data){
            return false;
        }
        if(node.left != null && node.data != node.left.data){
            return false;
        }
        count.count++;
        return true;



    }
    static  int unival(Node root){
        int c=0;
        unival(root,ct);
        return ct.count;
    }
    public static void main(String args[])
    {
        Node root = new Node(15);
        root.left = new Node(25);
        root.right = new Node(57);
        root.left.left = new Node(995);
        root.left.right = new Node(95);
        root.right.right = new Node(15);

        if (isBST(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
        System.out.println(unival(root));
    }

}
class Node  {
    int data;
    Node left;
    Node right;
    Node(int d){
        data = d;

    }
}class Count
{
    int count = 0;
}

