package DP_LCS_BASE;
import java.util.*;
public class WildcardMatching44 {

    public static void main(String[] args) {
        WildcardMatching44 a = new WildcardMatching44();
        a.isMatch("aa","*");
        a.isMatch1("aa","*");
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
    int[][] ans;
    public boolean isMatch1(String s, String p) {
        ans = new int[s.length()+1][p.length()+1];
        for(int[] a:ans)
            Arrays.fill(a,-1);
        return rec(s,p,0,0);
    }
    boolean rec(String s, String p, int i, int j)
    {
        if(p.length()==j && s.length()==i)
        {
            ans[i][j] = 1;
            return true;

        }
        if(p.length()==j)
        {
            ans[i][j] = 0;
            return false;
        }

        if(ans[i][j]!=-1)
            return ans[i][j]==1?true:false;

        if(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?' || p.charAt(j)=='*'))
            if(p.charAt(j)=='*')
            {
                ans[i][j] =  (rec(s,p,i,j+1) || rec(s,p,i+1,j))?1:0;
                return ans[i][j]==1?true:false;
            }
            else
            {
                ans[i][j]  = (rec(s,p,i+1,j+1))?1:0;
                return ans[i][j]==1?true:false;
            }
        else
        {
            if(p.charAt(j)=='*')
            {
                ans[i][j] = (rec(s,p,i,j+1))?1:0;
                return ans[i][j]==1?true:false;
            }
            else
            {
                ans[i][j] = 0;
                return ans[i][j]==1?true:false;
            }
        }


    }


}
