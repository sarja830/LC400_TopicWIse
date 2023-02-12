package SlidingWindow;
import java.util.*;
public class SlidingWIndowMaximum239 {

    public static void main(String[] args) {
        SlidingWIndowMaximum239 a = new SlidingWIndowMaximum239();
//        a.maxSlidingWindow(new int[]{7,2,4},2);
        a.maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6},5);
    }
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> dq = new LinkedList();
            int l=0;
            int r=0;
            int[] ans= new int[nums.length-k+1];

            while(r<k-1)
            {
                while(dq.size()>0 && dq.getLast()<nums[r])
                    dq.removeLast();

                dq.addLast(r++);
            }
            r=k-1;
            while(r<nums.length)
            {
                while(dq.size()>0 && dq.getFirst()<l)
                    dq.removeFirst();

                while(dq.size()>0 && (dq.getLast()<nums[r]))
                    dq.removeLast();

                dq.addLast(r);
                ans[l]= nums[dq.getFirst()];

                r++;
                l++;
            }
            return ans;
        }


// class Solution {
//     // TC: O(nlogk)
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int l=0;
//         int r=0;

//         List<Integer> ans= new LinkedList();
//         PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
//         while(r<k)
//         {
//             pq.add(nums[r++]);
//         }
//         r=k-1;
//         while(r<nums.length)
//         {
//             ans.add(pq.peek());
//             pq.remove(nums[l]);

//             r++;
//             l++;
//             if(r<nums.length)
//                 pq.add(nums[r]);
//         }

//         int[] ar = new int[ans.size()];

//         for(int i=0;i<ar.length;i++)
//             ar[i] = ans.get(i);
//         return ar;
//     }
// }
}
