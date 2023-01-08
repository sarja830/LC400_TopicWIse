package BinarySearch;

public class SearchInsertPosition35 {
    public static void main(String[] args) {
        SearchInsertPosition35.searchInsert(new int[]{1,2,3,4,6},5);
    }
    public static int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high) {
            int mid = low - (low - high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

}
