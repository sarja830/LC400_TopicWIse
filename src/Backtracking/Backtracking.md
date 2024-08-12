#### 980. Unique Paths III
````java
class Solution {
    int m;
    int n;
    int ans;
    public int uniquePathsIII(int[][] grid) {
         m =  grid.length;
         ans = 0;
         n = grid[0].length;
        int start[] = new int[2];
        int count = 0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                    start = new int[]{i,j};
                else if(grid[i][j]==0)
                    count++;
            }
             rec(start[0],start[1],grid,count);
        return ans;
        

    }
    void rec(int i, int j, int[][] grid, int count)
    {
        int sum = 0;
       
       
        int[] x = new int[]{1,-1,0,0};
        int[] y = new int[]{0,0,1,-1};
        
        for(int k=0;k<4;k++)
        { 
            int xCor = i+x[k];
            int yCor = j+y[k];
            if(xCor >= 0 && xCor<m && yCor>=0 && yCor<n &&  grid[xCor][yCor] != -1 &&grid[xCor][yCor] != 3 && grid[xCor][yCor] != 1)
            {
                if(grid[xCor][yCor]==2 )
                {    
                    if(count==0) ans++;
                }
                else
                {grid[xCor][yCor] = 3;
                rec(xCor,yCor, grid,count-1);
                grid[xCor][yCor] = 0;}
            }
        }
        
    }
}
````

```text
There are 2 types of bactracking code:

     
    
    
```
#### 93. Restore IP Addresses
```java
class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList();
         rec(0,new LinkedList(),s,4,ans);
        return ans;
    }
    void rec(int start, List<String> list, String s,int dots,List<String> ans)
    {
        int n = s.length();
        
        if(start==n && dots==0)
        {
            String res = "";
            for(String s1: list)
                res = res+ s1+".";
            
            ans.add(res.substring(0,res.length()-1));
            return;
        }
        for(int i=start;i<Math.min(n,start+3);i++)
        {
            String substring = s.substring(start,i+1);
            if(isValid(substring))
            {
                list.add(substring);
                rec(i+1,list,s,dots-1,ans);
                list.remove(list.size()-1);
            }
        }
    }
    boolean isValid(String s)
    {
        int n = s.length();
        int no = Integer.parseInt(s,10);
        if(n==2 && no<=9) return false; 
        if(n==3 && (no<100 || no>255)) return false;
        
        return true;
    }
}
```