package Stack;
import java.util.*;
public class Leetcode150 {
    public static void main(String[] args) {
        evalRPN(new String[]{"4","13","5","/","+"});
    }
        public static int evalRPN(String[] tokens) {
            int a;
            int b;
            int res;
            Stack<Integer> st = new Stack();
            for(String s:tokens)
            {
                char c = s.charAt(0);
                int n = s.length();
                if(n==1)
                {
                    if(c-'+'==0)
                    {
                        b = st.pop();
                        a = st.pop();
                        res = b+a;
                    }
                    else if( c-'-'==0)
                    {
                        b = st.pop();
                        a = st.pop();
                        res = b-a;
                        st.push(res);
                    }
                    else if(c- '*'==0)
                    {
                        b = st.pop();
                        a = st.pop();
                        res = b*a;
                        st.push(res);
                    }
                    else if(c-'/'==0)
                    {
                        b = st.pop();
                        a = st.pop();
                        res = b/a;
                        st.push(res);
                    }
                    else
                    {
                        st.push(Integer.valueOf(s));
                    }
                }
                else
                {
                    st.push(Integer.valueOf(s));
                }
            }
            return st.pop();
        }

}
