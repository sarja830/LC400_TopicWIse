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




### Interval Pattern

#### 435. Non-overlapping Intervals
```java


```

#### 452. Minimum Number of Arrows to Burst Balloons
```java
class Solution {
    public int findMinArrowShots(int[][] points) {
        int[] aux = new int[2];
        int count=1;
        Arrays.sort(points,(a,b)->{
            if(a[0]> b[0]) return 1;
            return -1;    
        });
     
        aux[0] = points[0][0];
        aux[1] = points[0][1];
        for(int i=1;i<points.length;i++)
            if(aux[1]>=points[i][0])
            {
                aux[1] = Math.min(aux[1],points[i][1]);
                aux[0] = Math.max(aux[0],points[i][0]);
            }
            else
            {
                aux[1] = points[i][1];
                aux[0] = points[i][0];
                count++;
            }
        return count;
    }
}
```

### 2 pass solutions

#### 135. Candy
```java
class Solution {
    public int candy(int[] ratings) {
        // 2 pass solution
        int sum = 0;
        int n = ratings.length;
        int ans[] = new int[n];
        Arrays.fill(ans,1);
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
                ans[i] = ans[i-1]+1;
        }
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
                if(ans[i]<=ans[i+1])
                    ans[i] = ans[i+1]+1;
        }
        for(int i:ans)
            sum = sum+i;
        return sum;
    }
}
```