# BINARY SEARCH BASIC FUNCTIONS:

The core conecpt of all the binary search algorithm is to eliminte half of the array everytime.
## Understanding of  basic functions in binary Search:
```
Take, for example, a sorted range

1 2 3 4 5 5 5 6 7 9
In a binary search for 3, we will have

v-- lower bound
1 2 3 4 5 5 5 6 7 9
^-- upper bound
And in a binary search for 5:

       v-- lower bound
1 2 3 4 5 5 5 6 7 9
             ^-- upper bound
The lower and upper bound are the same if the element does not exist in the range. In a binary search for 8:

                 v-- lower bound
1 2 3 4 5 5 5 6 7 9
                 ^-- upper bound
The author of the article to which you refer phrases all this in the equivalent terms of "smaller than" and "greater than" so that in a search of 5,

       v-- lower bound
t t t t f f f f f f      <-- smaller than?
1 2 3 4 5 5 5 6 7 9
f f f f f f f t t t      <-- greater than?
^-- upper bound
```

## Lower Bound
```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length, low=0,  high= n-1,ans =n;
        while(low<=high)
        {
            int mid = low+ (high- low)/2;
            // find the leftmost element which is greater than target
            if(nums[mid]>=target)
            {
                ans= mid;
                high = mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }
}
```



## upper Bound

```java

public class Solution {
    public static int upperBound(int []nums, int target, int n){
        //don't forget to initialize ans =n
        int low=0,  high= n-1, ans =n;
       while(low<=high)
       {
           int mid = low+ (high- low)/2;
           // find the leftmost element which is greater than target
           if(nums[mid]>target)
           {
               ans= mid;
               high = mid-1;
           }
           else{
               low = mid +1;
           }
       }
       return ans;

    }
}
```


## Search in rotated sorted array (all unique elements)

```java
class Solution {
    public int search(int[] nums, int target) {
        int low =0,n=nums.length, high = n-1;

        while(low<=high)
        {
            int mid = low+ (high-low)/2;
            if(nums[mid]==target)
                return mid;
            //check if it is left sorted or right sorted
            // it will be either left or right sorted or both 
            
                //condition for right sorted
            else if(nums[mid]<nums[low])
            {
                //if it lies in right sorted part then set the low high accordingly
                if(nums[mid]<target && nums[high]>=target)
                    low = mid+1;
                    // if not sorted then search in the left portion
                else
                    high = mid-1;
            }
            //condition for left sorted
            else
            {
                //if it lies in left sorted part then set the low high accordingly
                if(nums[mid]>target && nums[low]<=target)
                    high = mid-1;
                // if not sorted then search in the right portion
                else
                    low=mid+1;
            }
        }
        return -1;
    }
    
}
```
## Search in rotated sorted array (duplicate elements)
```java
class Solution {
    public boolean search(int[] nums, int target) {
         int low =0,n=nums.length, high = n-1;

        while(low<=high)
        {
            int mid = low+ (high-low)/2;
            if(nums[mid]==target)
                return true;
            else if(nums[mid]==nums[low] && nums[mid]==nums[high] )
                {
                    low=low+1;
                    high =high-1;
                }
            //right sorted
            else if(nums[mid]<nums[low])
            {
                if(nums[mid]<target && nums[high]>=target)
                    low = mid+1;
                else
                    high = mid-1;
            }
            //left sorted
            else
            {
                if(nums[mid]>target && nums[low]<=target)
                    high = mid-1;
                else
                    low=mid+1;
            }
        }
        return false;
    }
}
```
## find minimum in rotated sorted array (all unique elements)
```java
class Solution {
    public int findMin(int[] nums) {
        int low=0, high= nums.length-1,ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid =low+ (high-low)/2;
            //left half is sorted
            if(nums[mid]>=nums[low])
            {
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }
            //right half is sorted
            else 
            {
                ans=Math.min(ans,nums[mid]);
                high =mid-1;
            }
        }
        return ans;
    }
}
```

## find minimum in rotated sorted array (duplicate elements)
```java
class Solution {
    public int findMin(int[] nums) {
        int low=0, high= nums.length-1, ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid = low+ (high-low)/2;
            ans = Math.min(nums[mid],ans);
            
            if(nums[mid]==nums[low] && nums[high]==nums[mid])
            {
                ans =Math.min(ans,nums[mid]);
                low=low+1;
                high=high-1;
            }
            //left sorted
            else if(nums[mid]>=nums[low])
            {
                ans =Math.min(ans,nums[low]);
                low=mid+1;
            }
            else
            {
                ans =Math.min(ans,nums[mid]);
                high = mid-1;
            }

        }
        return ans;
    }
}
```

# Application Based Questions:

## Find square root of a number:

```java
import java.util.* ;
import java.io.*; 

public class Solution {

	public static int sqrtN(long N) {
		long low =1, high =N, ans =0;
		while(low<=high)
		{
			long mid = low+(high-low )/2;
			long sq = mid*mid;
            
            //pushing from small to equal 
			if(sq<=N) 
			{
				ans = mid;
				low=mid+1;
			}
			else if(sq>N)
			{
				high = mid-1;
			}
			
		}
		return (int)ans;

	}
}

```
## Koko eating bananas

```java
class Solution {
   // corner case : {}805306368,805306368,805306368},1000000000
    int n;
    public int minEatingSpeed(int[] piles, int h) {
 
        n=piles.length;
        int max=0;
        for(int i=0;i<piles.length;i++)
            max= Math.max(piles[i],max);
        int low=1;
        int high = max;
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            //since it is less time than h we need to decrease the intake
            // count decreases when mid increases hence the behaviour is opposite to normal binary search
            if(count(mid,piles)<=h)
            {
                ans=mid;
                high=mid-1;    
            }
            else
            {
                low=mid+1;
            }
        } 
        return ans;
    }
    double count(int k, int[] piles)
        {
            int n = piles.length;
            double hours=0;
            for(int i=0;i<n;i++)
            {
                    //slower runtime
                    // hours=hours + (int) Math.ceil((double)piles[i]/k);
                    hours=hours + piles[i]/k;
                    if(piles[i]%k!=0) hours=hours+1;
            }
            return hours;
        }
}
```

##  Minimum Number of Days to Make m Bouquets 

```java

class Solution {
     public int minDays(int[] bloomDay, int m, int k) {
        int low =Integer.MAX_VALUE;
        int ans =-1;
        int high= Integer.MIN_VALUE;
        if(m*k>bloomDay.length) return -1;
       
        for(int i:bloomDay)
        {
            low = Math.min(low,i);
            high =Math.max(high,i);
        }
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            // days increases number of bookehs increases hence the normal binary search behaviour
            if(countBouquets(mid,bloomDay, k)>=m)
            {
                ans = mid;
                high=mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return ans;
    }
    int countBouquets(int mid , int[] bloomDay, int k )
    {
        int n = bloomDay.length;
        int count =0 ,adj=0;
        for(int i=0;i<n;i++)
        {
            if(bloomDay[i]<=mid)
            {
                adj++;
                if(adj==k)
                {
                    count++;
                    adj=0;
                }
            }
            else 
            {
                adj =0;
            }
        }
        return count;
    }
}
```


## magnetic force between two balls - Aggressive cows Pattern min max questions :

```java
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        

        int low = 0, n=position.length, high = position[n-1]-position[0], ans =-1;
    
        while(high>=low)
        {
            int mid = low+(high-low)/2;
            if(isPossible(mid,m,position))
            {
                ans =mid;
                low = mid +1;
            }
            else
            {
                high =mid-1;
            }
        }
        return ans;
    }
    boolean isPossible(int mid, int m, int[] position)
    {
        int last = position[0], i=1, n = position.length;
        m=m-1;

        for( i=1;i<n;i++)
        {
            if(last+mid<=position[i])
            {
                last=position[i];
                m--;
                if(m==0) return true;
            }
        }   
    
        return false;
    }
}
```





## Leetcode refernce questions:
1. https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/3773943/easy-to-understand-solution-in-java-beats-100-using-modified-binary-search/
2. https://leetcode.com/problems/search-in-rotated-sorted-array-ii/solutions/3774068/easy-to-understand-solution-in-java-using-modified-binary-search-beats-100/
3. https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/3774187/easy-to-understand-solution-in-java-using-modified-binary-search-beats-100/
4. https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/solutions/3774219/easy-to-understand-solution-in-java-using-modified-binary-search-beats-100//find-minimum-in-rotated-sorted-array-ii/solutions/3774219/easy-to-understand-solution-in-java-using-modified-binary-search-beats-100/
5. https://leetcode.com/problems/magnetic-force-between-two-balls/solutions/3788154/easy-to-understand-solution-in-java-using-binary-search-beats-100/