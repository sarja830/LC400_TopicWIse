## Stacks

### Basics
####  225. Implement Stack using Queues
Just have 2 Queues:
q1 and q2 
Whenever any element comes in add it to q2
copy all element to q2 from q1 since stack is LIFO
copy eveything back to q1.

The operations 
1. pop() wil be O(1)
2. peek() will be O(1)
3. push will be O(n)

```java
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }
    
    public void push(int x) {
        q2.add(x);
        while(!q1.isEmpty())
        {
            q2.add(q1.poll());
        }
        while(!q2.isEmpty())
        {
            q1.add(q2.poll());
        }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
       return q1.peek();
    }
    
    public boolean empty() {
       return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```

#### 232. Implement Queue using Stacks
Have 2 stacks:
when you want to add an element copy everything from stack one to stack 2.
add element to stack 1;
copy everything to stack 1

```java
class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1 = new Stack();
        st2 = new Stack();
    }
    
    public void push(int x) {
        
        while(!st1.isEmpty())
            st2.push(st1.pop());
        st2.push(x);
        while(!st2.isEmpty())
            st1.push(st2.pop());
    }
    
    public int pop() {
        return st1.pop();
    }
    
    public int peek() {
        return st1.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```

#### 155. Min Stack

````java
class MinStack {

    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() 
    {
        st = new Stack();
        min = new Stack();
    }
    
    public void push(int val) 
    {
        st.push(val);    
        if(min.size()==0 || min.peek()>val)
        {
            min.push(val);
        }
        else
        {
            min.push(min.peek());
        }
    }
    
    public void pop() {
        st.pop();
        min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
````

#### 496. Next Greater Element I (NGL)

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ngl = new int[nums2.length];
        Stack<Integer> st = new Stack();
        int n =nums2.length;
        HashMap<Integer,Integer> map = new HashMap();
        map.put(nums2[n-1],-1);
        st.push(nums2[n-1]);
        for(int j=n-2;j>=0;j--)
        {
                while(!st.isEmpty() && st.peek()<=nums2[j])
                {
                    st.pop();
                }
                if(!st.isEmpty())
                    map.put(nums2[j],st.peek());
                else
                    map.put(nums2[j],-1);
            
            st.push(nums2[j]);
        }
        st.clear();
        for(int i=0;i<nums1.length;i++)
        {
            nums1[i] = map.getOrDefault(nums1[i],-1);
        }
        return nums1;

    }
}
```

#### 503. Next Greater Element II

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st  = new Stack();
        int n= nums.length;
        int[] res = new int[n];
        st.push(nums[n-1]);
        res[n-1]=-1;
        for(int i=2*n-2;i>=0;i--)
        {
            while(st.size()!=0  &&  st.peek()<=nums[i%n])
                st.pop();

            if(st.size()>0) res[i%n]=st.peek();
            else res[i%n]=-1;
            st.push(nums[i%n]);
        }

        return res;

    }
}
```

#### 1475. Final Prices With a Special Discount in a Shop (next smaller or equal element )

```java
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack();
        int n = prices.length;
        int[] nextSmallerOrEqual = new int[n];
        nextSmallerOrEqual[n-1] = 0;
        st.push(prices[n-1]);
        for(int i=n-2;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()>prices[i])
                st.pop();
            if(!st.isEmpty())
                nextSmallerOrEqual[i] = st.peek();
            else
                nextSmallerOrEqual[i]=0;
            
            st.push(prices[i]);
        }
        for(int i=0;i<n;i++)
            prices[i] = prices[i] - nextSmallerOrEqual[i];
        return prices;
    }
}
```
## Combinatorics

#### 2063. Vowels of All Substrings

```java
class Solution {

    public long countVowels(String word) {
        long n = word.length();
        long count=0;
    
        for(int i=0;i<n;i++)
        {
        
            if("aeiou".indexOf(word.charAt(i))>=0)
                count += (i+1)*(n-i);
        }
        return count;
    }
}
```

#### 907. Sum of Subarray Minimums
number of arrays were the element at a current index is minimum = x+1 * y+1
where x and y is the number of element to left and right respectively without including the min element.
```java
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];
       
        // nsr
        Stack<Integer> st = new Stack();
        nsr[n-1] = n;
        st.push(n-1);

        for(int j=n-2;j>=0;j--)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[j] )
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                nsr[j] = st.peek();
            }
            else
                nsr[j] =n;
            st.push(j);
        }


        st.clear();


        //nsl
        nsl[0] = -1;
        st.add(0);
        for(int j=1;j<n;j++)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[j] )
                {
                    st.pop();
                }
                if(!st.isEmpty())
                {
                    nsl[j] = st.peek();
                }
                else
                    nsl[j] =-1;
                st.push(j);
        }
       
        int mod= 1000000000 +7;
        long res =0;
        for(int i=0;i<n;i++)
        {
            res=res%mod+ ( (1L*(nsr[i]-i)*(i-nsl[i])* arr[i]))%mod;
            
        }
        return (int)res%mod; 
    }
}
```


#### 2104. Sum of Subarray Ranges
```java

```


#### 735. Asteroid Collision

```java
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0;i<n;i++)
        {
            //add element to the stack so that you can compare with the most recent asteroids
            if(st.isEmpty())
            {
                st.add(asteroids[i]);
                continue;
            }
            int a = st.peek();
            int b= asteroids[i];
// conditions where asteroids dont collide hence add them to the stack
            if( (a<0 && b>=0)|| (a>=0 && b>=0)|| (a<0 && b<0) )
            {
                st.add(b);
            }
// if they can collide 
            else
            {
            
// to decide whether the element needs to be added later on.
                boolean flag=false;
                
// while condition for collision is true
                while(!st.isEmpty() && st.peek()>0 && asteroids[i]<0)
                {
                    int sum =st.peek()+asteroids[i];
                    // sum is zero means the asteroid in stack is powerful and the upcoming asteroid will be destroyed
                    if(sum>0)
                    {
                        flag=false;
                        break;
                    }
// the upcoming asteroid is powerful and the one in the stack is destroyed. flag =true maybe it might get entry into the stack after sometime
                    else if(sum<0)
                    {
                        st.pop();
                        flag=true;
                    }
// both are destroyed
                    else
                    {
                        flag=false;
                        st.pop();
                        break;
                    }
                }
                if(flag) st.add(asteroids[i]);
            }
        }
            
        int[] res= new int[st.size()];
        int j= res.length-1;
        while(!st.isEmpty())
        {
            res[j] =st.pop();
            j--;
        }
        return res;
    }
}
```

#### trapping rainwater

#### 402. Remove K Digits

```java
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack();
       
        for(int i=0;i<num.length();i++)
        {
            char a = num.charAt(i);
            while(!st.isEmpty() && k>0 &&  st.peek()>a)
            {
                st.pop();
                k--;
            }
            if(st.size()==0 && a=='0')
                continue;
            else st.push(a);
        }
        while(!st.isEmpty() && k>0)
        {
            st.pop();
            k--;
        }
        String ans ="";
        while(!st.isEmpty())
        {
            
            ans=st.pop()+ans;
        }
        if(ans.equals("")) return "0";
        return ans;
    }
}
```

#### 84. Largest Rectangle in Histogram

```java
class Solution {

    public int largestRectangleArea(int[] heights) {
    
        // At any bar the largest area can be including that bar as the bottleneck
        int n = heights.length;
        int[] sl = new int[n];
        int[] sr = new int[n];
        Stack<Integer> st = new Stack();
        st.push(-1);
        for(int i=0;i<n;i++)
        {
            while(st.peek()>=0 && heights[st.peek()]>=heights[i])
                st.pop();
            sl[i]=st.peek();
            st.push(i);
        }
        st.clear();
        st.push(n);
        for(int i=n-1;i>=0;i--)
        {
            while(st.peek()<n && heights[st.peek()]>=heights[i])
                st.pop();
            sr[i]=st.peek();
            st.push(i);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            System.out.println(sr[i]+" "+sl[i]);
            max= Math.max(heights[i]*(sr[i]-sl[i]-1),max);
        }
        return max;
    }
}
```
#### 85. Maximal Rectangle

```java
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n= matrix.length;
        int m = matrix[0].length;
        int ans =0;
        int[] rowTilli= new int[m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                rowTilli[j] = (matrix[i][j]=='0')?0: rowTilli[j]+1;
            
            ans =Math.max(getMaxArea(rowTilli),ans);

        }
        return ans;
    }
    int getMaxArea(int[] rowTilli)
    {
        int n=rowTilli.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        Stack<Integer> st =  new Stack();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && rowTilli[st.peek()]>=rowTilli[i])
                st.pop();
 
            nsl[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && rowTilli[st.peek()]>=rowTilli[i])
                st.pop();
            nsr[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int maxArea = 0;
        for(int i=0;i<n;i++)
            maxArea= Math.max(maxArea,rowTilli[i]*(nsr[i]-nsl[i]-1));
        return maxArea;
    }
}
```

#### 388. Longest Absolute File Path


```java
class Solution {
    public int lengthLongestPath(String input) {
        String[] arr = input.split("\n");
        Stack<String[]> st = new Stack();
        int count=0;
        int ans =0;
        for(String str: arr )
        {
            String[] path = str.split("\t");
            while(!st.isEmpty() && st.peek().length>=path.length)
            {
                String[] temp =st.pop();
                count = count-temp[temp.length-1].length();
            }
            st.push(path);
            count = count+path[path.length-1].length();
            if(path[path.length-1].split("\\.").length>=2)
            {
                ans = Math.max(count+st.size()-1,ans);
                st.push(path);
                count = count+path[path.length-1].length();
            }
        }
        return ans;
    }
}
```


 

#### 678. Valid Parenthesis String
```java
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack();
        Stack<Integer> star = new Stack();
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c=='(')
                open.push(i);
            else if(c==')')
            {
                if(open.size()>0)
                    open.pop();
                else if(star.size()>0)
                    star.pop();
                else return false;
            }
            else
                star.push(i);
        }
        while(!open.isEmpty())
        {
            if(star.size()>0 && open.peek()<star.peek())
            {
                open.pop();
                star.pop();
            }
            else return false;
        }
     
        return true;
    }
}
```

#### 581. Shortest Unsorted Continuous Subarray
```
class Solution {
    public int findUnsortedSubarray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        int right = n;
        int left = -1;
      
        for(int i=0;i<n;i++)
        {
            if(arr[i]>max)
                max = arr[i];
            if(arr[i]<max)    right = i;
        }
        for(int i=n-1;i>=0;i--)
        {
            if(arr[i]<min)
                min = arr[i];
            if(arr[i]>min)    left = i;
        }

        return right-left+1>n?0: right-left+1;
    }
}```