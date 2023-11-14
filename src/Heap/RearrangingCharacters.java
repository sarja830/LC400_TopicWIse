package Heap;
import java.util.*;
public class RearrangingCharacters {
    public static void main(String[] args) {
        rearrangeCharacters("geeksforgeeks");
    }
        public static String rearrangeCharacters(String str) {
            {
                class Pair
                {
                    int count;
                    char c;
                    public Pair(int count, char c)
                    {
                        this.count = count;
                        this.c = c;
                    }
                }

                int[] character = new int[26];
                PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
                    if(a.count>b.count)
                        return -1;
                    else
                        return 1;
                });
                for(char c:str.toCharArray())
                {
                    character[c-'a']++;
                }
                for(int i=0;i<character.length;i++)
                {
                    if(character[i]>0)
                        pq.add(new Pair( character[i],(char)('a'+i)));
                }
                String res = "";
                List<Pair> list = new LinkedList();

                while(!pq.isEmpty())
                {
                    Pair p = pq.poll();
                    res = res + p.c;
                    p.count--;
                    if(p.count>0)
                    {
                        if(list.size()!=0)
                        {
                            pq.add(list.get(0));
                            list.remove(0);
                        }
                        list.add(p);
                    }
                }
                if(list.size()>0)
                    res =res +list.get(0);

                System.out.println(res);
                return res;
            }

        };
}
