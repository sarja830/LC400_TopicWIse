##  (HARD )
#### 815. Bus Routes
```java
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // bus stops and buses from that stop
        HashMap<Integer,List<Integer>> map = new HashMap();
        int n =  routes.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<routes[i].length;j++)
            {
                List<Integer> list =    map.getOrDefault(routes[i][j],new LinkedList());
                list.add(i);
                map.put(routes[i][j],list);
            }
        int level = 0;

        Queue<Integer> q = new LinkedList();
        int[] visitedStops = new int[1000000];
        int[] visitedBuses = new int[1000000];
        q.add(source);
        visitedStops[source] = 1;
        while(!q.isEmpty())
        {

            int siz = q.size();
            for(int i=0;i<siz;i++)
            {
                int temp = q.poll();
                if(temp==target)
                    return level;

                List<Integer> buses = map.get(temp);
                for(int j=0;j<buses.size();j++)
                {
                    if(visitedBuses[buses.get(j)]==0)
                    {
                        for(int k: routes[buses.get(j)])
                            if(visitedStops[k]==0)
                            {
                                q.add(k);
                                visitedStops[k] = 1;
                            }
                        visitedBuses[buses.get(j)]=1;
                    }
                }

            }
            level++;
        }
        return -1;

    }
}
```


#### 1424. Diagonal Traverse II
```java
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> ans = new LinkedList();
        if(nums.size()==0)  return ans.stream().mapToInt(i->i).toArray();
        
        Queue<Integer> qx = new LinkedList();
        Queue<Integer> qy = new LinkedList();
      
        qx.add(0);
        qy.add(0);
        ans.add(nums.get(0).get(0));
        while(!qx.isEmpty())
        {
            int siz = qx.size();
            for(int l =0;l<siz;l++)
            {
                
                int i = qx.poll();
                int j = qy.poll();
                if(i+1<nums.size() && nums.get(i+1).size()>j && nums.get(i+1).get(j)!=null )
                {
                    qx.add(i+1);
                    qy.add(j);
                    ans.add(nums.get(i+1).get(j));
                    nums.get(i+1).set(j,null);
                }
                if( nums.get(i).size()>j+1 && nums.get(i).get(j+1)!=null)
                {
                    qx.add(i);
                    qy.add(j+1);
                    ans.add(nums.get(i).get(j+1));
                    nums.get(i).set(j+1,null);
                }
                
                
            }
        
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
}
```


#### 498. Diagonal Traverse
```java
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean flag = true;
        List<Integer> finalAns = new LinkedList();
        Queue<Integer> qx = new LinkedList();
        Queue<Integer> qy = new LinkedList();
        qx.add(0);
        qy.add(0);
        finalAns.add(mat[0][0]);
        while(!qx.isEmpty())
        {
            int siz = qx.size();
            List<Integer> ans = new LinkedList();
            for(int l=0;l<siz;l++)
            {
                int i = qx.poll();
                int j = qy.poll();
                if(j+1<n && !visited[i][j+1])
                {
                    qx.add(i);
                    qy.add(j+1);
                    ans.add(mat[i][j+1]);
                    visited[i][j+1] = true;
                }
                if(i+1<m && !visited[i+1][j])
                {
                    qx.add(i+1);
                    qy.add(j);
                    ans.add(mat[i+1][j]);
                    visited[i+1][j] = true;
                }
            }

            if(!flag)
                Collections.reverse(ans);
            finalAns.addAll(ans);
            flag = !flag;

        }
        return finalAns.stream().mapToInt(i->i).toArray();
    }
}
```



#### Word break 

```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Queue<Integer> q = new LinkedList();
        
        int n = s.length();
        int[] visited = new int[n+1];
        q.add(0);
        while(!q.isEmpty())
        {
            
            int temp = q.poll();
            if(temp==n) return true;
            for(String word: wordDict)
            {
                int n1 = word.length();
                if(temp+n1<=n)
                {
                    String w = s.substring(temp,temp+n1);
                    if(w.equals(word) && visited[temp+n1]==0)
                    {
                        visited[temp+n1] = 1;
                        q.add(temp+n1);
                    }
                }
            }

        }
        return false;
        
    }
}
```

#### 140. Word Break II
```java
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Queue<Integer> q = new LinkedList();
        Queue<List<String>> q1 = new LinkedList();
        HashSet<String> set = new HashSet(wordDict);
         List<String> ans = new LinkedList();
        int n = s.length();
        q.add(0);

        while(!q.isEmpty())
        {
            int temp = q.poll();
            List<String> l = ((!q1.isEmpty())?q1.poll(): new LinkedList());
                
            if(temp==n)
            {
                String as = "";
                for(String s1: l)
                    if(as.length()==0)
                        as = s1;
                    else
                        as = as+" "+s1;
                ans.add(as);
                continue;
            }
            for(String word: wordDict)
            {
                int n1 = word.length();
                if(temp+n1<=n)
                {
                    String w = s.substring(temp,temp+n1);
                    if(w.equals(word))
                    {
                        q.add(temp+n1);
                        l.add(w);
                        q1.add(new LinkedList(l));
                        l.remove(l.size()-1);
                    }
                }
            }
        }
        return ans;
        
    }
}
```

####
```java
class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        int level=0;
        HashSet<String> set = new HashSet(Arrays.asList(deadends));
        Queue<char[]> q = new LinkedList();
        q.add(start.toCharArray());
        while(!q.isEmpty())
        {   
            int siz = q.size();
            for(int l=0;l<siz;l++)
            {
                char[] temp = q.poll();
                if(set.contains(String.valueOf(temp)))
                   continue;
                if((String.valueOf(temp)).equals(target))
                    return level;
                set.add(String.valueOf(temp));
                for(int i=0;i<4;i++) 
                {
                    char backup = temp[i];
                    int curr = temp[i] - '0';
                    int prev = (curr - 1) >= 0 ? curr - 1 : 9;
                    temp[i] = (char) (prev + '0');
                    q.add(Arrays.copyOf(temp, 4));

                    temp[i] = backup;
                    int next = (curr + 1) % 10;
                    temp[i] = (char) (next + '0');
                    q.add(Arrays.copyOf(temp, 4));
                    temp[i] = backup;
                }
            }
            level++;
        }
        return -1;
    }
}
```