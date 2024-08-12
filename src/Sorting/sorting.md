
#### 1094. Car Pooling (similar to meeting room 2        )
```java
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[][] ppl = new int[2*n][2];
        int j = 0;
        for(int     i[]: trips)
        {
            ppl[j][0] = i[1];
            ppl[j++][1] = i[0];
            ppl[j][0] = i[2];
            ppl[j++][1] = -i[0];

        }

        Arrays.sort(ppl,(a,b)->{
            if(a[0]==b[0])  
                return a[1] - b[1];
            return a[0] - b[0];
        });

        int count = 0;
        for(int a[]: ppl)
        {
            count = count+ a[1];
            if(count>capacity)
                return false;
            
        }
        return true;

    }
}
```