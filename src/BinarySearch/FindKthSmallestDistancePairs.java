package BinarySearch;
import java.util.*;
public class FindKthSmallestDistancePairs {

        int nums[];
        int n ;

    public static void main(String[] args) {
        FindKthSmallestDistancePairs a = new FindKthSmallestDistancePairs();
        a.smallestDistancePair(new int[]{1,6,1},3);
    }
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            this.nums=nums;
            n = nums.length;
            int low =0;
            int ans=0;
            int high= nums[n-1]-nums[0];
            while(low<=high)
            {
                int mid=low+(high-low)/2;
                if(count(mid)>=k)
                {
                    ans=mid;
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            return ans;
        }
        int count(int mid)
        {
            int i=0;
            int j=0;
            int count=0;
            while(i<n && j<=n)
            {
                while(j<n && nums[j]-nums[i]<=mid)
                    j++;
                count=count+j-i-1;

                i++;
            }
            return count;
        }

}
