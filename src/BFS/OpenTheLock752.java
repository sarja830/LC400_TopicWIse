package BFS;
import java.util.*;
public class OpenTheLock752 {
    public static void main(String[] args) {
        OpenTheLock752 a =  new OpenTheLock752();
        a.openLock( new String[]{"0201","0101","0102","1212","2002"}, "0202");
    }
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList();
        Set<String> set = new HashSet(Arrays.asList(deadends));

        q.add("0000");
        int level=0;
        while(!q.isEmpty())
        {

            int siz = q.size();
            for(int i=0;i<siz;i++)
            {
                String temp = q.poll();
                if(set.contains(temp)) continue;
                if(temp.equals(target)) return level;
                set.add(temp);
                for(int j=0;j<4;j++)
                {
                    int digit = temp.charAt(j)-'0';
                    int digitNext = digit==9?0:digit+1;
                    int digitPrev= digit==0?9:digit-1;

                    String up = temp.substring(0, j) + (char)(digitNext+'0') + temp.substring(j+ 1);
                    String down = temp.substring(0, j) +(char)(digitPrev+'0') + temp.substring(j + 1);
                    q.add(up);
                    q.add(down);

                }
                level++;
            }
        }
        return -1;
    }

}
