package SlidingWindow;
import java.util.*;
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring a  = new MinimumWindowSubstring();
        a.minWindow( "ADOBECODEBANC",  "ABC");
    }
        public String minWindow(String s, String t) {
            HashMap<Character,Integer> map = new HashMap();
            for(char c: t.toCharArray())
            {
                map.put(c,map.getOrDefault(c,0)+1);
            }
            int i=0,
                    j=0,
                    n=s.length(),
                    count=0,
                    m= t.length(),
                    min=Integer.MAX_VALUE,
                    min_index=-1;
            for(j=0;j<n;j++)
            {
                char ch = s.charAt(j);
                if( map.containsKey(ch) ==true)
                {
                    map.put(ch, map.get(ch)-1);
                    if(map.get(ch)==0)
                        count++;
                }
                while(count==m)
                {
                    if( j-i+1<min)
                    {
                        min =j-i+1;
                        min_index =i;
                    }
                    if(map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                        if (map.get(s.charAt(i)) >= 0)
                            count--;
                    }
                    i++;
                }
            }

            return s.substring(min_index,min+1);


        }

}
