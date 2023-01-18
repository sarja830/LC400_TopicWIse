package Backtracking;
import java.util.*;
public class CombinationSumII40 {
    public static void main(String[] args) {
        CombinationSum39 c = new CombinationSum39();
        c.combinationSum(new int[]{1,1,1,2,2},4);
    }
    List<List<Integer>> ans;
    int candidates[];
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        // sort the array first so that duplicates occur on after another are prevented to be called again and. again
        Arrays.sort(candidates);
        this.candidates=candidates;

        ans= new LinkedList();
        backtrack(0,target,new LinkedList<Integer>());
        return ans;

    }
    void  backtrack(int start,int target, List<Integer> list)
    {

        if(target==0) {
            ans.add(new LinkedList(list));
        }
        if(target<0) return;
        for(int i=start;i<candidates.length;i++)
        {
            // to avoid duplicates that will come for example 1,1,1,2,2 start=0 skip recursion calls starting from i=1 and i=2 similarly for 2 skip 4
            if(i>start && candidates[i]==candidates[i-1]) continue;

            list.add(candidates[i]);
            // since we can pick an element again and again passing i
            backtrack(i,target-candidates[i],list);
            list.remove(list.size()-1);
        }

    }

}
