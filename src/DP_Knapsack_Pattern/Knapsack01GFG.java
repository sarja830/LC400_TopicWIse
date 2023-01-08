package DP_Knapsack_Pattern;

import java.util.*;
import java.io.*;
import java.lang.*;


public class Knapsack01GFG {
    public static void main(String args[])throws IOException
    {

        int n=3;
        int w1=1;
        int w2=4;
        int val[] = new int[]{1,2,3};
        int wt[] = new int[]{4,5,1};
        int wt1[] = new int[]{1,2,4};
        int val1[] = new int[]{1,10,1};

        System.out.println("wt "+Arrays.toString(wt1));
        System.out.println("val "+Arrays.toString(val1));

        System.out.println("Weight1 "+1+" and weight2 "+4);
        Knapsack01GFG.knapSackRange(w1,w2, wt1, val1, n);
//     }
    }

//    Make sure that in the knapsack table the weight that we are including contains the element of that weight atleast
//    and if that is not possible we just put a zero indicating the condition is not satisfying
    static int knapSackRange(int W1, int W2, int wt[], int val[], int n)
    {
        int[][]  t= new int[n+1][W2+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=W2;j++)
            {
//      to make sure we have the element of that weight included atleast if not just we will not include that item
                if(j>=wt[i-1] && (t[i-1][j-wt[i-1]]>0 || j==wt[i-1] ))
                    t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                else
                    t[i][j]=t[i-1][j];
            }
        }
        int idealWeight=0;
        int max=Integer.MIN_VALUE;
        for(int j=W1;j<=W2;j++)
        {
            if(max<t[n][j])
            {
                max= t[n][j];
                idealWeight = j;
            }
        }
        System.out.println("ideal weight "+idealWeight);
        System.out.println("Max profit "+t[n][idealWeight]);

        Knapsack01GFG.PrintItems(t,idealWeight,wt,val,n);
        String deepArrayString =Arrays.deepToString(t);
        System.out.println("dp table  " +deepArrayString);
        return t[n][idealWeight];
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
