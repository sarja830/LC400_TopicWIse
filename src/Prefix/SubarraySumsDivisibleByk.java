package Prefix;
import java.util.*;
public class SubarraySumsDivisibleByk {
    public static void main(String[] args) {
        subarraysDivByK(new int[]{-1,2,9},2);
    }
        public static int subarraysDivByK(int[] nums, int k) {
            int n = nums.length;
            int[] prefix = new int[n];
            int count  =0;
            HashMap<Integer,Integer> map = new HashMap();
            map.put(0,1);
            for(int i=0;i<n;i++)
            {
                prefix[i] =nums[i] + ((i>0)?prefix[i-1]:0);
            }
            for(int i=0;i<n;i++)
            {

                prefix[i] = prefix[i]%k;
                count = count+map.getOrDefault(prefix[i],0);
                map.put(prefix[i], map.getOrDefault(prefix[i],0)+1);
            }
            return count;
        }

}
