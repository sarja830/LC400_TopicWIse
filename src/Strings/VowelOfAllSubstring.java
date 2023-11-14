package Strings;
import java.util.*;
public class VowelOfAllSubstring {
    public static void main(String[] args) {
        VowelOfAllSubstring a = new VowelOfAllSubstring();
        a.countVowels("aba");
    }
        public long countVowels(String word) {
            int n = word.length();
            long count=0;
            HashSet<Character> set = new HashSet();
            set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
            for(int i=0;i<n;i++)
            {
                if(set.contains(word.charAt(i)))
                    count = count+((i+1)*n-i);
            }
            return count;
        }

}
