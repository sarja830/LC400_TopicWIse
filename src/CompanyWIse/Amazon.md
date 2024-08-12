



#### 2825. Make String a Subsequence Using Cyclic Increments
```java
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0;
        int n = str1.length();
        
        for(int j=0;j<n;j++)
        {
            
            if( str1.charAt(j)==str2.charAt(i) || str1.charAt(j)+1==str2.charAt(i) )    
            {

                i++;
                
            }
            else if(str1.charAt(j)=='z' && str2.charAt(i)=='a')
                i++;
            if(i==str2.length())
                    return true;
        }
        return false;
    }
}
```