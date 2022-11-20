package DP_Rec_Memoization;
import java.util.*;
public class JumpGameii45 {
        public int jump(int[] nums) {
            // int[] memoize = new int[nums.length];
            // int count=recMemoize(nums,memoize,0);
            // return count==Integer.MAX_VALUE?0:count;

            return backtraversing(nums);
        }

        public int backtraversing(int[] nums)
        {
            int n = nums.length;
            int[] result = new int[n];
            Arrays.fill(result,10000);
            result[n-1]=0;
            for(int i=n-2;i>=0;i--)
            {
                for(int j=1;j<=nums[i] && i+j<n;j++)
                {
                    result[i]=Math.min(result[i],1+result[i+j]);
                }
            }
            return result[0];
        }
        int recMemoize(int[] nums, int[] memoize, int i)
        {
            int n = nums.length;
            if(i>=n-1) {
                return 0;}
            if(nums[i]==0) return 10000;
            if(memoize[i]!=0) return memoize[i];

            int jump=Integer.MAX_VALUE;

            for(int j=1;j<=nums[i];j++)
            {
                jump = Math.min(jump, 1+recMemoize(nums,memoize,i+j));
            }
            memoize[i]=jump;
            return memoize[i];
        }
}
