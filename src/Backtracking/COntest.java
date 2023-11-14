package Backtracking;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Collections;
import java.util.LinkedList;

public class COntest {
    public static void main(String[] args) {
        COntest a = new COntest();
        a.countSubMultisets(new LinkedList(Arrays.asList(1,2,2,3)),6,6);
    }
        int count =0;
        public int countSubMultisets(List<Integer> nums, int l, int r) {
            Collections.sort(nums);
            backtrack(nums,0,l,r,0);
            return count;
        }
        void backtrack(List<Integer> nums, int start, int l , int r, int sum)
        {
            if(sum>=l && sum<=r)
                count++;
            if(sum>=r) return;
            int n = nums.size();

            for(int j=start;j<n;j++)
            {
                if(j>start && nums.get(j)==nums.get(j-1))
                    continue;
                backtrack(nums,start+1,l,r,sum+nums.get(j));
            }
        }




}
