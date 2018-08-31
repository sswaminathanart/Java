
import java.io.*;
        import java.util.*;
        import java.lang.*;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class TreeGenericISBST {
    static class Node<T extends Comparable<T>>{
        T data;
        Node<T> left;
        Node<T> right;
        Node(T d){
            data = d;
        }
    }

    public static void main(String args[]){
        Node<Integer> root = new Node<>(10);
        root.left = new Node<>(5);
        root.right = new Node<>(15);
        boolean b = isBST(root);
        if(b) System.out.println("BST");
        else System.out.println("Not BST");
        printAllPaths(root);
    }
    static boolean isBST(Node<Integer> node){
        return isBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    static boolean isBST(Node<Integer> node,int min,int max){
        return node==null ||(min<node.data && node.data<max &&
                isBST(node.left,min,node.data) &&
                isBST(node.right,node.data,max));
    }
    static void printAllPaths(Node<Integer> node){
        ArrayList<Integer> al = new ArrayList<>();
        printAllPaths(node,al);
    }
    static void printAllPaths(Node<Integer> node,
                              ArrayList<Integer> al){
        if(node==null) return;
        al.add(node.data);
        if(node.left == null && node.right == null)
        { printAllPath(al);
            al = new ArrayList<>();
            System.out.print("\n");
        }
        else{
            printAllPaths(node.left,al);
            printAllPaths(node.right,al);
        }
    }
    static void printAllPath(ArrayList<Integer> al){
        for(Integer i : al) System.out.print(i +" . ");
    }

}