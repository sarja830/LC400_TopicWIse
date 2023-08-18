//package SlidingWindow;
//
//import java.util.*;
//
//public class LongestSubarrayHackerrank {
//    public static void main(String[] args) {
//        LongestSubarrayHackerrank a = new LongestSubarrayHackerrank();
//        a.congestedMountainTrain(int[] arrival, int[] direction);
//    }
//    class Pair
//    {
//        int time;
//        int direction;
//            public Pair(int a , int b)
//        {
//            time =a;
//            direction =b;
//        }
//
//    }
//    int[] congestedMountainTrain(int[] arrival, int[] direction)
//    {
//        int n = arrival.length;
//        Pair[] res = new Pair[n];
//        for(int i=0;i<n;i++)
//        {
//            res[i] = new Pair(arrival[i],direction[i]);
//        }
//        Arrays.sort(res,(p1, p2) -> p1.time.compareTo(p2.time));
//
//        int i=0;
//        int j=i+1;
//        while(j<n)
//        if(res[i]==)
//
//
//
//    }
//    int  decode (int length[] , int costPerCut, int salePrice)
//    {
//        int profit = 0;
//        int low =1, high =0;
//        int max=0;
//        for(int i=0;i<length.length;i++)
//        {
//            high = Math.max(length[i],max);
//        }
//
//
//        for(int i=low;i<=high;i++)
//        {
//            for(int j=0;j<length.length;j++) {
//                profit = profit + (length[j] / i) * salePrice * i - (((length[j] / i) - 1) * costPerCut);
//            }
//            if(max<profit)
//                max =profit;
//        }
//        return max;
//
//    }
//}
