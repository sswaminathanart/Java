public class DPMaxPath {
    static int[][] arr ={{5,10,20,30},
                         {35,4,25,15},
                          {92,80,61,72},
                          {12,16,70,2},
                          {8,18,41,3}};
    static int[][] arr2 = {
            {5,10,80},
            {20,35,2},
            {4,6,1},
            {22,32,30}};
    public static void main(String args[]){

       int max_val = find_max_path_main();
       System.out.println("MAX VALUE "+ max_val);
       max_val = dp_find_max_path();
       System.out.println("MAX VALUE "+ max_val);
    }
    public static int dp_find_max_path(){
        int[][] dpTable = new int[arr2.length+1][arr2[0].length+1];
        for(int i=0;i<dpTable.length;i++){
            dpTable[i][arr2[0].length] = 0;
        }
        for(int i=0;i<dpTable[0].length;i++){
            dpTable[arr2.length][i] = 0;
        }
        for(int i=dpTable.length-2;i>=0;i--){
            for(int j=dpTable[0].length-2;j>=0;j--){
                dpTable[i][j] = arr2[i][j] + Integer.max(dpTable[i][j+1],
                                                        dpTable[i+1][j]);
            }
        }
        recover_path(dpTable);
        return dpTable[0][0];
    }
    public static void recover_path(int[][] dpTable){
        System.out.println("DP table row 0 and col 0 "+arr2[0][0]);
        int r = 0,c = 0;
        while (r< dpTable.length-2 || c < dpTable[0].length-2) {
            if (dpTable[r][c + 1] > dpTable[r + 1][c]) {
                System.out.println("DP table row " + r + " and col " + (c + 1) + " " + arr2[r][c + 1]);
                c++;
            } else {
                System.out.println("DP table row " + (r + 1) + " and col " + c + " " + arr2[r + 1][c]);
                r++;
            }
        }

    }
    public static int find_max_path_main(){
        return find_max_path(0,0);
    }
    public static int find_max_path(int row,int col){
        //Base Case

        if(row>=arr.length || col >= arr[0].length){
            return 0;
        }
        if(row == arr.length-1 && col == arr[0].length-1 ){
            return arr[row][col];
        }
         return arr[row][col] + Integer.max(find_max_path(row,col+1),
                                            find_max_path(row+1,col));
    }


}
