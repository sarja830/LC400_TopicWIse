
package Graphs;
import java.util.*;
public class DetectCycleIn2dGrid {
    public static void main(String[] args) {
        DetectCycleIn2dGrid q = new DetectCycleIn2dGrid();
//        System.out.println(q.containsCycle(new char[][]{{'a','b','b'},{'b','z','b'},{'b','b','a'}}));
//        System.out.println(q.containsCycle(new char[][]{{'b','a','c'},{'c','a','c'},{'d','d','c'},{'b','c','c'}}));
        System.out.println(q.containsCycle(new char[][]{{'b','a','c'},{'c','a','c'},{'d','d','c'},{'b','c','c'}}));
    }


    public boolean containsCycle(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(Character.isLowerCase(grid[i][j]) && DFS(i,j,-1,-1,grid)) return true;
            }
        }
        return false;
    }

    boolean DFS(int i, int j, int parentX, int parentY, char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = Character.toUpperCase(grid[i][j]);
        int[] x = new int[]{1,0,-1,0};
        int[] y = new int[]{0,-1,0,1};
        boolean flag = false;
        for(int k=0;k<4;k++)
        {
            int xCor = i+x[k];
            int yCor = j+y[k];
            if(xCor!=parentX && yCor!=parentY && xCor>=0 && xCor<m && yCor>=0 && yCor<n && Character.toLowerCase(grid[xCor][yCor])==Character.toLowerCase(grid[i][j]) )
            {
                if(grid[xCor][yCor]==grid[i][j]) return true;
                flag = flag || DFS(xCor,yCor,i,j,grid);
            }
        }
        return flag;


    }}



//    public boolean containsCycle(char[][] grid) {
//
//        int n = grid.length;
//        int m = grid[0].length;
//
//// keep a visited array to prevent the cell from visiting again.
////Also it will help to detect if we have visited a cell again to form a cycle.
//        int[][] visited = new int[n][m];
//
//        for( int i =0;i<n;i++)
//            for(int j=0;j<m;j++)
//            {
////if unvisited then perform BFS or DFS
//                if(visited[i][j]==0)
//                    // if(DFS(i,j,grid,visited,-1 , -1))
//                    //     return true;
//                    if(BFS(i,j,grid,visited))
//                        return true;
//            }
//        return false;
//    }
//
//    boolean DFS(int i, int j, char[][] grid,int[][] visited, int parentx, int parenty)
//    {
//        int n = grid.length;
//        int m = grid[0].length;
//
//// to traverse in all 4 directions
//        int[]  x = new int[]{1,-1,0,0};
//        int[] y = new int[]{0,0,1,-1};
//
//// if it is visited by other path then return true it forms a cycle
//        if(visited[i][j]==1) return true;
//
//// mark visited and continue dfs
//        visited[i][j] =1;
//        for(int k=0;k<4;k++)
//        {
//            int xc = i+x[k];
//            int yc = j+y[k];
//
//// visit only those grid cells which has same character
//            if( xc>=0 && xc<n && yc>=0 && yc<m && grid[i][j]==grid[xc][yc])
//            {
//// check if it is not the same cell it has came from and if DFS returns true return true;
//                if((xc!=parentx || yc!=parenty) && DFS(xc,yc,grid,visited,i,j))
//                    return true;
//
//                // OR
//
//                // if(xc==parentx && yc==parenty)
//                //     continue;
//                // else
//                //     if(DFS(xc,yc,grid,visited,i,j))
//                //         return true;
//            }
//        }
//
//        return false;
//    }
//
//
//
//    boolean BFS(int i, int j, char[][] grid , int[][] visited)
//    {
//        int n = grid.length;
//        int m = grid[0].length;
//        Queue<int[]>  q = new LinkedList();
//        q.add(new int[]{i,j,-1,-1});
//        int[]  x = new int[]{1,-1,0,0};
//        int[] y = new int[]{0,0,1,-1};
//
//        while(!q.isEmpty())
//        {
//            int siz = q.size();
//            for(int l=0;l<siz;l++)
//            {
//                int[] temp = q.poll();
//                visited[temp[0]][temp[1]] =1;
//                for(int k=0;k<4;k++)
//                {
//                    int xc = temp[0]+x[k];
//                    int yc = temp[1]+y[k];
//
//
//// visit only those grid cells which has same character
//                    if(xc>=0 && xc<n && yc>=0 && yc<m && grid[temp[0]][temp[1]]==grid[xc][yc])
//
//// check if it is not the same cell it has came from a
//                        if( temp[2]!=xc || temp[3]!=yc )
//                        {
////if it is already visited then cycle exists return true
//                            if(visited[xc][yc]==1)
//                                return true;
//
//// otherwise add it to the queue
//                            q.add(new int[]{xc,yc,temp[0],temp[1]});
//                        }
//                }
//            }
//
//        }
//        return false;
//    }
//
//}
