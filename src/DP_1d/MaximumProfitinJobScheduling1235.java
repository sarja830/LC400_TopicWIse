package DP_1d;
import java.util.*;

//it didnt pass all test cases

public class MaximumProfitinJobScheduling1235 {

    public static void main(String[] args) {
//        int[] startTime = new int[]{1,2,3,3};
//        int[] endTime = new int[]{3,4,5,6};
//        int[]profit = new int[]{50,10,40,70};
//        int[] startTime = new int[]{6,15,7,11,1,3,16,};
//        int[] endTime = new int[]{19,18,19,16,10,8,19,8};
//        int[]profit = new int[]{2,9,1,19,5,7,3,19};
        int[] startTime = new int[]{24,24,7,2,1,13,6,14,18,24};
        int[] endTime = new int[]{27,27,20,7,14,22,20,24,19,27};
        int[]profit = new int[]{6,1,4,2,3,6,5,6,9,8};
        jobScheduling(startTime,endTime,profit);
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        class Job{
            int s,e,p;
            public Job(int a , int b ,int c)
            {
                s=a;
                e=b;
                p=c;
            }
        }
        int n = startTime.length;
        Job[] jobs = new  Job[n];
        for(int i=0;i<n;i++)
        {
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(jobs,(a,b)->Integer.compare(a.s,b.s));
        int[] ans = new int[n];
        ans[0]=jobs[0].p;
        for(int i=1;i<n;i++)
        {
            int j=i-1;
            ans[i]=jobs[i].p;
            while(j>=0 )
            {
                if(  jobs[i].s>=jobs[j].e)
                    ans[i]=Math.max(jobs[i].p+ans[j],ans[i]);
                j--;
            };

        }
        int max=0;
        for(int k:ans)
            max=Math.max(max,k);
        return max;
    }


}
