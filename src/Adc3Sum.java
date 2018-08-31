import java.util.Set;
import java.util.TreeSet;

public class Adc3Sum {
    public static void main(String args[]){
        int SIZE = 5;
        int[] x = {93,
                22,
                -71,
                -32,
                26,
                -80,
                -1,
                -24,
                45,
                53,
                20,
                -20,
                26,
                25,
                -13,
                -11,
                45,
                27,
                50,
                -21,
                49,
                -55,
                -33,
                -40,
                28,
                21,
                -68,
                -4,
                16,
                35,
                -3,
                -44,
                -16,
                -48,
                -8,
                -80,
                -42,
                -66,
                61,
                -51,
                -20,
                2,
                65,
                -5,
                -7,
                22,
                -6,
                12,
                -49,
                13,
                -80,
                49,
                39,
                -9,
                3,
                41,
                25,
                0,
                -25,
                -16,
                -33,
                21,
                13,
                -17,
                40,
                43,
                -15,
                -29,
                24,
                -1,
                -34,
                -41,
                -28,
                -14,
                34,
                -9,
                -78,
                0,
                -7,
                -31,
                9,
                44,
                47,
                -17,
                -29,
                40,
                -57,
                -20,
                -38,
                -21,
                -13,
                -4,
                -28,
                11};
        String[] result =findZeroSum(x);
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
        for(String s: result){
            System.out.println(s);
        }
    }
    static String[] findZeroSum(int[] arr) {
        Set<String> result = new TreeSet<>();
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            int next = i+1;
            int last = arr.length-1;
            while (next<last){
                int sum3 = arr[i]+arr[next]+arr[last];
                if(sum3==0){
                    result.add(arr[i]+","+arr[next]+","+arr[last]);
                    next++;
                    last--;
                }
                else if(sum3>0){
                    last--;
                }
                else {
                    next++;
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
    static void quickSort(int[] arr,int start,int end){
        if (start>= end) return;
        int pivot =chosePivot(start,end);
        int p = partition(arr,start,end,pivot);
        quickSort(arr,start,p-1);
        quickSort(arr,p+1,end);
    }
    static int chosePivot(int start,int end){
        return start;
    }
    static int partition(int[] arr,int start,int end,int pi){
        swap(arr,end,pi);
        int i = start;
        for(int curr=start;curr<end;curr++){
            if(arr[curr]<arr[end]){
                swap(arr,i,curr);
                i++;
            }
        }
        swap(arr,i,end);
        return i;

    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
