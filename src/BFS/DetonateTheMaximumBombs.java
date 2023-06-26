package BFS;
import java.util.*;
public class DetonateTheMaximumBombs {
    public static void main(String[] args) {
        DetonateTheMaximumBombs a = new DetonateTheMaximumBombs();
        a.maximumDetonation(new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}});
    }
    public int maximumDetonation(int[][] bombs)
    {
        int max=0;
        Arrays.sort(bombs,(a,b)->(b[2]-a[2]));
        for(int i=0;i<bombs.length;i++)
        {
            if(bombs[i][2]!=-1)
            {
                int count=0;
                Queue<int[]> q = new LinkedList<int[]>();
                q.add(Arrays.copyOf(bombs[i],bombs[0].length));
                bombs[i][2]=-1;
                while(!q.isEmpty())
                {
                    int[] temp = q.poll();
                    count++;
                    for(int ij=0;ij<bombs.length;ij++)
                    {
                        if(bombs[ij][2]!=-1 && (int)distance(temp,bombs[ij])<=temp[2])
                        {
                            q.add(bombs[ij]);
                            bombs[ij][2]=-1;
                        }
                    }
                }
                max=Math.max(count,max);
            }

        }
        return max;
    }



    double distance(int[] x, int[] y)
    {
        double ab= Math.sqrt(Math.pow(x[0]-y[0],2)+Math.pow(x[1]-y[1],2));
        return ab;

    }

}
