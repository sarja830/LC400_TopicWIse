package Hashing;
import java.util.*;
//hacker rank test find the
public class SequentialStringHackerRank {
    public static void main(String[] args) {
        SequentialStringHackerRank a= new SequentialStringHackerRank();
        System.out.print(a.checkInclusion("eidbaooo","ab"));
    }

        public boolean checkInclusion(String s1, String s2) {
            HashMap<Character,List<Integer> > map = new HashMap();
            HashMap<Character,Integer> map1 = new HashMap();
            int check=0;
            int max =-1;
            int n =s1.length();
            int m= s2.length();
            for(int i=0;i<n;i++)
            {
                char c = s1.charAt(i);
                if(map.containsKey(c))
                {
                    List<Integer> list =map.get(c);
                    list.add(i);
                }
                else
                {
                    List<Integer> newList = new LinkedList();
                    newList.add(i);
                    map.put(c,newList);
                }
            }
            for(int i=0;i<m;i++)
            {
                char c = s2.charAt(i);
                if(map1.containsKey(c))
                {
                    map1.put(c,map1.get(c)+1);
                }
                else
                {
                    map1.put(c,0);
                }
            }
            for(char i:map1.keySet())
            {
               int count = map1.get(i);
                if(map.containsKey(i))
                {
                    List<Integer> l = map.get(i);
                    if(l.size()<count)
                    {
                        return false;
                    }
                    if(l.get(count)>max)
                    {
                        check++;
                        max=Math.max(l.get(count),max);
                    }
                }
                else
                    return false;
                System.out.println(max);
            }
            return true;

        }

}
