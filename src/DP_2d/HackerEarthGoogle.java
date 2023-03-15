package DP_2d;

public class HackerEarthGoogle {
    static int[] a;
    static int[] b;
    static int[][] ans;
    public  static void main(String[] args) {
//        a=new int[]{3,5,2,1,9};
        a=new int[]{1,2,1,3,4,2,1,2,3,1};
//        b=new int[]{1,1,10,5,3};
        b=new int[]{5,5,1,1,1,5,5,1,1,1};
        HackerEarthGoogle aa= new HackerEarthGoogle();
        ans =  new int[a.length+1][b.length+1];
        int aaaa=  aa.dp(0,0);
        int b=aaaa;
    }
    int dp(int i, int j)
    {
        if(i>=a.length || j>=b.length)
        {
            return 0;
        }

        if(j+1<b.length)
            ans[i][j] =Math.min(dp(i+1,j+1)+a[i],dp(i+2,j+2)+b[j]+b[j+1]);
        else
            ans[i][j]= dp(i+1,j+1)+a[i];
        return ans[i][j];
    }

}
