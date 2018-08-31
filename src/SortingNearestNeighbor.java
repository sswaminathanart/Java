import java.util.*;

public class SortingNearestNeighbor {
    public static void main(String args[]){
        System.out.println("Hello");
    }
    public static int distance(Point p1,Point p2){
        return (p1.x-p2.x) * (p1.x-p2.x) + (p1.y-p2.y) * (p1.y - p2.y);
    }
    static int[][] find_nearest_neighbours(int px, int py, int[][] n_points, int k) {
       Point center = new Point(px,py);
       List<Point> list_n_points = new ArrayList<>();
       for(int i=0;i<n_points.length;i++){
           list_n_points.add(new Point(n_points[i][0],n_points[i][1]));
       }
        List<Point> ans = nearestKPoint_1(list_n_points,center,k);
       int[][] result = new int[ans.size()][2];
       int i=0;
       for(Point p : ans){
           result[i][0]=p.x;
           result[i][1]=p.y;
           i++;
       }
       return  result;

    }



    private static List<Point> nearestKPoint_1(List<Point> list, final Point center, int k) {
        List<Point> ans = new ArrayList<>();
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>( new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return distance(center, o2) - distance(center, o1);
            }
        });
        for (Point p : list) {
            maxHeap.add(p);
        }
        int i=0;
        while (i<k) {
            ans.add(maxHeap.poll());
        }
        return ans;
    }

}

class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}