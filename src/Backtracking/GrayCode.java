package Backtracking;
import java.util.*;
public class GrayCode {

    public static void main(String[] args) {
        grayCode(2);
    }
       static List<Integer> ans;
        static HashSet<StringBuilder> visited;
        public static List<Integer>  grayCode(int n) {
            visited = new HashSet();
            ans = new ArrayList();
            StringBuilder s = new StringBuilder();
            for(int i=0;i<n;i++)
                s.append('0');
            dfs(s,n);
            return ans;
        }
    static  void  dfs(StringBuilder s,  int n)
        {
            if(visited.contains(s))
                return;
            visited.add(new StringBuilder(s));
            ans.add(Integer.parseInt(s.toString(),2));
            for(int i=0;i<n;i++)
            {
                char or = s.charAt(i);
                char c = (or=='0')?'1': '0';
                s.setCharAt(i,c);
                if(!visited.contains(s))
                    dfs(new StringBuilder(s),n);
                s.setCharAt(i,or);
            }
        }

}
