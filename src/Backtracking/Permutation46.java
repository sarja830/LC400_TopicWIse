package Backtracking;
import java.util.*;
public class Permutation46 {

    static List<List<Integer>> ans;
    public static void main(String[] args) {
        System.out.println(Permutation46.permute(new int[]{1,2,3}).toString());
    }


    public static List<List<Integer>> permute(int[] nums) {
        ans= new LinkedList<>();
        backtrack(new LinkedList(),nums);
        return ans;
    }
    static void backtrack(List<Integer> list, int[] nums) {
        if (list.size() == nums.length) ans.add(new LinkedList<>(list));
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;

            list.add(nums[i]);
            backtrack(list, nums);
            list.remove(list.size() - 1);
        }
    }
}
