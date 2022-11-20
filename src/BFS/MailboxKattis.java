package BFS;

import java.io.*;
import java.util.StringTokenizer;

public class MailboxKattis {
    static int[][][] memoize;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] k = new int[n];
        int[] m = new int[n];
        for (int i = 0; i < n; i++)
        {
            StringTokenizer st1 = new StringTokenizer(in.readLine());

            k[i] = Integer.parseInt(st1.nextToken());
            m[i] = Integer.parseInt(st1.nextToken());

        }
        for (int i = 0; i < n; i++)
        {
            memoize = new int[k[i]+1][m[i]+1][m[i]+1];
            System.out.println(Mailbox(k[i],0,m[i]));
        }
    }

    public static int Mailbox(int k, int safeRange, int testRange) {
//        if there is only one mail box left then test crackers starting from safe range to test range
//        lets say you already know that 2 is the safe range you want to test on test range 7

        if(k==1)
            return testRange*(testRange+1)/2- safeRange*(safeRange+1)/2;

//        if safe range == test range then you have reached the limit no need to burst any cracker
        if(safeRange==testRange)
            return 0;

//        no mailbox left hence we return infinity so that it doesn't reflect in the answer
        if(k==0)
            return Integer.MAX_VALUE;

        if(memoize[k][safeRange][testRange]!=0)
            return memoize[k][safeRange][testRange];

        int result= Integer.MAX_VALUE;

//        burst i crackers which means (+i) crackers required
//        2 cases possible:
//           Case 1:
//              mailbox survives
//              update saferange to i-1 since on exploding i cracker it bursted.
//            Case 2:
//              mailbox exploded
//              update saferange to i since it survived i cracker

//        we will iterate over all the range to get the best possible answer which gives us minimum
        for(int i=safeRange+1;i<=testRange;i++)
        {
            result = Math.min(result, i+Math.max(Mailbox(k-1,safeRange,i-1),Mailbox(k,i,testRange)));
        }
        memoize[k][safeRange][testRange]=result;
        return memoize[k][safeRange][testRange];
    }
}
