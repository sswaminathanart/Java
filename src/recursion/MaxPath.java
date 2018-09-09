package recursion;

public class MaxPath {
    public static void main(String args[]){
        int[][] x = new int[5][5];
        System.out.println("MaxPath " +maxpath(x,0,0));
    }
    public static int maxpath(int[][] arr,int r,int c){
        int ROW = arr.length;
        int COL = arr[0].length;
        if(r < 0 || c < 0 || r>= ROW || c >= COL){
            return 0;
        }
        if(r == ROW-1 && c == COL-1) return 1;
        return maxpath(arr,r+1,c) + maxpath(arr,r,c+1);
    }
}
