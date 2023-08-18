import java.util.*;
class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer,List<Integer>> adj = new HashMap();
        int i=0;
        for(int[] edge: graph)
        {

            adj.putIfAbsent(i,new LinkedList());
            for(int j=0;j<edge.length;j++)
                adj.get(i).add(edge[j]);
            i++;
        }

        int[] color = new int[adj.size()];
        Arrays.fill(color,-1);
        for(i=0;i<color.length;i++)
        {
            if(color[i]==-1)
                if(!BFS(i,adj,color))
                    return false;
        }
    }


    boolean BFS(int root,Map<Integer,List<Integer>> adj ,int[] color){


        Queue<Integer> q = new LinkedList();
        int level=0;
        q.add(root);

        while(!q.isEmpty())
        {
            int siz = q.size();
            level++;
            for(int l=0;l<siz;l++)
            {
                int temp = q.poll();
                if(level%2==0 )
                    color[temp] = 0;
                List<Integer> neighbors = adj.get(temp);
                for( i=0;i<neighbors.size();i++)
                {
                    int neighbor = neighbors.get(i);
                    if(color[neighbor]==-1)
                    {
                        q.add(neighbors.get(i));
                    }
                    else
                    {
                        if(color[neighbor] == color[temp])
                            return false;
                    }
                }
            }
        }
    }
}