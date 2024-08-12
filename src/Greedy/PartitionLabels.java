package Greedy;
import java.util.*;
public class PartitionLabels {
    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij");
    }
        public static List<Integer> partitionLabels(String s) {
            HashMap<Character, Integer> map = new HashMap();
            List<Integer> ans = new LinkedList();
            int i =0;
            for(char c: s.toCharArray())
            {
                map.put(c,map.getOrDefault(c,i));
                i++;
            }
            int n = s.length();
            int j =n-1;
            while(j>=0)
            {
                char c1 = s.charAt(j);
                i = j;
                if(map.containsKey(c1))
                {
                    i = map.get(c1);

                    int curr = j;
                    while(curr>=i)
                    {
                        if(map.containsKey(s.charAt(curr)))
                            i = Math.max(map.get(s.charAt(curr)), i);
                        curr--;
                    }
                }
                ans.add(ans.size(),j-i+1);
                j=i-1;
            }
            return ans;


        }

}
