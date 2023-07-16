package BinarySearch;
import java.util.*;
public class FindRightInterval {
    public static void main(String[] args) {
        FindRightInterval a =  new FindRightInterval();
        a.findRightInterval(new int[][]
//                {{3, 4},{2, 3},{1, 2}});
                {{1, 4},{2, 3},{3, 4}});
    }
        public int[] findRightInterval(int[][] intervals) {
            HashMap<Integer,Integer> map = new HashMap();
            int k =0;
            for(int[] i:intervals)
                map.put(i[0],k++);
            int[] ans =  new int[intervals.length];
            int[] res =  new int[intervals.length];
            for(int i=0;i<intervals.length;i++)
            {
                ans[i]=intervals[i][0];
            }
            Arrays.sort(ans);
            k=0;
            for(int[] i:intervals)
            {
                int bs= BinarySearch(i[1],ans);
                if(k==map.getOrDefault(bs ,-1))
                    res[k] = -1;
                else
                    res[k] = map.getOrDefault( bs,-1);
                k++;

            }
            return ans;
        }
        int BinarySearch(int target, int[] ans)
        {
            int low=0;
            int high= ans.length-1;
            while(low<=high)
            {
                int mid = low+( high - low)/2;
                if(ans[mid] == target)
                {
                    return ans[mid];
                }
                else if( ans[mid]>target)
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
            if(low==ans.length) return -1;
            return ans[low];
        }

}
