package BitWise;

public class SetKthbitofGivenNumber {
    public static void main(String[] args) {
        System.out.println(setKthBit(10,2));
    }
    public static int setKthBit(int n,int k){
        return (1<<k|n);
    }
}
