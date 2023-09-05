#### 769. Max Chunks To Make Sorted

```java
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max_so_far = Integer.MIN_VALUE, ans =0;
        for(int i=0;i<arr.length;i++)
        {
            if(max_so_far<arr[i])
            {
                max_so_far =arr[i];
                
            }
            if(max_so_far==i)
            {
                ans++;
            }
        }
        return ans;
    }
}
```