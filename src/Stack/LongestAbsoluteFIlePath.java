package Stack;
import java.util.*;
public class LongestAbsoluteFIlePath {
    public static void main(String[] args) {
        LongestAbsoluteFIlePath a = new LongestAbsoluteFIlePath();
        a.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
    }
        public int lengthLongestPath(String input) {
            String[] arr = input.split("\n");
            Stack<String[]> st = new Stack();
            int count=0;
            int ans =0;
            for(String str: arr )
            {
                String[] path = str.split("\t");
                while(!st.isEmpty() && st.peek().length>=path.length)
                {
                    String[] temp =st.pop();
                    count = count-temp[temp.length-1].length();
                }
                st.push(path);
                count = count+path[path.length-1].length();
                System.out.println(path[path.length-1]);
                String[] file = path[path.length-1].split("\\.");
                if(file.length>0 && file[file.length-1].split(".").length==2)
                {
                    ans = Math.max(count,ans);
                    st.push(path);
                    count = count+path[path.length-1].length();
                }
            }
            return ans;
        }

}
