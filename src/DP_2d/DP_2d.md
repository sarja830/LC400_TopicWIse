## DP on Grids

#### General Process
1. First try to express the grid in terms of indices in the row and column.
2. Try all possibilities or explore all paths
3. sum up all ways /  find maximum / find minimum

#### To find the minimum in the base case
    - not possible -> return Integer.MAX_VALUE or amount+1
    - possible -> to return 0
#### to find the maximum in the base case
    - not possible -> return Integer.MIN_VALUE or amount+1
    - possible -> to return 0
#### To count all possible ways
    - not possible -> return 0
    - possible -> to return 1
 


#### Unique paths (count all unique paths)
#### Bottom up approach recursive
```java
class Solution {
    public int uniquePaths(int m, int n)
    {
        return rec(m-1,n-1);
    }
    int rec(int i , int j)
    {
        if(i==0 && j==0)
            return 1;
        else if(i<0 || j<0)
            return 0;
        return rec(i-1,j)+rec(i,j-1);

    }
}
```
#### Top down approach (tabular)
```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];
        ans[0][0] =1;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                int up=0, left =0;
                if(i>0)  up = ans[i-1][j];
                if(j>0)  left = ans[i][j-1];
                ans[i][j] = up+left+ans[i][j];
            }
        return ans[m-1][n-1];
    }
}
```

#### Unique paths 2(count all unique paths with obstacles)
#### Bottom up approach recursive
```java
class Solution {
    public int uniquePaths(int m, int n)
    {
        return rec(m-1,n-1);
    }
    int rec(int i , int j)
    {
        if(i==0 && j==0)
            return 1;
        else if(i<0 || j<0)
            return 0;
        if(grid[i][j]==1)
            return 0;
        return rec(i-1,j)+rec(i,j-1);

    }
}
```
#### Top down approach (tabular)
```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];
        ans[0][0] =1;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                int up=0, left =0;
                if(i>0)  up = ans[i-1][j];
                if(j>0)  left = ans[i][j-1];

                ans[i][j] = up+left+ans[i][j];
            }
        return ans[m-1][n-1];
    }
}
```

### Unique paths 2
####        
````java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =obstacleGrid.length, n =obstacleGrid[0].length;
        return rec(m-1,n-1, obstacleGrid);
    }
    int rec(int i, int j, int[][] grid)
    {
        if(i==0 && j==0)
            return 1;
        if(i<0 || j<0)
            return 0;
        if(grid[i][j]==1) return 0;
        else return rec(i-1,j,grid) + rec(i,j-1,grid);
    }
}
````



#### knapsack Pattern


#### 416. Partition Equal Subset Sum (knapsack given target possible or not)
```java
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0, n = nums.length;
        for(int i:nums)
            sum=sum+i;
        if(sum%2!=0) return false;
        boolean[][] ans = new boolean[n+1][sum/2+1];
       for(int i=0;i<=n;i++)
            ans[i][0] = true;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=sum/2;j++)
            {
                if(nums[i-1]<=j)
                    ans[i][j] = ans[i-1][j-nums[i-1]] || ans[i-1][j];
                else
                    ans[i][j] = ans[i-1][j];
            }
        return ans[n][sum/2];

    }
}
```

#### 322 . Coin change( minimum number of coins to form an amount )
```java
class Solution {
    int Amount;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] ans = new int[n+1][amount+1];
        Arrays.fill(ans[0],amount+1);

        for(int i=1;i<=n;i++)
            for(int j=1;j<=amount;j++)
            {

                if(coins[i-1]<=j)
                {
                    ans[i][j] = Math.min(ans[i][j-coins[i-1]]+1,ans[i-1][j]);
                }
                else
                    ans[i][j] = ans[i-1][j];
            }
        return ans[n][amount]>amount?-1:ans[n][amount];
        // int ans  = rec(coins,coins.length,amount);
        // return ans>amount?-1:ans;
    }
    int rec(int[] coins, int n, int amount)
    {
        if(n==0 || amount<=0)
            if(amount==0)
                return 0;
            else
                return Amount;

        else
        {
            int take =Amount;
            int notTake = rec(coins,n-1, amount);
            if(amount>=coins[n-1])
            {
                take = rec(coins,n, amount - coins[n-1])+1;
                return Math.min(take,notTake);
            }
            return notTake;

        }
    }
}
```

#### 518. Coin Change II (total no of ways we can make an amount from given denomination repitition allowed) 
```java
class Solution {
    public int change(int amount, int[] coins) {

        int[][] ans = new int[coins.length+1][amount+1];
        int n = coins.length;
        for(int i=0;i<=n;i++)
            ans[i][0]=1;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=amount;j++)
                if(coins[i-1]<=j)
                    ans[i][j] = ans[i][j-coins[i-1]] + ans[i-1][j];
                else
                    ans[i][j] = ans[i-1][j];

        return ans[n][amount];

    }
}


//  RECURSION WITH MEMOIZATION:
class Solution {
    int[][] ans;
    public int change(int amount, int[] coins) {
        int n =coins.length;

        ans = new int[n+1][amount+1];
        for(int[] ar : ans)
            Arrays.fill(ar,-1);
        return rec(coins,n,amount);
    }
    int rec(int[] coins, int n, int amount)
    {
        if(ans[n][amount]!=-1) return ans[n][amount];
        if(amount ==0 ) {
            ans[n][amount]= 1;
            return ans[n][amount];
        }
        if(n==0 || amount<0) return 0;

        if(amount>=coins[n-1])
        {
            //rec(coins,n-1,amount-coins[n-1]); it will be a redundant call 
            ans[n][amount]=  rec(coins, n, amount-coins[n-1])+rec(coins, n-1, amount);;
        }
        else
        {
            ans[n][amount]= rec(coins, n-1, amount);
        }
        return ans[n][amount];
    }
}
```

#### 983. Minimum Cost For Tickets

````java
class Solution {
    int[] ticketDays;
    int[][] ans;
    public int mincostTickets(int[] days, int[] costs) {
        ticketDays = new int[]{1,7,30};
        int n =days.length;
        ans =new int[n+1][days[n-1]+2];
        for(int[] i:ans)
        {
            Arrays.fill(i,-1);
        }
        // start from the end 
        // expiryDay this is the day when the pass will expire 
        return rec(costs,days,n, days[n-1]+1);
    }

    // function returns the min cost to cover all the days
    int rec(int[] costs, int[] days, int n, int expiryDay)
    {
        //if all the days are visited then return 0
        if(n==0 || expiryDay<0)
        {
            return 0;
        }
        if(ans[n][daysLeft]!=-1) return ans[n][expiryDay];
        int min = Integer.MAX_VALUE;
        if(expiryDay<=days[n-1])
            return rec(costs,days,n-1,expiryDay);
        else
        {
            for(int i=0;i<costs.length;i++)
            {
                min  = Math.min(rec(costs,days,n-1,days[n-1]-ticketDays[i]+1) +costs[i],min);
            }
            ans[n][daysLeft] = min;
            return min;
        }
    }

}
````


## Misc DP
#### 799.Champagne Tower

```java
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] ans = new double[query_row+1][query_row+1];
        ans[0][0] = poured;
        for(int i=1;i<=query_row;i++)
            for(int j=0;j<=i;j++)   
                if(i>=1 && ans[i-1][j]-1>0)
                    ans[i][j] = (ans[i-1][j]-1)/2.0;
                if(i>=1 && j>=1 && ans[i-1][j-1]-1>0)
                    ans[i][j] =ans[i][j]+ (ans[i-1][j-1]-1)/2.0; 

        return Math.min(ans[query_row][query_glass],1.0);
    }
}
```