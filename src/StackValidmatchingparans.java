import java.util.HashMap;
import java.util.Stack;

public class StackValidmatchingparans {
    public static void main(String args[]){
        String s="} ( 1 * 2) + 3 * ( 5 - 6)";
        boolean b =hasMatchingParantheses(s);
        if(b){System.out.print("Yes");}
        else {
            System.out.print("No");
        }
    }
    public static boolean hasMatchingParantheses(String strExpression) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> lookup = new HashMap<>();
        lookup.put('{','}');
        lookup.put('[',']');
        lookup.put('(',')');
        if( lookup.containsValue(strExpression.charAt(0))) return false;
        for(int i=0;i<strExpression.length();i++){
            if(strExpression.charAt(i)=='{'||
                    strExpression.charAt(i)=='['||
                    strExpression.charAt(i)=='('){
                stack.push(lookup.get(strExpression.charAt(i)));
            }
            else if(!stack.isEmpty() && stack.peek()==strExpression.charAt(i)){
                stack.pop();

            }
        }
        return stack.isEmpty();
    }
}
