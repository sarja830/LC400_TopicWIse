package Longest_Common_Substring_Center_Expansion;

public class PalindromicSubstrings647 {
    public static void main(String[] args) {

    }

    //     https://www.youtube.com/watch?v=nw7ofFCGl6w
    public int countSubstrings(String s) {

        int n = s.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            count+= countPallindrome(s,i,i)+countPallindrome(s,i,i+1);
        }
        return count;
    }
    public int countPallindrome(String s, int l , int r)
    {
        int count=0;
        while(l>=0 && r<s.length())
        {
            if(s.charAt(l)==s.charAt(r)) count++;
            else break;
            l--;
            r++;
        }
        return count;
    }


}
