package Heap;
import java.util.*;
public class LC1851 {
    public static void main(String[] args) {
        minInterval(new int[][]{
                {1, 4},{
                2, 4
        },{
                3, 6
        },{
                4, 4
        }}, new int[]{2,3,4,5});
    }

    public static int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int m = intervals.length;
        int[] ans = new int[n];

        Arrays.sort(intervals,(a,b)->{
            if(a[0]>b[0])
                return 1;
            else
                return -1;
        });
        int q[] = Arrays.copyOf(queries,n);
        Arrays.sort(q);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]>b[0])    return 1;
            else return -1;
        });
        HashMap<Integer,Integer> map = new HashMap();
        for(int a: q)
            System.out.println(a);
        int j=0;
        for(int i=0;i<n;i++)
        {
            while(j<m && intervals[j][0]>=q[i])
            {
                pq.add(new int[]{intervals[j][1]-intervals[j][0]+1, intervals[j][1]});
                j++;
            }
            while(!pq.isEmpty() && pq.peek()[1]<q[i])
            {
                pq.poll();
            }
            if(pq.size()>0)
                map.put(q[i],pq.peek()[0]);
            else
                map.put(q[i],-1);
        }

        for(int i=0;i<n;i++)
            ans[i] = map.getOrDefault(queries[i],0);

        return ans;

    }

}
