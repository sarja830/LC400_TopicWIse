package DP_2d;
import java.util.*;
public class KnightProbabiltyInChessboard {
    int inside;
    int outside;
    int n;
    int k;


    public static void main(String[] args) {
        KnightProbabiltyInChessboard a= new KnightProbabiltyInChessboard();
        a.knightProbability(3,2,0,0);

    }

    public double knightProbability(int n, int k, int row, int column) {
        this.k = k;
        this.n = n;
        this.outside = 0;
        this.inside = 0;
        rec(row,column,0);
        return inside/(outside+inside);
    }

    void rec( int x, int y, int level)
    {
        if(x<0 || y<0 || x>=n || y>=n)
        {
            outside++;
            return;
        }
        if(level==k)
        {
            inside++;
            return;
        }
        rec(x-2, y-1, level+1);
        rec(x-2, y+1, level+1);
        rec(x-1, y-2, level+1);
        rec(x-1, y+2, level+1);
        rec(x+1, y-2, level+1);
        rec(x+1, y+2, level+1);
        rec(x+2, y-1, level+1);
        rec(x+2, y+1, level+1);
    }
}
