package DP_Knapsack_Pattern;

import java.util.*;
import java.io.*;
import java.lang.*;


public class Knapsack01GFG {
    public static void main(String args[])throws IOException
    {

        int n=3;
        int w=4;
        int val[] = new int[]{1,2,3};
        int wt[] = new int[]{4,5,1};

//                String st[] = read.readLine().trim().split("\\s+");
//                inserting the values
//                for(int i = 0; i < n; i++)
//                    val[i] = Integer.parseInt(st[i]);
//                String s[] = read.readLine().trim().split("\\s+");
//                inserting the weigths
//                for(int i = 0; i < n; i++)
//                    wt[i] = Integer.parseInt(s[i]);
//                calling method knapSack() of class Knapsack
        System.out.println(Knapsack01GFG.knapSack(w, wt, val, n));
//            }
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
    public static void PrintItems(int[][] t,int W, int wt[], int val[], int n)
    {
        List<Integer> ans = new LinkedList<>();
        int i=n;
        int j=W;
        while(i!=0 && j!=0) {
            if (t[i-1][j]!=t[i][j]) {
                ans.add(wt[i-1]);
                j=j-wt[i-1];
            }
            i=i-1;
        }
        System.out.println("elements with wight kept inside bag");
        for(int k:ans) {
            System.out.println(k);
        }
        System.out.println("max profit");
    }


}
