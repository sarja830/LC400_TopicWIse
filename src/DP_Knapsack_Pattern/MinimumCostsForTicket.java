package DP_Knapsack_Pattern;

public class MinimumCostsForTicket {

        int[] ticketDays;

    public static void main(String[] args) {
        MinimumCostsForTicket a = new MinimumCostsForTicket();
        a.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15});
    }
        public int mincostTickets(int[] days, int[] costs) {
            ticketDays = new int[]{1,7,30};
            int n =days.length;
            return rec(costs,days,n, days[n-1]+1);
        }
        int rec(int[] costs, int[] days, int n, int daysLeft)
        {
            if(n==0)
            {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            if(daysLeft<=days[n-1])
                return rec(costs,days,n-1,daysLeft);
            else
            {
                for(int i=0;i<costs.length;i++)
                {
                    min  = Math.min(rec(costs,days,n-1,days[n-1]-ticketDays[i]+1) +costs[i],min);
                }
                return min;
            }
        }


}
