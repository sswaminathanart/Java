import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * The knight class provides a static main
 * method to read the dimensions of a board and
 * print a solution of the knight tour.
 *
 * See <a href="http://en.wikipedia.org/wiki/Knight%27s_tour">Wikipedia:
 * Knight's tour</a> for more information.
 *
 * The algorithm employed is similar to the standard backtracking
 * <a href="http://en.wikipedia.org/wiki/Eight_queens_puzzle">eight
 * queens algorithm</a>.
 *
 */

public class knight {
    static final int no_of_possible_moves = 8;
    // 8 possible moves of knight.
    static final  int add_row[] = {-2, -2, -1, 1, 2, 2, 1, -1};
    static final  int add_col[] = {-1, 1, 2, 2, 1, -1, -2, -2};
    static boolean is_valid_position(int rows, int cols, int new_row, int new_col)
    {
        return ((0 <= new_row) && (new_row < rows) && (0 <= new_col) && (new_col < cols));
    }
    static int find_minimum_number_of_moves(int rows, int cols, int start_row,
                                     int start_col, int end_row, int end_col) {
        // If starting and ending positions are same.
        if (start_row == end_row && start_col == end_col) {
            return 0;
        }
        Pair<Integer,Integer> start = new Pair<>(start_row,start_col);
        Pair<Integer,Integer> targer = new Pair<>(end_row,end_col);
        Map<Pair<Integer,Integer>,Integer> distance = new HashMap<>();
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        distance.put(start,0);
        ((LinkedList<Pair<Integer,Integer>>) q).add(start);
        while (!q.isEmpty()){
            Pair<Integer,Integer> curr =q.poll();
            if(curr.getKey() == end_row && curr.getValue()==end_col) {
                return distance.get(curr);
            }
            for (int i = 0; i < no_of_possible_moves; i++)
            {
                // Neighbour's position.
                int new_row = curr.getKey() + add_row[i];
                int new_col = curr.getValue() + add_col[i];
                Pair<Integer,Integer> new_pair =new Pair<>(new_row,new_col);
                if (is_valid_position(rows, cols, new_row, new_col))
                {
                    if(!distance.containsKey(new_pair)){
                        distance.put(new_pair,distance.get(curr)+1);
                        ((LinkedList<Pair<Integer,Integer>>) q).add(new_pair);
                    }
                }

            }

        }

        return -1;
    }
    /*   static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        // Write your code here.
        Pair<Integer,Integer> start = new Pair<>(start_row,start_col);
        Pair<Integer,Integer> targer = new Pair<>(end_row,end_col);
        Map<Pair<Integer,Integer>,Integer> distance = new HashMap<>();
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        ((LinkedList<Pair<Integer,Integer>>) q).add(start);
        distance.put(start,0);
        while (!q.isEmpty()){
            Pair<Integer,Integer> curr =q.poll();
            if(curr.getKey() == end_row && curr.getValue()==end_col)
                return distance.get(curr);
            for(Pair<Integer,Integer> nxt : get_neighbours(rows,cols,curr.getKey(),curr.getValue())){
                if(!distance.containsKey(nxt)){
                    distance.put(nxt,distance.get(curr)+1);
                    ((LinkedList<Pair<Integer,Integer>>) q).add(nxt);
                }
            }

        }


    return -1;
    }
    static ArrayList <Pair <Integer,Integer> > get_neighbours(int row, int cols, int i, int j){
        ArrayList <Pair <Integer,Integer> > neighbours = new ArrayList<>();
        // 8 neighbours
        if ( (0 <= i+2) && (i+2 < row) && (0 <= j+1) && (j+1 < cols)){
            neighbours.add(new Pair<Integer, Integer>(i + 2, j + 1));
        }
        if ( (0 <= i+2) && (i+2 < row) && (0 <= j-1) &&  (j-1 < cols)) {
            neighbours.add(new Pair<Integer, Integer>(i + 2, j - 1));
        }

        if ( (0 <= i+1) && (i+1 < row) && (0 <= j+2) && (j+2 < cols)) {
            neighbours.add(new Pair<Integer, Integer>(i + 1, j + 2));
        }

        if ( (0 <= i+1) && (i+1 < row) && (0 <= j-2) && (j-2 < cols)) {
            neighbours.add(new Pair<Integer, Integer>(i + 1, j - 2));
        }

        if ( (0 <= i-2) && (i-2 < row) && (0 <= j+1) && (j+1 < cols)) {
            neighbours.add(new Pair<Integer, Integer>(i - 2, j + 1));
        }

        if ( (0 <= i-2) && (i-2 < row) && (0 <= j-1) && (j-1 < cols)) {
            neighbours.add(new Pair<Integer, Integer>(i - 2, j - 1));
        }

        if ( (0 <= i-1) && (i-1 < row) && (0 <= j+2) && (j+2 < cols)) {
            neighbours.add(new Pair<Integer, Integer>(i - 1, j + 2));
        }

        if ( (0 <= i-1) && (i-1 < row) && (0 <= j-2) && (j-2 < cols)) {
            neighbours.add(new Pair<Integer, Integer>(i - 1, j - 2));
        }

        return neighbours;
    }

*/
    public static void main(String[] args) {
        int start_row = 0;
        int start_col = 0;
        int end_row = 4;
        int end_col = 1;
        int row = 5;
        int col = 5;
        int shortest_dis =find_minimum_number_of_moves(row,col,start_row,start_col,end_row,end_col);
        System.out.println("Distance "+ shortest_dis);


    }

}