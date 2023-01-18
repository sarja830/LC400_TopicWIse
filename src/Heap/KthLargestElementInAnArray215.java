package Heap;
import  java.util.*;
public class KthLargestElementInAnArray215 {
    public static void main(String[] args) {
        KthLargestElementInAnArray215 a = new KthLargestElementInAnArray215();
        a.findKthLargest(new int[]{1,2,3,4,5,6},2);
        a.findKthLargestSorting(new int[]{1,2,3,4,5,6},2);
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int arrEle:nums)
        {
            pq.add(arrEle);
            if(pq.size()>k)
                pq.remove();
        }
        return pq.poll();
    }

    public int findKthLargestSorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
