package DP_LCS_BASE;

public class PatternMatching {
    public static void main(String[] args) {
        PatternMatching a = new PatternMatching();
        a.isMatch("bbbba",".*a*a");
    }

        public boolean isMatch(String s, String p) {
            return Recursion(s,p,0,0);
        }
        boolean Recursion(String s, String p, int i, int j)
        {
            if(s.length()==i && p.length()==j)
                return true;
            if(p.length()==j)
                return false;
            boolean match = i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.' );

            if(j+1<p.length() && p.charAt(j+1)=='*')
                if(match)
                    return Recursion(s,p,i+1,j) || Recursion(s,p,i+1,j+2);
                else
                    return Recursion(s,p,i,j+2);
            if(match)
                return Recursion(s,p,i+1,j+1);

            return false;

        }

}
