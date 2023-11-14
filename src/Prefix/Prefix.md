
## Prefix sum


### PREFIX SUM

#### 930. Binary Subarrays With Sum

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n  = nums.length;
        int i =0;
        int sum=0, count=0;
        for(int j=0;j<n;j++)
        {
            sum=sum+nums[j];
            if(sum==goal)
                count++;
            else if(sum>goal)
            {
                while(sum>=goal)
                {
                    i++;
                    sum=sum-nums[i];
                    if(sum==goal)   count++;
                }
            }
        }
        while(i<n && sum>=goal)
        {
                    i++;
                   if(i<n) sum=sum-nums[i];
                    if(sum==goal)   count++;
        }
        return count;

    }
}
```
#### 238. Product of Array Except Self
```java

```
#### 1423. Maximum Points You Can Obtain from Cards

```java
class Solution {
    // the problem is to find the min sum subarray of size n-k
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int siz = n-k, min=Integer.MAX_VALUE;
        int prevSum =0;
        for(int i=0;i<n;i++)
        {
            cardPoints[i] = cardPoints[i]+prevSum;
            prevSum=cardPoints[i];
        }   
                                                                                           
        if(n<=k) return cardPoints[n-1];
        min  = cardPoints[n-k-1];
        for(int i=n-k;i<n;i++)
        {
            min = Math.min(cardPoints[i] - cardPoints[i-(n-k)],min);
        }
        return cardPoints[n-1]-min;

    }
}
```
####  1248. Count Number of Nice Subarrays
```java
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, res=0;
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for(int i=0;i<n;i++)
        {
            if(nums[i]%2!=0)
                sum=sum+1;
            map.put(sum,map.getOrDefault(sum,0)+1);
            res=res+map.getOrDefault(sum-k,0);
        }
        return res;
    }
}
```
