import java.rmi.MarshalledObject;
import java.util.*;

public class AdcSkyline {
    static class Building implements Comparable<Building>{
        int x;
        int height;
        boolean isStart;
        Building(int x,int h,boolean b){
            this.x = x;
            height = h;
            isStart = b;
        }

        @Override
        public int compareTo(Building other) {
            if(this.x != other.x) return Integer.compare(this.x,other.x);
           return  ((this.isStart)? -this.height:this.height)-((other.isStart)?-other.height:other.height);
        }
    }
    static int[][] find_skyline(int[][] buildings) {
        Map<Integer, Integer> heightandCount = new TreeMap<>();
        List<Building> buildingList = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        for(int[]building : buildings){
            Building b = new Building(building[0],building[1],true);
            buildingList.add(b);
            b = new Building(building[2],building[1],false);
        }
        Collections.sort(buildingList);
        heightandCount.put(0,1);
        int maxHeight = 0;
        for(Building building : buildingList){
            if(building.isStart) {
                heightandCount.compute(building.height,(key,value)->
                        {
                            if (value != null) return value + 1;
                            else return 1;
                        }
                );
            }
            else {
                heightandCount.compute(building.height,(key,value) ->
                {
                   if(value==1)return null;
                   else return value-1;
                });
            }
            int preMaxHeight = ((TreeMap<Integer, Integer>) heightandCount).lastKey();
            if(preMaxHeight!= maxHeight){
                result.add(new int[]{building.x,building.height});
                 maxHeight = preMaxHeight;
            }

        }
        return result.toArray(new int[result.size()][2]);

    }
    public static void main(String args[]) {
        int [][] buildings = {{1,4,3},{3,4,4},{2,2,6},{8,4,11}, {7,3,9},{10,2,11}};
        int[][] criticalPoints = find_skyline(buildings);

    }
}
