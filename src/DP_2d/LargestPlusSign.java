package DP_2d;
import java.util.*;
import java.util.stream.Collectors;

public class LargestPlusSign {
    public static void main(String[] args) {
        LargestPlusSign a = new LargestPlusSign();
        a.orderOfLargestPlusSign(2,new int[][]{

                {0, 0},
                {0, 1},
                {1, 0}

        });
    }
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        HashSet<List<Integer>> set = new HashSet();
        for(int[] mine: mines)
            set.add(Arrays.stream(mine).boxed().collect(Collectors.toList()));
        int[][][] computation = new int[n][n][4];
        // 0 left to right
        // 1 right to left
        // 2 up to down
        // 3 down to up
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                if(!set.contains(Arrays.asList(i,j)))
                {
                    computation[i][j][0] = ((j-1>=0)?computation[i][j-1][0]:0 ) + 1;
                    computation[i][j][2] = ((i-1>=0)?computation[i-1][j][2]:0 ) + 1;
                }
                else
                {
                    computation[i][j][2] = 0;
                    computation[i][j][0] = 0;
                }            }
        for(int i=n-1;i>=0;i--)
            for(int j=n-1;j>=0;j--)
            {
                if(!set.contains(Arrays.asList(i,j)))
                {
                    computation[i][j][1] = ((j+1<n)?computation[i][j+1][1]:0) + 1;
                    computation[i][j][3] = ((i+1<n)?computation[i+1][j][3]:0) + 1;
                }
                else
                {
                    computation[i][j][1] = 0;
                    computation[i][j][3] = 0;
                }
            }

        int max = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                max = Math.max(
                        Math.min(
                                Math.min(computation[i][j][1],computation[i][j][0]),
                                Math.min(computation[i][j][2],computation[i][j][3])
                        ),
                        max
                );
            }
        return max;
    }
}
