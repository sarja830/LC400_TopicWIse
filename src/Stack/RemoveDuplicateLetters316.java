package Stack;
import  java.util.*;
public class RemoveDuplicateLetters316 {
    public static void main(String[] args) {
        removeDuplicateLetters("bcabc");
    }

    public static String removeDuplicateLetters(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] visited= new int[26];
        Stack<Character> st = new Stack<>();
        int n =s.length();
        for(int i=n-1;i>=0;i--)
        {
            if(map.containsKey(s.charAt(i)))
                continue;
            else
                map.put(s.charAt(i),i);
        }

        for(int i=0;i<n;i++)
        {
            if(visited[s.charAt(i)-'a'] != 1)
            {
                if((st.size()!=0 && st.peek()<s.charAt(i)) || st.size()==0)
                {
                    if(visited[s.charAt(i)-'a']!=1)
                    {
                        st.push(s.charAt(i));
                        visited[s.charAt(i)-'a'] = 1;
                    }
                }
                else
                {
                    while(st.size()!=0 && st.peek()>s.charAt(i) && map.get(st.peek())>i )
                    {
                        visited[st.pop()-'a']=0;
                    }
                    st.push(s.charAt(i));
                    visited[s.charAt(i)-'a']=1;
                }
            }
        }


        String res="";
        while(st.size()!=0){
            res=st.pop()+res;
        }
        return res;
    }

}
