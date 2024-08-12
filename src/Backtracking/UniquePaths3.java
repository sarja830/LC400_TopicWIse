package Backtracking;

public class UniquePaths3 {
    public static void main(String[] args) {
        UniquePaths3 a = new UniquePaths3();
        a.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}});

    }
        int m;
        int n;
        int ans;
        public  int uniquePathsIII(int[][] grid) {
            m =  grid.length;
            ans = 0;
            n = grid[0].length;
            int start[] = new int[2];
            int count = 1;
            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++)
                {
                    if(grid[i][j]==1)
                        start = new int[]{i,j};
                    else if(grid[i][j]==0)
                        count++;
                }
            rec(start[0],start[1],grid,count);
            return ans;


        }
        void rec(int i, int j, int[][] grid, int count)
        {
            int sum = 0;
            if(grid[i][j]==2 && count<0)
                ans++;
            if(count==0) return ;
            int[] x = new int[]{1,-1,0,0};
            int[] y = new int[]{0,0,1,-1};

            for(int k=0;k<4;k++)
            {
                int xCor = i+x[k];
                int yCor = j+y[k];
                if(xCor >= 0 && xCor<m && yCor>=0 && yCor<n &&  grid[xCor][yCor] != -1 &&grid[xCor][yCor] != 3 && grid[xCor][yCor] != 1)
                {
                    grid[xCor][yCor] = 3;
                    rec(xCor,yCor, grid,count-1);
                    grid[xCor][yCor] = 0;
                }
            }

        }

}
