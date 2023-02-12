package Longest_Common_Substring_Center_Expansion;
import java.util.*;
public class MaximumNumberofNonOverlappingPalindromeSubstrings2472 {
    public static void main(String[] args) {
        MaximumNumberofNonOverlappingPalindromeSubstrings2472 a = new MaximumNumberofNonOverlappingPalindromeSubstrings2472();
        a.maxPalindromes("fttfjofpnpfydwdwdnns", 2);
    }
    int k;
    boolean[] used;

    public int maxPalindromes(String s, int k) {
        this.k = k;
        used = new boolean[s.length()];
        Arrays.fill(used, false);
        if (k == 1) return s.length();
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            int oddLength = centerExpansion(i, i, s);
            int evenLength = centerExpansion(i, i + 1, s);
            if (oddLength == i && evenLength == i) {
                i++;
            } else if (oddLength == i || evenLength == i) {
                i = oddLength == i ? evenLength : oddLength;
                used[i] = true;
                res = res + 1;
                i = i + 1;
            } else {
                i = Math.min(oddLength, evenLength);
                used[i] = true;
                i = i + 1;
                res = res + 1;
            }
        }
        return res;
    }

    int centerExpansion(int l, int r, String s) {
        int count = 0;
        int ol = l;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k && !used[l]) {

                    return r;
                }
            } else {
                return ol;
            }
            r++;
            l--;
        }
        return ol;
    }

}