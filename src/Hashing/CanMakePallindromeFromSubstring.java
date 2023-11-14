package Hashing;
import java.util.*;
public class CanMakePallindromeFromSubstring {

    public static void main(String[] args) {
        CanMakePallindromeFromSubstring a = new CanMakePallindromeFromSubstring();
        a.canMakePaliQueries("abcda",new int[][]{ {3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}});


    }
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            int[] characters = new int[26];
            HashMap<Integer,int[]> map = new HashMap();
            int i=0, n= 26;
            for(char c: s.toCharArray())
            {
                characters[c-'a']++;
                map.put(i++,Arrays.copyOf(characters,n));
            }
            i=0;
            List<Boolean> ans = new ArrayList();
            for(int[] q: queries)
            {
                int l =q[0];
                int r =q[1];
                int k =q[2];
                ans.add(isPallindrome( l, r, k, map));
            }
            return ans;
        }
        boolean isPallindrome(int l, int r,int k, HashMap<Integer,int[]> map)
        {
            int count =0;
            int[] prevState = map.getOrDefault(l-1,new int[26]);
            int[] currState = map.get(r);
            int[] ans = new int[26];
            for(int i=0;i<26;i++)
            {
                currState[i] = currState[i]- prevState[i];
                if(currState[i]%2!=0)
                    count++;
            }
            System.out.print(count+" ");
            if(count/2<=k)
                return true;

            return false;
        }

}
