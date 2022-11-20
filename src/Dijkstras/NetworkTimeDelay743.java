package Dijkstras;
import java.util.*;
public class NetworkTimeDelay743 {
    public static void main(String[] args) {
        NetworkTimeDelay743 n = new NetworkTimeDelay743();
//        times = {{2,1,1},{2,3,1},{3,4,1}}, n = 4, k = 2
        n.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2);
    }


        public int networkDelayTime(int[][] times, int n, int source) {

            HashMap<Integer,List<int[]>> map = new HashMap();

            for(int[] time:times)
            {
                if(!map.containsKey(time[0]))
                {
                    List<int[]> l = new LinkedList();
                    l.add(time);
                    map.put(time[0],l);
                }
                else
                {
                    List<int[]> lk =map.get(time[0]);
                    lk.add(time);
                    map.put(time[0],lk);
                }
            }


            // intialize the distance array and fill it as infinity
            int[] d = new int[n+1];
            Arrays.fill(d,10000);
            d[source]=0;

//            priority based on distance in pq int[]{node , distance_from_source}
//            priority based on distance
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
            pq.add(new int[]{source,d[source]});

            HashSet<Integer> processed = new HashSet();


            while(pq.size()!=0)
            {
                int[] current =pq.poll();
                int u =current[0];
//            int distance = current[1];

                if(processed.contains(u)) continue;

                processed.add(u);


                if(map.containsKey(u))
                    for(int[] nodes:map.get(u))
                    {
                        int v =nodes[1];
                        int distance=nodes[2];
                        if(d[v]>d[u]+distance)
                            d[v]=d[u]+distance;
                        pq.add(new int[]{v,d[v]});
                    }
            }

            int max=0;
            for(int i=1;i<d.length;i++)
            {
                if(i==source) continue;
                else
                    max=Math.max(max,d[i]);
            }
            if(processed.size()!=n) return -1;
            else return max;
        }

}

   

