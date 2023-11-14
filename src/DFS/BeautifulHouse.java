package DFS;

public class BeautifulHouse {
    public static void main(String[] args) {
        BeautifulHouse a = new BeautifulHouse();
//        a.numIslands(new int[]{
//                {}, {}, {},
//                {}, {}, {},
//                {}, {}, {},
//        });
    }
        public int numIslands(char[][] graph) {




            int m = graph.length;
            int count=0;
            int n =graph[0].length;
int [] x = new int[]{1,-1};

//
//       if( x,y-1;
//        x-1,y+1;
//        x,y+1;
//        x+1,y+1;
//        x+1,y;
//        x+1,y-1;
//        x,y-1;



            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++)
                {
                    if(i>=0 && i<n && j>=0 && j<m)
                    {

                    }

                }




            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++)
                {
                    if(graph[i][j]=='1')
                    {
                        DFS(i,j,graph,m,n);
                        count++;
                    }
                }
            return count;

        }
        void DFS(int i,int j,char[][] graph, int m, int n)
        {
            if(i<0 || j<0 || i>=m || j>=n || graph[i][j]=='0')
                return;

            graph[i][j]='0';
            DFS(i,j-1,graph,m,n);
            DFS(i-1,j,graph,m,n);
            DFS(i,j+1,graph,m,n);
            DFS(i+1,j,graph,m,n);
        }

}
