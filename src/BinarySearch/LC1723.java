package BinarySearch;
import java.util.*;
public class LC1723 {

        public static void main(String[] args) {
            LC1723 a = new LC1723();
            a.minimumTimeRequired(new int[]{1,2,4,7,8},2);
        }
        public int minimumTimeRequired(int[] jobs, int k) {
            int n = jobs.length;
            Arrays.sort(jobs);
            int low = Arrays.stream(jobs).min().getAsInt();
            int high = Arrays.stream(jobs).sum();
            int ans = high;
            while(low<=high)
            {
                int mid = low + (high-low)/2;
                if(backtrack(mid,k,jobs,new int[n], n, 0,0))
                {
                    ans = mid;
                    high = mid-1;
                }
                else
                    low = mid+1;
            }
            return ans;
        }


        boolean backtrack(int targetWork, int k, int[] jobs, int[] visited, int visitedCount, int curr,int currWork)
        {
            if(k<0) return false;
            if( visitedCount==0 ) return true;

            if(currWork==targetWork || curr==jobs.length) return backtrack(targetWork, k-1,jobs,visited,visitedCount,0,0);

            for(int i=curr;i<jobs.length;i++)
            {
                // if( i>curr && visited[i-1]==1 && jobs[i]==jobs[i-1]) continue;

                if(visited[i]==0 && currWork+jobs[i]<=targetWork)
                {
                    visited[i] = 1;
                    if(backtrack(targetWork, k,jobs,visited,visitedCount-1,i+1,currWork+jobs[i]))
                        return true;
                    visited[i] = 0;
                }
            }
            return false;
        }

}
