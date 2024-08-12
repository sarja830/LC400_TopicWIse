package DFS;
import java.util.*;
public class WordSearch79 {

   static int m ;
    static int n;
    static String w;
    public static void main(String[] args) {
        exist( new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}},"AAB");
    }

    public  static boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    char temp = board[i][j];
                    board[i][j] = 'x';
                    if(DFS(i,j,board,word,1)) return true;
                    board[i][j] = temp;
                }
            }
            return false;
    }
    static boolean  DFS(int i, int j, char[][] board, String word, int curr)
    {

              System.out.println(curr)  ;
        int m = board.length;
        int n = board[0].length;
        if(curr==word.length())
            return true;

        boolean ans = false;
        int[] x = new int[]{1,-1,0,0};
        int[] y = new int[]{0,0,1,-1};
        for(int k=0;k<4;k++)
        {
            int xCord = i+x[k];
            int yCord = j+y[k];
            if(xCord>=0 && xCord<m && yCord>=0 &&  yCord<n && word.charAt(curr)==board[xCord][yCord])
            {
                char temp = board[i][j];
                board[xCord][yCord] = 'x';
                ans = ans ||  DFS(xCord,yCord,board,word,curr+1);
                if(ans) return ans;
                board[xCord][yCord] = temp;
            }
        }
        return ans;

    }

}
