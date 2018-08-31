public class TreeLCA {
    static class Node<T extends Comparable<T>>{
        T data;
        Node<T> left;
        Node<T> right;
        Node(T t){
            data = t;
            left = null;
            right =  null;
        }
    }
    public static void main(String args[]){
        Node<Integer> root = new Node<>(10);
        root.left = new Node<>(5);
        root.right = new Node<>(15);
        System.out.println(LCA(root,5,15).data);
    }
    static Node<Integer> LCA(Node<Integer> n,int n1,int n2){
        if(n==null) return null;
        if(n.data==n1 || n.data==n2) return n;
        Node<Integer> nodeleft = LCA(n.left,n1,n2);
        Node<Integer> noderight = LCA(n.right,n1,n2);
        if(nodeleft!=null&&noderight!=null)return n;
        return (nodeleft!=null)?  nodeleft:  noderight;
    }
}
