package DP_LCS_BASE;
import java.util.*;
public class LIS {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{7,7,7,7,7,7,7});
    }
        public static int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] nums1 = new int[n];
            for(int i=0;i<n;i++)
                nums1[i]= nums[i];
            Arrays.sort(nums);

            int[][] ans = new int[n+1][n+1];
            for(int i=1;i<=n;i++)
                for(int j=1;j<=n;j++)
                    if(nums[i-1]==nums[j-1])
                        ans[i][j] = 1+ans[i-1][j-1];
                    else
                        ans[i][j] = Math.max(ans[i-1][j], ans[i][j-1]);

            return ans[n][n];



        }

}
