#### 50. Pow(x, n)
```java
class Solution {
    public double myPow(double x, int n) {
        if(n==1)
            return x;
        if(n==0) return 1;
        double num = myPow(x,n/2);
        if(n%2==0)
            return num*num;
        else
            return n>0?num*num*x:num*num*(1/x);
    }
}
```
#### 1922. Count Good Numbers
```java
class Solution {
     int modulo= (int)1e9+7;
    public int countGoodNumbers(long n) {
        
      return (int)((rec(n/2,4)*rec((n+1)/2,5))%modulo);
    }
    long rec(long n, int x)
    {
       
        if(n==0)
            return 1;
        long num = rec(n/2,x);
        return (num*num)*(n%2==0?1:x)%modulo;
        
    }

}
```