package DP_2d;

import java.util.Arrays;

public class UniquePathsII63 {
    public static void main(String[] args) {
        UniquePathsII63 a= new UniquePathsII63();
        a.uniquePathsWithObstacles(new int[][]{});
    }

    int[][] ans;
    int[][] g;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        ans = new int[m][n];
        for(int[] a:ans)
            Arrays.fill(a,-1);
        this.g=obstacleGrid;

        return rec(m-1,n-1);
    }
    int rec(int i, int j)
    {

        if(i<0 || j<0 || g[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(ans[i][j]!=-1) return ans[i][j];
        else
        {
            int up= rec(i,j-1);
            int left = rec(i-1,j);
            ans[i][j]= up+left;
            return ans[i][j];
        }
    }


}
