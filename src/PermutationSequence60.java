import java.util.*;
import java.util.PriorityQueue;

public class PermutationSequence60 {
    public static void main(String[] args) {
        PermutationSequence60 a = new PermutationSequence60();
        System.out.println(a.getPermutation(4, 9));
    }
    public String getPermutation(int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        int fact = 1;
        for(int i=1;i<=n;i++)
        {
            pq.add(i);
            fact=fact*i;
        }

        StringBuilder ans = new StringBuilder("");
        int maxAchievableValue = fact;
        fact = fact/n;
        int prev = 0;
        while(pq.size()>0)
        {
            maxAchievableValue = fact;
            List<Integer> tempList = new LinkedList();
            int j=1;
            while(prev+ maxAchievableValue*j<k)
            {
                tempList.add(pq.poll());
                j++;
            }
            ans.append(pq.poll());
            pq.addAll(tempList);
            if(pq.size()==1)
                ans.append(pq.poll());
            prev = maxAchievableValue*(j-1);
            if(pq.size()>0)
                fact = fact/pq.size();
        }
        return ans.toString();
    }

}
