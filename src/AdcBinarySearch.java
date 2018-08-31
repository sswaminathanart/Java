public class AdcBinarySearch {
    public static void main(String args[]){
        int[] x ={1,2,3,4,5};
        boolean b = binarySearch(x,14,0,x.length-1);
        if(b) System.out.println("Found");
        else
            System.out.println("Not Found");
    }
    public static boolean binarySearch(int[] arr,int x,int start,int end){
        if(start>end) return false;
        int mid = start +(end-start)/2;
        if(arr[mid]== x) return true;
        if(arr[mid]> x) return binarySearch(arr,x,start,mid-1);
        else return binarySearch(arr,x,mid+1,end);

    }
}
