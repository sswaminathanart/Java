public class GraphIslands {
    public static void main (String[] args) throws java.lang.Exception
    {
        int M[][]=  new int[][]
                {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("Number of islands is: "+ countIslands(M));
    }
    public static int countIslands(int[][] M){
        int len = M.length;
        int count = 0;
        boolean[][] visited = new boolean[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(!visited[i][j] && M[i][j] ==1){
                    DFS(M,len,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void DFS(int[][] M,int len,boolean[][] visited,int i,int j){
        int[] rowarr = {-1,-1,-1,0,0,1,1,1};
        int[] colarr = {-1,1,0,1,-1,-1,1,0};
        visited[i][j] = true;
        for(int k=0;k<8;k++){
            if(isSafe(M,len,len,(i+rowarr[k]),(j+colarr[k]),visited)){
                DFS(M,len,visited,(i+rowarr[k]),(j+colarr[k]));

            }
        }
    }
    public static boolean isSafe(int[][] M,int row,int col,int i,int j,boolean[][] visited){
        return (i>=0 && j>=0 && i<row && j<col && !visited[i][j] && M[i][j]==1 );
    }


}

