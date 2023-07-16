package BinarySearch.basics;

public class LowerBound {
    public static void main(String[] args) {
LowerBound a = new LowerBound();

System.out.println(a.searchInsert(new int[]{1,2,2,2,3,5,7,9},2));
System.out.println(a.searchInsert(new int[]{1,2,2,2,3,5,7,9},6));
    }
    public int searchInsert(int[] nums, int x) {
        int n=nums.length, low=0,  high= n-1,ans =-1;
        while(low<=high)
        {
            int mid = low+ (high- low)/2;
            if(nums[mid]>=x)
            {
                ans= mid;
                high = mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return low;
    }
}
