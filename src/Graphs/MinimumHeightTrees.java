package Graphs;
import java.util.*;
public class MinimumHeightTrees {
    public static void main(String[] args) {
        MinimumHeightTrees a = new MinimumHeightTrees();
        a.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
    }
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer>[] adjList = new List[n];
            int[] indegree = new int[n];
            List<Integer> ans = new LinkedList();
            for(int i=0;i<n;i++)
                adjList[i] = new LinkedList();
            for(int[] edge: edges)
            {   adjList[edge[0]].add(edge[1]);
                adjList[edge[1]].add(edge[0]);
                indegree[edge[0]]++;
                indegree[edge[1]]++;
            }
            Queue<Integer> q = new LinkedList();
            for(int i=0;i<n;i++)
            {
                if(indegree[i]==0)
                    q.add(i);
            }
            boolean flag = false;
            while(!q.isEmpty())
            {
                int siz = q.size();
                if(siz!=0)
                {
                    ans = new LinkedList(q);
                }
                for(int l=0;l<siz;l++)
                {
                    int temp = q.poll();
                    for(int i: adjList[temp])
                    {
                        indegree[i]--;
                        if(indegree[i]==1)
                        {
                            q.add(i);

                        }
                    }
                }
            }
            return ans;
        }

}
