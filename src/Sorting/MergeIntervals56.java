package Sorting;
import java.util.*;
public class MergeIntervals56 {
    public static void main(String[] args) {
        merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res= new ArrayList();
        Arrays.sort(intervals, (p1, p2) -> p1[0]-p2[0]);
        int start =intervals[0][0];
        int end=intervals[0][1];
        for(int[] i:intervals)
        {
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

}
