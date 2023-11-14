package Stack;
import java.util.*;
public class DecodeStrings394 {

    public static void main(String[] args) {
        DecodeStrings394 a = new DecodeStrings394();
        a.decodeString("100[leetcode]");
    }
        public String decodeString(String s) {

            int i=0,count = 0;
            int n = s.length();
            Stack<String> st = new Stack();
            while(i<n)
            {
                while(i<n && s.charAt(i)!=']')
                {
                    st.push(""+s.charAt(i));
                    i++;
                }
                i++;
                String res = "";
                while(!st.isEmpty() && st.peek().charAt(0)!='[')
                {
                    res = st.pop()+res;
                }
                if(!st.isEmpty() && (st.peek().charAt(0)=='[')) st.pop();
                count = -1;
                while(!st.isEmpty() &&  st.peek().charAt(0)-'0'<=9 && st.peek().charAt(0)-'0'>=0)
                    if(count==-1)
                        count = (st.pop().charAt(0)-'0');
                    else
                        count = (st.pop().charAt(0)-'0')*10 + count;
                String solved = formString(count, res);

                while( !st.isEmpty() && st.peek().charAt(0)!='[')
                {
                    solved = st.pop() + solved;
                }
                if(!st.isEmpty() && st.peek().charAt(0)!='[') st.pop();
                if(solved.length()!=0)
                    st.push(solved);
                else if(count==0 && res.length()!=0)
                    st.push(res);

            }
            String ans ="";
            while(!st.isEmpty())
                ans = st.pop()+ans;

            return ans;

        }
        String formString(int count, String str)
        {
            String res = "";
            for(int i=0;i<count;i++)
            {
                res =res + str;
            }
            return res;
        }

}
