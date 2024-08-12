package BFS;
import java.util.*;
public class OpenTheLock752 {
    public static void main(String[] args) {
        OpenTheLock752 a =  new OpenTheLock752();
        a.openLock( new String[]{"0201","0101","0102","1212","2002"}, "0202");
    }
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        int level=0;
        HashSet<String> set = new HashSet(Arrays.asList(deadends));
        Queue<char[]> q = new LinkedList();
        q.add(start.toCharArray());
        while(!q.isEmpty())
        {
            int siz = q.size();
            for(int l=0;l<siz;l++)
            {
                char[] temp = q.poll();
                if(set.contains(String.valueOf(temp)))
                    continue;

                if((String.valueOf(temp)).equals(target))
                    return level;
                set.add(String.valueOf(temp));
                for(int i=0;i<4;i++)
                {
                    char backup = temp[i];
                    int curr = temp[i]-'0';
                    int prev = (curr - 1)>=0?curr-1:9;
                    temp[i] = (char)(prev+'0');
                    q.add(temp);

                    temp[i] = backup;
                    int next = (curr+1)%10;
                    temp[i] = (char)(next+'0');
                    q.add(temp);
                    temp[i] = backup;
                }

            }
            level++;
        }
        return -1;
    }

}
