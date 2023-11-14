## DP on lcs based pattern string comparison


#### 583. Delete Operation for Two Strings 
```java

```
#### 115. Distinct Subsequences
```java
class Solution {
    
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] ans = new int[m+1][n+1];
        // for(int[] a:ans)
        //     Arrays.fill(a,-1);
        // return rec(s, t, s.length(), t.length(),ans);
        
        
        for(int i=0;i<=m;i++)
            ans[i][0] = 1;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
                if(s.charAt(i-1)==t.charAt(j-1))
                    ans[i][j] = ans[i-1][j-1] + ans[i-1][j];
                else
                    ans[i][j] = ans[i-1][j];
        return ans[m][n];
    }
    public int rec(String s, String t, int i, int j,int[][] ans)
    {
            if(j==0) return 1;
            if(i==0) return 0;

            if(ans[i][j]!=-1)
                return ans[i][j];
            if(s.charAt(i-1)==t.charAt(j-1))
                ans[i][j] = rec(s,t,i-1,j-1,ans)+rec(s,t,i-1,j,ans);
            else
                ans[i][j] = rec(s,t,i-1,j,ans);
            return ans[i][j];
    }
}
```