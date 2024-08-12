package Arrays;
import java.util.*;
public class CountNiceArrays {
    public static void main(String[] args) {
        CountNiceArrays a = new CountNiceArrays();
        a.countNicePairs(new int[]{12,12,13,14,15,16});
    }
    public int countNicePairs(int[] nums) {
        int n = nums.length;
//        int[] rev = Arrays.stream(nums).map(this::reverse).toArray();
        //both are correct

        int[] rev = Arrays.stream(nums).map(i->i-reverse(i)).toArray();
        System.out.print(Arrays.toString(rev));
        return 0;
//        return Arrays.stream(numbers)
//                .map(ReverseNumberLambda::reverse)
//                .toArray();
    }

    int reverse(int n)
    {
        int rev = 0;
        while(n>0)
        {
            rev = rev*10 + n%10;
            n = n/10;
        }
        return rev;
    }


}
