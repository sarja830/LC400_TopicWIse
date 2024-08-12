### 312. Burst Balloons
https://leetcode.com/problems/burst-balloons/solutions/4565793/easy-to-understand-solution-in-java-using-recursion-with-memoization-with-tree-diagram/
```java
class Solution {
    int[][] ans;
    public int maxCoins(int[] nums) {

        int[] arr = new int[nums.length+2];
        int n = nums.length;
        this.ans  = new int[n+1][n+1];
        arr[0] = 1;
        int k = 1;
        for(int i: nums)
            arr[k++] = i;
        arr[k] = 1;
        return rec(arr,1,n);

    }
    int rec(int[] nums, int i, int j)
    {
        int max = Integer.MIN_VALUE;
        if(i>j) return 0;
        int left = nums[i-1];
        int right = nums[j+1];
        if(ans[i][j]!=0) return ans[i][j];
        for(int k=i;k<=j;k++)
            max =    Math.max(
                    rec(nums,i,k-1) + left* nums[k] * right + rec(nums,k+1,j)
                    ,
                    max);
        ans[i][j] = max;
        return ans[i][j];
    }
}
```