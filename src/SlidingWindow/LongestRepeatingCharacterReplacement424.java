package SlidingWindow;

public class LongestRepeatingCharacterReplacement424 {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement424 a = new LongestRepeatingCharacterReplacement424();
        a.characterReplacement("ABBAABB",0);
    }
        public int characterReplacement(String s, int k) {
            int i =0, j=0, count=0, ans=0, maxCount=0;
            int nums[] = new int[26];
            int n = s.length();
            while(j<n)
            {
                char c = s.charAt(j);
                nums[c-'A']++;

                if(nums[c-'A']>maxCount)
                    maxCount = nums[c-'A'];

                while(j-i+1-maxCount>k)
                {

                    nums[s.charAt(i)-'A']--;
                    i++;
                }
                if(j-i+1>ans) ans= j-i+1;
                j++;
            }
            return ans;
        }

}
