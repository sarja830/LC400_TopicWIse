package DP_1d;

public class MaximumSubarray53{

    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int max_at_point=Integer.MIN_VALUE;
        int max_at_previous=nums[0];
        int n = nums.length;

        for(int i=1;i<n;i++)
        {
            max_at_point = Math.max(nums[i],nums[i]+max_at_previous);
            max=Math.max(max_at_point,max);
            max_at_previous=max_at_point;
        }
        return max;
    }

        public static int main(String[] args) {
            MaximumSubarray53 s= new MaximumSubarray53();
            return s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        }
}
