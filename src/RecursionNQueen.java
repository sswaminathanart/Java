import java.util.Map;

public class RecursionNQueen {
    public static void main(String args[]){
        int sizeOfchessboard = 6;
        nQueen(sizeOfchessboard);
    }
    public static boolean nQueen(int n){
        if (n==1){
            System.out.println("q");
            return true;
        }
        if(n<4){
            System.out.println("Not possible to Place "+n +" Queens of Size "+ n +" chessboard");
            return false;
        }
        int[] placementArr = new int[n];
        nQueen(placementArr,0);
        printQueens(placementArr);
        return true;
    }
    static boolean nQueen(int[] placementArr,int r){
        int n = placementArr.length;
        if(r==n) {

            return true;
        }
        for(int c=0;c<n;c++){
            placementArr[r] = c;
            if(isSafe(placementArr,r) && nQueen(placementArr,r+1))
                return true;
        }
        return false;
    }
    public static boolean isSafe(int[] q, int r2) {
        for (int r1 = 0; r1 < r2; r1++) {
            if (q[r1] == q[r2])             return false;   // same column
            if (Math.abs(q[r1] - q[r2]) == (r2 - r1)) return false;   // same major diagonal
            // same minor diagonal
        }
        return true;
    }

    public static void printQueens(int[] q) {
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j) {
                    System.out.print("q");
                }
                else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
