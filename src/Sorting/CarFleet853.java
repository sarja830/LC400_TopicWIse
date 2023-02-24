package Sorting;
import java.util.*;
public class CarFleet853 {
    public static void main(String[] args) {
        CarFleet853 a = new CarFleet853();
        a.carFleet(10, new int[]{6,8}, new int[]{3,2});
    }
        public int carFleet(int target, int[] position, int[] speed) {
            int n =position.length;

            double[] ans = new double[n];
            double[][] posTime = new double[n][2];

            for(int i=0;i<n;i++)
            {
                posTime[i][0] = target - position[i];
                posTime[i][1]= (double)posTime[i][0]/(double)speed[i];
            }
            Arrays.sort(posTime,(a,b)->((int)b[0]-(int)a[0]));
            double maxSoFar = Integer.MIN_VALUE;
            for(int i=n-1;i>=0;i--)
            {
                if(maxSoFar<posTime[i][1])
                {
                    maxSoFar = posTime[i][1];
                }

                ans[i]=maxSoFar;
            }
            int count=1;
            double now=ans[0];
            for(int i=1;i<n;i++)
            {
                if(ans[i]==now)
                    continue;
                else
                {
                    count++;
                    now=ans[i];
                }
            }
            return count;

        }

}
