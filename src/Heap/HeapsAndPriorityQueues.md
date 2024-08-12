
## Time complexity

insertion: O(logn)
Deletion peek element: O(logn)
Deletion other than peek : O(n) [search and find]
Heap creation: O(n)

## Problems
#### 451. Sort Characters By Frequency
inefficient way
```java
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c: s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        class Pair
        {
            int count;
            char c;
            public Pair(int count, char c)
            {
                this.count=count;
                this.c=c;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a,Pair b)->{
            if(a.count>b.count)
                return -1;
            else
                return 1;
        });
        for(char ch:map.keySet())
        {
            pq.add(new Pair(map.get(ch),ch));
        }
        String res = "";
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            for(int i=0;i<p.count;i++)
                res = res+p.c;
        }
        return res;
    }
}
```

```java
class Solution {
    public String frequencySort(String s) {
        int[] map = new int[256];
        for(char c: s.toCharArray())
            map[c]++;

        class Pair
        {
            int count;
            char c;
            public Pair( char c,int count)
            {
                this.count=count;
                this.c=c;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a,Pair b)->{
            if(a.count>b.count)
                return -1;
            else
                return 1;
        });
        for(int i=0;i<256;i++)
        {
            if(map[i]>0)
                pq.add(new Pair((char)i,map[i]));
        }
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            for(int i=0;i<p.count;i++)
                res = res.append(p.c);
        }
        return res.toString();


    }
}
```

#### 767. Reorganize String
```java Ï
class Solution {
    public String reorganizeString(String s) {
        String res ="";
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]>b[1])
                return -1;
            else return 1;
        });
        int max = 0;
        int[] characters = new int[26];
        for(char c:s.toCharArray())
        {
            characters[c-'a']++;
            if(max<characters[c-'a'])
                max = characters[c-'a'];
        }
        if(max-1>s.length()-max)
            return "";


        for(int i=0;i<characters.length;i++)
            if(characters[i]>0)
                pq.add(new int[]{'a'+i,characters[i]});

        Queue<int[]> list = new LinkedList();
        while(!pq.isEmpty())
        {
            int[] p = pq.poll();
            res =res + (char)p[0];
            p[1]--;
            if(list.size()>0)
                pq.add(list.poll());
            if(p[1]>0)
                list.add(p);
                
        }
        if(list.size()>0)
             res =res+(char)list.peek()[0];
        return res;
            
    }
}
```



#### 2551. Put Marbles in Bags - https://leetcode.com/problems/put-marbles-in-bags/
```java
class Solution {
    public long putMarbles(int[] nums, int k) {
        PriorityQueue<Integer> pqGreater = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> pqSmaller = new PriorityQueue<Integer>();

        long sum = 0;
        int n = nums.length;
        for(int i=1;i<n;i++)
        {
            
            pqGreater.add(nums[i]+nums[i-1]);
            pqSmaller.add(nums[i]+nums[i-1]);
            if(pqGreater.size()>=k)
                pqGreater.poll();
            if(pqSmaller.size()>=k)
                pqSmaller.poll();
        }

        while(pqGreater.size()>0)
            sum = sum + pqGreater.poll();
        while(pqSmaller.size()>0)
            sum = sum - pqSmaller.poll();
            
        return -1*sum;

    }
}
```