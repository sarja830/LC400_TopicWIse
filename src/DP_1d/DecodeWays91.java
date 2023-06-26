package DP_1d;

public class DecodeWays91 {

    public static void main(String[] args) {
        DecodeWays91 a = new DecodeWays91();
        a.numDecodings("12");
    }
    public int numDecodings(String s) {
        return rec(s,0,s.length());
    }


    int rec(String s, int i, int n )
    {
        if(i==n) return 1;
        if(i>=n) return 0;
        int no =s.charAt(i)-'0';
        int no2= -1;
        if(i<=n-2)  no2 = no*10+s.charAt(i+1)-'0';

        if(i<=n-2 && no2<=26 && no2>=0 && no<=26 &&  no>=0 )
        {
            return rec(s,i+1,n)+rec(s,i+2,n);
        }
        else
            return rec(s,i+1,n);
    }

}
