package Strings;

public class ValidPallindrome {
    public static void main(String[] args) {
        ValidPallindrome a = new ValidPallindrome();
        a.isPalindrome("A man, a plan, a canal: Panama");
    }
        public boolean isPalindrome(String s) {

             String s1 ="";
            int n = s.length();
            int i=0;
            for( i=0;i<n;i++)
                if(Character.isLetterOrDigit(s.charAt(i)))
                    s1=s1+s.charAt(i);
            i=0;
            n = s1.length();
            int j = n-1;

            while(j>=i)
            {
                if(i<n && !Character.isLetterOrDigit(s1.charAt(i)))
                    i++;
                if(j>=0 && !Character.isLetterOrDigit(s1.charAt(j)))
                    j--;
                if(i>=n && j<0)  return false;

                if( s1.charAt(i)!=s1.charAt(j)) return false;
                j--;
                i++;
            }
            return true;
        }

}
