
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