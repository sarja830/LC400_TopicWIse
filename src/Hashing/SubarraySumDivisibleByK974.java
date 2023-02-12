package Hashing;
import java.util.*;
public class SubarraySumDivisibleByK974 {
    public static void main(String[] args) {
        SubarraySumDivisibleByK974 a = new SubarraySumDivisibleByK974();
//        a.subarraysDivByK(new int[]{4,5,0,-2,-3,1},5);
        a.subarraysDivByK(new int[]{0,-5},10);
    }
        public int subarraysDivByK(int[] nums, int k) {
            int count=0;
            HashMap<Integer,Integer> map = new HashMap();
            map.put(0,1);
            int sum=0;
            if(nums.length==1)
            {
                if(nums[0]%k==0) return 1;
                else return 0;
            }
            for(int i=0;i<nums.length;i++)
            {
                sum=(sum+nums[i]%k)%k;
                if(nums[i]%k==0) count=count+1;
                if(map.containsKey((k-(nums[i]%k))%k))
                {
                    count=count+map.get((k-nums[i]%k)%k);

                }
                if(map.containsKey(sum))
                    map.put(sum,map.get(sum)+1);
                else
                    map.put(sum,1);
            }
            return count;
        }

}
