package simulation;
import java.util.*;
public class ZigzagConversion {
    public static void main(String[] args) {
        convert("Paypalishiring",3);
        convert("Paypalishiring",4);
    }
        public static String convert(String s, int n) {
            char[][] ans = new  char[1000][1000];
            for(char[] c:ans)
                Arrays.fill(c,'#');
            int i=0;
            int j=0;
            int k=0;
            while(k<s.length())
            {
                while(i<n && k<s.length())
                {
                    ans[i][j] = s.charAt(k++);
                    i++;
                }
                i--;
                while(i>1 && k<s.length())
                {
                    j++;
                    i--;
                    ans[i][j] = s.charAt(k++);
                }
                i--;
                j++;
            }
            String res = "";
            for( i=0;i<1000;i++)
                for( j=0;j<1000;j++)
                {
                    if(ans[i][j]!='#')
                        res= res+ans[i][j];
                }
            return res;

        }

}
