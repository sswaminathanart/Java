public class CountNoIsland {
    public static void main(String args[]) {
        int[][] arr = {
                {1, 0, 1, 0},
                {0, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}};
    int islandcount = count_island(arr);
    System.out.println("Island Count "+islandcount);
    }
    public static int count_island(int [][] arr){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j] == 1){
                    count++;
                    get_neighbors(arr,i,j,arr.length,arr[i].length);
                }
            }

        }
        return count;
    }
    public static void get_neighbors(int[][] arr,int row,int col,int rowlen,int collen){
        if(row>=rowlen || row < 0 || col >= collen || col<0 || arr[row] [col] ==0)  return;
        arr[row][col] = 0;
        get_neighbors(arr,row+1,col,rowlen,collen);
        get_neighbors(arr,row-1,col,rowlen,collen);
        get_neighbors(arr,row,col+1,rowlen,collen);
        get_neighbors(arr,row,col-1,rowlen,collen);
        get_neighbors(arr,row+1,col+1,rowlen,collen);
        get_neighbors(arr,row-1,col-1,rowlen,collen);
    }
}
