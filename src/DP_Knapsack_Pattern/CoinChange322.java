package DP_Knapsack_Pattern;
import java.util.*;

public class CoinChange322 {
    public static void main(String[] args) {
//        coinChange(new int[]{1,2,5},11);
//        coinChange(new int[]{2},3);
        coinChangeRec(new int[]{2},3);
    }


        public static int coinChangeRec(int[] coins, int amount) {
            return rec(coins,coins.length,amount);
        }
        static int rec(int[] coins, int n, int amount)
        {
            if(n==0 || amount<=0)
            {
                if(amount==0)
                    return 0;
                else
                    return Integer.MAX_VALUE;
            }
            else
                return Math.min(
                        rec(coins,n-1,amount),
                        Math.min(
                                rec(coins,n-1,amount-coins[n-1]),
                                rec(coins,n,amount-coins[n-1])
                        )+1
                );
        }



        public static int coinChange(int[] coins, int amount) {
            int n = coins.length;

            int[][] ans = new int[n + 1][amount + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j >= coins[i - 1]) {
                        if ((ans[i - 1][j - coins[i - 1]] == 0 || ans[i][j - coins[i - 1]] == 0) && j - coins[i - 1] != 0)
                            ans[i][j] = 0;
                        else
                            ans[i][j] = Math.min(1 + Math.min(ans[i - 1][j - coins[i - 1]], ans[i][j - coins[i - 1]]), ans[i - 1][j]);
                    } else {
                        ans[i][j] = 0;
                    }
                }

            }

            if (ans[n][amount] < 0 || ans[n][amount] == Integer.MAX_VALUE)
                return -1;
            return ans[n][amount];
        }

    }