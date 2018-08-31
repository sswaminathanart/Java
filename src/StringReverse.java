public class StringReverse {
    public static void main(String args[]){
        String str ="1234";
        System.out.println("Reverse of "+str +" "+reverse1(str));
    }
    public static String reverse(String str){
        if(str.length()<=1) return str;
        String revstr = reverse(str.substring(1))+ str.charAt(0);
        return revstr;
    }
    public static String reverse1(String str){
        if(str.length()<=1) return str;
        int len = str.length()-1;
       // String revstr = reverse1(str.substring(1))+ str.charAt(0);

        return str.charAt(len)+reverse1(str.substring(0,len));
    }
}
