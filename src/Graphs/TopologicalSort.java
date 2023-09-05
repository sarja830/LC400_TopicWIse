package Graphs;
import java.util.*;
public class TopologicalSort {
    public static void main(String[] args) {
        List<Integer> list = topologicalSort(new int[][]{
                {0,1},
                {0,2},
                {1,2}
        }
        ,3,3);

        for(int i:list)
        {
            System.out.println(i);
        }
    }
    public static List<Integer> topologicalSort(int[][] edge, int e, int v) {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for(int i=0;i<e;i++)
        {
            adj.putIfAbsent(edge[i][0],new LinkedList<>()).add(edge[i][1]);
        }

        int[] visited = new int[v];
        Stack<Integer> st = new Stack();
        for(int i=0;i<v;i++)
            if(visited[i]==0)
                DFS(st,adj,i,visited);

        List<Integer> ans = new LinkedList<Integer>();
        while(!st.isEmpty())
        {
            ans.add(st.pop());
        }
        return ans;
    }
    static void  DFS(Stack<Integer> st , HashMap<Integer,List<Integer>> adj, int node, int[] visited)
    {
        visited[node] =1;
        if(adj.containsKey(node))
            for( int i: adj.get(node) )
            {
                DFS(st,adj,i,visited);
            }
        st.push(node);

    }

}
