package SlidingWindow;
import java.util.*;
public class LongestSubbstringWithoutRepeatingCharacters3{
    public static void main(String[] args) {
        LongestSubbstringWithoutRepeatingCharacters3 a = new LongestSubbstringWithoutRepeatingCharacters3();
        System.out.println(a.lengthOfLongestSubstring("abba"));
    }
    public int lengthOfLongestSubstring(String s) {
        int lpointer=0;
        int rpointer=0;
        int max=0;
        HashMap<Character,Integer> map = new HashMap();

        while(rpointer<s.length() && rpointer>=lpointer)
        {
            char temp = s.charAt(rpointer);
            if(map.containsKey(temp))
            {
                if(map.get(temp)+1<lpointer)
                    lpointer=map.get(temp)+1;
                map.put(temp,rpointer);
            }
            else
            {
                map.put(temp,rpointer);
            }
            max=Math.max(rpointer-lpointer+1,max);
            rpointer++;
        }
        return max;
    }

}
