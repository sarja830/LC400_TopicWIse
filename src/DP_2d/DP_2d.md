## DP on Grids

#### General Process
1. First try to express the grid in terms of indices in the row and column.
2. Try all possibilities or explore all paths
3. sum up all ways /  find maximum / find minimum


The tabular approach is always opposite to recursion.

#### To find the minimum in the base case
    - not possible -> return Integer.MAX_VALUE or amount+1
    - possible -> to return 0
#### to find the maximum in the base case
    - not possible -> return Integer.MIN_VALUE or amount+1
    - possible -> to return 0
#### To count all possible ways
    - not possible -> return 0
    - possible -> to return 1

### grid problems (start fixed and end fixed)

####  Unique paths (count all unique paths)

Bottom up approach recursive
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
Top down approach (tabular)
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
Bottom up approach recursive
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
Top down approach (tabular)
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

#### Unique paths 2

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

#### 64. Minimum Path Sum (minimum path sum in a grid)

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int m =grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        ans[0][0]=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j>0 && i>0 )
                    ans[i][j] = Math.min(ans[i-1][j],ans[i][j-1]);
                else {
                    if(i>0)
                        ans[i][j]=ans[i-1][j];
                    if(j>0)
                        ans[i][j] = ans[i][j-1];}
                ans[i][j]=ans[i][j]+grid[i][j];
            }
        }
        return ans[m-1][n-1];
    }
}

class Solution {
    int[][] ans;
    int[][] g;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ans = new int[m][n];
        for(int[] a:ans)
            Arrays.fill(a,-1);
        this.g=grid;

        return rec(m-1,n-1);
    }
    int rec(int i, int j)
    {

        if(i<0 || j<0 ) return 100000000;
        if(i==0 && j==0) return g[i][j];
        if(ans[i][j]!=-1) return ans[i][j];
        else
        {
            int up= rec(i,j-1)+g[i][j];
            int left = rec(i-1,j)+g[i][j];
            ans[i][j]= Math.min(up,left);
            return ans[i][j];
        }
    }
}
```



### grid problems (start is fixed)

#### 120. Triangle

```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] ans = new int[triangle.size()][triangle.size()];
        int n = triangle.size();
        // base case
        for(int i=0;i<n;i++)
            ans[n-1][i] = triangle.get(n-1).get(i);


        for(int i=n-2;i>=0;i--)
            for(int j =0;j<=i;j++)
                ans[i][j] = Math.min(ans[i+1][j+1], ans[i+1][j])+triangle.get(i).get(j);

        return ans[0][0];
    }
}

class Solution {
    int[][] ans;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n =triangle.size();
        ans = new int[n+1][triangle.get(n-1).size()+1];
        for(int[] ar:ans)
            Arrays.fill(ar,-1);
        return rec(triangle,0,0);
    }
    int rec(List<List<Integer>> triangle, int i, int current)
    {
        if(i>=triangle.size()) return 0;
        List<Integer> list = triangle.get(i);
        if(ans[i][current]!=-1) return ans[i][current];
        ans[i][current]= Math.min(rec(triangle,i+1,current)+list.get(current),rec(triangle,i+1,current+1)+list.get(current));
        return ans[i][current];
    }
}
```

#### 799. Champagne Tower

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

### grid problems start is not fixed end is not fixed
#### 931. Minimum Falling Path Sum

```java
 class Solution {
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
                if(j+1<n)
                    ans[i][j] = Math.min(ans[i][j],ans[i+1][j+1]);
                ans[i][j]= ans[i][j]+matrix[i][j];
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            res= Math.min(res,ans[0][i]);
        return res;
    }
}

class Solution {
    int m;
    int n;
    int[][] matrix;
    int[][] ans;
    public int minFallingPathSum(int[][] mat) {
        matrix = mat;
        m = matrix.length;
        n = matrix[0].length;
        ans = new int[m][n];
        int res=Integer.MAX_VALUE;
        for(int[]a : ans)
        {
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        for(int i=0;i<m;i++)
        {
            res =  Math.min(rec(0,i),res);
        }
        return res;
    }

    int rec(int i, int j)
    {
        if(j<0 || j>=n)
            return Integer.MAX_VALUE;
        if(ans[i][j]!=Integer.MAX_VALUE)
            return ans[i][j];
        if(i==n-1)
        {
            ans[i][j] = matrix[i][j];
            return ans[i][j];
        }

        int min =0;
        min = Math.min( Math.min( rec(i+1, j-1), rec(i+1,j) ),
                rec(i+1,j+1) )+matrix[i][j];
        ans[i][j] = min;
        return min;
    }
}
```


### knapsack Pattern


#### Classic Knapsack

given a weight[]
a value[]
and a weight find the maximum profit.
```java
public class Solution {
    public static int cutRod(int price[], int n) {
        int m = price.length;
        int[][] ans = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                if(i<=j)
                    ans[i][j] = Math.max(
                            ans[i][j-i]+price[i-1],
                            ans[i-1][j]
                    );
                else
                    ans[i][j] = ans[i-1][j];
            }
        return ans[m][n];
    }
}
```
####  Find all distinct subset (or subsequence) sums
Given a set of integers, find all distinct sums that can be generated from the subsets of the given sets.
```java

class Solution
{
    public int[] DistinctSum(int[] nums)
    {
        int n = nums.length;
        int sum=0;
        for(int a:nums) sum=sum+a;
        int[][] ans = new int[n+1][sum+1];

        Arrays.fill(ans[0],sum+1);
        ans[0][0] =0;
        for(int i=1;i<=n;i++)
            for(int j =1;j<=sum;j++)
            {
                if(j>=nums[i-1])
                    ans[i][j] = Math.min(ans[i-1][j-nums[i-1]]+1, ans[i-1][j]);
                else
                    ans[i][j] = ans[i-1][j];
            }
        List<Integer> list = new ArrayList();
        list.add(0);
        for(int i=1;i<=sum;i++)
        {
            if(ans[n][i]<=sum)
                list.add(i);
        }
        int[] res = new int[list.size()];
        int k=0;
        for(int l:list) res[k++]=l;
        return res;
    }
}
```


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
In coin change you want the exact amount that is the reason you take +INF for greater than cases so that it never get in the min function
whereas in knapsack
there is no such restriction
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

#### Rod Cutting Problem

```java
public class Solution {
    public static int cutRod(int price[], int n) {
        int m = price.length;
        int[][] ans = new int[m+1][n+1];
        //here the price of length of rods is given by index hence we use i only but in knapsack we use weight[i]
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                if(i<=j)
                    ans[i][j] = Math.max(
                            ans[i][j-i]+price[i-1],
                            ans[i-1][j]
                    );
                else
                    ans[i][j] = ans[i-1][j];
            }
        return ans[m][n];
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

### knapsack 3d
#### 879. Profitable Schemes

```java
class Solution {
    int ans[][][];
    public int profitableSchemes(int ppl, int minProfit, int[] group, int[] profit) {
        int sum =0;
        for(int i:profit) sum=sum+i;
        ans =  new int[group.length+1][ppl+1][sum+1];
        for(int[][] a : ans)
            for(int[] b: a)
                Arrays.fill(b,-1);
        return rec(group.length,ppl,minProfit,0,group,profit);
    }

    int rec(int n, int ppl, int min, int p, int[] group, int[] profit)
    {
        if(n==0 || ppl==0)
        {
            ans[n][ppl][p] = min<=p?1:0;
            return ans[n][ppl][p];
        }

        if(ans[n][ppl][p]!=-1)
            return ans[n][ppl][p]%(int)(Math.pow(10,9)+7) ;

        if( ppl>=group[n-1])
            ans[n][ppl][p] =
                    (rec(n-1,ppl-group[n-1],min,p+profit[n-1],group,profit)
                            +rec(n-1,ppl,min,p,group,profit));
            // %(int)(Math.pow(10,9)+7) ;

        else
            ans[n][ppl][p] =  rec(n-1,ppl,min,p,group,profit);
        // %(int)(Math.pow(10,9)+7) ;


        return ans[n][ppl][p]%(int)(Math.pow(10,9)+7) ;
    }
}
```

#### 474. Ones and Zeroes

```java
class Solution {
    int m;
    int n ;
    int[][][] ans;
    public int findMaxForm(String[] strs, int m, int n) {
        int n1= strs.length;
        this.m =m;
        this.n = n;
        ans = new int[n1+1][m+1][n+1];
        for(int[][] a:ans)
            for(int[] b:a)
                Arrays.fill(b,-1);
        return rec(n1,strs,m,n);
    }
    int rec(int n, String[] strs,  int i , int j)
    {
        if(ans[n][i][j] != -1)
            return ans[n][i][j];
        if(n==0)
        {
            ans[n][i][j] =  0;
            return ans[n][i][j];
        }
        if(i==0 && j==0){
            ans[n][i][j] =  0;
            return ans[n][i][j];
        }


        int[] count =countZerosAndOnes(strs[n-1]);

        if(count[0]<=i && j>=count[1])
        {
            ans[n][i][j] =  Math.max(rec(n-1,strs,i,j),rec(n-1,strs,i-count[0], j-count[1])+1);
        }
        else
            ans[n][i][j] = rec(n-1,strs,i,j);

        return ans[n][i][j];
    }
    int[] countZerosAndOnes(String s)
    {
        int[] ans = new int[2];
        for(char c : s.toCharArray())
            if(c=='0') ans[0]++;
            else ans[1]++;
        return ans;
    }
}
```

### Longest common subsequence

#### 1143. Longest Common Subsequence

```java
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int ans[][] = new int[n+1][m+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    ans[i][j]=ans[i-1][j-1]+1;
                else
                    ans[i][j] = Math.max(ans[i-1][j], ans[i][j-1]);
        return ans[n][m];
    }
}
```

#### 516. Longest Palindromic Subsequence

```java
class Solution {
    public int longestPalindromeSubseq(String s) {

        String rev = new StringBuilder(s).reverse().toString();
        int m =s.length();
        int n = rev.length();
        int[][] ans = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                if(s.charAt(i-1)==rev.charAt(j-1))
                    ans[i][j]= ans[i-1][j-1]+1;
                else
                    ans[i][j]= Math.max(ans[i-1][j], ans[i][j-1]);

        return ans[m][n];
    }
}
```

#### 583. Delete Operation for Two Strings

```java

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] ans = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    ans[i][j] = ans[i-1][j-1]+1;
                else
                    ans[i][j] = Math.max(ans[i-1][j],ans[i][j-1]);
        return m+n-2*(ans[m][n]);
    }
}


```

### Misc DP
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


I spent 4 hours collecting these 52 DP problems of all patterns.

If you solve all problems, you can solve any DP problem in an Interview.

Here are they:

[1] DP on Strings

1. https://lnkd.in/dpHdnbJg
2. https://lnkd.in/dftf72nm
3. https://lnkd.in/dHAn6fGW
4. https://lnkd.in/dUnJw4bS
5. https://lnkd.in/dM8aTrRv
6. https://lnkd.in/dpSTcynK
7. https://lnkd.in/db9ZagnM
8. https://lnkd.in/dxUK2cCv

[2] DP on Decision Making

1. https://lnkd.in/dEiTg5yB
2. https://lnkd.in/dk3zMy3s
3. https://lnkd.in/dKhAzfUa
4. https://lnkd.in/diWt_CpT
5. https://lnkd.in/dF4U5ZsV
6. https://lnkd.in/dMst59zc

[3] DP on Merging Intervals

1. https://lnkd.in/dHx3CTdg
2. https://lnkd.in/de4ZDJVh
3. https://lnkd.in/dA_Nh7VC
4. https://lnkd.in/dqiJp2Xh
5. https://lnkd.in/dp3eXBVq
6. https://lnkd.in/dy3eKPbv
7. https://lnkd.in/dEsEBt_Q


[4] DP on Distinct Ways

1. https://leetcode.com/problems/unique-paths/?envType=list&envId=55ajm50i
2. https://leetcode.com/problems/unique-paths-ii/?envType=list&envId=55ajm50i
3. https://leetcode.com/problems/climbing-stairs/?envType=list&envId=55ajm50i
4. https://leetcode.com/problems/combination-sum-iv/?envType=list&envId=55ajm50i
5. https://leetcode.com/problems/partition-equal-subset-sum/?envType=list&envId=55ajm50i
6. https://leetcode.com/problems/target-sum/?envType=list&envId=55ajm50i
7. https://leetcode.com/problems/out-of-boundary-paths/?envType=list&envId=55ajm50i
8. https://leetcode.com/problems/number-of-longest-increasing-subsequence/?envType=list&envId=55ajm50i
9. https://leetcode.com/problems/knight-probability-in-chessboard/?envType=list&envId=55ajm50i
10. https://leetcode.com/problems/domino-and-tromino-tiling/?envType=list&envId=55ajm50i
11. https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/?envType=list&envId=55ajm50i
12. https://leetcode.com/problems/soup-servings/?envType=list&envId=55ajm50i
3. https://leetcode.com/problems/dungeon-game/?envType=list&envId=55ac4kuc
4. https://leetcode.com/problems/maximal-square/?envType=list&envId=55ac4kuc
5. https://leetcode.com/problems/perfect-squares/?envType=list&envId=55ac4kuc
6. https://leetcode.com/problems/coin-change/?envType=list&envId=55ac4kuc
7. https://leetcode.com/problems/ones-and-zeroes/?envType=list&envId=55ac4kuc
8. https://leetcode.com/problems/2-keys-keyboard/?envType=list&envId=55ac4kuc
9. https://leetcode.com/problems/min-cost-climbing-stairs/?envType=list&envId=55ac4kuc
10. https://leetcode.com/problems/minimum-number-of-refueling-stops/?envType=list&envId=55ac4kuc
11. https://leetcode.com/problems/minimum-falling-path-sum/?envType=list&envId=55ac4kuc
12. https://leetcode.com/problems/minimum-cost-for-tickets/?envType=list&envId=55ac4kuc
13. https://leetcode.com/problems/last-stone-weight-ii/?envType=list&envId=55ac4kuc
14. https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/?envType=list&envId=55ac4kuc
