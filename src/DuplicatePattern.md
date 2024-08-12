
The solution to all the problems is pretty standard just place the elements on their correct places and then start checking which element is not in its correct place.
And return the desired answer.
### 287. Find the Duplicate Number

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int i=0, n =nums.length;
        while(i<n)
        {
            while(nums[i]!=i+1)
            {
                if(nums[nums[i]-1]==nums[i])
                    return nums[i];
                int b = nums[i]-1;
                int temp = nums[i];
                nums[i] = nums[b];
                nums[b] = temp;
            }
            i++;
        }
        return -1;
    }
}

```

#### 41. First Missing Positive
```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i =0;i<n;i++)
        {
            while(nums[i]!=i+1)
            {
                if(nums[i]<=0 || nums[i]>n || nums[nums[i]-1] == nums[i] ) break;
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i=0;i<n;i++)
            if(nums[i]!=i+1)
                return i+1;
        return n+1;
    }
}
```



#### 268. Missing Number
Using XOR operation
```java

class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res ^ (nums[i] ^ i);
        }
        return res ^ n;
    }
}
```
the same can be done using The technique of placing element on their correct position
```java
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            while(nums[i]!=i)
            {
                if(nums[i]<0 || nums[i]>=n) break;
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i=0;i<n;i++)
            if(nums[i]!=i)
                return i;
        return n;
    }
}
```

### 136. Single Number


```java
class Solution {
    public int singleNumber(int[] nums) {
        int s =nums[0];
        for(int i=1;i<nums.length;i++)
            s = s^nums[i];
        return s;
    }

}
```


#### 645. Set Mismatch
```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];

        // first arranging all the elements on their correct places
        for(int i=0;i<n;i++)
            while(nums[i]!=i+1)
            {
                // if a duplicate occurs then break and move on to arrange other elements
                if(nums[i]==nums[nums[i]-1]) break;
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        // check which element are not in correct place the element that is missing and the element that is in its place will be a part of the answer
        for(int i=0;i<n;i++)
            if(nums[i]!=i+1)
            {
                ans[0] = nums[i];
                ans[1] = i+1;
            }
        return ans;
    }
}
```