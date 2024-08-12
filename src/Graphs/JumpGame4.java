package Graphs;
import java.util.*;
public class JumpGame4 {
    public static void main(String[] args) {
        minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404});
    }
    public static int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i=0;i<n;i++) {
            Object o = !map.containsKey(arr[i]) ? map.put(arr[i], new ArrayList<>()) :null;
            map.get(arr[i]).add(i);
        }
        HashMap<Integer,List<Integer>> graph = new HashMap();
        for(int i=0;i<n;i++)
        {
            graph.put(i, new ArrayList<>());
            if(i+1<n)
                graph.get(i).add(i+1);
            if(i-1>=0)
                graph.get(i).add(i-1);
            if(map.containsKey(arr[i]))
                for(int neighbor: map.get(arr[i]))
                    if(neighbor!=i)
                        graph.get(i).add(neighbor);
        }
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.add(0);
        while(!q.isEmpty())
        {
            int siz = q.size();
            for(int l=0;l<siz;l++)
            {
                int temp = q.poll();
                if(temp==n-1)
                    return level;
                for (int k : graph.get(temp)) {
                    q.add(k);
                }
            }
            level++;
        }
        return n-1;
    }

}
