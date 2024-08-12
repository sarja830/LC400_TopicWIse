package Strings;

public class ValidNumber {

        public static void main(String[] args) {
            isNumber("12.5e+12.5e");

        }
        public static boolean isNumber(String s) {
            int dot = 1;
            int n = s.length();
            int sign = 1;
            int i=0;
            while(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-'))
            {
                if(sign>0)
                    sign--;
                else return false;
                i++;
            }
            while(i<n && s.charAt(i)!='e')
            {
                if(s.charAt(i)=='.')
                {
                    if(dot<1)
                        return false;
                    dot--;
                    i++;
                    if(i==n) return false;
                }
                else if (s.charAt(i)-'0'>9 && s.charAt(i)-'0'<0 )
                    return false;
                else
                    i++;
                if(i==n) return true;
            }


            if(s.charAt(i)=='e' && i+1<n && (s.charAt(i+1)=='+' || s.charAt(i+1)=='-'))
            {
                i= i+2;
                if(i==n) return false;


                    while (i < n) {
                        System.out.println(s.charAt(i)-'0');
                        if (s.charAt(i) - '0' > 9 || s.charAt(i) - '0' < 0)
                            return false;
                        else
                            i++;
                    }
            }
            else
                return false;

            return true;
        }

}
