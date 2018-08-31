
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GraphRainfallChallenge {
    public static class Pair<A, B> {
        public final A fst;
        public final B snd;
        public Pair(A var1, B var2) {
            this.fst = var1;
            this.snd = var2;
        }
        public String toString() {
            return "Pair[" + this.fst + "," + this.snd + "]";
        }
        public boolean equals(Object var1) {
            return var1 instanceof Pair && Objects.equals(this.fst, ((Pair)var1).fst) && Objects.equals(this.snd, ((Pair)var1).snd);
        }
        public int hashCode() {
            if (this.fst == null) {
                return this.snd == null ? 0 : this.snd.hashCode() + 1;
            } else {
                return this.snd == null ? this.fst.hashCode() + 2 : this.fst.hashCode() * 17 + this.snd.hashCode();
            }
        }
    }
    static int[] calculate_sizes_of_basins(int[][] elevation_map) {
        Map<Integer,Integer> basinsMap =new HashMap<>();
        Map<Pair<Integer,Integer>,Integer> pairMap = new HashMap<>();
        int ROW = elevation_map.length;
        int COL = elevation_map[0].length;
        int currentBasin = 1;

        for(int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if(r==0 && c==0) {
                    currentBasin = 1;
                    basinsMap.put(1,1);
                    pairMap.put(new Pair<>(r,c),1);
                   // dfs(elevation_map,currentBasin,pairMap,basinsMap,ROW,COL,r,c);
                }
                else if(!pairMap.containsKey(new Pair<>(r,c))){
                    dfs(elevation_map,currentBasin,pairMap,basinsMap,ROW,COL,r,c);
                }

            }
        }
        int x[]={1,2};
       return x;

    }
    static void dfs(int[][] elevation_map,int currentBasin, Map<Pair<Integer,Integer>,Integer> pairMap,Map<Integer,Integer> basinsMap,
                    int ROW,int COL,int r,int c){
        Pair<Integer,Integer> currPair = getMinNeighbourPair(elevation_map,ROW,COL,r,c,pairMap);
        if(!pairMap.containsKey(currPair)){
            currentBasin++;
            basinsMap.put(currentBasin,1);
            pairMap.put(new Pair<>(r,c),currentBasin);
            dfs(elevation_map,currentBasin,pairMap,basinsMap,ROW,COL,currPair.fst,currPair.snd);
        }
        else {
            currentBasin = pairMap.get(currPair);
            basinsMap.put(currentBasin,basinsMap.get(currentBasin)+1);
            pairMap.put(new Pair<>(r,c),currentBasin);
        }

    }
    static Pair getMinNeighbourPair(int[][] elevation_map,int ROW,int COL,int r,int c,Map<Pair<Integer,Integer>,Integer> pairMap){
        int[] xval = {0,0,1,-1};
        int[] yval = {1,-1,0,0};
        int minVal = Integer.MAX_VALUE;
        Pair<Integer,Integer> minPair = new Pair<>(-1,-1);
        for(int i=0;i<xval.length;i++){
            if(isSafe(ROW,COL,r+xval[i],c+yval[i],pairMap) && minVal > elevation_map[r+xval[i]][c+yval[i]]){
               minVal = elevation_map[r+xval[i]][c+yval[i]];
               minPair = new Pair<>(r+xval[i],c+yval[i]);
            }

        }
        return minPair;
    }
    static boolean isSafe(int ROW,int COL,int r,int c,Map<Pair<Integer,Integer>,Integer> pairMap){
        return (r>=0 && c>=0 && r<ROW && c <COL );
    }
    public static void main(String args[]){
        int[][] elevation_map ={{1,0,2,5,8},
                                {2,3,4,7,9},
                                {3,5,7,8,9},
                                {1,2,5,4,3},
                                {3,3,5,2,1}};
        int x[]=calculate_sizes_of_basins(elevation_map);
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
    }
}
