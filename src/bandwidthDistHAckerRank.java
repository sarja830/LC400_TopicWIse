import DP_Knapsack_Pattern.Knapsack01GFG;

public class bandwidthDistHAckerRank {
    public static void main(String[] args) {
        System.out.println(knapSack(200, new int[]{100,500,80,25,400},new int[]{100,1000,120,110,100},5));
    }
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // int n= wt.length;
        int[][]  t= new int[n+1][W+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=W;j++)
            {
                if(j>=wt[i-1])
                    t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                else
                    t[i][j]=t[i-1][j];
            }
        }
        Knapsack01GFG.PrintItems(t,W,wt,val,n);
        return t[n][W];
    }
}
