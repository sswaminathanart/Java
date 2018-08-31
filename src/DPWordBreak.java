import java.util.*;

public class DPWordBreak {
    public static void main(String args[]) {
        String s = "catsanddog";
        String[] words = {"cat", "cats", "and", "sand", "dog"};
        String[] wordB = wordBreak(s, words);
        for(String ss:wordB){
            System.out.println(ss);
        }
    }
    public static String[] wordBreak(String s,String[] words){
        Set<String> dicwords = new HashSet<>(Arrays.asList(words));
        List<String> resultList = wordBreakHelper(s, dicwords);
        return resultList.toArray(new String[resultList.size()]);

    }
    public static List<String> wordBreakHelper(String s,Set<String> dicwords){
        List<String>[] wordCollection = new ArrayList[s.length()+1];
        wordCollection[0] = new ArrayList<>();
        for(int startIdx=0;startIdx<s.length();startIdx++){
            for(int nextIdx=startIdx+1;nextIdx<=s.length();nextIdx++){
                if(dicwords.contains(s.substring(startIdx,nextIdx))) {
                    if (wordCollection[startIdx] != null) {
                        String subword = s.substring(startIdx, nextIdx);
                        if (wordCollection[nextIdx] == null) {
                            List<String> newWord = new ArrayList<>();
                            newWord.add(subword);
                            wordCollection[nextIdx] = newWord;
                        } else {
                            wordCollection[nextIdx].add(subword);
                        }
                    }
                }
            }
        }
        if(wordCollection[s.length()]== null)
            return new ArrayList<>();
        else{
            List<String> result = new ArrayList<>();
            dfs(wordCollection,result,"",s.length());
            return  result;
        }
    }
    public static void dfs(List<String>[] wordCollection,List<String> result,String s,int len){
        if(len ==0){
            result.add(s.trim());
            return;
        }
        for(String str: wordCollection[len]){
            String combined = str +" "+s;
            dfs(wordCollection,result,combined,len-str.length());
        }
    }


}
