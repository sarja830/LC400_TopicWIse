package Stack;
import java.util.*;

public class NextGreaterElementii503 {
    public static void main(String[] args) {
        System.out.print(nextGreaterElements(new int[]{1,2,1}).toString());
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st  = new Stack();
        int n= nums.length;
        int[] res = new int[n];
        st.push(nums[n-1]);
        res[n-1]=-1;
        for(int i=2*n-2;i>=0;i--)
        {
            while(st.size()!=0  &&  st.peek()<=nums[i%n])
                st.pop();

            if(st.size()>0) res[i%n]=st.peek();
            else res[i%n]=-1;
            st.push(nums[i%n]);
        }
        return res;

    }

}
