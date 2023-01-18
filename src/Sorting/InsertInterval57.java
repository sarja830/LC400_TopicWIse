//package Sorting;
//import java.util.*;
//
//public class InsertInterval57 {
//
//    public static void main(String[] args) {
//        insert(new int[][]{ {1,3} ,{6,9} },new int[]{7,5});
//    }
//    public static int[][] insert(int[][] intervals, int[] newInterval) {
//        List<int[]> res = new LinkedList();
//        int n = intervals.length();
//        int[][] intervalsTotal =new int[n+1][2];
//        intervalsTotal[n] = newInterval;
//        int key =intervalsTotal[n][0];
//        while(intervalsTotal[k][0]>key)
//            int x = binarySearch(0,intervals.length-1,intervals,newInterval);
//        int k =intervals.length-1;
//
//        int start=intervals[0][0];
//        int end=intervals[0][1];
//        int j=0;
//        for(int[] i:intervals)
//        {
//            if(end>=i[0])
//            {
//                end=Math.max(end,i[1]);
//            }
//            else
//            {
//                res.add(new int[]{start,end});
//                start=i[0];
//                end=i[1];
//            }
//            j++;
//        }
//        res.add(new int[]{start,end});
//        return res.toArray(new int[0][]);
//    }
//
//    static int binarySearch(int low, int high, int[][] intervals , int[] target)
//    {
//        if(low<high)
//        {
//            int mid=(low+high)/2;
//            if(intervals[mid][0]==target[0]) return mid;
//            else if(intervals[mid][0]>target[0])
//                return binarySearch(low,mid-1,intervals,target);
//            else if(intervals[mid][0]<target[0])
//                return binarySearch(mid+1,high,intervals,target);
//        }
//        return low;
//    }
//}
