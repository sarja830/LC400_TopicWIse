package Backtracking;

public class Mall {
    static int count;
    static int[][] visited;
    public static void main(String[] args) {
        count=0;
        visited = new int[5][5];
        int a = movement(2,1,true,true,5,5,1,2);

    }
    static int performOp( int x,boolean sign)
    {
        if(sign==true) return x+1;
        else return x-1;
    }

    static int movement(int x1, int y1, boolean sign1, boolean sign2, int m, int n,  int x2, int y2)
    {

        if(visited[x1][y1]==0) visited[x1][y1] =1;
        else return -1;

        if(x1==x2 && y1==y2)
            return count;
        else
        {

            if((performOp(x1,sign1)>=m || performOp(x1,sign1)<0 ) &&( performOp(y1,sign2)>=n || performOp(y1,sign2)<0)) {

                count=count+1;
                return movement(performOp(x1, !sign1), performOp(y1, !sign2),!sign1,!sign2, m, n, x2, y2);

            }
            else if((performOp(x1,sign1)>=m || performOp(x1,sign1)<0 ) || ( performOp(y1,sign2)>=n || performOp(y1,sign2)<0)) {

                count=count+1;
                if (performOp(x1,sign1)>=m || performOp(x1,sign1)<0  ) return movement(performOp(x1,!sign1),y1,!sign1,sign2,m,n,x2,y2);
                else return movement(x1,performOp(x2,!sign2),sign1,!sign2,m,n,x2,y2);
            }
            else
                return movement(performOp(x1, sign1), performOp(y1, sign2),sign1,sign2, m, n, x2, y2);
        }
}
}
