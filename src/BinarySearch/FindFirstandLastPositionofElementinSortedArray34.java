package BinarySearch;
import java.util.*;

public class FindFirstandLastPositionofElementinSortedArray34 {

        int target;
        int[] res;

    public static void main(String[] args) {
        FindFirstandLastPositionofElementinSortedArray34 a = new FindFirstandLastPositionofElementinSortedArray34();
        System.out.println(a.searchRange(new int[]{5,7,7,8,8,10},8).toString());
    }
        public  int[] searchRange(int[] nums, int target) {
            this.target=target;
            res= new int[]{-1,-1};
            int low =0;
            int high = nums.length-1;
            BSLeft(low,high,nums);
            BSRight(low,high,nums);
            // while(low<=high)
            // {
            //     int mid= low-(low-high)/2;
            //     if(nums[mid]==target){
            //          res[0]=mid;
            //          high=mid-1;
            //     }
            //     else if(nums[mid]>target) high=mid-1;
            //     else low=mid+1;
            // }
            //  low =0;
            //  high = nums.length-1;
            // while(low<=high)
            // {
            //     int mid= low-(low-high)/2;
            //     if(nums[mid]==target){
            //          res[1]=mid;
            //          low=mid+1;
            //     }
            //     else if(nums[mid]>target) high=mid-1;
            //     else low=mid+1;
            // }
            return res;
        }

        void  BSRight(int low , int high, int[] nums)
        {
            if(low<=high)
            {
                int mid=low-(low-high)/2;
                if(nums[mid]==target){
                    res[1]=mid;
                    BSRight(mid+1,high,nums);
                }
                else if(nums[mid]>target)  BSRight(low,mid-1,nums);
                else  BSRight(mid+1,high,nums);
            }


        }
        void  BSLeft(int low, int high, int[] nums)
        {
            if(low<=high)
            {       int mid= low-(low-high)/2;
                if(nums[mid]==target){
                    res[0]=mid;
                    BSLeft(low,mid-1,nums);
                }
                else if(nums[mid]>target) BSLeft(low,mid-1,nums);
                else  BSLeft(mid+1,high,nums);
            }

        }

}
