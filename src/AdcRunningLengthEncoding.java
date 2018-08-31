public class AdcRunningLengthEncoding {
    static String RLE(String s) {
        if(s.length()==1) return s;
        int count = 1;
        int mark=0;
        StringBuilder builder = new StringBuilder();

        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1) && i<s.length()-1){
                count++;
            }
            else if(i==s.length()-1 && s.charAt(i)==s.charAt(i-1)){
                count++;
                builder.append(count);
                builder.append(s.charAt(mark));
                count=1;
                mark=i;
            }
            else{
                if(count !=1){
                    builder.append(count);}
                builder.append(s.charAt(mark));
                count=1;
                mark=i;
            }
        }
        if(mark==s.length()-1&&count==1){
            builder.append(s.charAt(mark));
        }
        return builder.toString();
    }
    public static void main(String args[]){
        System.out.println(RLE("xyz"));
    }
}
