package Graphs;

public class FloodFill {
    public static void main(String[] args) {
        FloodFill a =  new FloodFill();
//        a.floodFill(
//
//                new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2
//        );
        a.floodFill(

                new int[][]{{0,0,0},{0,0,0},{0,0,0}},0,0,0
        );
    }
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            DFS(image,sr,sc,image[sr][sc], color);
            return image;
        }
        void DFS(int[][] image, int i, int j,int oc, int color)
        {
            if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=oc )
                return;

            image[i][j] = color;

            DFS(image, i , j+1 , oc, color);
            DFS(image, i-1 , j , oc, color);
            DFS(image, i , j-1 , oc, color);
            DFS(image, i+1 , j , oc, color);
            return;
        }

}
