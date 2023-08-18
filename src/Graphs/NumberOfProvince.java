package Graphs;
import java.util.*;
public class NumberOfProvince {
    public static void main(String[] args) {
        NumberOfProvince a = new NumberOfProvince();
        a.findCircleNum(new int[][]{
                {1,0,0,1},
                {0, 1, 1, 0} ,
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        });

    }

    int[]  visited;
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new LinkedList();
        for(int i =0;i<isConnected.length;i++)
        {
            List<Integer> list = new LinkedList();
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                    list.add(j);
            }
            adj.add(list);
        }
        int count=0;

        visited = new int[isConnected.length];
        int n =visited.length;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                //DFS(i, adj );
                BFS(i, adj);
                count++;
            }
        }
        return count;
    }

    void BFS(int root, List<List<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty())
        {
            int temp = q.poll();
            visited[temp] =1;
            List<Integer> neighbors = adj.get(root);
            for(int i: neighbors)
            {
                if(visited[i]==0)
                    q.add(i);
            }
        }
        return;
    }

    void DFS(int root, List<List<Integer>> adj)
    {
        visited[root] =1;
        List<Integer> neighbors = adj.get(root);
        for(int i:neighbors)
        {
            if(visited[i]==0)
                DFS(i,adj);
        }
    }

}
