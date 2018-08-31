public class RecursionMaxPath {
    public static final int SIZE = 3;
    public static void main(String args[]){
        int[][] path = new int[SIZE][SIZE];
        int noofPath = maxpath(path);
        System.out.println("Max Path is "+ noofPath);
    }
    public static int maxpath(int[][] M){
        return maxpathUtil(M,0,0);
    }
    public static int maxpathUtil(int[][] M,int r,int c){
        int ROW = M.length;
        int COL = M[0].length;
        if(r>=ROW) return 0;
        if(c>=COL) return 0;
        if(r == ROW-1 && c == COL-1) return 1;
        return maxpathUtil(M,r+1,c) + maxpathUtil(M,r,c+1);
    }
}
