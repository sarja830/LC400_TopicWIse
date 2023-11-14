package Heap;
import java.util.*;
public class RearrangeString {
    public static void main(String[] args) {
        reorganizeString("vvvlo");
    }
        public static  String reorganizeString(String s) {
            String res ="";
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
                if(a[1]>b[1])
                    return -1;
                else return 1;
            });
            int[] characters = new int[26];
            for(char c:s.toCharArray())
                characters[c-'a']++;
            for(int i=0;i<characters.length;i++)
                if(characters[i]>0)
                    pq.add(new int[]{'a'+i,characters[i]});

            Queue<int[]> list = new LinkedList();
            while(!pq.isEmpty())
            {
                int[] p = pq.poll();
                res =res + (char)p[0];
                p[1]--;
                if(p[1]>0)
                {
                    if(list.size()>0)
                        pq.add(list.poll());
                    list.add(p);
                }
            }
            if(list.size()>0)
                if(list.peek()[1]>1)
                    return "";
                else res =res+(char)list.peek()[0];
            return res;

        }

}
