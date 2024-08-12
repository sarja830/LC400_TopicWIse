package DP_1d;
import
        java.util.*;
public class BestTeamWithNoCOnflict {
    public static void main(String[] args) {
        bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{
            2, 1, 2, 1});
    }
        public static  int bestTeamScore(int[] scores, int[] ages) {
            int n = scores.length;
            int[][] nums = new int[n][n];
            int l=0;
            for(int[] a : nums)
            {    a[0]= ages[l];
                a[1] = scores[l++];
            }
            Arrays.sort(nums,(a,b)->{
                return a[0]- b[0];
            });
            for(int a[]: nums)
                System.out.println(a[0]+" "+a[1]);
            int max = 0;
            int[] ans = new int[n];
            ans[0] = scores[0];
            for(int i=1;i<n;i++)
            {
                ans[i] = nums[i][1];
                for(int j=i-1;j>=0;j--)
                    if(nums[j][1]<=nums[i][1])
                    {    ans[i] = Math.max(ans[i],nums[i][1] + ans[j]);

                    }

                // System.out.println(ans[i]);
                max = Math.max(max,ans[i]);
            }

            return max;

        }


}
