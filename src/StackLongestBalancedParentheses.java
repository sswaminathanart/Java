import java.sql.Statement;
import java.util.Stack;

public class StackLongestBalancedParentheses {
    public static void main(String args[]) {
        String str = "((()))(((()()()(())";
        System.out.println("Longent parenteses count " + longestBalancedParentheses(str));
    }

    static int longestBalancedParentheses(String str) {
        int maxCount = 0;
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);///demarker
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(')
            indexStack.push(i);
            else {
                int currindex = indexStack.pop();
                if(!indexStack.empty()){
                    if(i-indexStack.peek()>maxCount){
                        maxCount = i -indexStack.peek();
                    }
                }
                else{
                    indexStack.push(i);
                }
            }
        }
        return maxCount;
    }
}


