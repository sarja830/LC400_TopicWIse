package Graphs;

import java.util.LinkedList;
import java.util.List;

public class SumOfDistancesInTree {
    public static void main(String[] args) {
        sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
    }

    public static int sumOfDistancesInTree(int n, int[][] edges) {
        List<Integer>[] adjList = new LinkedList[n];
        for(int i=0;i<n;i++)
            adjList[i] = new LinkedList();
        for(int[] edge: edges)
        {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        int[] sum = new int[n];
        int[] count = new int[n];
        dfs(adjList,0,-1,count,sum);
        return sum[0];
    }
    // for a single node
    static void dfs(List<Integer>[] adjList, int node, int parent, int count[], int sum[]) {
        for (int child : adjList[node]) {
            if (child != parent) {
                dfs(adjList, child, node, count, sum);
                count[node] =count[node] + count[child];
                sum[node] += sum[child] + count[child];
            }
        }
        count[node]++;
    }


}
