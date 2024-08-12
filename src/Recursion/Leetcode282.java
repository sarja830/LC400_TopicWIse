package Recursion;
import java.util.*;
public class Leetcode282 {
    public static void main(String[] args) {
        addOperators("232",8);
    }
        static List<String> ans;
        public static List<String> addOperators(String num, int target) {
            ans = new LinkedList();
            rec(num,1,""+num.charAt(0),target,num.charAt(0)-'0');
            return ans;
        }
        static void  rec(String nums , int n, String res, int target, int no)
        {
            if(n==nums.length())
            {
                if(no==target)
                    ans.add(res);
                return;
            }
            int digit = Integer.valueOf(nums.charAt(n));
            rec(nums,n+1,res+"+"+nums.charAt(n),target,no+digit);
            rec(nums,n+1,res+"*"+nums.charAt(n),target,no*digit);
            rec(nums,n+1,res+"-"+nums.charAt(n),target,no-digit);
        }

}
