package BinarySearch;
import java.util.*;
public class FindMinimumTImeToFinishAllJobs1723 {
    public static void main(String[] args) {
        FindMinimumTImeToFinishAllJobs1723 a = new FindMinimumTImeToFinishAllJobs1723();
//        a.minimumTimeRequired(new int[]{1,2,4,7,8},3);
        a.minimumTimeRequired(new int[]{1867731,4771762,2710043,7567506,5011359},2);
        a.isPossible(new int[]{1867731,4771762,2710043,7567506,5011359},2,11650852);
    }
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        long high = 0;
        if(jobs.length==1 && k==1)
            return jobs[0];
        for(int i: jobs)
            high = high + i;
        int n = jobs.length;
        long low = jobs[0], ans =high;

        while(low<=high)
        {
            long mid = low + (high-low)/2;
            if(isPossible(jobs,k,mid))
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return (int)ans;
    }
    boolean isPossible(int[] nums, int k, long workPerWorker)
    {
        long work = 0;
        int l = 0,  r = nums.length-1, count = 0;
        while(l<=r)
        {
            if(nums[r]>workPerWorker || nums[l]>workPerWorker)
                return false;
            if(work+nums[r]<=workPerWorker)
            {
                work = work+nums[r];
                r--;
            }
            else if(work+nums[l]<=workPerWorker)
            {
                work = work+nums[l];
                l++;
            }
            else
            {
                count++;
                work = 0;
            }

        }


        return count<=k?true:false;
    }
}
