
import java.util.*;


public class AdcWordBreak {
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, List<String>> mapWords = new HashMap<>();
        for(String word : magazine) {
            if(mapWords.get(word)==null) {
                List<String> wordList = new LinkedList<>();
                wordList.add(word);
                mapWords.put(word, wordList);
            } else {
                List<String> wordList = mapWords.get(word);
                wordList.add(0,word);
                mapWords.put(word, wordList);
            }
        }

        boolean noteDatainMag = true;
        for(String noteWord : note) {
            List<String> wordList = mapWords.get(noteWord);
            if(wordList == null) {
                noteDatainMag = false;
                break;
            } else {
                if(wordList.size()>0) {
                    wordList.remove(0);
                    if(wordList.size() == 0) {
                        mapWords.remove(noteWord);
                    }
                }
            }
        }

        if(noteDatainMag)
            System.out.println("Yes");
        else
            System.out.println("No");
    }


    public static void main(String args[]){
        String[] str1={"apgo","clm","w","lxkvg","mwz","elo","bg","elo","lxkvg","elo","apgo","apgo","w","elo","bg"};
        String[] str2={"elo","lxkvg","bg","mwz","clm","w"};

        checkMagazine(str1, str2);
    }
}
