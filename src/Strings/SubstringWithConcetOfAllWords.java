package Strings;
import java.util.*;

public class SubstringWithConcetOfAllWords {
    public static void main(String[] args) {
        SubstringWithConcetOfAllWords a =new SubstringWithConcetOfAllWords();
        a.findSubstring("wordgoodgoodgoodbestword",
                new String[]{"word","good","best","good"});
    }
        public List<Integer> findSubstring(String s, String[] words) {
            int n = s.length();
            List<Integer> ans = new LinkedList();
            HashMap<String,Integer> map = new HashMap();
            for(String word: words)
                map.put(word,map.getOrDefault(word,0)+1);

            int wordLength = words[0].length();
            int seen =words.length;
            for(int i=0;i<n;i++)
            {
                int j = i;
                if(j+wordLength<=n && map.containsKey(s.substring(j,j+wordLength)))
                {
                    while( (j+wordLength<=n && map.containsKey(s.substring(j,j+wordLength))) && seen!=0)
                    {
                        if(map.get(s.substring(j,j+wordLength))==1)
                            map.remove(s.substring(j,j+wordLength));
                        else
                            map.put(s.substring(j,j+wordLength),map.get(s.substring(j,j+wordLength))-1);
                        j=j+wordLength;
                        seen--;
                    }
                    if(seen==0) ans.add(i);
                    seen = words.length;
                    map.clear();
                    for(String word: words)
                        map.put(word,map.getOrDefault(word,0)+1);
                }
            }
            return ans;
        }

}
