

https://stackoverflow.com/questions/15805578/will-two-strings-with-same-content-be-stored-in-the-same-memory-location

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

### combinatorics
#### 2063. Vowels of All Substrings

```java
class Solution {

    public long countVowels(String word) {
        long n = word.length(),  count=0;

        for(int i=0;i<n;i++)
            if("aeiou".indexOf(word.charAt(i))>=0)
                count += (i+1)*(n-i);
        return count;
    }
}
```

#### 2207. Maximize Number of Subsequences in a String
used prefix sum and normal logic
```java
class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {

        int n = text.length();
        long count = 0, res = 0, res1= 0,count1 =1;
        for(int i=n-1;i>=0;i--)
        {
            char c = text.charAt(i);
            if(c==pattern.charAt(1))
            {
                count1++;
                count++;
            }
            else if(c==pattern.charAt(0))
            {
                res = res+count;
                res1 = res1 + count1;
            }
        }
        if(pattern.charAt(1)==pattern.charAt(0))
        {
            return count *(count+1)/2;
        }

        // lets assume we have added the pattern of 0 to the starting
        res = res+count;
      
        return Math.max(res,res1);

    }
}
```

#### 38. Count and Say
```Java
class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";

        return rec(n,"1");
    }

    String rec(int n, String s)
    {

// base case
        if(n==1)
            return s;



// string processing 
        int siz = s.length();
        String res = "";
        int count = 1;
        char curr = s.charAt(0);
        for(int i=1;i<siz;i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                count++;
            }
            else
            {
                res= res + count + curr;
                curr = s.charAt(i);
                count = 1;
            }

        }
        res= res + count + curr;

// processing the stirng unless you reach your desired step 
        return rec(n-1,res);

    }
}

```

#### https://leetcode.com/problems/encode-and-decode-strings/
```java
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded =  new StringBuilder("");
        for(String s: strs)
            encoded.append(s.length()).append("#").append(s);
        System.out.println(encoded.toString());
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s1) {
        int i=0;
        List<String> ans = new LinkedList();
        while(i<s1.length())    
        {
            int n = 0;
            while(s1.charAt(i)!='#')
            {
                char c = s1.charAt(i++);
                n = n*10+c-'0';
            }
            
            ans.add(s1.substring(i+1,i+1+n));
            i = i+1+n;
            
        }
         
        return ans;
    }
}
```

#### String compression
```java
class Solution {
    public int compress(char[] chars) {
        if(chars.length==1)
            return 1;
        Stack<Character> digits ;
        int i = 0, n = chars.length, count = 1;
        char curr = chars[0];
        for(int j=1;j<n;j++)
        {
            char c = chars[j];
            if(c!=curr)
            {
                chars[i++] = curr;
                if(count>1)
                {
                    for(char c1: String.valueOf(count).toCharArray())
                        chars[i++] = c1;
                }
                curr = c;
                count = 1;
            }
            else
                count++;
        }
        chars[i++] = curr;
        if(count>1)
                {
                    for(char c1: String.valueOf(count).toCharArray())
                        chars[i++] = c1;
                }
        return i;
    }
}
```

#### 722. Remove Comments
```java
class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new LinkedList();
        boolean comment = false;
        String ansString = "";
        for(String s: source)
        {
            if(comment==false)
                ansString = "";
           
            int n = s.length();
            for(int i=0;i<n;i++)
            {
                if(comment==false)
                {
                        if(i+1<n && s.charAt(i)=='/' && s.charAt(i+1)=='*')
                    {
                        comment = true;
                        i++;
                    }
                    else if(i+1<n && s.charAt(i)=='/' && s.charAt(i+1)=='/')
                            break;
                    else 
                        ansString = ansString + s.charAt(i);
                }
                else
                if( i+1<n && s.charAt(i)=='*' && s.charAt(i+1)=='/')
                {
                    comment = false;
                    i++;
                }
                
            }
            if(ansString.length()!=0) 
                if(comment==false)
                    ans.add(ansString);
        }
        return ans;
    }
}
```
