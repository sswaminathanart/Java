public class Sortingintegernotamongfourbilliongivenones {
    public static final int I =8;
    public static void main(String args[]) {


        int[] x ={0,1,2,3,4,5,6};
        int missing= find_an_integer_not_among_given_integers(x);
        System.out.println("Missing Integer "+ missing);
    }
        static int find_an_integer_not_among_given_integers(int[] nos) {
            long numberOflnts = ((long) (nos.length + I));
            byte[] bitfield = new byte[(int) (numberOflnts / 8)];
            int ret_value=0;
            for(int i=0;i<nos.length;i++){
                bitfield[nos[i]/8] |= 1 << (nos[i] % 8);
            }
            for (int i = 0; i < bitfield.length; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((bitfield[i] & (1 << j)) == 0) {
                         ret_value = i * 8 + j;

                    }
                }
            }
        return ret_value;
        }
}
