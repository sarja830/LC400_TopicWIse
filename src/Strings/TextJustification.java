package Strings;
import java.util.*;
public class TextJustification {
    public static void main(String[] args) {
        TextJustification a = new TextJustification();
//        a.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16);
        a.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList();
        int currLength = 0;
        List<String> localWords = new LinkedList();
        int spaces = 0;
        for (int k = 0; k < words.length; k++) {
            String word = words[k];
            if (maxWidth - currLength >= word.length()) {
                localWords.add(word);
                currLength = currLength + word.length();
                if (currLength < maxWidth) {
                    spaces++;
                    currLength = currLength + 1;
                }

            } else {

                spaces = spaces + (maxWidth - currLength);
                currLength = currLength + (maxWidth - currLength);
//                if (k == words.length - 1)
//                    ans.add(formString(spaces, localWords, true));
//                else
                    ans.add(formString(spaces, localWords, false));
                localWords.clear();
                localWords.add(word);

                currLength = word.length();
                spaces = 0;
                if (currLength < maxWidth) {
                    spaces++;
                    currLength = currLength + 1;
                }
            }
        }
        if (currLength != 0) {
            spaces = spaces + (maxWidth - currLength);
            ans.add(formString(spaces, localWords, true));
        }
        return ans;
    }

    String formString(int spaces, List<String> words, boolean isLeft) {
        if (words.size() == 1) {
            String res = words.get(0);
            for (int i = 0; i < spaces; i++)
                res = res + " ";
            return res;
        }
        int n = spaces / (words.size() - 1);
        int extraSpace = spaces % (words.size() - 1);
        String res = "";
        if (!isLeft)
            for (int i = 0; i < words.size(); i++) {
                res = res + words.get(i);
                if (i == words.size() - 1)
                    continue;
                for (int j = 0; j < n; j++) {
                    res = res + " ";
                }
                if (extraSpace > 0) {
                    res = res + " ";
                    extraSpace--;
                }

            }
        else
            for (int i = words.size() - 1; i >= 0; i--) {
                res = words.get(i) + res;
                if (i == 0)
                    continue;
                for (int j = 0; j < n; j++) {
                    res = " " + res;
                }
                if (extraSpace > 0) {
                    res = " " + res;
                    extraSpace--;
                }
            }
        return res;
    }
}