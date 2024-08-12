package Strings;
import java.util.*;
public class ReplaceSubstringForBalancedSubstring {
    public static void main(String[] args) {
        balancedString("WWEQERQWQWWRWWERQWEQ");
    }
        public static int balancedString(String s) {
            int n = s.length();
            int l = n/4;
            HashMap<Character, Integer> map = new HashMap();
            for(char c: s.toCharArray())
                map.put(c,map.getOrDefault(c,0)+1);

            int count = 0;
            for(char i='A';i<='Z';i++)
            {
                int occ = map.getOrDefault(i,0);
                if(occ>l)
                {
                    map.put(i,occ-l);
                    count = count+occ - l;
                }
            }
            if(count==0 ) return 0;
            int curr = 0;
            int i = 0;
            int min  = Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
            {
                char c = s.charAt(j);
                if(map.containsKey(c))
                {
                    if(map.get(c)>0)
                        curr++;
                    map.put(c,map.get(c)-1);
                }
                while(curr == count)
                {
                    min = Math.min(j-i+1,min);
                    char c1 = s.charAt(i++);
                    if(map.containsKey(c1))
                    {
                        if(map.get(c1)>=0)
                            curr--;
                        map.put(c1,map.get(c1)+1);
                    }
                }
            }
            return min;

        }

}
