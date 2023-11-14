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