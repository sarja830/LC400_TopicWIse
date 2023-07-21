package BinarySearch;
import java.util.*;
public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        MagneticForceBetweenTwoBalls a = new MagneticForceBetweenTwoBalls();
        a.maxDistance(new int[]{22,57,74,79},4);
    }
    public int maxDistance(int[] position, int m) {
            Arrays.sort(position);

            int low = 0, n=position.length, high = position[n-1], ans =-1;
            while(high>=low)
            {
                int mid = low+(high-low)/2;
                if(isPossible(mid,m,position))
                {
                    ans =mid;
                    low = mid +1;
                }
                else
                {
                    high =mid-1;
                }
            }
            return ans;
        }
        boolean isPossible(int mid, int m, int[] position)
        {
            int last = position[0], i=1, n = position.length;
            m=m-1;

            while(m!=0)
            {

                while(i<n && last+mid>position[i])
                {
                    i++;
                }
                if(i==n) return false;
                last=i;
                m=m-1;
            }
            return true;
        }

}
