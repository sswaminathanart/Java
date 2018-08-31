public class DPNumberofPathsinMatrix {
    static int numberOfPaths(int[][] a) {
        int r = a.length, c = a[0].length;
        int[][] s = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(a[i][j] ==0)
                    s[i][j] = 1;
                else
                    s[i][j] = 1;

            }
        }
        return uniquePathsWithObstacles(s);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length, c = obstacleGrid[0].length;
        int[][] s = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(obstacleGrid[i][j] == 1)
                    s[i][j] = 0;
                else {
                    if(i == 0 && j == 0)
                        s[i][j] = 1;
                    else if (i == 0)
                        s[i][j] = s[i][j - 1];
                    else if (j == 0)
                        s[i][j] = s[i - 1][j];
                    else
                        s[i][j] = s[i - 1][j] + s[i][j - 1];
                }
            }
        }
        return s[r - 1][c - 1];
    }



    public static void main(String args[]){
        int[][] a ={
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}
        };
        int paths =uniquePathsWithObstacles(a);
        System.out.println("No of Paths "+ paths);
    }
}
