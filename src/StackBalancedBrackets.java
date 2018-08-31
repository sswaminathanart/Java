import java.util.HashMap;
import java.util.Stack;

public class StackBalancedBrackets {
    public static void main(String args[]){
        String input ="{[()]}";
        boolean b = balancedBrackets(input);
        System.out.println(b);
    }
    static boolean balancedBrackets(String str){
        Stack<Character> s =new Stack<>();
        HashMap<Character,Character> bb = new HashMap<>();
        bb.put('{','}');
        bb.put('(',')');
        bb.put('[',']');

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='{' ||str.charAt(i)=='('||str.charAt(i)=='['){
                s.push(bb.get(str.charAt(i)));
            }
            else if((!s.isEmpty()) && (s.peek() == str.charAt(i))){
                s.pop();
            }
        }
        return s.isEmpty();
    }

}
