package Longest_Common_Substring_Center_Expansion;


//naresh gupta video
public class LongestPallindormicSubstring5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {

        int n = s.length();
        String res="";
        int count=0;
        for(int i=0;i<n;i++)
        {
            String resOdd = generatePallindrome(s,i,i);
            if(res.length()<resOdd.length() ) res=resOdd;
            String resEven = generatePallindrome(s,i,i+1);
            if(resEven.length()>res.length()) res=resEven;

        }
        return res;
    }
    public static String generatePallindrome(String s, int l , int r)
    {
        String res="";
        while(l>=0 && r<s.length())
        {
            if( s.charAt(l)==s.charAt(r))
            {
                if(l==r)
                    res=res+s.charAt(l);
                else
                    res=s.charAt(l)+res+s.charAt(r);
            }
            else break;
            l--;
            r++;
        }
        return res;
    }
}
