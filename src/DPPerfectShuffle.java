public class DPPerfectShuffle {
    public static void main(String args[]) {
        String a = "abc";//"bcc";
        String b = "xyz";//"bbca";
        String c = "abcxyz";//"bbcbcac";
        boolean check = isPerfectShuffle(a, b, c);
        String ss=(check)?"perfet shffle":" Not a perfect Shffle";
        System.out.println(c +" is a "+ ss+ " of "+a+" and "+b);
    }
    public static boolean isPerfectShuffle(String a,String b,String c){
        boolean[][] pf = new boolean[a.length()+1][b.length()+1];
        pf[0][0] = true;
        for(int ai=1;ai<=a.length();ai++){
            pf[ai][0] = pf[ai-1][0] && a.charAt(ai-1)==c.charAt(ai-1);
        }
        for(int bi=1;bi<=a.length();bi++){
            pf[0][bi] = pf[0][bi-1] && b.charAt(bi-1)==c.charAt(bi-1);
        }
        for(int bi=1;bi<=b.length();bi++){
            for(int ai=1;ai<=a.length();ai++){
                pf[ai][bi] = (ai >0 && pf[ai-1][bi] && a.charAt(ai-1)==c.charAt(ai+bi-1))
                        || (bi>0 && pf[ai][bi-1] && b.charAt(bi-1)==c.charAt(ai+bi-1));

            }
        }
        return pf[a.length()][b.length()];
    }
}
