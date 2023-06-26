package DP_Knapsack_Pattern;

public class q5 {
  static   int targetGlobal;
    public static void main(String[] args) {
        int sum=0;
        int target =-5;
        int[] nums = new int[]{4,2,1};
         for(int i=0;i<nums.length;i++)
             sum=sum+Math.abs(nums[i]);

         int[][] memo = new int[nums.length+1][sum+sum+1];
         targetGlobal = target;

        q5 a = new q5();
        System.out.println(a.rec( new int[]{4,2,1},-5,3,memo,sum));
    }
    static int rec(int[] nums, int target, int n, int[][] memo,int sum )
     {
         if(n==0)
         {
             if(target==targetGlobal) return 1;
             else return 0;
         }
        if(memo[n][sum+target]!=0) return memo[n][sum+target];

         else memo[n][sum+target]= rec(nums,target+nums[n-1],n-1,memo, sum) + rec(nums,target-nums[n-1],n-1,memo, sum);
         return memo[n][sum+target];
     }
}
