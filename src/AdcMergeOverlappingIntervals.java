import java.util.ArrayList;
import java.util.Collections;

public class AdcMergeOverlappingIntervals {
     //Definition for an interval.
         public static class Interval implements Comparable<Interval>{
                    int start;
                    int end;
                    Interval() { start = 0; end = 0; }
                    Interval(int s, int e) { start = s; end = e; }
         @Override
         public int compareTo(Interval o) {
             return Integer.compare(this.start,o.start);
         }
         }
    static int[][] getMergedIntervals(int[][] inputArray) {
        ArrayList<Interval> intervals = new ArrayList<>();

        for(int i=0;i<inputArray.length;i++){
            intervals.add(new Interval(inputArray[i][0],inputArray[i][1]));
        }
        if(intervals.size() == 0){
            int[][] output =new int[intervals.size()][2];
            return output;}
        if(intervals.size() == 1){
            int[][] output =new int[intervals.size()][2];
            for(Interval iv : intervals){
                output[0][0] = iv.start;
                output[0][1] = iv.end;
            }
            return output;
        }
        Collections.sort(intervals);
        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;

        ArrayList<Interval> result = new ArrayList<Interval>();

        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(current.start <= end){
                end = Math.max(current.end, end);
            }else{
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }

        }

        result.add(new Interval(start, end));
        int i = 0;
        int[][] output1 =new int[result.size()][2];
        for(Interval iv : result){
            output1[i][0] = iv.start;
            output1[i][1] = iv.end;
            i++;
        }
        return output1;
    }
    public static void main(String args[]){
        int[][] x= {{3,4}};
        int[][] op =getMergedIntervals(x);
        for(int i=0;i<op.length;i++){
            System.out.println(op[i][0] +" , "+op[i][1]);
        }

    }


     }
