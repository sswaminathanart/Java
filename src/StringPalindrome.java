public class StringPalindrome {
    public static void main(String args[]) {
        String s = "aabbaa";
        boolean b= ispalindrome(s);
        if(b)
            System.out.println("String "+s+" is a Palindrome");
        else
            System.out.println("String "+s+" is not a Palindrome");
        b= ispalindrome1(s,0,s.length()-1);
        if(b)
            System.out.println("String "+s+" is a Palindrome");
        else
            System.out.println("String "+s+" is not a Palindrome");
    }
    public static boolean ispalindrome(String str){
        if(str.length()<=1) return true;
        if(str.charAt(0)==str.charAt(str.length()-1)){
            return ispalindrome(str.substring(1,str.length()-1));
        }
        else {
            return false;
        }
    }
    public static boolean ispalindrome1(String str,int l,int r){
        if(l>=r) return true;
        if(str.charAt(0)==str.charAt(str.length()-1)){
            return ispalindrome1(str.substring(1,str.length()-1),l+1,r-1);
        }
        else {
            return false;
        }
    }


}
