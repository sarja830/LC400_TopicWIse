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