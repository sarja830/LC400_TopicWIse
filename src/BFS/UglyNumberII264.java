package BFS;
import java.util.*;
public class UglyNumberII264 {
    public static void main(String[] args) {
        UglyNumberII264 a = new UglyNumberII264();
        a.nthUglyNumber(10);
    }
        public int nthUglyNumber(int n) {
            PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
            Queue<Integer> q = new LinkedList();
            q.add(1);
            boolean flag=false;
            int prevCount=0;
            int count=1;
            if(n==1) return 1;

            while(q.size()!=0)
            {
                int siz=q.size();
                if(count>n)
                {
                    prevCount=count-n;
                    flag=true;
                }
                for(int i=0;i<siz;i++)
                {
                    int temp =q.poll();
                    if(flag)
                        pq.add(temp);

                    q.add(temp*2);
                    q.add(temp*3);
                    q.add(temp*5);
                    count=count+3;
                }
                if(flag)
                {
                    int temp=0;
                    for(int j=1;j<prevCount;j++)
                        temp=pq.poll();
                    return temp;
                }

            }
            return -1;
        }

}
