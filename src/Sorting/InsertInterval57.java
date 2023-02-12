package Sorting;
import java.util.*;
class InsertInterval57 {
    public static void main(String[] args) {
        InsertInterval57 a = new InsertInterval57();
        a.insert(new int[][]{{1,5}}, new int[]{0,3});
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {


        int n = intervals.length;
        List<int[]> res= new ArrayList();
        if(intervals.length==0){
            res.add(newInterval);
            return res.toArray(new int[0][]);
        }
        List<int[]> intervalsList= new ArrayList();
        for(int[] a: intervals)
            intervalsList.add(a);
        // binarySearch(intervals,newInterval);
        intervalsList.add(binarySearch(intervals,newInterval),newInterval);
        // Arrays.sort(intervals, (p1, p2) -> p1[0]-p2[0]);
        int start =intervals[0][0];
        int end=intervals[0][1];
        for(int k=0;k<intervalsList.size();k++)
        {
            int i[] = intervalsList.get(k);
            if(end>=i[0])
            {
                end=Math.max(i[1],end);
            }
            else
            {
                res.add(new int[]{start,end});
                start =i[0];
                end =i[1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);

    }
    int binarySearch( int[][] intervals , int[] newInterval)
    {
        int low=0;
        int high=intervals.length-1;
        while(low<=high)
        {
            int mid=low-(low-high)/2;
            if(intervals[mid][0]==newInterval[0])
                return mid;
            else if(intervals[mid][0]>newInterval[0])
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
}