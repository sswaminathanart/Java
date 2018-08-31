import java.util.Stack;

public class TreeMergeTwoBSTs {
    static class Node<T extends Comparable<T>>{
        T data;
        Node<T> left;
        Node<T> right;
        Node(T d){
            data = d;
            left = null;
            right = null;
        }
    }
    public static void main(String args[]){
        int[] x = {1,5,6,8,9};
        int[] y = {2,3,4,7,10};
        Node<Integer> n1 = convertToBST(x);
        Node<Integer> n2 = convertToBST(y);
        Node<Integer> n = mergeBST(n1,n2);
        InorderIterator<Integer> in = new InorderIterator<>(n);
        while (in.hasNext()){
            System.out.println(in.next().data);
        }
    }
    public static Node<Integer> convertToBST(int[] arr){
        return convertToBST(arr,0,arr.length-1);
    }
    public static Node<Integer> convertToBST(int[] arr,int s,int e){
        if(s>e) return null;
        int mid = s+(e-s)/2;
        Node<Integer> n = new Node<>(arr[mid]);
        n.left = convertToBST(arr,s,mid-1);
        n.right = convertToBST(arr,mid+1,e);
        return n;
    }
    static class InorderIterator<T extends Comparable<T>>{
        Stack<Node<T>> stack = new Stack<>();
        InorderIterator(Node<T> node){
            pushLeft(node);
        }
        void pushLeft(Node<T> node){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }
        boolean hasNext(){
            return !stack.empty();
        }
        Node<T> next(){
            if(!hasNext()) return null;
            Node<T> n = stack.pop();
            pushLeft(n.right);
            return n;
        }

    }
    static Node<Integer> insertNode(Node<Integer> n,int val){
        if(n==null) return new Node<>(val);
        if(n.data<=val) n.right = insertNode(n.right,val);
        if(n.data> val) n.left = insertNode(n.left,val);
        return n;
    }
    static Node<Integer> mergeBST(Node<Integer> n1,Node<Integer> n2){
        if(n1==null && n2==null) return null;
        if(n1==null) return n2;
        if(n2==null) return n1;
        InorderIterator<Integer> in = new InorderIterator<>(n2);
        while(in.hasNext()){
            n1 = insertNode(n1,in.next().data);

        }
        return n1;


    }

}
