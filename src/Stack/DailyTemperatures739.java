package Stack;
import java.util.*;
public class DailyTemperatures739 {

    public static void main(String[] args) {
        dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
    }
        public static int[] dailyTemperatures(int[] temperatures) {
            class pair
            {
                int temp;
                int index;
                pair(int a ,int b)
                {
                    temp=a;
                    index=b;
                }
            }
            Stack<pair> st = new Stack();
            int n = temperatures.length;
            int[] res= new int[n];
            st.push(new pair(temperatures[n-1],n-1));
            res[n-1]=0;
            for(int i=n-2;i>=0;i--)
            {

                while(st.size()!=0 && st.peek().temp<=temperatures[i])
                        st.pop();
                if(st.size()!=0)
                    res[i]= st.peek().index-i;
                else
                    res[i]=0;
                st.push(new pair(temperatures[i],i));
            }
            return res;

        }

}
