import javafx.scene.layout.Priority;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class SortingNutsandBolts {
    public static void main(String args[]){
        int[] nuts = {4, 32, 5, 7};
        int[] bolts = {32, 7, 5, 4};
        String[] result=solve(nuts,bolts);
        for(String s: result){
            s.toCharArray();
            System.out.println(s);
        }
    }
    static String[] solve(int[] nuts, int[] bolts) {
        Set<String> result = new TreeSet<>();
        PriorityQueue<Integer> nutspq = new PriorityQueue<>();
        PriorityQueue<Integer> boltspq = new PriorityQueue<>();
        for(int i=0;i<nuts.length;i++){
            nutspq.add(nuts[i]);
        }
        for(int i=0;i<bolts.length;i++){
            boltspq.add(bolts[i]);
        }
        while (!nutspq.isEmpty() && !boltspq.isEmpty()){
            int n = nutspq.poll();
            int b = boltspq.poll();
            if(n==b){
                result.add(n+" "+b);
            }
            else if(n>b){
                b = boltspq.poll();
            }
            else{
                n = nutspq.poll();

            }

        }
        return result.toArray(new String[result.size()]);

    }
}
