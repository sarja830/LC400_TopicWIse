

#### 3. Longest Substring Without Repeating Characters

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] map = new int[256];
        int i =0,j=0,count =0;
        Arrays.fill(map,-1);
        for(j=0;j<n;j++)
        {
            char c = s.charAt(j);
            if(map[c]<i)
            {
                map[c] = j; 
            }
            else
            {
                i=map[c]+1;
                map[c] = j;
            }
            count = Math.max(count, j-i+1);
        }
        return count;
    }
}
```

#### 1004. Max Consecutive Ones III

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0,count=0,ans=0;
        int n = nums.length;
        int tempK=k;
        for( j=0;j<n;j++)
        {
            if(nums[j]==1)
                count++;
            else
            {
//                if available swaps are completed then increase i
                while(tempK==0)
                {
                    if(nums[i]==0) tempK++;
                    i++;
                }
//                if we have available buffer to swap we can decrease k
                tempK--;
            }
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }
}
```
#### 904. Fruit Into Baskets
refer to the next problem and prefer that solution
```java
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap();

    int n = fruits.length;
    int rpointer=0;
    int maxFruits=Integer.MIN_VALUE;
    int lpointer=0;
        for(rpointer=0;rpointer<n;rpointer++)
        {
// if same type of fruit occurs keep on adding and keep the latest index of fruit in hashmap  
            if(map.containsKey(fruits[rpointer]))
            {
                map.put(fruits[rpointer],rpointer);
            }   
// else if the different type of fruit havent reached limit in basket and keep the latest index of fruit in hashmap  
            else if(map.size()<2)
            {
                map.put(fruits[rpointer],rpointer);
            }
// remove fruit with the min index so that we loose on less fruits and also dont forget to add new fruit to the basket  
            else
            {
                int min = Integer.MAX_VALUE;
                int minFruit = Integer.MAX_VALUE;
                for(int val:map.keySet())
                {
                    
                    if(min>map.get(val))
                    {
                        min=map.get(val);
                        minFruit = val;
                    }
                }
                lpointer=min+1;
                map.remove(minFruit);
                map.put(fruits[rpointer],rpointer);
            }
// check count of fruits in every iteration and keep track of maximum 
            int count =rpointer-lpointer+1;
            maxFruits =Math.max(count,maxFruits);
        }
        return maxFruits;
    }
}
```
####  Longest Substring with At Most K Distinct Characters (LC premium) this is from coding ninja
this can be simulated using count and array also
```java
import java.util.HashMap;

public class Solution {

	public static int kDistinctChars(int k, String str) {
		if(k==0)
			return 0;
		HashMap<Character,Integer> map = new HashMap();
		int i=0,j=0,max=0,n =str.length();
		for(j=0;j<n;j++)
		{
			char c= str.charAt(j);
			if(map.containsKey(c))
			{
				map.put(c,map.get(c)+1);
			}
			else{
				
				while(map.size()>=k)
				{
					map.put(str.charAt(i),map.get(str.charAt(i))-1);
					if(map.get(str.charAt(i))==0)
					{
						map.remove(str.charAt(i));
					}
					i++;
				}
				map.put(c,1);
			}
			max = Math.max(j-i+1,max);
		}
		return max;
	}

}

```
#### 992. Subarrays with K Different Integers
To find the subarrays containing exactly k different integers. you need to find the subarrays contains atmost k integer- subarrays containing atmost k-1 integers.


```java
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubarrayHavingAtmostKDistinct(nums,k)-countSubarrayHavingAtmostKDistinct(nums,k-1);
    }
  int  countSubarrayHavingAtmostKDistinct(int[] nums, int k) {
      if(k==0) return 0;
        HashMap<Integer,Integer> map = new HashMap();
        int i=0,j=0, count =0, n = nums.length;
        for(j=0;j<n;j++)
        {
            int num = nums[j];
            if(map.containsKey(num))
            {
                map.put(num,map.get(num)+1);
            }
            else
            {
                while(map.size()==k)
                {
                    map.put(nums[i],map.get(nums[i])-1);
                    if(map.get(nums[i])==0)
                        map.remove(nums[i]);
                    i++;
                }
                map.put(nums[j],1);
            }
            count=count+j-i+1;
        }
        return count;
    }
}
```

#### 424. Longest Repeating Character Replacement
This problem is little tricky just focus on the character with the maximum occurence 
```java
class Solution {
    public int characterReplacement(String s, int k) {
        int i=0, j=0, n =s.length(), ans=0;
        int maxCount=0;
        int[] map = new int[26];
        for(j=0;j<n;j++)
        {
            char c = s.charAt(j);
            map[c-'A']++;

            if(map[c-'A']>maxCount)
            {
                maxCount = map[c-'A'];
            }
// when u increase i it might effect the maxCount but it doesnt matter. we already recorder it in the previous iteration
// we will anyways update maxcount in the upcoming iteration            
            while(j-i+1-maxCount>k)
            {
                map[s.charAt(i)-'A']--;
                i++;
            }
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }
}
```

### finding all the characters of a particular string in a string pattern 

#### 76. Minimum Window Substring


Three Data Structures used here:
character and occurence HashMap - of substring t
count - to count the characters of substring t
```java
class Solution {
    public String minWindow(String s, String t) {
           HashMap<Character,Integer> map = new HashMap();
        for(char c: t.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int i=0,
            j=0,
            n=s.length(),
            count=0,
            m= t.length(),
            min=Integer.MAX_VALUE,
            min_index=-1;
        for(j=0;j<n;j++)
        {
            char ch = s.charAt(j);
            if( map.containsKey(ch) ==true)
            {
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)>=0)
                    count++;
            }
            while(count==m)
            {
                if( j-i+1<min)   
                {
                    min =j-i+1;
                    min_index =i;
                }
                if(map.containsKey(s.charAt(i)))
                {
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                    if(map.get(s.charAt(i))>0)
                        count--;
                }
                i++;
            }
        }
        if(min_index==-1) return "";
        return s.substring(min_index,min_index+min );

        
    }
}
```


#### 1234. Replace the Substring for Balanced String

````java
class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int l = n/4;
       HashMap<Character, Integer> map = new HashMap();
        for(char c: s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        
        int count = 0;
        for(char i='A';i<='Z';i++)
        {
            int occ = map.getOrDefault(i,0);
            if(occ>l)
            {
                map.put(i,occ-l);
                count = count+occ - l;
            }
            else
                map.remove(i);
        }
        if(count==0 ) return 0;
        int curr = 0;
        int i = 0;
        int min  = Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
        {
            char c = s.charAt(j);
            if(map.containsKey(c))
            {
                if(map.get(c)>0)
                    curr++;
                map.put(c,map.get(c)-1);
            }
            while(curr == count)
            {
                min = Math.min(j-i+1,min);
                char c1 = s.charAt(i++);
                if(map.containsKey(c1))
                {
                    if(map.get(c1)>=0)
                        curr--;
                    map.put(c1,map.get(c1)+1);
                }
            }
        }
        return min;

    }
}
````
#### 1358. Number of Substrings Containing All Three Characters
```java
class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map = new HashMap();
        map.put('a',1);
        map.put('b',1);
        map.put('c',1);
        int count=0,res=0;
        int i=0,j=0,n= s.length();
        for(j=0;j<n;j++)
        {
            char c = s.charAt(j);
            if(map.containsKey(c))
            {
                map.put(c,map.get(c)-1);
                if(map.get(c)>=0)
                    count++;
                while(i<n && count==3)
                {
                    res= res+n-1-j+1;
                    if(map.containsKey(s.charAt(i)))
                    {
                        map.put(s.charAt(i),map.get(s.charAt(i))+1);
                        if(map.get(s.charAt(i))>0)
                        {
                            count--;
                        }
                    }
                    i++;
                }

            }
        }
        return res;
    }
}
```
#### 2062. Count Vowel Substrings of a String
```java

```

### Solved using prefix sum and hashMap

#### 930. Binary Subarrays With Sum

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map = new HashMap();

        int currSum =0,res=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            currSum=currSum+nums[i];
            res += map.getOrDefault(currSum-goal,0);
            if(map.containsKey(currSum))
                map.put(currSum,map.get(currSum)+1);
            else
                map.put(currSum,1);
        }
        return res;
    }
}
```

####  1248. Count Number of Nice Subarrays
```java
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, res=0;
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for(int i=0;i<n;i++)
        {
            if(nums[i]%2!=0)
                sum=sum+1;
            map.put(sum,map.getOrDefault(sum,0)+1);
            res=res+map.getOrDefault(sum-k,0);
        }
        return res;
    }
}
```
#### 1423. Maximum Points You Can Obtain from Cards
```java
class Solution {
    // the problem is to find the min sum subarray of size n-k
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int siz = n-k, min=Integer.MAX_VALUE;
        int prevSum =0;
        for(int i=0;i<n;i++)
        {
            cardPoints[i] = cardPoints[i]+prevSum;
            prevSum=cardPoints[i];
        }   
                                                                                           
        if(n<=k) return cardPoints[n-1];
        min  = cardPoints[n-k-1];
        for(int i=n-k;i<n;i++)
        {
            min = Math.min(cardPoints[i] - cardPoints[i-(n-k)],min);
        }
        return cardPoints[n-1]-min;

    }
}
```


####  727. Minimum Window Subsequence
```java
class Solution {
    public String minWindow(String s, String t) {
      int i1=0,j1=0;
            int i=0,j=0;
            int count =0, min=Integer.MAX_VALUE,min_index=-1;
            while(j<s.length())
            {
                char c =  s.charAt(j);
                if(c==t.charAt(j1))
                {
                    count++;
                    j1++;
                }

                if(count==t.length())
                {
                    int k=j;
                    int temp = t.length()-1;
                    while(temp>=0)
                    {
                        if(t.charAt(temp)==s.charAt(k))
                            temp--;
                        k--;
                    }
                    if(min>j-(k+1)+1)
                    {
                        min= j-(k+1)+1;
                        min_index = k+1;
                    }
                    i=k+2;
                    j =k+2;
                    count=0;
                    j1=0;
                }
                else {
                    j++;
                }

            }
            if(min_index==-1) return "";
            return s.substring(min_index,min_index+min);

        }
}
```

#### 2781. Length of the Longest Valid Substring

```java
class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        // set to store forbidden words
        HashSet<String> set = new HashSet(forbidden);
        int maxLength = 0;
        for(String s:forbidden) maxLength = Math.max(s.length(),maxLength);
        int n = word.length();
        int l = n-1, r = n-1;
        int max = 0;
        for( l=n-1;l>=0;l--)
        {
            for(int i=l;i<=Math.min(l+maxLength,r);i++)
            {
                if(set.contains(word.substring(l,i+1)))
                {
                    r= i-1;
                    break;
                }
            }
            
            max = Math.max(r-l+1,max);

        }
        return max;

    }
}
```

#### 1838. Frequency of the Most Frequent Element
```java
class Solution {

        public int maxFrequency(int[] A, int k) {
        int res = 1, i = 0, j;
        long sum = 0;
        Arrays.sort(A);
        for (j = 0; j < A.length; ++j) {
            sum += A[j];
            while (sum + k < (long)A[j] * (j - i + 1)) {
                sum -= A[i];
                i += 1;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}



```


Using Prev Method:

#### 1248. Count Number of Nice Subarrays
```java
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0, n = nums.length, prev = 0, ans = 0,i=0;
        for(int j=0;j<n;j++)
        {
            if(nums[j]%2!=0)
            {
                count++;
                prev = 0;
            }
            while(count==k)
            {
                prev = prev+1;
                if(nums[i]%2!=0)
                    count--;
                i++;
            }
            ans = ans+prev;
         
        }
        return ans;
    }
}
```

#### 1358. Number of Substrings Containing All Three Characters
```java
class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map = new HashMap();
        int n = s.length();
        int prev = 0, ans=0,i=0;
        for(int j=0;j<n;j++)
        {
            char c = s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size()==3)
            {
                prev = prev+1;
                char c1 = s.charAt(i);
                map.put(c1,map.getOrDefault(c1,0)-1);
                if(map.get(c1)==0)
                    map.remove(c1);
                i++;
            }
            ans = ans+prev;
        }
        return ans;
    }
}
```
#### 2962. Count Subarrays Where Max Element Appears at Least K Times

```java
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int i=0;
        long ans = 0, prev = 0, count=0;
        int max = Arrays.stream(nums).max().orElse(0);
        for(int j=0;j<n;j++)
        {
            if(nums[j]==max) count++;
            while(count==k)
            {
                prev = prev + 1;
                if(nums[i++]==max) count--;
            }
            ans = ans +prev;
        }
        return ans;
    }
}

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int i=0;
        long count=0, ans=0;
        int max = Arrays.stream(nums).max().orElse(0);
        for(int j=0;j<n;j++)
        {
            if(nums[j]==max) 
                count++;    
             while(count==k)
            {
                if(nums[i]==max) count--;
                i++;
            }
            if(count==k-1) 
                ans = ans+i;
        }
        return ans;
    }
}


```