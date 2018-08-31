import java.util.*;

public class AdcSortArryFrequency {
    public static void main(String args[]){
        int[] x = {2,4,4,1,1,1,5};
        sortbyFrequency(x);

    }
    public static void sortbyFrequency(int[] arr){
        Map<Integer,Integer> freqMap = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int count = freqMap.getOrDefault(arr[i], 0);
            freqMap.put(arr[i], count + 1);
            output.add(arr[i]);
        }
        FrequencyCompa fc = new FrequencyCompa(freqMap);
        Collections.sort(output,fc);
        for(Integer i : output){
            System.out.print(i + " ");
        }

    }
    public static class FrequencyCompa implements Comparator<Integer>{
        Map<Integer,Integer> map = new HashMap<>();
        FrequencyCompa(Map<Integer,Integer> m){
            map =m;
        }


        @Override
        public int compare(Integer o1, Integer o2) {
            int frequencyCompare = map.get(o1).compareTo(map.get(o2));
            int valueCompare = o1.compareTo(o2);
            if(frequencyCompare==0) return valueCompare;
            else return frequencyCompare;
        }
    }
}
