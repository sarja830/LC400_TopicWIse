package Graphs;
import java.util.*;
public class LargestPathValue {
    public static void main(String[] args) {
        LargestPathValue a = new LargestPathValue();
        a.largestPathValue("nnllnzznn",
                new int[][]{
                        {0, 1}, {1, 2}, {2, 3}, {2, 4}, {3, 5}, {4, 6}, {3, 6}, {5, 6}, {6, 7}, {7, 8}
                });
    }
        public int largestPathValue(String colors, int[][] edges) {
            int n = colors.length();
            List<Integer>[] adjList = new LinkedList[n];
            for(int i=0;i<n;i++)
                adjList[i] = new LinkedList();
            int[] indegree = new int[n];
            Queue<Integer> q = new LinkedList();
            int[][] colorCount = new int[n][26];
            for(int[] edge: edges)
            {
                adjList[edge[0]].add(edge[1]);
                indegree[edge[1]]++;
            }
            for(int i=0;i<n;i++)
                if(indegree[i]==0)
                {
                    q.add(i);
                    colorCount[i] = new int[26];
                    colorCount[i][colors.charAt(i)-'a']++;
                }

            int ans = 1;
            int count = 0;
            while(!q.isEmpty())
            {
                int temp = q.poll();
                count++;

                for(int i: adjList[temp])
                {
                    indegree[i]--;
                    for(int x=0;x<26;x++)
                        colorCount[i][x] = Math.max(colorCount[temp][x],colorCount[i][x]);
                    if(indegree[i]==0)
                    {
                        q.add(i);
                        colorCount[i][colors.charAt(i)-'a']++;
                        if(colorCount[i][colors.charAt(i)-'a']>ans)
                            ans = colorCount[i][colors.charAt(i)-'a'];

                    }
                }
            }
            if(count!=n)
                return -1;
            else return ans;

        }


}
