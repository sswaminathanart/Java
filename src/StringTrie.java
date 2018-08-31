import java.util.HashMap;
import java.util.Map;

public class StringTrie {

    class TrieNode {
        Map<Character, TrieNode> children ;
        boolean isEndofWord;
        TrieNode() {
            children = new HashMap<>();
            isEndofWord =false;
        }
    }
    private  final TrieNode root;
    public StringTrie(){
        root = new TrieNode();
    }

}
