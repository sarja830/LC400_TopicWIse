package BinarySearch;
import java.util.*;
public class hIndex {

        public int hIndex(int[] citations) {
            int n =citations.length;
            Arrays.sort(citations);
            return n-binarySearch(citations,3);
        }
        int binarySearch(int[] nums, int target)
        {
            int low =0;
            int high = nums.length-1;
            while(low<=high)
            {
                int mid  = low+(high-low)/2;
                if(nums[mid]==target)
                {
                    return mid;
                    // high = mid-1;
                }
                else if(nums[mid]>target)
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
            return low;
        }

    public static void main(String[] args) {
        hIndex a = new hIndex();
        a.hIndex(new int[]{1,3,1});
    }
}
