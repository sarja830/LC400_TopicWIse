package Recursion;
import java.util.*;
public class RemoveInvalidParantheses {
    public static void main(String[] args) {
        RemoveInvalidParantheses a = new RemoveInvalidParantheses();
        a.removeInvalidParentheses("()())()");
    }
        int n;
        List<String> ans;
        int min;
        String s;
        public List<String> removeInvalidParentheses(String s) {
            n=s.length();
            this.s=s;
            min=Integer.MAX_VALUE;
            ans = new LinkedList();
            rec("",1,0,0);
            return ans;
        }
        void rec(String str, int i, int eq, int skipped)
        {
            if(i>n)
            {
                if(skipped<min )
                {
                    min=skipped;
                    ans.clear();
                    ans.add(str);
                }
                else if(skipped==min)
                {
                    ans.add(str);
                }
                else return;
            }
            char c=s.charAt(i-1);
            if(c=='(')
            {
                rec(str, i+1,eq,skipped+1);
                rec(str+c, i+1,eq+1,skipped);

            }
            else if(c==')')
            {
                if(eq<=0)
                {
                    rec(str,i+1,eq,skipped+1);
                }
                else
                {
                    rec(str, i+1,eq,skipped+1);
                    rec(str+c, i+1,eq-1,skipped);

                }
            }
            else
            {
                rec(str+c, i+1,eq,skipped);
            }
            return;

        }

}
