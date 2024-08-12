package Graphs;

public class countSubIsland {

    public static void main(String[] args) {
        countSubIsland a = new countSubIsland();

        int[][] grid1 ={{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 ={{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        a.countSubIslands(grid1, grid2 );
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count=0;
        int m = grid2.length;
        int n = grid1.length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid2[i][j]==1)
                {
                    if(DFS(i,j,grid2,grid1)) count++;
                }
            }
        }
        return count;
    }

    boolean DFS(int i, int j, int[][] grid, int[][] check)
    {
        int m = grid.length;
        int n = grid[0].length;
        int x[] = new int[]{1,-1,0,0};
        int y[] = new int[]{0,0,1,-1};

        boolean ans = true;
        grid[i][j] = 2;
        if(check[i][j]==0)
            ans = false;
        for(int k=0;k<4;k++)
        {
            int xCor = i+x[k];
            int yCor = j+y[k];
            if(xCor>=0 && xCor<m && yCor>=0 && yCor<n && grid[xCor][yCor]==1)
            {
                if(check[xCor][yCor]==0)
                {
                    ans = false;
                }
                ans = ans && DFS(xCor,yCor,grid,check);
            }
        }
        return ans;
    }

}


