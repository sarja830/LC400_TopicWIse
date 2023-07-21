package Strings;
import java.util.*;
public class ReverseWordsInString {

        public static void main(String[] args) {
                ReverseWordsInString a = new ReverseWordsInString();
                a.reverseWords("the sky is blue");
        }
        public String reverseWords(String ss) {
            int n = ss.length();
            char[] s = ss.toCharArray();
            Stack<String> st = new Stack();
            int i=0;
            while(i<n)
            {
                while(i<n && ss.charAt(i)==' ')
                    i++;
                int j = i;
                String word ="";;
                while(j<n && ss.charAt(j)!=' ')
                {
                    word=word+ss.charAt(j);
                    j++;
                }
                if(word.length()!=0)
                    st.add(word);
                i=j;
            }
            String res="";
            boolean flag=false;
            while(!st.isEmpty())
            {
                if(!flag)
                {
                    res= st.pop();
                    flag=true;
                }
                else
                {
                    res= res+" "+st.pop();
                }

            }

            return res;
        }


}
