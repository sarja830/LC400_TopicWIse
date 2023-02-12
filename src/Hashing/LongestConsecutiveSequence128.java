package Hashing;
import java.util.*;
public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        LongestConsecutiveSequence128 a = new LongestConsecutiveSequence128();
        a.longestConsecutive(new int[]{100,4,200,1,3,2});
    }

        public int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet();
            for(int i:nums)
            {
                set.add(i);
            }
            int max=0;
            for(int i=0;i<nums.length;i++)
            {
                if(set.contains(nums[i]-1))
                    continue;
                else
                {
                    int j=1;
                    int count=1;
                    while(set.contains(nums[i]+j))
                    {
                        j++;
                        count++;
                    }
                    max=Math.max(max,count);
                }
            }
            return max;
        }

}
