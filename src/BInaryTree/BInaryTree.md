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