public class StringRabinKarpSearch {
    public static final int PRIME =101;
    public static int subStringMatch(String s,String p){
        int plen = p.length();
        int slen = s.length();

        int sHash = calculateHash(s.toCharArray(),plen);
        int pHash = calculateHash(p.toCharArray(),plen);
        for(int i=1;i<slen-plen;i++){
            if((sHash == pHash) &&
                    (charByCharCheck(s.toCharArray(),i-1,i+plen-2,p.toCharArray(),0,plen-1))){
                return i-1;
            }
            else{
                if(i+plen-1 < slen)
                sHash = recalculateHash(s.toCharArray(),i-1,i+plen-1,sHash,plen);
            }

        }
        return -1;
    }
    public static int calculateHash(char[] charr,int len){
        int hash=0;
        for(int i=0;i<len;i++){
            hash += charr[i] * Math.pow(PRIME,i);
        }
        return hash;
    }
    public static int recalculateHash(char[] charr,int oldidx
                                      ,int newidx,int oldhash,int len){
        int hash = oldhash - charr[oldidx];
        hash = hash/PRIME;
        hash += charr[newidx] * Math.pow(PRIME,len-1);
        return hash;
    }
    public static boolean charByCharCheck(char[] s,int sstart,int send,char[] p,int pstart,int pend){
        if((send-sstart)!=(pend-pstart)){
            return false;
        }
        else{
            while (sstart<send && pstart<pend){
                if(s[sstart]!=p[pstart]) return false;
                sstart++;
                pstart++;
            }
            return true;
        }
    }
    public static void main(String args[]){
        String s =  "Hello How Are You";
        String p = "Are";
        int x = subStringMatch(s,p);
        if (x!=-1)
        System.out.println("Matched and Matched at "+x);
    }
}
