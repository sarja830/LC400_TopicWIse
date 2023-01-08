package Hashing;
import java.util.*;
public class ContinuosSubarraySum523 {
    public static void main(String[] args) {
        checkSubarraySum(new int[]{5,0,0,0},3);
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<n;i++)
        {
            nums[i]=nums[i]%k;
            sum=sum+nums[i];
            sum=sum%k;
            if(map.containsKey(k-nums[i]))
            {
                if(i-map.get(k-nums[i])>=2)
                    return true;
            }
            else
                if(map.containsKey(sum)) continue;
                else map.put(sum,i);
        }
        return false;
    }
}
