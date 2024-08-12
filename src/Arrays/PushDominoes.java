package Arrays;
import java.util.*;
public class PushDominoes {
    public static void main(String[] args) {
        PushDominoes a = new PushDominoes();
        a.pushDominoes("..R..");
    }
    public String pushDominoes(String dominoes) {


                char[] s = dominoes.toCharArray();
                int n = s.length;
                int prev = -1;
                char[] ans = new char[n];
                double[] force = new double[n];
                for(int i=0;i<n;i++)
                {
                    if(s[i]=='R'){
                        prev = i;
                        force[i] = Integer.MAX_VALUE;
                    }
                    else if(s[i]=='L'){
                        prev = -1;
                    }

                    if(prev!=-1 && s[i]=='.')
                        force[i] = 1 /((double)i-(double)prev);
                }
                prev =-1;
                for(int i=n-1;i>=0;i--)
                {
                    if(s[i]=='L'){ prev = i; force[i] = Integer.MIN_VALUE;}
                    else if(s[i]=='R') prev = -1;
                    else if(prev!=-1 && s[i]=='.')
                    {
                        System.out.print(force[i]);
                        force[i] = force[i]+ 1/(i-prev);
                        System.out.print(" "+force[i]);
                        System.out.println(" ");
                    }

                    if(force[i]>0.0){ ans[i] = 'R'; }
                    else if(force[i]==0.0) ans[i] = '.';
                    else ans[i] = 'L';
                }
                return new String(ans);
            }


}
