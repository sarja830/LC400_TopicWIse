package DFS;

public class Sign {

    public static void main(String[] args) {
        Sign a = new Sign();
        a.regionsBySlashes(new String[]{"/\\","\\/"});
    }
    public int regionsBySlashes(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int k=0;
        int ans = 0;
        int[][] convertedMatrix = new int[m*3][n*3];
        for(int i=0;i<3*m;i+=3)
        {
            String s = grid[k++];
            // System.out.println(s);
            int curr =0 ;
            for(int j=0;j<3*n;j+=3)
            {
                if(s.charAt(curr)==' ' || s.charAt(curr)=='/')
                {
                    System.out.println(s.charAt(curr));
                    addCells(convertedMatrix,i,j,s.charAt(curr)+"");
                    curr++;
                }
                else
                {
                    System.out.println(s.charAt(curr));
                    addCells(convertedMatrix,i,j,s.charAt(curr)+s.charAt(curr+1)+"");
                    curr+=2;
                }
            }
        }

        for(int i=0;i<3*m;i+=3)
            for(int j=0;j<3*n;j+=3)
            {
                if(convertedMatrix[i][j]==0)
                {
                    dfs(convertedMatrix,i,j);
                    ans++;
                }
            }
        return ans;

    }
    void dfs(int[][] grid, int i, int j)
    {
        int m =grid.length;
        int n =grid[0].length;
        grid[i][j] = -1;
        int[] x = new int[]{0,0,1,-1};
        int[] y = new int[]{1,-1,0,0};
        for(int k=0;k<4;k++)
        {
            int xCor = i+x[k];
            int yCor = j+y[k];
            if(xCor>=0 && xCor<m && yCor>=0 && yCor<n && grid[xCor][yCor]==0)
                dfs(grid,xCor,yCor);
        }
    }
    void addCells(int[][] convertedMatrix, int startI, int startJ, String c )
    {

        if(c.equals("/"))
        {
            for(int i=startI;i<startI+3;i++)
                for(int j=startJ;j<startJ+3;j++)
                {
                    if(i==2-j)
                        convertedMatrix[i][j]=1;
                }
        }
        else if(c.equals("\\"))
        {
            for(int i=startI;i<startI+3;i++)
                for(int j=startJ;j<startJ+3;j++)
                {
                    if(i==j)
                        convertedMatrix[i][j]=1;
                }
        }
    }
}

