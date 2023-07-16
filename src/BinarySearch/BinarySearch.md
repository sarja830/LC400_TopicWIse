# BINARY SEARCH BASIC FUNCTIONS:
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


## Leetcode refernce questions:
1. https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/3773943/easy-to-understand-solution-in-java-beats-100-using-modified-binary-search/
2. https://leetcode.com/problems/search-in-rotated-sorted-array-ii/solutions/3774068/easy-to-understand-solution-in-java-using-modified-binary-search-beats-100/
3. https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/3774187/easy-to-understand-solution-in-java-using-modified-binary-search-beats-100/
4. https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/solutions/3774219/easy-to-understand-solution-in-java-using-modified-binary-search-beats-100//find-minimum-in-rotated-sorted-array-ii/solutions/3774219/easy-to-understand-solution-in-java-using-modified-binary-search-beats-100/