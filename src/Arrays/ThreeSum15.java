package Arrays;
import java.util.*;
public class ThreeSum15 {
    public static void main(String[] args) {
//        List<List<Integer>> ans = threeSum(new int[]{-2,0,1,1,2});

        List<List<Integer>> ans = threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4});
        System.out.println();
    }
        public static List<List<Integer>> threeSum(int[] nums) {
            int target=0;
            int n =nums.length;

// sort the array
            Arrays.sort(nums);
            List<List<Integer>> ans = new LinkedList();

// iterate over the array from left to right
            for(int i=0;i<nums.length-2;i++)
            {

//to elimiate duplicates
                if(i>0 && nums[i]==nums[i-1]) continue;

//setup subarray using l and r pointer and search for the target-nums[i]
                int l = i+1;
                int r=nums.length-1;
                int addUp = target-nums[i];

                while(l<r)
                {
                    if(nums[l]+nums[r]==addUp)
                    {
                        ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        l++;
                        r--;

//2 while loops to eliminate duplicates-----
                        while (l<n && l-1>0 && nums[l] == nums[l -1])
                            l++;
                        while (r > 0 && r+1<n && nums[r] == nums[r + 1])
                            r--;
                    }
                    else if(nums[l]+nums[r]<addUp)l++;
                    else if(nums[l]+nums[r]>addUp)r--;
                }
            }
            return ans;

        }
}
