public class GraphMaxRegion {
    public static void main (String[] args) throws java.lang.Exception
    {
        int M[][]=  new int[][]
                        {{1, 1, 1, 1, 0},
                         {0, 1, 1, 1, 1},
                         {1, 0, 0, 1, 1},
                         {0, 0, 0, 0, 0},
                         {1, 0, 1, 0, 1}
                };
        System.out.println("Number of islands is: "+ maxIslands(M));
    }
    public static boolean isSafe(int[][] M,int ROW,int COL,int r,int c,boolean[][] visited){
        return (
                r>=0 && c>=0&&
                r<ROW && c<COL &&
                !visited[r][c] &&
                        M[r][c]==1);
    }
    public static int dfs(int[][] M,int ROW,int COL,int r,int c,boolean[][] visited) {
        visited[r][c] = true;
        int[] rVal = {-1,-1,-1,0,0,1,1,1};
        int[] cVal = {-1,0,1,-1,1,-1,0,1};
        int count = 1;
        for(int i=0;i<rVal.length;i++){
            if(isSafe(M,ROW,COL,r+rVal[i],c+cVal[i],visited)) {
                count +=dfs(M,ROW,COL,r+rVal[i],c+cVal[i],visited);
            }
        }
        return count;
    }


        public static int maxIslands(int[][] M){
        int count = 0;
        int maxCount =0;
        int ROW = M.length;
        int COL = M[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        for(int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if(!visited[r][c]) {
                    count = dfs(M, ROW, COL, r, c, visited);
                    maxCount = Math.max(count, maxCount);
                }
            }
        }
        return maxCount;
    }
}
