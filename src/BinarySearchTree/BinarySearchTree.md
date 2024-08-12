### 701. Insert into a Binary Search Tree (. It is guaranteed that the new value does not exist in the original BST.)
```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        TreeNode ans = root;
        while(true)
        {
            if(root.val<val)
            {
                if(root.right==null)
                {
                    root.right= new TreeNode(val);
                    return ans;
                }
                root=root.right;
            }
            else
            {
                if(root.left==null)
                {
                    root.left= new TreeNode(val);
                    return ans;
                }
                root=root.left;
            }
        }
        
    }
}
```

### 230. Kth Smallest Element in a BST
#### inroder traversal of a BST will always output the values in ascending order.
```java
class Solution {
    int count;
    TreeNode ans;
    public int kthSmallest(TreeNode root, int k) {
         count=k;
         ans=null;
        rec(root);
        return ans.val;
        
    }
    void rec(TreeNode root)
    {
        if(root==null)
            return  ;
      
        if(root.left!=null)
        {
             rec(root.left);
        } 
         count--;
        if(count==0)
         ans = root;
        if(root.right!=null){
             rec(root.right);
        }

    }
}
```


### 98. Validate Binary Search Tree


```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return rec(null,null,root);
    }
    boolean rec(Integer min, Integer max, TreeNode root)
    {
        if(root==null)
            return true;
        if((min==null || root.val<min) && (max==null || root.val>max))
            return rec(root.val,max,root.left) && rec(min,root.val,root.right);
        else return false;
    }
}
```

### 235. Lowest Common Ancestor of a Binary Search Tree

```java

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(p==null || q==null || root==null) return null;

// they both are to the left side of the binary search tree
        if(root.val>p.val && root.val>q.val)
        {
            return lowestCommonAncestor(root.left,p,q);
        }

//they both are to the right side of the binary Search tree
        if(root.val<p.val && root.val<q.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }
// otherwise they split
        return root;
    }
}
```



### 173. Binary Search Tree Iterator


```java

class BSTIterator {

    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack();

        while(root!=null)
        {
            st.push(root);

            root=root.left;
        }
    }

    public int next() {

        TreeNode ans =null;
        if(!st.isEmpty())
        {
            ans = st.pop();
            TreeNode temp = ans.right;
            while(temp!=null)
            {
                st.add(temp);
                temp=temp.left;
            }
        }
        if(ans==null) return -1;
        return ans.val;
    }

    public boolean hasNext() {
        if(!st.isEmpty())
            return true;
        return false;
    }
}

```

### 99. recover binary search tree

```java

class Solution {
    boolean flag =false;
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
      
      flag =false;
      first =null;
      prev=null;
      second=null;
        rec(root);
        int temp =first.val;
        first.val=second.val;
        second.val = temp;
        return;
    }
    void rec( TreeNode root)
    {
        if(root==null)
            return ;
        rec( root.left);
       
        if(prev!=null && !flag && root.val < prev.val)
        {
            flag =true;
            first=prev;
            second = root;
        }
        else if(prev!=null && flag && root.val < prev.val)
        {
            second=root;
            return;
        }
        prev = root;
        rec(root.right);
    }
}
```

#### 109. Convert Sorted List to Binary Search Tree
```java

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return rec(head);
    }
    TreeNode rec(ListNode root)
    {
        if(root==null) 
        {
            return null;
        }
        else if(root.next==null) 
            return new TreeNode(root.val);
        ListNode middle = MiddleOfALinkedlist(root);
        TreeNode treenode = new TreeNode(middle.val);
        TreeNode left =  rec(root);
        TreeNode right = rec(middle.next);
        treenode.left = left;
        treenode.right = right;

        return treenode;
    
    }
    ListNode MiddleOfALinkedlist(ListNode root)
    {
        int count = 0;
        ListNode slow = root;
        ListNode fast = root;
        ListNode curr = new ListNode(-1);
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            if(fast==null || fast.next==null)
                 curr = slow;
            slow = slow.next;
        }
        curr.next = null;
        return slow;
    }


}

```