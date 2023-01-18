package Arrays;
import java.util.*;

public class FindTheDuplicateNumber287 {

        //solution using concept of linked list in a cycle
        // TC: O(n)
        // SC: O(1)
        public int findDuplicate(int[] nums) {
            if(nums.length<2)  return nums[0];
            int slow=nums[0];
            int fast=nums[nums[0]];
            while(slow!=fast  )
            {
                slow=nums[slow];
                fast=nums[nums[fast]];
            }

            fast=0;
            while(slow!=fast)
            {
                slow=nums[slow];
                fast=nums[fast];
            }
            return slow;
        }

        // Solution using hashset
        // TC: O(n)
        // SC: O(n)
        public int QfindDuplicate(int[] nums) {
            int n = nums.length;
            HashSet<Integer> set = new HashSet();
            for(int i=0;i<n;i++)
            {
                if(set.contains(nums[i])) return nums[i];
                else set.add(nums[i]);
            }
            return -1;
        }


    public static void main(String[] args) {
        FindTheDuplicateNumber287 a = new FindTheDuplicateNumber287();
        a.findDuplicate(new int[]{1,3,4,2,2});
    }
}
