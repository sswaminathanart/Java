import java.util.Map;

public class DPRobbery {
    public static void main(String args[]){
        int[] houseValue ={6, 1, 2, 7};
        int total=maxRobery(houseValue);
        System.out.println("Total robbery"+ total);
    }
    public static int maxRobery(int[] houseValue){
        if (houseValue.length==0) return 0;
        int[] dpTable = new int[houseValue.length];
        dpTable[0] = houseValue[0];
        dpTable[1] = Math.max(houseValue[0],houseValue[1]);
        for(int i=2;i<houseValue.length;i++){
            dpTable[i] =Math.max(houseValue[i]+dpTable[i-2],dpTable[i-1]);
        }
        return dpTable[houseValue.length-1];
    }
}
