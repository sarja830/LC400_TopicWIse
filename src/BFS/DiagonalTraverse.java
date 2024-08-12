package BFS;
import java.util.*;
public class DiagonalTraverse {

        public static void main(String[] args) {
            findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        }
        public static  int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            boolean flag = true;
            int n = mat[0].length;
            Queue<int[]> q = new LinkedList();
            HashSet<int[]> set = new HashSet<>();
            List<Integer> ans = new LinkedList();
            q.add(new int[]{0,0});
            while(!q.isEmpty())
            {
                int siz = q.size();
                List<int[]> buff = new LinkedList();
                for(int l=0;l<siz;l++)
                {
                    int[] temp = q.poll();
                    int i = temp[0];
                    int j = temp[1];
                    ans.add(mat[temp[0]][temp[1]]);

                    if(set.contains(new int[]{i,j+1}) &&  j+1<n) {
                        q.add(new int[]{i, j + 1});
                        set.add(new int[]{i, j + 1});
                    }

                    if(i+1<m)
                    {
                        q.add(new int[]{i+1,j});
                    }
                }


                flag = !flag;
            }

            return ans.stream().mapToInt(i -> i).toArray();
        }

}
