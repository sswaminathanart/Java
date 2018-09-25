package dynamicprograming;

public class MaxPath {
    static int[][] arr ={{5,10,20,30},
            {35,4,25,15},
            {92,80,61,72},
            {12,16,70,2},
            {8,18,41,3}};
    static int ROW = arr.length;
    static int COL = arr[0].length;
    public static void main(String[] args){
        int max_value = recursion_maxpath(0,0);
        System.out.println("Max = "+max_value);
        max_value = dp_maxpath();
        System.out.println("DP Max = "+max_value);
    }
    public static int recursion_maxpath(int r,int c){
        if(r >= ROW || c>=COL) return 0;
        if(r == ROW-1 && c == COL-1) return arr[r][c];
        return arr[r][c] + Integer.max(recursion_maxpath(r,c+1),
                            recursion_maxpath(r+1,c));
    }
    public static int dp_maxpath(){
        int[][] dp_table = new int[ROW+1][COL+1];
        for(int r=0;r<=ROW;r++){
            dp_table[r][COL] = 0;
        }
        for(int c=0;c<=COL;c++){
            dp_table[ROW][c] = 0;
        }
        dp_table[ROW-1][COL-1] = arr[ROW-1][COL-1];
        for(int r=ROW-1;r>=0;r--){
            for(int c=COL-1;c>=0;c--){
                dp_table[r][c] = arr[r][c] + Integer.max(dp_table[r][c+1],
                                                        dp_table[r+1][c]);
            }
        }
        recover_path(dp_table);
        return dp_table[0][0];
    }
    public static void recover_path(int[][] dpTable){
        System.out.println("DP table row 0 and col 0 "+arr[0][0]);
        int r=0,c=0;
        while(r< dpTable.length-2 || c< dpTable[0].length-2){
            if (dpTable[r][c + 1] > dpTable[r + 1][c]) {
                System.out.println("DP table row " + r + " and col " + (c + 1) + " " + arr[r][c + 1]);
                c++;
            } else {
                System.out.println("DP table row " + (r + 1) + " and col " + c + " " + arr[r + 1][c]);
                r++;
            }
        }
    }
}
