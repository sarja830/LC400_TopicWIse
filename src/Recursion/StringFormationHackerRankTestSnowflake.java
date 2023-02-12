package Recursion;

public class StringFormationHackerRankTestSnowflake {
    public static void main(String[] args) {
//            int x = calculateWays(1,1);
//            int x = calculateWays(4,1);
//            int x = calculateWays(2,2);
//            long x = calculateWays(21,5); //828001349
            long x = calculateWays(0,2); //828001349
//            long x = calculateWays(37,20); //859194521
//            int x = calculateWays(2,1);

//        Syst
            System.out.println((int)x);

    }
    static int maxvowels;
    static long[][] ans;
    public static  long calculateWays(int wordLen, int maxVowels)
    {
        ans = new long[wordLen+1][maxVowels+1];
        maxvowels=maxVowels;
        if(wordLen==0) return 0;
        return (int)rec(wordLen,maxVowels);
    }
    public static  long rec(int wordLen, int maxVowels)
    {
        if(wordLen==0) return (long)1;
        if(maxVowels<0) return (long)0;
        if(ans[wordLen][maxVowels]!=0) return ans[wordLen][maxVowels];
        if(maxVowels==0) 
            ans[wordLen][maxVowels]= ((rec(wordLen-1,maxvowels)%1000000007)*21)%1000000007;
        else
            ans[wordLen][maxVowels] =(((rec(wordLen-1,maxVowels-1)%1000000007)*5)%1000000007
                                     +((rec(wordLen-1,maxvowels)%1000000007)*21)%1000000007)%1000000007;
        return ans[wordLen][maxVowels];
    }
}
