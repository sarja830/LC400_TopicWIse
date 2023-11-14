package DP_2d;

public class MinimumFallingPathSum {

    public static void main(String[] args) {
        MinimumFallingPathSum a = new MinimumFallingPathSum();
        a.minFallingPathSum(new int[][]{{-80,-13,22},{83,94,-5},{73,-48,61}});
    }
        public int minFallingPathSum(int[][] matrix) {

            int m = matrix.length;
            int n = matrix[0].length;
            int ans[][] = new int[m][n];
            for(int i=0;i<n;i++)
                ans[m-1][i] = matrix[m-1][i];
            for(int i=m-2;i>=0;i--)
            {
                for(int j =0;j<n;j++)
                {
                    ans[i][j] = ans[i+1][j];
                    if(j>=1)
                        ans[i][j] = Math.min(ans[i][j],ans[i+1][j-1]);
                    else if(j+1<n)
                        ans[i][j] = Math.min(ans[i][j],ans[i+1][j+1]);
                    ans[i][j]= ans[i][j]+matrix[i][j];
                }
            }
            int res=Integer.MAX_VALUE;
            for(int i=0;i<n;i++)
                res= Math.min(res,ans[0][i]);
            return res;
        }


// class Solution {
//     int m;
//     int n;
//     int[][] matrix;
//     public int minFallingPathSum(int[][] mat) {
//         matrix = mat;
//         m = matrix.length;
//         n = matrix[0].length;
//         int ans=Integer.MAX_VALUE;
//         for(int i=0;i<m;i++)
//         {
//           ans =  Math.min(rec(0,i),ans);
//         }
//         return ans;
//     }

//     int rec(int i, int j)
//     {
//         if(j<0 || j>=n)
//             return Integer.MAX_VALUE;

//         if(i==n-1)
//             return matrix[i][j];

//         int min =0;
//         min = Math.min( Math.min( rec(i+1, j-1), rec(i+1,j) ),
//          rec(i+1,j+1) )+matrix[i][j];
//         return min;
//     }
// }
}

