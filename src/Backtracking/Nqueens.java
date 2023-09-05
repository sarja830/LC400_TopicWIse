package Backtracking;
import java.util.*;
public class Nqueens {
    public static void main(String[] args) {
        Nqueens a = new Nqueens();
        a.solveNQueens(4);
    }

        HashMap<Integer,Character> diagonalUp = new HashMap();
        HashMap<Integer,Character> diagonalDown = new HashMap();
        HashMap<Integer,Character> left = new HashMap();
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for(char[] arr : board)
            {
                Arrays.fill(arr,'.');
            }
            List<List<String>> ans = new LinkedList();
            rec(ans,n,board,0);
            return ans;
        }

    void rec( List<List<String>> ans ,int n, char[][] board , int col)
    {
        if(col==board[0].length)
        {
            List<String> list = new LinkedList();
            for(char ar[]:board)
            {
                list.add(new String(ar));
            }
            ans.add(list);
            return;
        }
        for(int i=0;i<board.length;i++)
        {
            board[i][col] = 'Q';

            if(isSafe(i,col,board))
            {
                diagonalDown.put(i+col,'Q');
                diagonalUp.put(n-1-i+col,'Q');
                left.put(i,'Q');
                rec(ans,n,board,col+1);
                diagonalDown.remove(i+col);
                diagonalUp.remove(n-1-i+col);
                left.remove(i);
            }

            board[i][col] = '.';
        }
        return;
    }
    boolean isSafe(int row,int col, char[][] board)
    {

        if(diagonalDown.containsKey(row+col))
            return false;
        if(diagonalUp.containsKey(board.length-1-row+col))
            return false;
        if(left.containsKey(row))
            return false;

        return true;
    }


//        public List<List<String>> solveNQueens(int n) {
//            char[][] board = new char[n][n];
//            for(char[] arr : board)
//            {
//                Arrays.fill(arr,'.');
//            }
//            List<List<String>> ans = new LinkedList();
//            rec(ans,board,0);
//            return ans;
//        }
//        void rec( List<List<String>> ans ,  char[][] board , int col)
//        {
//            if(col==board[0].length)
//            {
//                List<String> list = new LinkedList();
//                for(char ar[]:board)
//                {
//                    list.add(ar.toString());
//                }
//                ans.add(list);
//            }
//            for(int i=0;i<board.length;i++)
//            {
//                board[i][col] = 'Q';
//                if(isSafe(i,col,board))
//                {
//                    rec(ans,board,col+1);
//                }
//                board[i][col] = '.';
//            }
//            return;
//        }
//        boolean isSafe(int row,int col, char[][] board)
//        {
//
//            for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
//            {
//                if(board[i][j]=='Q')
//                    return false;
//            }
//            for(int j=col-1;j>=0;j--)
//            {
//                if(board[row][j]=='Q')
//                    return false;
//            }
//            for(int i=row-1,j=col-1;i<board.length&&j>=0;i++,j--)
//            {
//                if(board[i][j]=='Q')
//                    return false;
//            }
//            return true;
//        }


}
