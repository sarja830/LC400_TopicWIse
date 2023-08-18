### BFS

#### Count the number of province
```java
class Solution {
    int[]  visited;
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new LinkedList();
        for(int i =0;i<isConnected.length;i++)
        {
            List<Integer> list = new LinkedList();
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                    list.add(j);
            }
            adj.add(list);
        }
        int count=0;
        
        visited = new int[isConnected.length];
        int n =visited.length;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                //DFS(i, adj );
                BFS(i, adj);
                count++;
            }
        }
        return count;
    }

    void BFS(int root, List<List<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty())
        {
            int temp = q.poll();
            visited[temp] =1;
            List<Integer> neighbors = adj.get(temp);
            for(int i: neighbors)
            {
                if(visited[i]==0)
                    q.add(i);
            }
        }
        return;
    }

    void DFS(int root, List<List<Integer>> adj)
    {
        visited[root] =1;
        List<Integer> neighbors = adj.get(root);
        for(int i:neighbors)
        {
            if(visited[i]==0)
                DFS(i,adj);
        }
    }
}
```
#### 200. Number of Islands
```java
class Solution {
    public int numIslands(char[][] graph) {
        int m = graph.length;
        int count=0;
        int n =graph[0].length;
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
```

#### 994. Rotting Oranges (report time to rott the oranges)

```java
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q= new LinkedList<int[]>();
       for(int i=0;i<grid.length;i++)
        for(int j=0;j<grid[0].length;j++)
            if(grid[i][j]==2)
            {
                q.add(new int[]{i,j});
            }
        int minutes=0;
        while(!q.isEmpty())
        {
            int siz=q.size();
            minutes++;
            for(int k=0;k<siz;k++)
            {
                int[] temp = q.poll();
                
                int[] x= new int[]{0,1,0,-1};
                int[] y = new int[]{1,0,-1,0};
                for(int i=0;i<4;i++)
                    if(temp[0]+x[i]>=0 && 
                    temp[0]+x[i]<grid.length && temp[1]+y[i]>=0 && temp[1]+y[i]<grid[0].length
                    && grid[temp[0]+x[i]][temp[1]+y[i]]==1)
                    {
                        grid[temp[0]+x[i]][temp[1]+y[i]]=2;
                        q.add(new int[]{temp[0]+x[i],temp[1]+y[i]});
                    }
            }
        }
        for(int i=0;i<grid.length;i++)
        for(int j=0;j<grid[0].length;j++)
            if(grid[i][j]==1)
            {
                return -1;
            }
        return minutes>0?minutes-1:0;
    }
}
```

#### 733. FLood Fill (fill all the connected components with same value to the new given value)
```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        
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
    }
}
```


####  542. 01 Matrix (minimum distance of zeros from ones)

```java
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m =mat.length, n =mat[0].length;
        int[][] visited = new int[m][n];
        // for(int[] a : visited)
        //     Arrays.fill(a,-1);
        Queue<int[]> q =  new LinkedList();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    //adding it to queue mark as visited.
                    visited[i][j]=0;
                    q.add(new int[]{i,j});
                }
                else
                    visited[i][j]=-1;
            }
        int level=0;
        while(!q.isEmpty())
        {
            
            int siz = q.size();
            level++;
            for(int k=0;k<siz;k++)
            {
                int[] temp = q.poll();
                int[] x = new int[]{1,-1,0,0};
                int[] y = new int[]{0,0,1,-1};
                for(int i=0;i<4;i++)
                {
                    int xc = temp[0]+x[i];
                    int yc =temp[1]+y[i];
                    
                    if(xc>=0 && xc<m && yc>=0 && yc<n && visited[xc][yc]==-1)
                    {
                        visited[xc][yc] = level;
                        q.add(new int[]{xc,yc});
                    }
                }
            }
        }
        return visited;
    }
}
```


#### 130. Surrounded Regions (save the regions which is connected by corners)

```java
class Solution {
    int m;
    int n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        
        //check the region and mark 
        for(int i=0;i<m;i++)
        {
            if(board[i][0]=='O')
                checkRegion(i,0,board);
            if(board[i][n-1]=='O')
                checkRegion(i,n-1,board);
        }
        for(int j=0;j<n;j++)
        {
            if(board[0][j]=='O')
                checkRegion(0,j,board);
            if(board[m-1][j]=='O')
                checkRegion(m-1,j,board);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='1')
                    board[i][j]='O';
                else
                    board[i][j]='X';
            }
        }
        return ;
    }

    void checkRegion(int i, int j, char[][] board)
    {
        int m = board.length;
        int n = board[0].length;
        int[] x = new int[]{1,-1,0,0};
        int[] y = new int[]{0,0,1,-1};
        board[i][j]='1';
        for(int k =0;k<4;k++)
        {
            int xc = i+x[k];
            int yc = j+y[k];

            if(xc>=0 && xc<m && yc>=0 && yc<n && board[xc][yc]=='O')
            {
                checkRegion(xc,yc,board);
            }
        }
        return;
    }
}
```

#### 1020. Number of Enclaves

```java
class Solution {
    public int numEnclaves(int[][] grid) {
        int m =grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++)
        {

            if(grid[i][0]==1)
                check(grid,i,0);
            if(grid[i][n-1] ==1)
                check(grid,i,n-1);
        }

        for(int j=0;j<n;j++)
        {

            if(grid[0][j]==1)
                check(grid,0,j);
            if(grid[m-1][j] ==1)
                check(grid,m-1,j);
        }

        int count = 0;
        for(int i=1;i<m-1;i++)
            for(int j=1;j<n-1;j++)
            {
                if(grid[i][j] ==1)
                    count++;
            }
        return count;
    }
    void check(int[][] grid, int i , int j)
    {
        int m =grid.length;
        int n =grid[0].length;
        int[] x = new int[]{1,-1,0,0};
        int[] y = new int[]{0,0,1,-1};
        grid[i][j] = 0;
        for(int k =0;k<4;k++)
        {
            int xc = i+x[k];
            int yc = j+y[k];

            if(xc>=0 && xc<m && yc>=0 && yc<n && grid[xc][yc]==1)
                check(grid,xc,yc);
        }
    }
}
```


#### 127. Word Ladder (BFS)

```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet(wordList);

        Queue<String> q = new LinkedList();

        q.add(beginWord);
int level=0;
        while(!q.isEmpty())
        {
            int siz = q.size();
            level++;
            for(int k=0;k<siz;k++)
            {
                String temp  = q.poll();
                
                if((temp).equals(endWord)) return level;
                for(int i=0;i<temp.length();i++)
                {
                    char[] word = temp.toCharArray();
                    for(char j='a';j<='z';j++)
                    {
                        word[i] = j;
                        String newWord = new String(word);
                        if(set.contains(newWord))
                        {
                            q.add(newWord);
                            set.remove(newWord);
                        }
                    }   
                }
            }
        }
        return 0;
        
    }
}
```

#### WOrd Ladder 2 Getting timed out
```java
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> ans = new LinkedList();
if(!wordList.contains(endWord)) return ans;
    HashMap<String,Integer> levelWiseWords = BFSFindLevelWiseWords(endWord,beginWord,wordList);

    DFS(ans,new LinkedList(),levelWiseWords, 0,beginWord,endWord);

    return  ans;

    }

void DFS(List<List<String>> ans,List<String> list, HashMap<String,Integer> levelWise,int level, String word,String endWord)
{
    if((word).equals(endWord))
    {
        list.add(word);
        ans.add(new LinkedList(list));
        list.remove(list.size()-1);
        return;
    }
    list.add(word);
    char[] wordArray = word.toCharArray();
    for(int i=0;i<word.length();i++)
    {

        char backup =wordArray[i];
        for( char j='a';j<='z';j++)
        {

            wordArray[i] = j;
            String newWord = new String(wordArray);
            if(level+1==levelWise.getOrDefault(newWord,-5))
                DFS(ans,list,levelWise,level+1,newWord, endWord);
         
        }
        wordArray[i]= backup;
    }
    list.remove(list.size()-1);
    return;
}

HashMap<String,Integer> BFSFindLevelWiseWords(String endWord, String startWord, List<String> wordList)
   {
        HashSet<String> set = new HashSet(wordList);
        Queue<String> q = new LinkedList();
        int level = 0;
        HashMap<String,Integer> levelWise = new HashMap();
        q.add(startWord);
        levelWise.put(startWord,level);
        while(!q.isEmpty())
        {
            int siz = q.size();
            level++;
            for(int k=0;k<siz;k++)
            {
                String temp = q.poll();

                if((temp.equals(endWord)))
                {
                    levelWise.put(endWord,level-1);
                    return levelWise;
                }
                 char[] word = temp.toCharArray();
                for(int i=0;i<temp.length();i++)
                {
                   char backup = word[i];
                    for(char j='a';j<='z';j++)
                    {
                        word[i] = j;
                        String newWord = new String(word);
                        if(set.contains(newWord))
                        {
                           levelWise.put(newWord,level);
                           set.remove(newWord);
                           q.add(newWord);
                        }
                    }
                    word[i]=backup;
                }
            }
        }
        return levelWise;
   }
}
```


### distinct islands 2 on leetcode (coding ninja distinct island  )
###### maintain a set to keep track of the shape use the concept of axes shifting
```java
import java.util.*;
public class Solution 
{
    //dont use list of int[] it fails because internally set uses a.equals(b) and not Arrays.equals(a,b)
	static Set<List<List<Integer>>> set ;
	public static int distinctIsland(int [][] arr, int n, int m) 
	{
		set = new HashSet();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(arr[i][j]!=0)
				{
					List<List<Integer>> list = new LinkedList();
					DFS(i,j,arr,n,m,list,i,j);
					set.add(list);
				}
			}
		}
		return set.size();
	}

	static void DFS(int i, int j, int[][] arr, int n, int m, List<List<Integer>> list, int oi , int oj)
	{
        //store the island pattern by taking a common shifting the access
		list.add(new LinkedList(Arrays.asList(i-oi,j-oj)));
        
        //mark as visited
		arr[i][j] = 0;
		int x[] = new int[]{1,-1,0,0};
		int y[] = new int[]{0,0,1,-1};

		for(int k=0;k<4;k++)
		{
			int xc = i+x[k];
			int yc = j+y[k];
			if(xc<n && yc<m &&xc>=0 && yc>=0 && arr[xc][yc]!=0)
				DFS(xc,yc,arr,n,m,list,oi,oj);
		}
	}
}

```
#### 785. Is Graph Bipartite? (BFS)


```Java
class Solution {
     int[] color;
     int[][] adj;
    public boolean isBipartite(int[][] graph) {
     
        int  n = graph.length;
        adj = graph;
        color = new int[n];
        Arrays.fill(color,-1);
// since the graph may or may not be connected hence we need to check all the independent components
        for(int i=0;i<color.length;i++)
        {
            if(color[i]==-1)
                if(BFS(i)==false)
                    return false;
        }
        return true;
    }


    boolean BFS(int root){

        Queue<Integer> q = new LinkedList();
        int level=0;
        q.add(root);

        while(!q.isEmpty())
        {
            int siz = q.size();
            level++;
            for(int l=0;l<siz;l++)
            {
                int temp = q.poll();
                if(level%2==0 )
                    color[temp] = 0;
                int[] neighbors = adj[temp];
                for(int i=0;i<neighbors.length;i++)
                {
                    int neighbor = neighbors[i];
                    if(color[neighbor]==-1)
                    {
                        q.add(neighbor);
                    }
//if its already color check for same color
                    else
                    {
                        if(color[neighbor] == color[temp])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}

```


#### detect cycle in a directed graph


Here we need to keep track of the path visited

![img.png](img.png)a->b->c
   
```java
import java.util.*;
import java.util.LinkedList;

public class Solution 
{
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        HashMap<Integer,List<Integer>> adj = new HashMap();
        for(int[] edge: edges)
        {
            adj.putIfAbsent(edge[0], new LinkedList());
            adj.get(edge[0]).add(edge[1]);

        }
        int[] visited = new int[v];
        int[] pathVisited = new int[v];
        for(int i=0;i<v;i++)
            if(visited[i]==0)
                if(DFS(i,visited,pathVisited,adj))
                    return true;
        return false;
	}
    static boolean DFS(int root, int[] visited, int[] pathVisited, HashMap<Integer,List<Integer>> adj)
    {
        if( pathVisited[root]==1)
            return true;
        if(visited[root]==1) 
            return false;

        visited[root]=1;
        pathVisited[root]=1;
      
        if(adj.containsKey(root ))
            for(int i: adj.get(root))
            {
                if(DFS(i,visited,pathVisited,adj))
                    return true;
            }
        pathVisited[root]=0;
        return false;
       
    }
}
```