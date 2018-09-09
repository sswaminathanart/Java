package recursion;

public class WildCard {
/*
Input: 10?
Output: 101, 100

i.e. ? behaves like a wild-card. There are two possibilities for 10?, when that ? is replaced with either 0 or 1.

Input: 1?0?
Output: 1000, 1001, 1100, 1101

Please write a program that takes given strings as input and produces the suggested output.

Given string can only have three characters: 0, 1 and ?
 */
public static void main(String[] args){
    String input = "1?0?";
    wildCard(input);
}
public static void wildCard(String s){
    char[] ch = new char[s.length()];
    helper(s.toCharArray(),ch,0);
}
public static void helper(char[] s,char[] n,int i){
    if(i>= s.length){
        System.out.println(String.valueOf(n));
        return;
    }
    if(s[i]=='?') {
        n[i] = '1';
        helper(s, n, i + 1);
        n[i] = '0';
        helper(s, n, i + 1);
    }
    else{
        n[i]= s[i];
        helper(s,n,i+1);

    }
}

}

