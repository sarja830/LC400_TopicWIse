package DP_LCS_BASE;

public class lcs {
    public static void main(String[] args) {
        findLCS(  8 ,8, "aaaabbbb", "babababa");

//        findLCS(3,3,"abc","xyz");
    }
        public static String findLCS(int m1, int n1, String text1, String text2){

            int m = text1.length(), n = text2.length();
            int[][] ans = new int[m+1][n+1];
            for(int i=1;i<=m;i++)
                for(int j=1;j<=n;j++)
                    if(text1.charAt(i-1)==text2.charAt(j-1))
                        ans[i][j] = ans[i-1][j-1] + 1;
                    else
                        ans[i][j] = Math.max(ans[i-1][j],ans[i][j-1]);

            int i=m,j=n;
            String res = "";
            while(i>=1 && j>=1)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    res = text1.charAt(i-1)+res;
                    i--;
                    j--;
                }
                else
                {
                    if(ans[i-1][j]>ans[i][j-1])
                        i--;
                    else
                        j--;
                }
            }
            return res;
        }

}
