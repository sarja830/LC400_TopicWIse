package DP_2d;
import java.util.*;
public class MinimumPathSum64 {
    public static void main(String[] args) {
        MinimumPathSum64 a = new MinimumPathSum64();
        a.minPathSum(new int[][]{});
    }

    int[][] ans;
    int[][] g;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ans = new int[m][n];
        for(int[] a:ans)
            Arrays.fill(a,-1);
        this.g=grid;

        return rec(m-1,n-1);
    }
    int rec(int i, int j)
    {

        if(i<0 || j<0 ) return 100000000;
        if(i==0 && j==0) return g[i][j];
        if(ans[i][j]!=-1) return ans[i][j];
        else
        {
            int up= rec(i,j-1)+g[i][j];
            int left = rec(i-1,j)+g[i][j];
            ans[i][j]= Math.min(up,left);
            return ans[i][j];
        }
    }

}
