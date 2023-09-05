package Stack;
import java.util.*;
public class MaximalRectangle {
    public static void main(String[] args) {
        MaximalRectangle a = new MaximalRectangle();
        a.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
        public int maximalRectangle(char[][] matrix) {
            int n= matrix.length;
            int m = matrix[0].length;
            int ans =0;
            int[] rowTilli= new int[m];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                    rowTilli[j] = (matrix[i][j]=='0')?0: rowTilli[j]+1;

                ans =Math.max(getMaxArea(rowTilli),ans);

            }
            return ans;
        }
        int getMaxArea(int[] rowTilli)
        {
            int n=rowTilli.length;
            int[] nsl = new int[n];
            int[] nsr = new int[n];
            Stack<Integer> st =  new Stack();
            for(int i=0;i<n;i++)
            {
                while(!st.isEmpty() && rowTilli[st.peek()]>=rowTilli[i])
                {
                    st.pop();
                }
                nsl[i] = st.isEmpty()?-1:st.peek();
                st.push(i);
            }
            st.clear();
            for(int i=n-1;i>=0;i--)
            {
                while(!st.isEmpty() && rowTilli[st.peek()]>=rowTilli[i])
                {
                    st.pop();
                }
                nsr[i] = st.isEmpty()?n:st.peek();
                st.push(i);
            }
            int maxArea = 0;
            for(int i=0;i<n;i++)
                maxArea= Math.max(maxArea,rowTilli[i]*(nsr[i]-nsl[i]-1));
            return maxArea;
        }

}
