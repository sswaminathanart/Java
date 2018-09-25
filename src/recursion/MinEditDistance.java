package recursion;

public class MinEditDistance {
    public static void main(String[] args) {
        String source = "fds";
        String dest = "fjs";
        int mindist = minEditDistance(source,dest);
        System.out.println("Min operations "+ mindist );
    }
    public static int minEditDistance(String source,String dest){
        char[] sarr = source.toCharArray();
        char[] darr = dest.toCharArray();
        return minEditDistanceHelper(sarr,0,darr,0);
    }
    public static int minEditDistanceHelper(char[] sarr,int i,char[] darr,int j){
        if(i==sarr.length && j==darr.length) return 0;
        if(i==sarr.length) return darr.length-j;
        if(j==darr.length) return sarr.length-i;
        if(sarr[i] == darr[j])
            return minEditDistanceHelper(sarr,i+1,darr,j+1);
        else
            return Math.min(Math.min(minEditDistanceHelper(sarr,i,darr,j+1),
                    minEditDistanceHelper(sarr,i+1,darr,j)),
                    minEditDistanceHelper(sarr,i+1,darr,j+1))+1;

    }

}
