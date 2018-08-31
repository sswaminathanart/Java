import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GraphKnightTour {
    public static void main(String args[]) {
        int minDistance = knightTour(0, 0, 6, 6);
        System.out.println(minDistance);
    }
    public static int knightTour(int sr,int sc,int er,int ec){
        Pair<Integer,Integer> spair = new Pair<>(sr,sc);
        Pair<Integer,Integer> epair = new Pair<>(er,ec);
        return bfs(spair,epair);
    }
    public static int bfs(Pair<Integer,Integer> spair,Pair<Integer,Integer> epair){
        Queue<Pair> queue = new LinkedList<>();
        Map<Pair,Integer> distance = new HashMap<>();
        ((LinkedList<Pair>) queue).add(spair);
        int[] rval = {2,2,-2,-2,1,1,-1,-1};
        int[] cval = {1,-1,1,-1,2,-2,2,-2};
        distance.put(spair,0);
        while (!queue.isEmpty()){
            Pair<Integer,Integer> curr = queue.poll();
            if(curr.getKey()==epair.getKey() && curr.getValue() == epair.getValue()){
                return distance.get(curr);
            }
            for(int i=0;i<rval.length;i++){
                int row = curr.getKey()+rval[i];
                int col = curr.getValue() + cval[i];
                if(isSafe(row,col)){
                    Pair<Integer,Integer> nei = new Pair<>(row,col);
                    if(!distance.containsKey(nei)) {
                        ((LinkedList<Pair>) queue).add(nei);
                        distance.put(nei, distance.get(curr) + 1);
                    }
                }
            }

        }
        return -1;
    }
    public static boolean isSafe(int row,int col){
        return (row>=0 && col>=0 && row< 8 && col <8);
    }
}
