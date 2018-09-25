package recursion;

public class RegExp {
    public static void main(String[] args) {
        String s = "abcdz";
        String p = "a**dz";
        boolean b = regExpMatch(s,p);
        System.out.println(b);
    }
    public static boolean regExpMatch(String s,String p){
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();
        return regExpMatchHelper(sarr,0,parr,0);
    }
    public static boolean regExpMatchHelper(char[] sarr,int i,char[] parr,int j){
        //base Case
        if(j==parr.length) return i==sarr.length;
        if(i==sarr.length && j != parr.length ){
            boolean allStart = true;
            for(int k=j;k<parr.length;k++){
                if(parr[k]!='*' && allStart) allStart = false;
            }
            return allStart;
        }
        if(parr[j]=='*' && j != parr.length && i==sarr.length){
            return false;
        }
        if(parr[j]=='?'||parr[j]==sarr[i])
            return regExpMatchHelper(sarr,i+1,parr,j+1);
        if(parr[j]=='*')
        {
            return regExpMatchHelper(sarr,i,parr,j+1)
                    || regExpMatchHelper(sarr,i+1,parr,j);
        }
        return false;
    }
}
