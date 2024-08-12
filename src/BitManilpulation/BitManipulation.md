#### Single Number
````java
class Solution {
    public int singleNumber(int[] nums) {
        int s =nums[0];
        for(int i=1;i<nums.length;i++)
            s = s^nums[i];
        return s;
    }
 
}
````

#### 191. Number of 1 Bits

```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int one = 1;
        int count = 0;
        while(n!=0)
        {
            count = count + (n&1);
            n = n>>>1;

        }
        return count;
    }

}
```

#### 338. Counting Bits
````java
class Solution {
    public int[] countBits(int n) {

        int[] dp = new int[n+1];
        dp[0] = 0;
      
        int offset = 1;
        for(int i=1;i<=n;i++)
        {   

            if(offset*2==i)
                offset = i;
           
            dp[i] = 1 + dp[i-offset];
        }
        return dp;
    }
}
````