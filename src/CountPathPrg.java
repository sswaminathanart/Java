public class CountPathPrg {
    public static int countPath(int[][] arr){
        return countPathHelper(arr,0,0);
    }
    public static int countPathHelper(int[][] arr,int r,int c){
        if(r==arr.length-1 && c== arr[0].length-1){
            return 1;
        }
        if(r>=arr.length || c >= arr[0].length)
            return 0;
        return countPathHelper(arr,r,c+1) + countPathHelper(arr,r+1,c);
    }
    public static void main(String args[]){
        int[][] x={{1,2,3},
                {4,5,6},
                {7,8,9}};
        int k = countPath(x);
        System.out.print(k);
    }
}
