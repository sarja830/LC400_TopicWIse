package BinarySearch;
import java.util.ArrayList;
import java.util.Arrays;

public class PaintersPartitionProblem {



        public static void main(String[] args) {
           int a = findLargestMinDistance(new ArrayList<Integer>(Arrays.asList(10 ,20, 30, 40)), 2);

        }
        public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
        {
            int low =0, high = 0,ans =0;
            for(int i:boards)
            {
                low =Math.max(i,low);
                high  = i+high;
            }
            while(low<=high)
            {
                int mid = low+(high-low)/2;
                if(count(boards , mid)<=k)
                {
                    ans = mid;
                    high = mid-1;
                }
                else
                {
                    low = mid-1;
                }
            }
            return ans;
        }
        static int count(ArrayList<Integer> boards,int paint)
        {
            int painted = 0;
            int count =1;
            for(int i: boards)
            {
                painted = painted + i;
                if(painted>paint)
                {
                    painted= i;
                    count++;
                }
            }
            return count;
        }

}
