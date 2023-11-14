package SlidingWindow;

import java.util.*;
public class LongestSubstringWIthoutRepeatingCharacters {
    public static void main(String[] args) {
    LongestSubstringWIthoutRepeatingCharacters a = new LongestSubstringWIthoutRepeatingCharacters();
    a.lengthOfLongestSubstring("abcabcbb");
    }

        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int[] map = new int[256];
            int i =0,j=0,count =0;
            Arrays.fill(map,-1);
            for(j=0;j<n;j++)
            {
                char c = s.charAt(j);
                if(map[c]<i)
                {
                    map[c] = j;
                }
                else
                {
                    i=map[c]+1;
                    map[c] = i;
                }
                count = Math.max(count, j-i+1);
            }
            return count;
        }

}
