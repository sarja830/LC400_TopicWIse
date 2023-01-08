package Strings;
import java.util.*;
public class AddStrings415 {
    public static void main(String[] args) {
        addStrings("456","77");
    }

        public static String addStrings(String num1, String num2) {
            int i=num1.length()-1;
            int j = num2.length()-1;
            int xy,z,x=0,y=0;
            int carry=0;
            StringBuilder res=new StringBuilder();
            while(i>=0 || j>=0)
            {

//                if(i>=0)
//                    x= Character.getNumericValue(num1.charAt(i));
//                if(j>=0)
//                    y=Character.getNumericValue(num2.charAt(j));

                if(i>=0)
                    x= num1.charAt(i)-'0';
                if(j>=0)
                    y=num2.charAt(j)-'0';

                xy =x+y+carry;
                z=(x+y+carry)%10;
                carry=xy/10;

//                res=Character.forDigit(z,10)+res;
                res.append(z);
                i--;
                j--;
                x=0;
                y=0;
            }
            if(carry!=0) res.append(carry);
            return res.reverse().toString();
        }

}
