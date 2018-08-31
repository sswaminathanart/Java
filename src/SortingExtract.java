import java.util.HashMap;
import java.util.Map;

public class SortingExtract {
    public static void main(String args[]){
        String[] input={"key1 abcd",
                "key2 zzz",
                "key1 hello",
                "key3 world",
                "key1 hello"};
        String[] result = solve(input);
        System.out.println("abcd".compareTo("hello"));
        for(String s:result){
            System.out.println(s);
        }

    }
    static String[] solve(String[] arr) {
        Map<String,Integer> keycount = new HashMap<>();
        Map<String,String> keyvalue = new HashMap<>();
        for(String s: arr){
            String[] kv = s.split(" ");
            String k = kv[0];
            String v = kv[1];
                if (!keycount.containsKey(k)) {
                    keycount.put(k, 1);
                    keyvalue.put(k,v );
                }
                else {
                    keycount.put(k,keycount.get(k)+1);
                    if(v.compareTo(keyvalue.get(k))>= 1){
                        keyvalue.put(k,v);

                    }
                }

        }
        String[] result = new String[keycount.size()];
        int i=0;
        for(Map.Entry<String,String> m : keyvalue.entrySet()){
            result[i] = m.getKey() + ":"+keycount.get(m.getKey()) +","+ m.getValue();
            i++;
        }
        return result;
    }
}
