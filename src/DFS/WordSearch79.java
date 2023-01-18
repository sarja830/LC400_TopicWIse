//package DFS;
//import java.util.*;
//public class WordSearch79 {
//
//   static int m ;
//    static int n;
//    static String w;
//    public static void main(String[] args) {
//        exist( new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED");
//    }
//
//    public static boolean exist(char[][] board, String word) {
//        boolean a=false;
//        m=board.length;
//        n=board[0].length;
//        w=word;
//        for(int i=0;i<m;i++)
//        {
//            for(int j=0;j<n;j++)
//            {
//                if(word.charAt(0)==board[i][j])
//                {
//                    a= bfs(board,i,j);
//                    if(a) return a;
//                }
//            }
//        }
//        return false;
//    }
//    static boolean bfs(char[][] board, int i, int j)
//    {
//        String s="";
//        int k=0;
//        boolean[][] visited = new boolean[board.length][board[0].length];
//        Stack<Integer> qx = new Stack();
//        Stack<Integer> qy = new Stack();
//        char temp;
//        qx.add(i);
//        qy.add(j);
//        while(qx.size()!=0)
//        {
//            if(k==w.length()) return true;
//
//
//                int tempx =qx.pop();
//                int tempy =qy.pop();
//                if(tempx>=0 && tempx<m &&  tempy>=0 && tempy<n && visited[tempx][tempy]!=true  && w.charAt(k)==board[tempx][tempy]) {
//                    temp = board[tempx][tempy];
//                    s=s+temp;
//                }
//                else
//                    continue;
//                visited[tempx][tempy]=true;
//                qx.add(tempx+1);            qy.add(tempy);
//                qx.add(tempx-1);            qy.add(tempy);
//                qx.add(tempx);            qy.add(tempy+1);
//                qx.add(tempx);            qy.add(tempy-1);
//
//
//            k++;
//        }
//        return false;
//    }
//
//}
