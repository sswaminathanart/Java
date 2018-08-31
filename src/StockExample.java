import java.util.Stack;

public class StockExample {
    public static int maxbalance(String str){
        Stack<Integer> s =new Stack<>();
        int maxb =0;
        s.push(-1);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                s.push(i);
            }
            else
            {
                s.pop();
                if(!s.isEmpty()){
                    maxb =(maxb<i-s.peek())?i-s.peek():maxb;
                }
                else {
                    s.push(i);
                }
            }
        }
        return maxb;
    }
    public static void main(String args[]){
        String s="((()))))))";
        int i=maxbalance(s);
        System.out.print(s+"    "+i);
    }
}
