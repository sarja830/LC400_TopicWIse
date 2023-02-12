package DP_LCS_BASE;
import java.util.*;
public class WildcardMatching44 {

    public static void main(String[] args) {
        WildcardMatching44 a = new WildcardMatching44();
        a.isMatch("aa","*");
    }
    public boolean isMatch(String s, String p) {
        boolean[][]  ans = new boolean[s.length()+1][p.length()+1];
        ans[0][0] =true;
        for(int i=1;i<=s.length();i++)
            ans[i][0] = false;

        for(int j=1;j<=p.length();j++)
            if(p.charAt(j-1)=='*' && ans[0][j-1]==true)
                ans[0][j] =  true;


        for(int i=1;i<=s.length();i++)
            for(int j=1;j<=p.length();j++)
            {
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                    ans[i][j] = ans[i-1][j-1];
                else if(p.charAt(j-1)=='*')
                {
                    ans[i][j]=ans[i][j-1]||ans[i-1][j];
                }
                else
                    ans[i][j]=false;
            }
        return ans[s.length()][p.length()];
    }

}
