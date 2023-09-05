### The top-down 

Recursiveness
Note that both top-down and bottom-up can be implemented with recursion or iterative table-filling, though it may not be natural.
```
                f4
        f3             f2
    f2      f1      f1      f0
 ``` 

### The bottom up approach follows the bottom up approach
which is starting from the base case to the top level of the tree.


## Questions

### 70. Climbing Stairs

#### Bottom up approach
```java

//tabular dp
class Solution {
    public int climbStairs(int n) {
        int[] res = new int[n+1];
        if(n==2) return 2;
        if(n==1) return 1;
        res[1]=1;
        res[2]=2;
        for(int i=3;i<=n;i++)
        {
            res[i] = res[i-1]+res[i-2];
        }   
        return res[n];
    }
}

// tabular dp space optimized
class Solution {
    public int climbStairs(int n) {
         if(n<=2) return n;
        int prev1=1;
        int prev2=2;
        int ans =0;
        for(int i=3;i<=n;i++)
        {
            ans= prev1+prev2;
            prev1=prev2;
            prev2=ans;
        }
        return ans;
    }
}
```


#### top down approach
```java
//  recursion with memoization
class Solution {
    public int climbStairs(int n) {
        return rec(n,res);
    }
    public int rec(int n,int[] res)
    {
        if(n==0) return 1;
        if(n<0) return 0;
        if(res[n]!=0) 
            return res[n];
        else
            res[n]= rec(n-1,res)+rec(n-2,res);
        return res[n];
    }
}
```

### Frog Jump  Coding ninja (find minimum total energy to reach the n+1 stair) https://www.codingninjas.com/studio/problems/frog-jump_3621012?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

#### bottom up approach
```java
public class Solution {
    public static int frogJump(int n, int heights[]) {
        if(n<=2) return Math.abs(heights[0]-heights[1]);
        int res[] = new int[n+1];
        res[0] = 0;
        res[1] = Math.abs(heights[1]-heights[0]);
        if(n<=2) return res[n-1];
        for(int i=2;i<n;i++)
        {
            res[i]= Math.min(Math.abs(heights[i]-heights[i-1])+res[i-1],
            Math.abs(heights[i]-heights[i-2])+res[i-2]);
        }
        return res[n-1];
    }

}
```

#### top down approach
```java
public class Solution {
    static int[] res; 
    public static int frogJump(int n, int heights[]) {
        
        res = new int[n];
        Arrays.fill(res,-1);
        return rec(n-1,heights);
    }

    static int rec(int n, int[] nums)
    {   
        if(n==0)
            return 0;
        if(n==1)
            return Math.abs(nums[1]-nums[0]);
       
       if(res[n]!=-1) return res[n];
       res[n]= Math.min(Math.abs(
           nums[n]-nums[n-1])+rec(n-1,nums),
       Math.abs(nums[n]-nums[n-2])+rec(n-2, nums));
       return res[n];
                
    }

}
```

### 198. House Robber  (Maximum sum of non-adjacent elements)

#### Bottom Up or tabular
```java

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if(n==1) return nums[0];
        res[0]= nums[0];
        res[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++)
        {
            res[i] = Math.max(nums[i]+res[i-2],res[i-1]);
        }
        return res[n-1];
    }
}
```

#### recursion with memoization

```java

//  RECURSION WITH MEMOIZATION
class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return recMemo(nums,nums.length-1);
    }
    int recMemo(int[] nums, int n)
    {
        if(n<0) return 0;
        if(memo[n]!=-1) return memo[n];
        memo[n] =Math.max(recMemo(nums,n-2)+nums[n],recMemo(nums,n-1));
        return memo[n];
    }
}

```


### 213. House Robber II
#### bottom  up approach
```java
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] res= new int[n];
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        res[0]=nums[0];
        res[1]=Math.max(nums[0],nums[1]);
      
       
        for(int i=2;i<n-1;i++)
        {
            res[i]=Math.max(res[i-1],res[i-2]+nums[i]);
        }
        int first = res[n-2];
        Arrays.fill(res,-1);
        res[1] =nums[1];
        res[2] =Math.max(nums[1],nums[2]);
        for(int i=3;i<n;i++)
        {
            res[i]=Math.max(res[i-1],res[i-2]+nums[i]);
        }
        return Math.max(res[n-1],first);
    }
}
```
