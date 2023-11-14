package Hackerrank;

import java.util.Arrays;

public class IdleServers {
    public static void main(String[] args) {
        IdleServers a = new IdleServers();
//        a.minimumCost(new int[]{3,1,5,2},6);
        a.minimumCost(new int[]{10,30,15,25},100);
//        a.minimumCost(new int[]{2,5,1,7,3,8},14);
    }
    int minimumCost(int[] data, int k )
    {
        Arrays.sort(data);
        int n = data.length;
        int high = n/2;
        int low = 0;
        int  ans = -1;
        while(low<=high)
        {
            int mid  = low+ (high-low)/2;
            if(isPossible(mid,data,k))
            {
                ans = mid;
                high =  mid-1;
            }
            else {
                low = mid +1;
            }
        }
        return ans;
    }
    boolean isPossible(int mid, int[] data, int k)
    {
        int i =0;
        int j = data.length-1;
        int sum = 0;
        while(j>i)
        {
            if(mid>0)
            {
                sum = sum+data[j];
                mid--;
                i++;
                j--;
            }
            else
            {
                sum = sum+data[i];
                i++;
                i++;
            }

        }
        if(sum>=k)
             return true;
        else return false;
    }

}
