public class StringAnagram {
    public static void main(String args[]){
        String s1="debit cards";
        String s2 = "bad credits";
        if (anagram(s1,s2)) {
            System.out.println("yes  "+s1 +" and "+s2+" are anagram");
        } else {
            System.out.println("No  "+s1 +" and "+s2+" are anagram");
        }
        char[] extra =makeAnagram("abc","bcakd");
        for(int i=0;i<extra.length;i++){
            if(extra[i] !=0)
            System.out.println(extra[i]);
        }
    }
    public static boolean anagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] asciiArr = new int[256];
        int source_no_of_unique_char = 0;
        int target_no_of_unique_char = 0;
          //Soure iteration
          for(int i=0;i<s.length();i++){
              if(asciiArr[s.charAt(i)]==0){
                  source_no_of_unique_char++;
              }
              ++asciiArr[s.charAt(i)];
          }
        for(int i=0;i<t.length();i++){
            if(asciiArr[t.charAt(i)]==0){
                return false;
            }
            else {
                --asciiArr[t.charAt(i)];
            }
            if(asciiArr[t.charAt(i)]==0){
                target_no_of_unique_char++;
            }
            if(target_no_of_unique_char==source_no_of_unique_char){
                return i==t.length()-1;
            }
        }
        return false;

    }
    static char[] makeAnagram(String a, String b) {
        int[] asciiArr = new int[256];
        int[] asciiArr1 = new int[256];
        char[] extra= new char[256];
        int result =0;
        for(int i=0;i<a.length();i++){
            ++asciiArr[a.charAt(i)];
        }
        for(int i=0;i<b.length();i++){
            ++asciiArr1[b.charAt(i)];
        }
        int j =0;
        for(int i=0;i<asciiArr.length;i++){
            if(asciiArr[i]!=asciiArr1[i]){
                extra[j] =(char) i;
                j++;
            }
        }
        return extra;
    }
}
