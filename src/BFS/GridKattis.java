package BFS;


import java.io.*;
import java.util.*;
public class GridKattis {
    static class Pair
    {
        int x;
        int y;
        public Pair(int a, int b)
        {
            x=a;
            y=b;
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] visited = new int[m][n];
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++)
        {
            String line = in.readLine();

            for (int j = 0; j < n; j++)
            {
                grid[i][j] =  Integer.parseInt(line.substring(j, j + 1));
            }
        }
//        int minn = backTrack(0,0,grid,visited,0);


        System.out.println(BFS(grid,visited));
        in.close();
    }


    //    BFS based solution getting accepted due to the termination as soon as it founds the minimum level
    public static int BFS(int[][] grid, int[][] visited)
    {
        int m = grid.length;
        int n = grid[0].length;


//        queue for a BFS implementation
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0));
//        count variable for level calculation or steps to reach the end of the grid
        int count=0;


        while(q.size()!=0)
        {
            int siz=q.size();
            count =count +1;
            for(int i=0;i<siz;i++)
            {
                Pair temp =q.poll();
                int x=temp.x;
                int y =temp.y;

//                terminating as soon as it reached end
                if(x==m-1 && y==n-1) return count-1;

//                traversing all possible 4 direction with the value of cell steps
                if((x<m && x>=0) && (y>=0 && y<n) && visited[x][y]==0)
                {
                    q.add(new Pair( x- grid[x][y]  , y ));
                    q.add(new Pair( x  , y-grid[x][y]  ));
                    q.add(new Pair( x+ grid[x][y]  , y  ));
                    q.add(new Pair( x  , y+grid[x][y]  ));

//                    marking as visited so that it is not visited again
                    visited[x][y]=1;
                }

            }
        }
        return -1;
    }


//Time Complexity.md
//Since it is a bfs implementation visiting each node which can be at max O(m*n)
//BFS in a graph takes O(V+E) here since the vertices can be m*n.
//hence the time complexity is O(n^2);



    //    dfs based solution getting timed out due to recursive call visiting all the paths of graph then returning minimum
    public int backTrack(int i,int j,int[][] grid, int[][] visited, int step)
    {
        int m = grid.length;
        int n = grid[0].length;
        if(i>=m || j>=n || i<0 || j<0 || visited[i][j]==1 )
            return 5000;
        if(i==m-1 && j==n-1) return step;

        visited[i][j]=1;
        // return
        int mini = Math.min(
                Math.min(
                        backTrack(i+ grid[i][j] , j , grid, visited ,step + 1),
                        backTrack(i- grid[i][j] , j , grid, visited ,step + 1)),
                Math.min(
                        backTrack(i , j+ grid[i][j] , grid, visited ,step + 1),
                        backTrack(i , j- grid[i][j] , grid, visited ,step + 1))
        );
        visited[i][j]=0;
        return mini;
    }
}
