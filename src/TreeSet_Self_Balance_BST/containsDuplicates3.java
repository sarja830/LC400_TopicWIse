package TreeSet_Self_Balance_BST;
import java.util.*;
public class containsDuplicates3 {
    public static void main(String[] args) {
        containsNearbyAlmostDuplicate(new int[]{4,1,6,3},4,1);
    }

        public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            TreeSet<Integer> set = new TreeSet();
            int n = nums.length;
            int i = 0;
            for(int j=0;j<n;j++)
            {
                if( j-i>indexDiff)
                    set.remove(nums[i++]);

                Integer ceil = set.ceiling(nums[j]);
                if ( ceil!=null && Math.abs((int)ceil)-nums[j] <=valueDiff)
                    return true;
                Integer floor = set.floor(nums[j]);
                if( floor!=null && Math.abs((int)floor-nums[j])<=valueDiff)
                    return true;

                set.add(nums[j]);
            }
            return false;
        }


}
