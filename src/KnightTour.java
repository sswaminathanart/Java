import javafx.util.Pair;

import java.util.*;
public class KnightTour{

    public static void main(String args[]){
        int rows = 5;
        int cols = 5;
        int start_row = 0;
        int start_col = 0;
        int end_row = 4;
        int end_col = 1;
        int minmove = find_min_move(rows,cols,start_row,start_col,end_row,end_col);
        System.out.println(minmove);

    }
    public static boolean isValid(int rows,int cols,int row,int col){
        return (row >= 0 && col >= 0 && row<rows && col <cols);
    }

    public static int find_min_move(int rows,int cols,int start_row,int start_col,int end_row,int end_col){
        int[] add_row = {2,2,1,1,-2,-2,-1,-1};
        int[] add_col = {1,-1,2,-2,1,-1,2,-2};
        int SIZE = 8;
        Pair<Integer,Integer> start = new Pair<>(start_row,start_col);
        Queue<Pair<Integer,Integer>> q  = new LinkedList<>();
        Map<Pair<Integer,Integer>,Integer> seen = new HashMap<>();
        q.add(start);
        seen.put(start,0);
        while(!q.isEmpty()){
            Pair<Integer,Integer> curr = q.poll();
            if(curr.getKey() == end_row && curr.getValue() ==  end_col){
                return seen.get(curr);
            }
            for(int i=0;i<8;i++){
                int nei_row = curr.getKey() + add_row[i];
                int nei_col = curr.getValue() + add_col[i];
                Pair<Integer,Integer> nei = new Pair<>(nei_row,nei_col);
                if(!seen.containsKey(nei) && isValid(rows,cols,nei_row,nei_col)){
                    seen.put(nei,seen.get(curr)+1);
                    q.add(nei);
                }
            }
        }
        return -1;
    }
}