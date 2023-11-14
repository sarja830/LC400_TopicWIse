package SlidingWindow;
import java.util.*;
public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        SubarraysWithKDifferentIntegers a= new SubarraysWithKDifferentIntegers();
        a.subarraysWithKDistinct(new int[]{1,2},1);
    }
        public int subarraysWithKDistinct(int[] nums, int k) {
            return countSubarrayHavingAtmostKDistinct(nums,k)-countSubarrayHavingAtmostKDistinct(nums,k-1);
        }
        int  countSubarrayHavingAtmostKDistinct(int[] nums, int k) {
            HashMap<Integer,Integer> map = new HashMap();
            int i=0,j=0, count =0, n = nums.length;
            for(j=0;j<n;j++)
            {
                int num = nums[j];
                if(map.containsKey(num))
                {
                    map.put(num,map.get(num)+1);
                }
                else
                {
                    while(map.size()==k)
                    {
                        map.put(nums[i],map.get(nums[i])-1);
                        if(map.get(nums[i])==0)
                            map.remove(nums[i]);
                        i++;
                    }
                    map.put(nums[j],1);
                }
                count=count+j-i+1;
            }
            return count;
        }

}
