import java.io.*;
import java.util.*;
import java.lang.*;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class TreeGenericInorderIterator {
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
        int[] x ={5,6,7,8,9,10,11};
        Node<Integer> root = convertBST(x);
        perOrderTravel(root);
        InorderIterator<Integer> in = new InorderIterator<>(root);
        System.out.println();
        while(in.hasNext()){
            System.out.println(in.next().data);
        }
    }
    static Node<Integer> convertBST(int[] arr){
        return convertBST(arr,0,arr.length-1);
    }
    static Node<Integer> convertBST(int[] arr,
                                    int start,int end){
        if(start>end) return null;
        int mid = start +(end-start)/2;
        Node<Integer> root = new Node<>(arr[mid]);
        root.left = convertBST(arr,start,mid-1);
        root.right = convertBST(arr,mid+1,end);
        return root;
    }
    static void perOrderTravel(Node<Integer> node){
        if(node == null) return;
        System.out.println(node.data);
        perOrderTravel(node.left);
        perOrderTravel(node.right);
    }
    static class InorderIterator<T extends Comparable<T>>{
        Stack<Node<T>> stack = new Stack<>();
        InorderIterator(Node<T> node){
            pushLeft(node);
        }
        public void pushLeft(Node<T> node){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        public boolean hasNext(){
            return !stack.empty();
        }
        public Node<T> next(){
            if(!hasNext()) return null;
            Node<T> node = stack.pop();
            this.pushLeft(node.right);
            return node;
        }

    }

}