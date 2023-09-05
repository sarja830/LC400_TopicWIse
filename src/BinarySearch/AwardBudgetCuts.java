package BinarySearch;
import java.io.*;
import java.util.*;

public class AwardBudgetCuts {

        static double findGrantsCap(double[] grantsArray, double newBudget) {
            double low= 0, high =newBudget, ans = 0;
            Arrays.sort(grantsArray);
            while(low<=high)
            {
                int mid = (int)(low+high)/2;
                if(isPossible(mid,grantsArray,newBudget))
                {
                    ans = mid;
                    low = mid+1;
                }
                else
                {
                    high =mid-1;
                }
            }
            return ans;
        }
        static boolean isPossible(double sal, double[] nums, double total)
        {
            double n = nums.length;
            for(int i=0;i<n;i++)
            {
                if(nums[i]>sal)
                {
                    if(total<=0) return false;
                    total = total -sal;
                }
                else
                {
                    total=total-nums[i];
                }
            }
            if(total<0) return false;
            return true;
        }

        public static void main(String[] args) {
//            System.out.println( findGrantsCap(new double[]{2,100,50,120,1000},190) );
            System.out.println( findGrantsCap(new double[]{2,4,6},3) );
        }


}
