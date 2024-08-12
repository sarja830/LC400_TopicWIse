package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FIndTheSafestPathInAGrid {

        int m;
        int n;
        int x[];
        int y[];

    public static void main(String[] args) {
        FIndTheSafestPathInAGrid a = new FIndTheSafestPathInAGrid();
        a.maximumSafenessFactor(new ArrayList<List<Integer>>(){{
            add(new ArrayList<Integer>(){{
                add(0);
                add(0);
                add(1);
            }});
            add(new ArrayList<Integer>(){{
                add(0);
                add(0);
                add(0);
            }});
            add(new ArrayList<Integer>(){{
                add(0);
                add(0);
                add(0);
            }});
        }});
    }
        public int maximumSafenessFactor(List<List<Integer>> gridList) {

            m = gridList.size();
            n = gridList.get(0).size();

            x = new int[]{0,1,0,-1};
            y = new int[]{1,0,-1,0};
            int grid[][] = BFS(gridList);
            return DFS(grid,0,0);

        }
        int DFS(int[][] grid, int xCor, int yCor)
        {

            if(xCor==m-1 && yCor==n-1)
                return  grid[xCor][yCor];

            int max = Integer.MIN_VALUE;
            for(int k=0;k<2;k++)
            {
                int nextX = xCor + x[k];
                int nextY = yCor + y[k];
                if(nextX>=0 && nextX<m && nextY>=0 && nextY<n)
                {
                    int childmin = DFS(grid,nextX,nextY);
                    max = Math.max(childmin, max);
                }
            }
            return Math.min(max,grid[xCor][yCor]);
        }


        int[][] BFS(List<List<Integer>> gridList)
        {
            int[][] grid = new int[m][n];
            Queue<int[]> q = new LinkedList<>();

            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++)
                    if(gridList.get(i).get(j)==1)
                        q.add(new int[]{i,j,-1,-1});
                    else grid[i][j] = Integer.MAX_VALUE;
            int level = 0;
            while(!q.isEmpty())
            {
                int siz = q.size();
                for(int l=0;l<siz;l++)
                {
                    int[] temp = q.poll();
                    int xCor = temp[0];
                    int yCor = temp[1];
                    int parentX = temp[2];
                    int parentY = temp[3];
                    grid[xCor][yCor] = Math.min(level,grid[xCor][yCor]);

                    for(int k=0;k<4;k++)
                    {
                        int nextX = xCor+x[k];
                        int nextY = yCor+y[k];
                        if(nextX>=0 && nextX<m && nextY>=0 && nextY<n
                                && nextX!=parentX && nextY!=parentY && grid[nextX][nextY]!=0
                        )
                            if(level+1<grid[nextX][nextY])
                                q.add(new int[]{nextX,nextY,xCor,yCor});
                    }
                }
                level++;
            }
            return grid;
        }


}
