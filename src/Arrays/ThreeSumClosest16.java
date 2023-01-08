package Arrays;
import java.util.*;
public class ThreeSumClosest16 {
    public static void main(String[] args) {
        threeSumClosest();
    }
    public static int threeSumClosest(int[] nums, int target) {

        int n =nums.length;
        int sum,min=Integer.MAX_VALUE;
        int res=target;
        // HashMap<Integer,Integer> map = new HashMap<>();

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
            int addUp=target-nums[i];
            while(l<r)
            {
                sum=nums[i]+nums[l]+nums[r];
                if(min>Math.abs(target-sum))
                {
                    min=Math.abs(target-sum);
                    res=sum;}
                if(nums[l]+nums[r]==addUp)
                {

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
        return res;
    }

}
