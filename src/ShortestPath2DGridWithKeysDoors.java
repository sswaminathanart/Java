import javafx.util.Pair;

import java.util.*;

public class ShortestPath2DGridWithKeysDoors {

    static final int MAX_ROWS = 100;
    static final int MAX_COLS = 100;
    static final int MAX_KEYS = 10;
    private static final int add_r[] = {-1, 0, 1, 0};
    private static final int add_c[] = {0, -1, 0, 1};

    static boolean is_start(char ch) {
        return ch == '@';
    }

    static boolean is_stop(char ch) {
        return ch == '+';
    }

    static boolean is_water(char ch) {
        return ch == '#';
    }

    static boolean is_land(char ch) {
        return ch == '.';
    }

    static boolean is_key(char ch) {
        System.out.println("Key "+ch);
        return ('a' <= ch && ch < ('a' + MAX_KEYS));
    }

    static boolean is_door(char ch) {
        return ('A' <= ch && ch < ('A' + MAX_KEYS));
    }

    static boolean can_open_door(char door, int ring_of_keys) {
        System.out.println("ring_of_keys " +ring_of_keys);
        System.out.println("door " +door);
        System.out.println("Ret val "+((ring_of_keys >> (door - 'A')) & 1));
        return ((ring_of_keys >> (door - 'A')) & 1) != 0;
    }

    // node that start and stop are passed by reference hence change will be reflected.
    static Pair<Integer, Integer>  get_start_positions(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        Pair<Integer, Integer> start =null;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (is_start(grid[r].charAt(c))) {
                    start = new Pair<Integer, Integer>(r, c);
                }
            }
        }
        return start;
    }
    static Pair<Integer, Integer> get_stop_positions(String[] grid) {
        int rows = grid.length;
        Pair<Integer, Integer> stop =  null;
        int cols = grid[0].length();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (is_stop(grid[r].charAt(c))) {
                    stop = new Pair<Integer, Integer>(r, c);
                }
            }
        }
        return stop;
    }


    static List<Pair<Integer, Integer>> find_shortest_path(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        Pair<Integer, Integer> start = get_start_positions(grid);
        Pair<Integer, Integer> stop = get_stop_positions(grid);
        // Get the starting and ending point.
        //System.out.println(start.getKey()+"  "+start.getValue());
        return bsf(grid, start, stop);
    }

    static List<Pair<Integer, Integer>> bsf(String[] grid, Pair<Integer, Integer> start, Pair<Integer, Integer> target) {
        Map<Pair<Pair<Integer, Integer>,Integer>, Integer> distanceMap = new HashMap<>();
        Map<Pair<Pair<Integer, Integer>,Integer>,Pair<Pair<Integer, Integer>,Integer>>  path = new HashMap<>();
        Queue<Pair<Pair<Integer, Integer>,Integer>> q = new LinkedList<>();
        //Pair of Pair.
        //1st pair (row,col)
        //2nd pair 1st pair and key
        Pair<Pair<Integer,Integer>,Integer> startwithkey = new Pair<>(start,0);
        int rows = grid.length;
        int cols = grid[0].length();
        int new_ring_of_keys = 0;
        ((LinkedList<Pair<Pair<Integer,Integer>,Integer>>) q).add(startwithkey);
        distanceMap.put(startwithkey, 0);
        while (!q.isEmpty()) {
            Pair<Pair<Integer,Integer>,Integer> curr = q.poll();
            if (is_stop(grid[curr.getKey().getKey()].charAt(curr.getValue())))
            {
                continue;
            }
            // Visit all four neighbours and update.
            for (int i = 0; i < 4; i++) {
                int neighbour_row = curr.getKey().getKey() + add_r[i];
                int neighbour_col = curr.getKey().getValue() + add_c[i];
                Pair<Integer,Integer> neighbour = new Pair<>(neighbour_row, neighbour_col);
                Pair<Pair<Integer,Integer>,Integer> neighbourWithKey =
                        new Pair<>(neighbour,curr.getValue());
                if (neighbour_row < 0 || neighbour_row >= rows
                        || neighbour_col < 0 || neighbour_col >= cols) {
                    continue;
                }
                if (is_water(grid[neighbour_row].charAt(neighbour_col))) {
                    continue;
                } else if (is_land(grid[neighbour_row].charAt(neighbour_col)) ||
                        is_start(grid[neighbour_row].charAt(neighbour_col)) ||
                        is_stop(grid[neighbour_row].charAt(neighbour_col))) {
                    if (!distanceMap.containsKey(neighbourWithKey)) {
                        add_neighbour_to_queue(distanceMap,
                                neighbourWithKey,
                                curr,
                                path,
                                q,
                                rows,
                                cols);

                    }

                }
                else if (is_key(grid[neighbour_row].charAt(neighbour_col))) {
                    if (!distanceMap.containsKey(neighbourWithKey)) {
                        new_ring_of_keys = curr.getKey().getValue()  | (1 << (grid[neighbour_row].charAt(neighbour_col) - 'a'));
                        neighbourWithKey =new Pair<>(neighbour,new_ring_of_keys);
                        add_neighbour_to_queue(distanceMap,
                                neighbourWithKey,
                                curr,
                                path,
                                q,
                                rows,
                                cols);
                    }
                }
                else if (is_door(grid[neighbour_row].charAt(neighbour_col)))
                {
                    // Can enter only if we have key for that door.
                    if (can_open_door(grid[neighbour_row].charAt(neighbour_col), curr.getKey().getValue()))
                    {
                        if (!distanceMap.containsKey(neighbourWithKey)) {
                            add_neighbour_to_queue(distanceMap,
                                    neighbourWithKey,
                                    curr,
                                    path,
                                    q,
                                    rows,
                                    cols);
                        }
                    }
                }
            }
        }
        return build_path(grid,path, target,new_ring_of_keys);

    }

    public static void add_neighbour_to_queue(Map<Pair<Pair<Integer, Integer>,Integer>, Integer> distanceMap ,
                                              Pair<Pair<Integer,Integer>,Integer> neighbour,
                                              Pair<Pair<Integer,Integer>,Integer> curr,
                                              Map<Pair<Pair<Integer, Integer>,Integer>,Pair<Pair<Integer, Integer>,Integer>> path,
                                              Queue<Pair<Pair<Integer,Integer>,Integer>> q,
                                              int rows,
                                              int cols) {
        path.put(neighbour, curr);
        distanceMap.put(neighbour,
                    distanceMap.get(curr) + 1);

        q.add(neighbour);
    }
    public static List<Pair<Integer,Integer>> build_path(String[] grid,
            Map<Pair<Pair<Integer, Integer>,Integer>,Pair<Pair<Integer, Integer>,Integer>> path,
            Pair<Integer,Integer> dest,
            int new_ring_of_keys){
        List<Pair<Integer,Integer>>  lst = new ArrayList<>();
        Pair<Integer,Integer> cur =dest;
        Pair<Pair<Integer,Integer>,Integer> currWithPath = new Pair<>(cur,new_ring_of_keys);
        while (path.get(currWithPath)!= null){
            lst.add(0,currWithPath.getKey());
            currWithPath =path.get(currWithPath);
            if (is_door(grid[currWithPath.getKey().getKey()].charAt(currWithPath.getKey().getValue()))){
                cur = new Pair<>(currWithPath.getKey().getKey(),currWithPath.getKey().getValue());
                currWithPath = new Pair<>(cur,currWithPath.getValue()-1);
            }
        }
        lst.add(0,currWithPath.getKey());
        return lst;
    }
    public static void main(String args[]){
        String[] input ={"...B",
                         ".b#.",
                         "@#+."};

        System.out.println("Test");
        List<Pair<Integer, Integer>> output =find_shortest_path(input);
        for(Pair<Integer, Integer> par : output){
            System.out.print("("+par.getKey()+","+par.getValue()+")   ");
        }
    }
}
