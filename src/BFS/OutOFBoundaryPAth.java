package BFS;
import java.util.*;
public class OutOFBoundaryPAth {
    public static void main(String[] args) {
        OutOFBoundaryPAth a= new OutOFBoundaryPAth();
        a.findPaths(2,2,2,0,0);
    }
    int maxMove;
    int m;
    int n;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.maxMove = maxMove;
        return rec(startRow,startColumn, 0);
    }
    int rec(int i, int j, int level )
    {
        if(level<=maxMove && (i==-1 || j==-1 || i==m || j==n) ) return 1;
        if(level>maxMove) return 0;
        return rec(i+1,j,level+1) +
                rec(i-1,j,level+1)+
                rec(i,j+1,level+1)+
                rec(i,j-1,level+1);

    }
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//            int[] x = new int[]{0,0,1,-1};
//            int[] y = new int[]{1,-1,0,0};
//            Queue<int[]> q = new LinkedList();
//            q.add(new int[]{startRow,startColumn});
//            int level = 0;
//            int ans = 0;
//            while(!q.isEmpty())
//            {
//                int siz = q.size();
//                for(int l=0;l<siz;l++)
//                {
//                    int[] temp = q.poll();
//                    for(int k=0;k<4;k++)
//                    {
//                        int xCor = temp[0] + x[k];
//                        int yCor = temp[1]+ y[k];
//                        if(xCor>=-1 && xCor<=m && yCor>=-1 && yCor<=n)
//                        {
//                            if(xCor==-1 || xCor==m || yCor==-1 || yCor==n)
//                                ans++;
//                            else
//                                q.add(new int[]{xCor,yCor});
//                        }
//                    }
//                    level++;
//                    if(level==maxMove)
//                        return ans;
//                }
//            }
//            return ans;
//        }

}
