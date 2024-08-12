package DP_1d;
import java.util.*;
public class DeleteAndEarn {
    public static void main(String[] args) {
        deleteAndEarn(new int[]{1,1,1,2,4,5,5,5,6});
    }
        public static int deleteAndEarn(int[] nums) {
            Arrays.sort(nums);

            int j = -1;
            int curr = Integer.MAX_VALUE;
            int[] val = new int[nums.length];
            for(int i: nums)
            {
                if(curr == i)
                    nums[j] = nums[j]+ i;
                else
                {
                    j++;
                    curr = i;
                    nums[j] = i;
                    val[j] = i;
                }
            }
            int n = j+1;
            int[] ans = new int[n];

            for(int i=0;i<n;i++)
            {
                if(i>=1 && val[i]-1!=val[i-1])
                    ans[i] = nums[i] + ans[i-1];
                else
                    ans[i] = Math.max((i>=1?nums[i-1]:0),nums[i]+(i-2>=0?nums[i-2]:0));

            }
            return ans[n-1];
        }

}
