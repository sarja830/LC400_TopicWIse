package DP_Rec_Memoization;

import java.util.*;
public class JumpGame3 {
        public boolean canReach(int[] arr, int start) {

            int n = arr.length;
            int[] visited = new int[n];
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            while(!q.isEmpty())
            {
                int siz = q.size();
                for(int i=0;i<siz;i++)
                {
                    int temp=q.poll();
                    if(arr[temp]==0) return true;
                    visited[temp]=1;
                    if(temp-arr[temp]>=0 && temp-arr[temp]<n && visited[temp-arr[temp]]!=1) q.add(temp-arr[temp]);
                    if(temp+arr[temp]>=0 && temp+arr[temp]<n && visited[temp+arr[temp]]!=1) q.add(temp+arr[temp]);
                }
            }
            return false;
        }
}
