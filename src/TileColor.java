import java.util.*;

public class TileColor {
    public static void main(String[] args) {
        TileColor a = new TileColor();
        System.out.print(a.solution(new int[]{0,1,0,1,1},3));
    }
    int solution(int[] tileColors, int size)
    {
        int n = tileColors.length;
        int count =0;
        Deque<Integer> q = new LinkedList<>();
        int i=0;
        for(int j=0;j<n+size;j++)
        {
            while(!q.isEmpty() && q.getFirst()<i )
                q.removeFirst();

            if(j>0 && tileColors[(j-1)%n]==tileColors[j%n]) {
                q.add(j % n);
            }
            if(j-i+1==size)
            {
                if(q.size()==0) count++;
                i++;
            }
        }
        return count;
    }
}
