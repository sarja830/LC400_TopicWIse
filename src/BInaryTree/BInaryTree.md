# Binary Search Traversals

## 2. Depth First Search
### 1. Inorder traversal
```java
class Solution {
    List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
          ans = new LinkedList();
        rec(root);
        return ans;
    }
    void rec(TreeNode root)
    {
        if(root==null) return;
        rec(root.left);
        ans.add(root.val);
        rec(root.right);
    }
}
```
### 2. preorder traversal
```java
class Solution {
    List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
          ans = new LinkedList();
        rec(root);
        return ans;
    }
    void rec(TreeNode root)
    {
        if(root==null) return;
        ans.add(root.val);
        rec(root.left);
        rec(root.right);
    }
}
```
### 3. postorder traversal 
```java
class Solution {
    List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
          ans = new LinkedList();
        rec(root);
        return ans;
    }
    void rec(TreeNode root)
    {
        if(root==null) return;
        rec(root.left);
        rec(root.right);
        ans.add(root.val);
    }
}
```
## 1. Breadth First Search
```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return ansList;
        q.add(root);
        
        while(!q.isEmpty())
        {
            List<Integer> ansSublist = new ArrayList<>();
            int siz = q.size();
            for(int i=0;i<siz;i++)
            {
                TreeNode temp = q.poll();
                ansSublist.add(temp.val);
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            ansList.add(ansSublist);
        }
        return ansList;
    }
}
```

## Any node to any node pattern

### Maximum depth of binary tree
```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
```
### balanced binary tree
```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkAtEachTree(root)==-1?false:true;
    }
    int checkAtEachTree(TreeNode root)
    {
        if(root==null) return 0;
        int lh = checkAtEachTree(root.left);
        if(lh==-1) return -1;
        int rh = checkAtEachTree(root.right);
        if(rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return Math.max(lh,rh)+1;
    }

}
```

### Diameter of a binary tree
```java
class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[]{Integer.MIN_VALUE};
        diameter(root,ans);
        return ans[0];
    }
    int diameter(TreeNode root, int[] ans)
    {
        if(root==null)
        {
            return 0;
        }
        int lh= diameter(root.left,ans);
        int rh = diameter(root.right,ans);
        ans[0] = Math.max(ans[0],lh+rh);
        return 1+ Math.max(lh,rh);

    }
}
```

### binary tree maximum path sum between any two nodes
```java
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[]{Integer.MIN_VALUE};
        maxSum(root,ans);
        return ans[0];
    }
    int maxSum(TreeNode root, int[] ans)
    {
        if(root==null)
            return 0;
        int lh = Math.max(0,maxSum(root.left,ans));
        int rh = Math.max(0,maxSum(root.right,ans));
        ans[0] = Math.max(ans[0],lh+rh+root.val);
        return root.val+ Math.max(lh,rh);
    }
}
```

### Same tree
```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
```
## BFS traversal Questions

### Zigzag traversal

```java

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        int count = 0;
        List<List<Integer>> ans =new LinkedList();
        if(root==null) return ans;
        q.add(root);
        while(!q.isEmpty())
        {
            
            int siz = q.size();
            List<Integer> list = new LinkedList();
            for(int i=0;i<siz;i++)
            {
                TreeNode temp = q.poll();
                
                if(count%2==0)
                    list.add(temp.val);
                else
                    list.add(0,temp.val);
                if(temp.left!=null) 
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);      
            }
            count++;
            ans.add(list);
        }
        return ans;

    }
}
```

## DFS traversal questions
### right side view of binary tree
```java

// USING DFS TECHNIQUE:
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList();
        RootRightLeftTraversal(root,0,ans);
        return ans;
    }
    void RootRightLeftTraversal(TreeNode root, int level ,List<Integer> ans)
    {
        if(root==null) return;
        if(level==ans.size())
        {
            ans.add(root.val);
        }
        if(root.right!=null)
            RootRightLeftTraversal(root.right,level+1,ans);
        if(root.left!=null)
            RootRightLeftTraversal(root.left,level+1,ans);
    }
    
}


// USING BFS TECHNIQUE:
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<Integer> list = new LinkedList();
        if(root==null) return list;
        q.add(root);

        while(!q.isEmpty())
        {
            int siz = q.size();
            for(int i=0;i<siz;i++)
            {
                TreeNode temp = q.poll();
                if(i==0)
                     list.add(temp.val);
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
            }
        }
         return list;
    }
}
```
### Symmetric tree
```java
class Solution {
    public boolean isSymmetric(TreeNode root) 
    {
        if(root==null) return true;
        return rec(root.left,root.right);
    }
    boolean rec(TreeNode root1, TreeNode root2)
    {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val!=root2.val) return false;
        return  rec(root1.left,root2.right) && rec(root1.right,root2.left);
    } 
}
```


## Backtracking in Binary Tree  (from root to leaf)


### 257. Binary Tree Paths (from root to leaf)

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList();
        backtrack(root,ans,"");
        return ans;
    }
    void backtrack(TreeNode root, List<String> ans, String str)
    {
        if(root==null) 
        {
            return;
        }
        String tempstr =str;
        if(str=="")
            str ="" + root.val;
        else
            str = str+"->"+root.val;
        if(root.left==null && root.right==null)
            ans.add(new String(str));
        backtrack(root.left,ans,str);
        backtrack(root.right,ans,str);
        str = tempstr;

    }
}
```


### 988. Smallest String Starting From Leaf

```java

class Solution {

    public String smallestFromLeaf(TreeNode root) {
        String[] min =new String[1];
        min[0]="";
        backtrack(root,"",min);
        return min[0];
    }
    void backtrack(TreeNode root, String str, String[] min)
    {
        if(root==null)
            return;
        String tempstr = str;
        str= str+(char)(root.val+97);
        if(root.right==null && root.left==null)
        {
            String a =new StringBuilder(str).reverse().toString();
            if(min[0]=="")
                min[0]=a;
            else
                min[0] = min[0].compareTo(a)>0?a:min[0];
        }
        backtrack(root.left,str,min);
        backtrack(root.right,str,min);
        str = tempstr;
    }
}
```

### 129. Sum Root to Leaf Numbers 


```java

class Solution {
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        backtrack(root,0,sum);
        return sum[0];
    }
    void backtrack(TreeNode root, int curr, int[] sum)
    {
        if(root==null) return;
        int tempcurr= curr;

        curr=tempcurr*10+root.val;
        if(root.right==null && root.left==null)
        {
            sum[0]=sum[0]+ curr;
        }
        
        backtrack(root.left,curr,sum);
        backtrack(root.right,curr,sum);
        curr = tempcurr;
    }
}
```


### 113. Path Sum II (from root to leaf)
```java

```

### 112. Path Sum (from root to leaf)
```java

```