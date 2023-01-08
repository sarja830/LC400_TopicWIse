package DP_LCS_BASE;

public class EditDistance72 {
    public static void main(String[] args) {
        minDistance("horse","ros");
    }
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] ans = new int[m+1][n+1];

        // base cases:
        //lets say if word1 is of length m and word 2 is of length n
        // CASE 1: if m==0 then to make word1 to word2 you need to insert n characters; hencen operations
        // CASE 2: if n==0 then to make word1 to word2 you need to delete m characters; hence m operations
        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++)
            {
                // base case 1
                if(i==0)  ans[i][j]=j;

                // base case 2
                if(j==0)  ans[i][j]=i;
            }
        ans[0][0]=0;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                // if matching char no need to perform any operations
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    ans[i][j] = 0+ans[i-1][j-1];
                else
                {
                    // insert: insert in word1 which means i remains same j-1 since last added char in word1 matches last char in j (+1 since insert operation done)
                    // or
                    //  delete: delete in word1 which means i become i-1 and j remains same (+1 since delete operation done)
                    // or
                    //  replace: replace last char of word1 with last char of word2 which mean i-1 and j-1 (+1 since replace operation done)
                    int min = Math.min(ans[i][j-1]+1,ans[i-1][j]+1);
                    ans[i][j]=Math.min(min,ans[i-1][j-1]+1);
                }
            }

        return  ans[m][n];

    }
}
