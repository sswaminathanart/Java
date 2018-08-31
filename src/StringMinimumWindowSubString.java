import java.util.*;

public class StringMinimumWindowSubString {
    public static void main(String args[]){

       // System.out.println(MinWindow("acdbddddddddaaaaaaaadabbbba","baad"));
        System.out.println(minWindow1("acdbddddddddaaaaaaaadabbbba","baad"));
    }
    static String MinWindow(String strText, String strCharacters){
        Map<Character,Integer> characterSet = new HashMap<>();
        for(int i=0;i<strCharacters.length();i++){
            if (characterSet.containsKey(strCharacters.charAt(i))) {
                characterSet.put(strCharacters.charAt(i), characterSet.get(strCharacters.charAt(i)) + 1);
            } else {
                characterSet.put(strCharacters.charAt(i), 1);
            }
        }
        return minWindow(strText,characterSet);

    }
    static String minWindow(String strText,Map<Character,Integer> characterSet){
        String retString ="";
        int minlen = Integer.MAX_VALUE;
        int left = 0,right = 0;
        int minStart = -1;
        int minEnd = -1;
        Map<Character,Integer> freqMap = new HashMap<>();
        while (right<strText.length()){
            while (freqMap.size()!= characterSet.size()){
                char rightCh = strText.charAt(right);
                if(characterSet.containsKey(rightCh)) {
                    if (freqMap.containsKey(rightCh)) {
                        freqMap.put(rightCh, freqMap.get(rightCh) + 1);
                    } else {
                        freqMap.put(rightCh, 1);
                    }
                }
                right++;
                if(right== strText.length()) break;
            }char leftCh = strText.charAt(left);
            while (freqMap.size() == characterSet.size() && freqMap.get(leftCh)==characterSet.get(leftCh) && left<right){
                leftCh = strText.charAt(left);
                if(freqMap.containsKey(leftCh)){
                    freqMap.put(leftCh,freqMap.get(leftCh)-1);
                    if(freqMap.get(leftCh)==0) {
                        freqMap.remove(leftCh);
                    }
                }
                left++;
            }
            if(  left !=0 && right-left+2 < minlen){
                minlen = right-left+2;
                minStart = left-1;
                minEnd = right;
                retString = strText.substring(minStart,minEnd);
            }
        }
        return retString;
    }
    public static String minWindow1(String S, String T) {
        String res = "";
        if(S == null || T == null || S.length()==0 || T.length()==0)
            return res;

        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for(int i =0;i < T.length(); i++){
            if(!dict.containsKey(T.charAt(i)))
                dict.put(T.charAt(i), 1);
            else
                dict.put(T.charAt(i), dict.get(T.charAt(i))+1);
        }

        int count = 0;
        int pre = 0;
        int minLen = S.length()+1;
        for(int i=0;i<S.length();i++){
            if(dict.containsKey(S.charAt(i))){
                dict.put(S.charAt(i),dict.get(S.charAt(i))-1);
                if(dict.get(S.charAt(i)) >= 0)
                    count++;

                while(count == T.length()){
                    if(dict.containsKey(S.charAt(pre))){
                        dict.put(S.charAt(pre),dict.get(S.charAt(pre))+1);

                        if(dict.get(S.charAt(pre))>0){
                            if(minLen>i-pre+1){
                                res = S.substring(pre,i+1);
                                minLen = i-pre+1;
                            }
                            count--;
                        }
                    }
                    pre++;
                }
            }//end for if(dict.containsKey(S.charAt(i)))
        }
        return res;
    }
}
