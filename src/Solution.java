import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import javax.script.*;

class EvaluateString
{
    public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
            }

            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

}

class Solution {
static class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next=null;
    }
}
public static boolean hasCycle(Node root){
    Node slow=root;
    Node fast=root;
    boolean isCycle=false;
    while (fast != null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow==fast){
            isCycle=true;
            break;
        }

    }
    return isCycle;
}
public static int cycleLength(Node root){
    boolean b=hasCycle(root);
    int cycleLen =0;
    if(b){
        Node slow=root;
        Node fast=root;
        boolean isCycle=false;
        while (fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                isCycle=true;
                break;
            }

        }
        while (slow.next!=fast){
            cycleLen++;
            slow=slow.next;
        }

    }
    return cycleLen;

}
    public static Node cycleStart(Node root) {
        boolean b = hasCycle(root);
        Node slow = root;
        Node fast = root;
        if (b) {

            boolean isCycle = false;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    isCycle = true;
                    break;
                }

            }
            slow=root;
            while (slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }

        }
        return slow;
    }
    public static Node fineMid(Node root){
        Node fast = root.next;
        Node slow = root;
        while(fast != null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static Node merge(Node left,Node right){
    Node result =null;
    if(left==null) result =  right;
    if(right==null) result=left;
    else if((left!=null && right !=null)) {
        if (left.data <= right.data) {
            result = new Node(left.data);
            result.next = merge(left.next, right);;

        } else {
            result = new Node(right.data);
         //   result = result.next;
            result.next=merge(left, right.next);
        }
    }
    return result;
    }
    public static Node mergeSort(Node root){
        if(root==null || root.next==null)
            return root;
        Node middle=fineMid(root);
        Node nextTomiddle=middle.next;
        middle.next = null;
        Node left=mergeSort(root);
        Node right=mergeSort(nextTomiddle);
        Node result=merge(left,right);
    return result;
    }
    public static Node partition(Node root,int pi){
    Node left = null;
    Node l=left;
    Node n=null;
    Node right = null;
    Node r=null;
    Node m=null;
    Node mid = null;
    if(root==null || root.next==null) return root;
    while (root!=null) {
        n = new Node(root.data);
        if (n.data < pi) {
            if(left==null) {
                left = n;
                l=left;
            }
            else {
                left.next = n;
                left = left.next;
            }
        }
        if (n.data > pi) {
            if(right==null) {
                right = n;
                r=right;
            }
            else {
                right.next = n;
                right = right.next;
            }

        }
        if(n.data==pi) {
            if (mid == null) {
                mid = n;
                m=mid;
            } else {
                mid.next = n;
                mid = mid.next;
            }
        }

        root=root.next;
    }
    if(mid!=null && left!=null)
    left.next=m;
    if(right!=null && mid != null)
    mid.next=r;
    return l;

    }
    public static void main(String args[]) {
    Node root=new Node(15);
    root.next=new Node(6);
    root.next.next=new Node(7);
    Node n=root.next.next;
    for(int i=0;i<5;i++){
        n.next=new Node(i);
        n=n.next;
    }
    Node node=root;
    Node ptr=root;
    //Node ptr1=root;


    Node part=partition(root,3);
        System.out.print("\nPart   ");

        while (part!=null){
            System.out.print(part.data+" --->   ");
            part = part.next;
        }
}


}