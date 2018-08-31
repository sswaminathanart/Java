public class DPMinimumEditDistance {
    public static void main(String args[]){
        String a="abhr";
        String b ="arhb";
        int noOfOps = minEditDistance(a,b);
        System.out.println("Min Operations "+ noOfOps);
    }
    public static int minEditDistance(String strWord1,String strWord2){
        int[][] dpTable = new int[strWord1.length()+1][strWord2.length()+1];
        for(int i=0;i<=strWord1.length();i++){
            dpTable[i][0] = i;
        }
        for(int j=0;j<=strWord2.length();j++){
            dpTable[0][j] = j;
        }
        for(int i=1;i<=strWord1.length();i++){
            for(int j=1;j<=strWord2.length();j++){
                if(strWord1.charAt(i-1)==strWord2.charAt(j-1)){
                    dpTable[i][j] = dpTable[i-1][j-1];
                }
                else{
                    dpTable[i][j] = 1 + Math.min(Math.min(dpTable[i][j-1],
                                                dpTable[i-1][j]),
                                                dpTable[i-1][j-1]);
                }
            }
        }
        return dpTable[strWord1.length()][strWord2.length()];
    }
}
