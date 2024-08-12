package DP_2d;
import java.util.*;
public class NumberOfSubmatricesThatSumToTarget {

    public static void main(String[] args) {
        NumberOfSubmatricesThatSumToTarget a = new NumberOfSubmatricesThatSumToTarget();
        a.numSubmatrixSumTarget(new int[][]{{0, 1, 0},{1,1,1},{0,1,0}},0 );
    }
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int count = 0;
            int[][] sum = new int[m][n];
            for(int i=0;i<m;i++)
            {
                int curr = 0;
                for(int j=0;j<n;j++)
                {
                    curr = curr+matrix[i][j];
                    sum[i][j] = (i-1>=0? sum[i-1][j]:0) + curr;
                }
            }
            //start from 0 to boot then 1 to bottom so on and so forth

            for(int k=0;k<n;k++)
            {
                for(int i=k;i<n;i++)
                {
                    HashMap<Integer,Integer> map = new HashMap();
                    map.put(0,1);
                    for(int j=0;j<n;j++)
                    {
                        int curr = sum[i][j]-((k-1>=0)?sum[k-1][j]:0);
                        count = count+map.getOrDefault(target-curr,0);
                        map.put(curr,map.getOrDefault(curr,0)+1);
                    }
                }
            }
            return count;
        }

}
