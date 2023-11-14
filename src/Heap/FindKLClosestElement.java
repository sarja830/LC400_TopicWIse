package Heap;


import java.util.*;

public class FindKLClosestElement {
    public static void main(String[] args) {
        FindKLClosestElement a = new FindKLClosestElement();
        a.findClosestElements(new int[]{1,2,3,4,5},4,3);
    }

        public List<Integer> findClosestElements(int[] nums, int k, int x) {
            int index = binarySearch(nums,x);
            int n = nums.length;
            int l = index;
            int r = index+1;

            Deque<Integer> ans = new ArrayDeque<>();

            while(l>=0 && r<n)
            {
                if(Math.abs(x-nums[l])<=Math.abs(x-nums[r]) )
                {
                    ans.addFirst(nums[l]);
                    l--;
                }
                else
                {
                    ans.addLast(nums[r]);
                    r++;
                }
                if(ans.size()==k)
                    return new LinkedList(ans);
            }
            while(l>=0)
            {
                ans.addFirst(nums[l]);
                l--;
                if(ans.size()==k)
                    return new LinkedList(ans);
            }
            while(r<n)
            {
                ans.addLast(nums[r]);
                r++;
                if(ans.size()==k)
                    return new LinkedList(ans);
            }

            return new LinkedList(ans);

        }
        int binarySearch(int[] nums, int target)
        {
            int n = nums.length;
            int low =0, high = n-1;
            while(low<=high)
            {
                int mid = low + (high - low)/2;
                if(nums[mid]>=target)
                    high = mid-1;
                else
                    low = mid+1;
            }
            return low;
        }

}
