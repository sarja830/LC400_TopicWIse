//package Arrays;
//import java.util.*;
//public class MultiplyStrings43 {
//    public static void main(String[] args) {
//        MultiplyStrings43 a = new MultiplyStrings43();
//        a.multiply("99","99");
//    }
//        public String multiply(String num1, String num2) {
//            int m =num1.length();
//            int n = num2.length();
//            int[] ans = new int[m+n];
//            int carry=0;
//            int k=-1;
//            for(int i=m-1;i>=0;i--)
//            {
//                k++;
//                for(int j=n-1;j>=0;j--)
//                {
//                    int a = Integer.valueOf(num1.charAt(i));
//                    int b = Integer.valueOf(num2.charAt(j));
//                    int mul = a*b;
//                    ans[i+j+2-k]=mul%10;
//                    mul=mul/10;
//                    carry =ans[i+j+1-k]+carry+mul;
//                }
//                carry = ans[i+j+2-k+1]=carry;
//            }
//        }
//
//}
