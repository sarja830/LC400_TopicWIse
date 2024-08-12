package Hashing;

public class BullsAndCows {
        public static void main(String[] args) {
            BullsAndCows a = new BullsAndCows();
            System.out.println(a.getHint("1123","0111"));
        }
        public String getHint(String secret, String guess) {
            int n = secret.length();
            int cows = 0;
            int bulls = 0;
            char[] guessArr = secret.toCharArray();

            int[] map = new int[10];
            for(int i=0;i<n;i++)
            {
                char s = secret.charAt(i);
                char g = guess.charAt(i);
                System.out.println(s+" "+g);
                if(s==g)
                {
                    bulls++;
                    guessArr[i] = '#';
                }
                else
                    map[s-'0']++;

            }
            for(int i: map)
                System.out.print(i);
            for(char c: guessArr)
            {
                if(c!='#' && map[c-'0']>0)
                {
                    System.out.println(map[c-'0']);
                    cows++;
                    map[c-'0']--;
                }

            }
            return bulls+"A"+cows+"B";

        }

}
