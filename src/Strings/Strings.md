## Basic String Problems

#### 8. String to Integer (atoi)

```java
class Solution {
    public int myAtoi(String s) {
       
        long res = 0;
        int positive=0, negative=0,i=0,n =s.length();

        char[] arr = s.toCharArray();
      
        //skip all the spaces
        while(i<n && arr[i]==' ')
        {
            i++;
            
        }

        while(i<n && (arr[i]=='-' || arr[i]=='+' ))
        {
            if(arr[i]=='+')
                positive++;
            else 
                negative++;
            i++;
        }
        if(positive+negative>1) return 0;
        while(i<n && (arr[i]-'0'>=0 && arr[i]-'0'<=9))
        {
            res=res*10+(arr[i]-'0');
            if(negative>0 && -1*res<=Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if(negative==0 && res>=Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            
            i++;
        }
        return negative>0?-1*(int)res:(int)res;
    }
    
}
```