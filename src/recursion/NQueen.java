package recursion;

public class NQueen {
    public static void main(String[] args) {
        int size = 5;
        nQueen(size);


    }
    public static boolean nQueen(int size){
        if (size ==1) return true;
        if(size==2 || size ==3 ) return false;
        int[] placementArr = new int[size];
        nQueen(placementArr,0);
        printarr(placementArr);
        return true;

    }
    public static boolean nQueen(int[] arr,int r){
        if(r== arr.length)
        return true;
        for(int c=0;c<arr.length;c++){
            arr[r] = c;
            if(isSafe(arr,r) && nQueen(arr,r+1)) return true;
        }
        return false;
    }

    public static boolean isSafe(int[] arr,int r2){
        for(int r1=0;r1<r2;r1++){
            if(arr[r1]==arr[r2]) return false;
            if(Math.abs(arr[r1]-arr[r2])==r2-r1) return false;
        }
        return true;
    }
    public static void printarr(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i]==j) System.out.print("q");
                else System.out.print("-");
            }
            System.out.println();
        }
    }
}
