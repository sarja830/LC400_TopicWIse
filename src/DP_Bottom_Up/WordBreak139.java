package DP_Bottom_Up;
import  java.util.*;

public class WordBreak139 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("leet","code"));
        WordBreak139.wordBreak( "leetcode", list);
    }

    public static  boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<String>(wordDict);
        boolean[] ans = new boolean[n+1];
        // when there is no more character the base case hence the value is 1 means
        ans[n]=true;

        for(int i=n-1;i>=0;i--)
        {
            for(String word:set)
                if(i+word.length()<=n && ans[i+word.length()]==true && s.substring(i,i+word.length()).equals(word))
                    ans[i]=true;
        }
        return ans[0];
    }

}
