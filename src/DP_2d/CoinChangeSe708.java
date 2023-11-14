package DP_2d;

import java.util.Arrays;

public class CoinChangeSe708 {
    // A coin can be taken only once.
    public static void main(String[] args) {
        CoinChangeSe708 a = new CoinChangeSe708();
//        int[] coins = new int[]{1,3,5,7,8,9,12,5,4,3,2,1,3,4,5,5,2,1,3,4,4,3,3,4,3,4,4,4,4,4,3,1,3,2,3,2,20,12};
        int[] coins = new int[]{1,3,5,7};
        int sum = 5;
        int n = coins.length;
        System.out.println(n);
        System.out.println(a.minCoinChange(coins, sum ));
    }


    int minCoinChange(int[] coins, int amount)
    {
        int n = coins.length;
        int[][] ans = new int[n+1][amount+1];
        Arrays.fill(ans[0],amount+1);
        ans[0][0] = 0;

        for(int i=1;i<=n;i++)
            for(int j=1;j<=amount;j++)
                if(coins[i-1]<=j)
                    ans[i][j] = Math.min(ans[i-1][j-coins[i-1]]+1,ans[i-1][j]);
                else
                    ans[i][j] = ans[i-1][j];

        for(int[] a: ans) {
            System.out.println();
            for (int k : a)
                System.out.print(" " +k);
        }
        return ans[n][amount]>amount?-1:ans[n][amount];
    }


}
