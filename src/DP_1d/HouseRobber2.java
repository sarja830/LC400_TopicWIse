package DP_1d;
import java.util.*;
public class HouseRobber2 {
    public static void main(String[] args) {
        HouseRobber2 a = new HouseRobber2();
        a.rob(new int[]{1,2,3,1});
    }
        public int rob(int[] nums) {
            int n = nums.length;
            int[] res= new int[n];
            Arrays.fill(res,-1);
            res[0]=nums[0];
            res[1]=Math.max(nums[0],nums[1]);
            if(n==1) return nums[0];
            if(n==2) return Math.max(nums[0],nums[1]);
            for(int i=2;i<n-1;i++)
            {
                res[i]=Math.max(res[i-1],res[i-2]+nums[i]);
            }
            int first = res[n-2];
            Arrays.fill(res,-1);
            res[1] =nums[1];
            res[2] =Math.max(nums[1],nums[2]);
            for(int i=3;i<n;i++)
            {
                res[i]=Math.max(res[i-1],res[i-2]+nums[i]);
            }
            return Math.max(res[n-1],first);
        }
    }
