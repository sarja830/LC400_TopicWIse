####  1752. Check if Array Is Sorted and Rotated

```java
class Solution {

    public boolean check(int[] nums) {
        boolean flag =false;
        for(int i=1;i<nums.length;i++)
        {
            if(!flag)
            {    if(nums[i-1]>nums[i])
                {
                    if(nums[i]>nums[0])
                        return false;
                    flag=true;
                }
            }
            else
            {
                if(nums[i]<=nums[0] && nums[i-1]<=nums[i])
                    continue;
                else
                    return false;
            }
        }
        return true;
    }
}
```

#### 26. Remove Duplicates from Sorted Array

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=0, n = nums.length;
        for( j=1;j<n;j++)
        {
            if(nums[i]!=nums[j])
            {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
```
#### 217. Contains Duplicate

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int i:nums)     
        {
            if(set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }
}
```
#### 219. Contains Duplicate II
```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set  = new HashSet();
        int i = 0, j = 0, n = nums.length;
        for(j=0;j<n;j++)
        {
            if(j-i>k)
            {
                set.remove(nums[i]);
                i++;
            }
            if(set.contains(nums[j]))
                return true;
            else
                set.add(nums[j]);
        }
        return false;
    }
}
```

#### 283. Move Zeroes

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int i=-1, j =0, n = nums.length;
        for( j=0;j<n;j++)
            if(nums[j]!=0)
                nums[++i]= nums[j];

        i++;
        while(i<n){
             nums[i++]=0;
        }        
    }
}
```

#### 189. Rotate Array

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
       reverse(nums,0,n-1);
       reverse(nums,0,k%n-1);
       reverse(nums,k%n,n-1);
     
    }
    void reverse(int[] nums, int i, int j )
    {
        
        while(j>=i)
        {
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++; j--;
        }
    }
}
```


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


### 3 sum pattern

####  16. 3Sum Closest
```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int i=0, j=0, k=0, n=nums.length, ans=Integer.MAX_VALUE, diff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(i=0;i<n-2;i++)
        {
            j=i+1;
            k=n-1;
            while(j<k)
            {
                if(Math.abs(target-(nums[i]+nums[j]+nums[k]))<diff)
                {
                    diff=Math.abs(target-(nums[i]+nums[j]+nums[k]));
                    
                    ans = nums[i]+nums[j]+nums[k];
                    if(diff == 0) return ans;
                }
                if(target-(nums[i]+nums[j]+nums[k])>0)
                    j++;
                else
                    k--;
                
            }
        }
        return ans;
    }
}
```

