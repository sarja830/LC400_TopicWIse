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

### 687. Longest Univalue Path
```java

class Solution {
    int max;
    public int longestUnivaluePath(TreeNode root) {
        max=0;
        rec(root,-1);
        return max;
    }
    int rec(TreeNode root, int prev)
    {
        if(root==null) return 0;
        int l =rec(root.left,root.val);
        int r =rec(root.right,root.val);
        max=Math.max(1+l+r-1,max);
        if(prev==root.val)
            return 1+Math.max(l,r);
        else
            return 0;

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
class Solution {
    int target;
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)    
    {
        this.target = targetSum;
        ans = new LinkedList();
        backtrack(new LinkedList() , root, 0);
        return ans;
    }
   void backtrack(List<Integer> list , TreeNode root, int sum)
    {
        if(root==null) return;
        list.add(root.val);
        if(root.left ==null && root.right==null && sum+root.val == target)
        {
            ans.add(new LinkedList(list));
           list.remove(list.size()-1);
            return;
        }
        backtrack(list,root.left,sum+root.val);
        backtrack(list,root.right,sum+root.val);
        list.remove(list.size()-1);
    }
}

```

### 112. Path Sum (from root to leaf)
```java

```

## Miscellenous 

### 236. Lowest Common Ancestor of a Binary Tree
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
       if(root==null || root==p || root==q) return root;

       
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);      
        if(left == null)
            return right;
        else if(right==null)
            return left;
        else   
            return root;

    }
}
```


## BFS Hard

### 662. Maximum Width of Binary Tree

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode>  q = new LinkedList();
        Queue<Integer> qno = new LinkedList();
        int min=Integer.MIN_VALUE;
        int max = 0;
        q.add(root);
        qno.add(0);
        while(!q.isEmpty())
        {
            int siz=q.size();
           
            for(int i=0;i<siz;i++)
            {
                TreeNode temp= q.poll();
                int tempNo= qno.poll();
                if(i==0) min=tempNo;
                if(i==siz-1) max = Math.max(max,tempNo-min+1);
                if(temp.left!=null){
                     q.add(temp.left);
                     qno.add(2*tempNo+1-(2*min-1));
                }
                if(temp.right!=null) 
                {
                    q.add(temp.right);
                    qno.add(2*(tempNo)+2-(2*min-1));
                }

            }
        }
        return max;
    }
}
```

## Double BFS 

### 863. All Nodes Distance K in Binary Tree

```java
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //first bfs to traverse and make a map
        List<Integer> ans = new LinkedList();
        Queue<TreeNode> q = new LinkedList();
        HashMap<TreeNode, TreeNode> map = new HashMap();
        q.add(root);
        TreeNode temp;
        while(!q.isEmpty())
        {
            temp = q.poll();
            if(temp.left!=null)
            {
                q.add(temp.left);
                map.put(temp.left,temp);
            }
            if(temp.right!=null)
            {
                q.add(temp.right);
                map.put(temp.right,temp);
            }
        }
        HashSet<TreeNode>  visited = new HashSet();
        q.clear();
        q.add(target);
        visited.add(target);
        while(!q.isEmpty())
        {
            int siz = q.size();
            if(k==0)
            {
                for(int j=0;j<siz;j++)
                {
                    ans.add(q.poll().val);
                }
                return ans;
            }
            for(int i=0;i<siz;i++)
            {
                temp = q.poll();
                if(temp.left!=null)
                {
                    if(!visited.contains(temp.left))
                        q.add(temp.left);
                    visited.add(temp.left);
                }
                if(temp.right!=null)
                {
                    if(!visited.contains(temp.right))
                        q.add(temp.right);
                    visited.add(temp.right);
                }   
                if(map.containsKey(temp))
                {
                     if(!visited.contains(map.get(temp)))
                        q.add(map.get(temp));
                    visited.add(map.get(temp));
                }   
            }
            k--;
        }
        return ans;
    }
}
```

### 2385. Amount of Time for Binary Tree to Be Infected

```java
class Solution {
    public int amountOfTime(TreeNode root, int start) {
         
         TreeNode target = null;
         //first bfs to traverse and make a map
        List<Integer> ans = new LinkedList();
        Queue<TreeNode> q = new LinkedList();
        HashMap<TreeNode, TreeNode> map = new HashMap();
        q.add(root);
        TreeNode temp;
        while(!q.isEmpty())
        {
            temp = q.poll();
            if(temp.val==start) 
                target = temp;
            if(temp.left!=null)
            {
                q.add(temp.left);
                map.put(temp.left,temp);
            }
            if(temp.right!=null)
            {
                q.add(temp.right);
                map.put(temp.right,temp);
            }
        }
        HashSet<TreeNode>  visited = new HashSet();
        int k=0;
        q.clear();
        q.add(target);
        visited.add(target);
        while(!q.isEmpty())
        {
            int siz = q.size();
            k++;
            for(int i=0;i<siz;i++)
            {
                temp = q.poll();
                if(temp.left!=null)
                {
                    if(!visited.contains(temp.left))
                        q.add(temp.left);
                    visited.add(temp.left);
                }
                if(temp.right!=null)
                {
                    if(!visited.contains(temp.right))
                        q.add(temp.right);
                    visited.add(temp.right);
                }   
                if(map.containsKey(temp))
                {
                     if(!visited.contains(map.get(temp)))
                        q.add(map.get(temp));
                    visited.add(map.get(temp));
                }   
            }
            
        }
        // the first iteration of addition for root  is not considered
        return k-1;

    }
}
```

#### Reference
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solutions/3831154/easy-to-understand-solution-in-java-using-2-bfs/
https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/solutions/3831175/easy-to-understand-solution-in-java-using-2-bfs/


### 106. construct binary tree from inorder and postorder traversal

```java
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         HashMap<Integer,Integer>  map = new HashMap();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return rec(map,postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    TreeNode rec(HashMap<Integer,Integer> map, int[] postorder,int postStart, int postEnd, int[] inorder , int inStart, int inEnd)
    {
        if(postStart>postEnd || inStart >inEnd) return null;
        int index = map.get(postorder[postEnd]);
        int numsLeft = index-inStart;
        TreeNode root= new TreeNode(postorder[postEnd]);
        root.left = rec(map,postorder, postStart, postStart+numsLeft-1, inorder, inStart, index-1);

        root.right =  rec(map ,postorder, postStart+numsLeft,postEnd-1,inorder,index+1,inEnd);
        return root;

    }
}
```

### 105. Construct binary tree from preorder and inorder binary tree traversal

```java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>  map = new HashMap();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return rec(map,preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    TreeNode rec(HashMap<Integer,Integer> map, int[] preorder,int preStart, int preEnd, int[] inorder , int inStart, int inEnd)
    {
        if(preStart>preEnd || inStart >inEnd) return null;
        int index = map.get(preorder[preStart]);
        int numsLeft = index-inStart;
        TreeNode root= new TreeNode(preorder[preStart]);
        root.left = rec(map,preorder, preStart+1, preStart+numsLeft, inorder, inStart, index-1);

        root.right =  rec(map ,preorder, preStart+numsLeft+1,preEnd,inorder,index+1,inEnd);
        return root;



    }
}
```


### 297. Serialize and Desrialize a binary tree

```java
public class Codec {

    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        
        
        String str = "";
        if(root==null)
            return str;
        TreeNode temp;
        q.add(root);
        str = str+root.val;
        while(!q.isEmpty())
        {
             temp = q.poll();
            if(temp.left!=null)
            {
                q.add(temp.left);
                str = str+" "+temp.left.val;
            }
            else
            {
                str = str+" "+"#";
            }

            if(temp.right!=null)
            {
                q.add(temp.right);
                str=str+" "+temp.right.val;
            }
            else
            {
                str=str+" "+"#";
            }
        } 
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str) 
    {
        if(str.length()==0) return null;
        int i=0;
        String[] s = str.split(" ");
        int n = s.length;
        TreeNode temp;
        temp = new TreeNode(Integer.valueOf(s[0])); 
        Queue<TreeNode> q = new LinkedList();
        TreeNode root=temp;
        q.add(temp);
        i++;
        while( !q.isEmpty() && i<n )
        {
            temp = q.poll();
            if(!(s[i]).equals("#"))
            {
                
                temp.left =  new TreeNode(Integer.valueOf(s[i]));
                q.add(temp.left);
            }
            i++;

            if(i<n && !(s[i]).equals("#"))
            {
                temp.right = new TreeNode(Integer.valueOf(s[i]));
                q.add(temp.right);
            }
            i++;
        } 
        return root;
    }
}

```


### 114. Flatten Binary Tree to Linked List

```java
class Solution {
    TreeNode prev;
    public void flatten(TreeNode root) {
        prev=null;
        rec(root);
        return ;
    }
    void rec(TreeNode curr)
    {
        if(curr==null) return;
        if(prev!=null)
        {
            prev.right= curr;
            prev.left =null;
        }

        TreeNode r = curr.right;
        prev=curr;
        rec(curr.left);
        rec(r);
    }

}
```