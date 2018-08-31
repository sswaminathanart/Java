public class AdcDetectPrimeNumbers {
    static String detect_primes(int[] a) {
        int maxval=getMax(a);
        boolean[] isNotprime=new boolean[maxval+1];
        primefill(maxval,isNotprime);
        String retStr ="";
        for(int i=0;i<a.length;i++) retStr += (isNotprime[a[i]]) ? "0" : "1";
    return retStr;
    }
    static void primefill(int max_value,boolean[] isNotPrime){
        isNotPrime[1] = true;
        // i <= max_value is also correct but this more efficient.
        for (int i = 2; i * i <= max_value; i++)
        {
            // Using int will overflow. Consider max_value = 10^6 now start = (10^6 * 10^6) > INT_MAX!
            int start = i * i;
            if (start <= max_value)
            {
			/*
			In most of the implementations people start from j = i + i, but this will be just
			waste of time. Think when i = 5 now we can visit like 10, 15, 20, 25, 30, 35... but
			here note that 10 = 2 * 5 so when i = 2 we have already marked it, same for 15 = 3 * 5
			so when i = 3 we have already marked it! So it is same as starting from i * i. But
			directly starting from i * i will save time!
			*/
                for (int j = start; j <= max_value; j += i)
                {
                    isNotPrime[j] = true;
                }
            }
        }

    }
    static int getMax(int[] arr){
        int maxval = arr[0];
        for(int i=1;i<arr.length;i++){
            if(maxval<arr[i]) maxval=arr[i];
        }
        return maxval;
    }
    public static void main(String args[]){
        int[] x={6, 2, 5, 8};
        System.out.println(detect_primes(x));
    }
}
