package Greedy;
import java.util.*;
public class Candies {

        public int candy(int[] ratings) {
            // 2 pass solution
            int sum = 0;
            int n = ratings.length;
            int ans[] = new int[n];
            Arrays.fill(ans,1);
            for(int i=1;i<n;i++)
            {
                if(ratings[i]>ratings[i-1])
                    ans[i] = ans[i-1]+1;
            }
            for(int i=n-2;i>=0;i--)
            {
                if(ratings[i]>ratings[i+1])
                    if(ans[i]<=ans[i+1])
                        ans[i] = ans[i+1]+1;
            }
            for(int i:ans)
                sum = sum+i;
            return sum;
        }

}
