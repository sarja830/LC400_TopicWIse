#### 2398. Maximum Number of Robots Within Budget

Binary search and sliding window maximum using deque
````java
class Solution {
    
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
````