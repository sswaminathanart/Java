package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args){
        String s ="abracadabra";
        List<List<String>> res = partition(s);
        for(List<String> rr: res)
        {
            StringBuilder sb=new StringBuilder();
            for(String str : rr)
            {
                sb.append(str+"|");
            }
            System.out.println(sb.toString().substring(0,sb.toString().length()-1));
        }
    }
    public static List<List<String>> partition(String s){
        List<String> l = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        helperfun(s,res,l,0);
        return  res;
    }
    public static void helperfun(String s,List<List<String>> res,List<String> l,int k){
        //base case
        if(k == s.length()){
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i = k+1; i<=s.length();i++){
            if(isPalindrome(s.substring(k,i))){
                l.add(s.substring(k,i));
                helperfun(s,res,l,i);
                l.remove(l.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while (l<r){
            if(s.charAt(l) != s.charAt(r) ) return false;
            else {
                l++;
                r--;
            }
        }
        return true;
    }
}
