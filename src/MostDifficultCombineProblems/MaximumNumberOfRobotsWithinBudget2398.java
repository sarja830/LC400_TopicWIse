package MostDifficultCombineProblems;
import java.util.*;
public class MaximumNumberOfRobotsWithinBudget2398 {
    public static void main(String[] args) {
        MaximumNumberOfRobotsWithinBudget2398 a = new MaximumNumberOfRobotsWithinBudget2398();
        a.maximumRobots(new int[]{19,63,21,8,5,46,56,45,54,30,92,63,31,71,87,94,67,8,19,89,79,25}, new int[]{91,92,39,89,62,81,33,99,28,99,86,19,5,6,19,94,65,86,17,10,8,42},  25);
    }


        public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {

            int n = chargeTimes.length;
            int ans =0;
            int low = 0, high = n;
            while(low<=high)
            {

                int mid = low+(high-low)/2;
                if(isPossible(mid,budget,runningCosts, chargeTimes))
                {
                    ans=mid;
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
            return ans;
        }
        boolean isPossible(int consecutiveNumberOfRobots , long budget, int[] runningCosts, int[] chargeTimes)
        {
            int n = chargeTimes.length;
            Deque<Integer> dq = new LinkedList();
            int l = 0, r = 0;
            long sum = 0;

            for(r=0;r>=0 && r<n;r++)
            {

                //calculate max time for charge
                sum= sum+runningCosts[r];

                while(dq.size()>0 && dq.getFirst()<l)
                    dq.removeFirst();

                while(dq.size()>0 && chargeTimes[dq.getLast()]<chargeTimes[r])
                    dq.removeLast();

                dq.addLast(r);
                if(r>=consecutiveNumberOfRobots-1)
                {

                    if((consecutiveNumberOfRobots*sum + chargeTimes[dq.getFirst()])<=budget)
                        return true;
                    sum=sum-runningCosts[l];
                    l++;
                }
            }
            return false;

        }

}
