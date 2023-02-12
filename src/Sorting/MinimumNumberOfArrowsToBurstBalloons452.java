package Sorting;
import java.util.*;
public class MinimumNumberOfArrowsToBurstBalloons452 {
    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons452 a= new MinimumNumberOfArrowsToBurstBalloons452();
        a.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}});
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->a[0]/2-b[0]/2);
        List<int[]> ans = new LinkedList();
        int m=points.length, n=points[0].length;
        int[] a = new int[]{points[0][0],points[0][1]};

        for(int i=0;i<m;i++)
        {
            if(a[1]>=points[i][0])
            {
                a[0]=Math.min(a[0],points[i][0]);
                a[1]= Math.min(points[i][1],a[1]);
            }
            else
            {
                ans.add(new int[]{a[0],a[1]});
                a[0]=points[i][0];
                a[1]=points[i][1];
            }
        }

        ans.add(new int[]{a[0],a[1]});
        return ans.size();
    }

}
