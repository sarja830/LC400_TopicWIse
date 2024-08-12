
#### 2147. Number of Ways to Divide a Long Corridor

```java
class Solution {
    public int numberOfWays(String corridor) {

        int plants = 0;
        int seats = 0;
        long res= 1;
        long mod = (long)1e9+7;
        
        int localSum=0;
        for( char c: corridor.toCharArray())
        {
            if(c=='S')
            {
                seats++;
                if(seats>=2 && seats%2!=0)
                    res = ((localSum+1)*res)%mod;
                    localSum = 0;
            }
            else {
                if(seats>=2 && seats%2==0)
                    localSum++;
            }
        }
        
        if(seats%2!=0 || seats==0) return 0;
        // if(seats==2 ) return 1;
        return (int)res;
        
        
    }
}
```