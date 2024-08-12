#### 380. Insert Delete GetRandom O(1)
```java
class RandomizedSet {
    Random random;
    HashMap<Integer,Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        random = new Random();
        map = new HashMap();
        list  = new LinkedList();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        else
        {
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        list.set(map.get(val),list.get(list.size()-1));
        map.put(list.get(list.size()-1),map.get(val));
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```

#### 1647. Minimum Deletions to Make Character Frequencies Unique
````
class Solution {
    public int minDeletions(String s) {
        int[] chars = new int[26];
        for(char c: s.toCharArray())
            chars[c-'a']++;
        Arrays.sort(chars);
        int curr = chars[25];
        int ans = 0;
        for(int i=24;i>=0;i--)
        {
            if(chars[i]>=curr && curr>=0)
            {
                if(curr>0)
                    curr = curr-1;
                ans = ans + chars[i] -curr;
            }
            else
                curr = chars[i];
        }
        return ans;

    }
}
````


####  767. Reorganize String
```java
class Solution {
    public String reorganizeString(String s) {
        StringBuilder res =new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]- a[1]);
        int max = 0;
        int[] characters = new int[26];
        for(char c:s.toCharArray())    
            characters[c-'a']++;
    
        for(int i=0;i<characters.length;i++)
            if(characters[i]>0)
                pq.add(new int[]{'a'+i,characters[i]});

        Queue<int[]> list = new LinkedList();
        while(!pq.isEmpty())
        {
            int[] p = pq.poll();
            res.append((char)p[0]);
            p[1]--;
            if(list.size()>0)
                pq.add(list.poll());
            if(p[1]>0)
                list.add(p);
        }
        
        if(list.size()>0)      
            return "";
    
        return res.toString();
            
    }
}
```