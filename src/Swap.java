import java.util.*;
public class Swap {

    public static void main(String[] args) {
        Swap a = new Swap();
        a.solution(new int[]{2,-2,5,3}, new int[]{1,5,-1,1});
    }
    long solution(int[] a , int[] b )
    {
        int i=0;
        int n = a.length;
        long count=0;
        int j;
        for(i=0;i<n;i++)
        {
            for(  j=i;j<n;j++)
            {
                if(a[i]-b[j]==a[j]-b[i])
                    count++;
            }
        }
        return count;
    }
}
