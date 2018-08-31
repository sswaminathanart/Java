
import java.util.*;

public class AdcZeroSum {
    private static<K,V> void insert(Map<K, List<V>> hashMap, K key, V value)
    {
        // if the key is seen for the first time, initialize the list
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }

        hashMap.get(key).add(value);
    }
    static int[]  sumZero(int[] A)
    {
        // create an empty Multi-map to store ending index of all
        // sub-arrays having same sum
        Map<Long, List<Integer>> hashMap = new HashMap<>();
        List<Integer> output = new ArrayList<>();

        // insert (0, -1) pair into the map to handle the case when
        // sub-array with 0 sum starts from index 0
        insert(hashMap, 0l, -1);

        long sum = 0;

        // traverse the given array
        for (int i = 0; i < A.length; i++)
        {
            // sum of elements so far
            sum += A[i];

            // if sum is seen before, there exists at-least one
            // sub-array with 0 sum
            if (hashMap.containsKey(sum))
            {
                List<Integer> list = hashMap.get(sum);

                // find all sub-arrays with same sum
                for (Integer value: list) {
                    // System.out.println("Subarray [" + (value + 1) + ".." +
                    //                 i + "]");
                    output.add(value+1);
                    output.add(i);
                }
            }

            // insert (sum so far, current index) pair into the Multi-map
            insert(hashMap, sum, i);
        }
        int[] intArray = new int[2];
        if(output.size()>0){
            for (int i = 0; i < 2; i++) {
                intArray[i] = (int)output.get(i);
            }
            return intArray;
        }
        else{
            int x[] ={-1};
            return x;
        }
    }
    public static void main(String args[]){
        int[] y = {5,1,2, -3,7,-4};
        int[] x= sumZero(y);
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
    }

}
