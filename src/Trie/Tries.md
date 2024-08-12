#### 211. Design Add and Search Words Data Structure
```java
class WordDictionary {

    class Node
    {
        Node[] links;
        boolean flag ;
        Node()
        {
            links = new Node[26];
        // always take care of this 
            flag = false;02
        }
        Node getNode(char c)
        {
            return links[c-'a'];
        }
        Node setNode(char c)
        {
            links[c-'a'] = new Node();
            return links[c-'a'];
        }
    }
    Node trie;
    public WordDictionary() {
        trie = new Node();

    }
    
    public void addWord(String word) {
        Node node = trie;
        for(char c: word.toCharArray())
        {
            node = node.getNode(c)==null?node.setNode(c):node.getNode(c); 
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        
        return dfs(trie,word);
    }
   boolean dfs(Node node, String s)
    {
        if(node == null) return false;
        boolean ans = false;
        for(int j=0;j<s.length();j++)
        {
            char c = s.charAt(j);
            if(c=='.')
            {
                for(char i='a';i<='z';i++)
                {
                    ans = ans || dfs(node.getNode(i),s.substring(j+1,s.length()));
                }
                return ans;
            }
            else
            {
                node = node.getNode(c);
                if(node==null)
                    return false;
            }

        }
        if(node.flag)
            return true;
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
```


#### 1268. Search Suggestions System
```java
class Solution {
    class Node
    {
        Node[] child;
        int[] count;
        boolean flag;
        public Node()
        {
            child = new Node[26];
            count = new int[26]; 
            flag = false;
            Arrays.fill(child,null);
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) 
    {
        Node start = new Node();
        int n = products.length;
        for(int i=0;i<n;i++)
            insert(products[i],start);
        List<List<String>> ans = new LinkedList();
        for(int i=0;i<searchWord.length();i++)
        {
            List<String> list = new LinkedList();
            if(start!=null)
            {
                start = start.child[searchWord.charAt(i) - 'a'];       
                DFS(start,searchWord.substring(0,i+1),new int[]{0},list);
            }
            ans.add(list);
        }
        return ans;
    }
   
    void DFS(Node node, String s,int[] count,List<String> list)
    {
        if(node==null) return;
        if(count[0]==3)
                return ;
        if(node!=null &&  node.flag==true)
        {
            count[0]++;
            list.add(s);
        }
        if(node!=null)
        for(int i=0;i<26;i++)
        {
            if(node.count[i]!=0)
            {
                DFS(node.child[i],s+(char)('a'+i),count,list);
                if(count[0]==3)
                    return ;
            }
        }
        return ;
    }
    public void insert(String word, Node root)
    {
        for(char c: word.toCharArray())
        {
            root.count[c-'a']++;
            if(root.child[c-'a']==null)
                root.child[c-'a'] = new Node();
            root = root.child[c-'a'];
        }
        root.flag = true;
    }
}
```


#### Word Search 2
```java
class Solution {
    List<String> ans;
    class Node
    {
        Node[] child;
        boolean flag;
        Node()
        {
            child = new Node[26];
            Arrays.fill(child, null);
            flag = false;
        }
    }
    public List<String> findWords(char[][] board, String[] words) 
    {   
        ans = new LinkedList();
        int m = board.length;
        int n = board[0].length;
        Node root = new Node();
        for(String word: words)
            addWord(root, word);
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                char c = board[i][j];
                if(root.child[c-'a']!=null)
                {
                    DFS(i,j,board,new int[m][n],root.child[c-'a'],c+"");
                }
            }
            return ans;
        
    }
    
    void DFS(int i , int j, char[][] grid, int[][] visited, Node root, String word)
    {
        char c = grid[i][j];
         int m = grid.length;
        int n = grid[0].length;
        int[] x = new int[]{1,-1,0,0};
        int[] y = new int[]{0,0,1,-1};
        visited[i][j] = 1;
        if(root.flag==true)
        {    
            ans.add( word);
            root.flag = false;
        }
        for(int k=0;k<4;k++)
        {
            int xCor = i+x[k];
            int yCor = j+y[k];
            if(
                xCor>=0 && xCor<m && yCor>=0 && yCor<n 
                && visited[xCor][yCor]==0 
                && root.child[grid[xCor][yCor]-'a']!=null
                )
                {
                     visited[xCor][yCor] = 1;
                    DFS(xCor, yCor, grid, visited, root.child[grid[xCor][yCor]-'a'], word+grid[xCor][yCor]);
                     visited[xCor][yCor] = 0;
                }
        }
    }
    void addWord(Node root,String word)
    {
        for(char c: word.toCharArray())
        {
            if(root.child[c-'a']==null)
                root.child[c-'a'] = new Node();
            root = root.child[c-'a'];
        }
        root.flag = true;
    }
}
```