package BFS;
import java.util.*;
public class SHortestBridge {
    int[] x = new int[]{1,-1,0,0};
    int[] y = new int[]{0,0,1,-1};
    int m;
    int n;

    public static void main(String[] args) {
        SHortestBridge a = new SHortestBridge();
        a.shortestBridge(
                new int[][]{{0, 1, 0, 0, 0},
                        {0, 1, 0, 1, 1},
                        {0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0}});
    }

        public int shortestBridge(int[][] grid) {
            int level = 0;
            m =grid.length;  n = grid[0].length;
            Queue<int[]> q = new LinkedList();
            for(int i=0;i<m;i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        DFS(i, j, grid, q);
                        while(!q.isEmpty())
                        {
                            int siz = q.size();
                            for(int l=0;l<siz;l++)
                            {
                                int[] temp = q.poll();

                                for(int k=0;k<4;k++)
                                {
                                    int xCor = temp[0]+x[k];
                                    int yCor = temp[1]+y[k];
                                    if(xCor>=0 && xCor<m && yCor>=0 && yCor<n && (grid[xCor][yCor]==0 || grid[xCor][yCor]==1))
                                    {
                                        if(grid[xCor][yCor]==1)
                                            return level;
                                        q.add(new int[]{xCor,yCor});
                                        grid[xCor][yCor] = 2;
                                    }

                                }
                            }
                            level++;
                        }
                    }
                }
            }

            return level-1;
        }



        void DFS(int i, int j, int[][] grid, Queue<int[]> q)
        {

            grid[i][j] = 2;
            q.add(new int[]{i,j});

            for(int k=0;k<4;k++)
            {
                int xCor = i+x[k];
                int yCor = j+y[k];
                if(xCor>=0 && xCor<m && yCor>=0 && yCor<n && grid[xCor][yCor]==1)
                    DFS(xCor,yCor,grid,q);
            }
        }

}
