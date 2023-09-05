package BinarySearch;
import java.lang.reflect.Array;
import java.util.*;
public class SecureServer {
    public static void main(String[] args) {
SecureServer   a = new SecureServer();
System.out.println(a.findLargestMinVulnerability(new LinkedList<>(Arrays.asList(3,4,5)),4));
//System.out.println(a.findLargestMinVulnerability(new LinkedList<>(Arrays.asList(2,2,3,3)),3));
System.out.println(a.findLargestMinVulnerability(new LinkedList<>(Arrays.asList(2,2,3,3)),3));
    }
    HashMap<Long,Long>map;
    long findLargestMinVulnerability(List<Integer> arr , long k)
    {




//        Collections.sort(arr);
        map = new HashMap<>();
        long low=Long.MAX_VALUE, high= Long.MIN_VALUE, ans =0;
        for(int i:arr)
        {
            low = Math.min(i-k,low);
            high = Math.max(i,high);
        }
        while(low<=high)
        {
            long mid = low+(high-low)/2;
            if(isPossible(arr,mid,k))
            {
                ans=mid;

                high =mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return map.get(ans);
    }

    boolean isPossible(List<Integer> arr, long mid,long k)
    {
        boolean flag=false;
        long min = Long.MAX_VALUE;
       for(int i=0;i<arr.size();i++)
       {
           if(arr.get(i)>mid || flag) {
               k = k - (arr.get(i) - mid);
               min = Math.min(min,arr.get(i) - mid);
               if (k < 0) return false;
           }
           else {
               flag =true;
               min = Math.min(min,arr.get(i));
           }
       }
       map.put(mid,min);
       return true;
    }

}
