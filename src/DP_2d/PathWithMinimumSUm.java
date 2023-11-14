package DP_2d;

public class PathWithMinimumSUm {
    public static void main(String[] args) {
        PathWithMinimumSUm a = new PathWithMinimumSUm();
        a.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}});
    }

        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            int left = 0, up = 0;
            int[][] ans = new int[m][n];

            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++)
                {
                    left = -1;
                    up = -1;
                    if(j>0)
                        left = Math.max(ans[i][j-1],
                                Math.abs(heights[i][j]-heights[i][j-1]));
                    if(i>0)
                        up = Math.max(ans[i-1][j],
                                Math.abs(heights[i][j]-heights[i-1][j]));


                    if(left!=-1 && up!=-1)
                        ans[i][i] = Math.min(left,up);
                    else
                        if(left != -1)
                            ans[i][j] = left;
                        else if(up!=-1)
                            ans[i][j] = up;
                }
            return ans[m-1][n-1];
        }

}
