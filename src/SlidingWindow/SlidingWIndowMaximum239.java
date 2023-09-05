package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class SlidingWIndowMaximum239 {
    //using heap
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length;
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        while (r < k - 1) {
            pq.add(new int[]{nums[r], r});
            r++;
        }
        for (r = k - 1; r < n; r++) {

            pq.add(new int[]{nums[r], r});
            while (pq.peek()[1] > r && pq.peek()[1] < l)
                pq.poll();
            ans[l] = pq.peek()[0];

            l++;

        }
        return ans;
    }

    public static void main(String[] args) {
        SlidingWIndowMaximum239 a = new SlidingWIndowMaximum239();
//        a.maxSlidingWindow(new int[]{7,2,4},2);
//        a.maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6},5);
        a.maxSlidingWindow(new int[]{1, -1}, 1);
    }

    //using deque
    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList();
        int l = 0,r = 0;
        int[] ans = new int[nums.length - k + 1];

        while (r < k - 1) {
            while (dq.size() > 0 && dq.getLast() < nums[r])
                dq.removeLast();

            dq.addLast(r++);
        }
        r = k - 1;
        while (r < nums.length) {
            while (dq.size() > 0 && dq.getFirst() < l)
                dq.removeFirst();

            while (dq.size() > 0 && (dq.getLast() < nums[r]))
                dq.removeLast();

            dq.addLast(r);
            ans[l] = nums[dq.getFirst()];

            r++;
            l++;
        }
        return ans;
    }
}
