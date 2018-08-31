public class AdcLeftRotation {
    static int[] rotLeft(int[] a, int d) {
        int modofd = d % a.length;
        int[] temp = new int[modofd];
        for(int  j=0;j<temp.length;j++){
            temp[j]=a[j];
        }
        for(int i=0;i<a.length-modofd;i++){
            a[i] = a[i+modofd];
        }
        for(int i=(a.length-modofd),j=0;j<modofd && i<a.length;i++,j++){
            a[i]=temp[j];
        }
        return a;
    }
    public static void main(String args[]){
        int[] a ={1,2,3,4,5};
        int[] result = rotLeft(a,4);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
