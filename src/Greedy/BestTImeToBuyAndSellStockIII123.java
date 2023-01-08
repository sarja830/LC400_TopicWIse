package Greedy;

public class BestTImeToBuyAndSellStockIII123 {

    public static void main(String[] args) {
        maxProfit(new int[]{3,3,5,0,0,3,1,4});
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfitFromLeft[] = new int[n];
        int maxProfitFromRight[] = new int[n];
        int maxi=0;
        int least_so_far=prices[0];

        for(int i=1;i<n;i++)
        {
            if(least_so_far>prices[i])

                least_so_far=prices[i];

            else
                maxi=Math.max(maxi,prices[i]-least_so_far);

            maxProfitFromLeft[i]=maxi;
        }


        maxi=0;
        int max_so_far =prices[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(prices[i]>max_so_far)
                max_so_far = prices[i];
            else
                maxi= Math.max(maxi,max_so_far-prices[i]);

            maxProfitFromRight[i]=maxi;
        }

        maxi=0;
        for(int i=0;i<n-1;i++)
        {
            maxi=Math.max(maxProfitFromLeft[i] + maxProfitFromRight[i+1],maxi);
        }

        return maxi;
    }
}
