public class DPLongestCommonSubsequence {
    public static void main(String args[]) {
        String a = "bcc";
        String b = "bbca";
        String ss = longestCommonSubsequence(a, b);
        System.out.println("Length of Longest Common Subsequence of "+a+" and "+b+" is "+ss );
    }
    public static String longestCommonSubsequence(String strX,String strY){
        int[][] dpTable = new int[strX.length()+1][strY.length()+1];
        for(int i=1;i<=strX.length();i++){
            for(int j=1;j<=strY.length();j++){
                dpTable[i][j] = Integer.max(
                        dpTable[i-1][j],
                        dpTable[i][j-1]);
                if(strX.charAt(i-1)==strY.charAt(j-1))
                    dpTable[i][j] = Integer.max(dpTable[i-1][j-1] + 1,dpTable[i][j]);

            }
        }
        // Following code is used to print LCS
        int m=strX.length();
        int n = strY.length();
        int index = dpTable[m][n];
        int temp = index;

        // Create a character array to store the lcs string
        char[] lcs = new char[index+1];
        lcs[index] = ' '; // Set the terminating character

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m, j = n;
        while (i > 0 && j > 0)
        {
            // If current character in X[] and Y are same, then
            // current character is part of LCS
            if (strX.charAt(i-1) == strY.charAt(j-1))
            {
                // Put current character in result
                lcs[index-1] = strX.charAt(i-1);

                // reduce values of i, j and index
                i--;
                j--;
                index--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (dpTable[i-1][j] > dpTable[i][j-1])
                i--;
            else
                j--;
        }
        return new String(lcs);
    }

}
