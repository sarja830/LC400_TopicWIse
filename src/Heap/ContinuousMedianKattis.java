package Heap;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class ContinuousMedianKattis {
    static PriorityQueue<BigInteger> lq ;
    static PriorityQueue<BigInteger> rq;
    static BigInteger sum;
    static boolean  even=true;
    static double[] nums;
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
//      taking input
        int n = Integer.parseInt(st.nextToken());

//      using BigInteger to get the correct answer range
        BigInteger[] sums = new BigInteger[n];

        for(int i=0;i<n;i++)
        {
            StringTokenizer st1 = new StringTokenizer(in.readLine());
            int m = Integer.parseInt(st1.nextToken());


            lq = new PriorityQueue(Collections.reverseOrder());
            rq = new PriorityQueue();
            sum = BigInteger.valueOf(0);
            nums= new double[m];
            even=true;
            StringTokenizer st2 = new StringTokenizer(in.readLine());
            for (int j = 0;j < m; j++)
            {
                nums[j] = Integer.parseInt(st2.nextToken());

//      adding to the priority queue
                ContinuousMedianKattis.addNum((long)nums[j]);

//      Finding median
                if(even) {
                    sum = sum.add((lq.peek().add(rq.peek()) ).divide(BigInteger.valueOf(2)) );
                }
                else {
                    sum = sum.add(lq.peek());
                }
            }
            sums[i] = sum;
        }

//        printing all the medians
        for(BigInteger s:sums)
            System.out.println(s);
    }

    public static void addNum(long num)
    {
        if(even)
        {
            rq.add(BigInteger.valueOf(num));
            lq.add(rq.poll());
        }
        else
        {
            lq.add(BigInteger.valueOf(num));
            rq.add(lq.poll());
        }
        even=!even;
    }


}
