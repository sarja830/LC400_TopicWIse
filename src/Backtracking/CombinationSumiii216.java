package Backtracking;
import  java.util.*;
public class CombinationSumiii216 {

    public static void main(String[] args) {
        CombinationSumiii216 c = new CombinationSumiii216();
        c.combinationSum3(3,7);
    }
        List<List<Integer>> ans;
        int candidates[];
        int k;
        public List<List<Integer>> combinationSum3(int k, int n) {
            candidates=new int[]{1,2,3,4,5,6,7,8,9};
            int target=n;
            this.k=k;
            // sort the array first so that duplicates occur on after another are prevented to be called again and. again
            Arrays.sort(candidates);
            ans= new LinkedList();
            backtrack(0,target,new LinkedList<Integer>());
            return ans;

        }
        void backtrack(int start,int target, List<Integer> list)
        {

            if(target==0) {
                if(list.size()==k)
                    ans.add(new LinkedList(list));
            }
            if(target<0) return;
            for(int i=start;i<candidates.length;i++)
            {
                // to avoid duplicates that will come for example 1,1,1,2,2 start=0 skip recursion calls starting from i=1 and i=2 similarly for 2 skip 4
                if(i>start && candidates[i]==candidates[i-1]) continue;

                list.add(candidates[i]);
                // since we can pick an element again and again passing i
                backtrack(i+1,target-candidates[i],list);
                list.remove(list.size()-1);
            }
        }

}
