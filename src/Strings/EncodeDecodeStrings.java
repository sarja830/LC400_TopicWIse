package Strings;
import java.util.*;
public class EncodeDecodeStrings {
    public static void main(String[] args) {

        List<String> ans = decode(encode(Arrays.asList("63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O ")));
        System.out.println(ans);
    }

        // Encodes a list of strings to a single string.
        public static String encode(List<String> strs) {
            StringBuilder encoded =  new StringBuilder("");
            for(String s: strs)
                encoded.append(s.length()).append("#").append(s);
            System.out.println(encoded.toString());
            return encoded.toString();
        }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s1) {
        int i=0;
        List<String> ans = new LinkedList();
        while(i<s1.length())
        {
            int n = 0;
            while(s1.charAt(i)!='#')
            {
                char c = s1.charAt(i++);
                n = n*10+c-'0';
            }

            ans.add(s1.substring(i+1,i+1+n));
            i = i+1+n;

        }

        return ans;
    }
    }

