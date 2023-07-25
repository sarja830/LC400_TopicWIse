package BFS;
import com.sun.source.tree.Tree;

import java.util.*;
public class VerticalTraversal {

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static void main(String[] args) {
        VerticalTraversal a =new VerticalTraversal();
        TreeNode root = new TreeNode(3,new TreeNode(9,null,null),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        a.verticalTraversal(root);
    }
        class Pair
        {
            TreeNode root;
            int pos;
            public Pair(TreeNode root, int pos)
            {
                this.root =root;
                this.pos = pos;
            }
        }
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> ans = new LinkedList();
            List<List<Integer>> rans = new LinkedList();
            List<List<Integer>> lans = new LinkedList();

            Queue<Pair> q = new LinkedList();
            q.add(new Pair(root,0));
            while(!q.isEmpty()) {
                int siz = q.size();
                for (int j = 0; j < siz; j++) {
                    Pair temp = q.poll();
                    TreeNode tnode = temp.root;
                    int level = temp.pos;
                    int l = Math.abs(level);
                    List<Integer> list;
                    if (level < 0) {

                        if (lans.size() >= l) {
                            list = lans.get(l - 1);
                            list.add(tnode.val);
                            lans.remove(l-1);
                            lans.add(l - 1, new LinkedList(list));
                        } else {
                            List<Integer> newList1 = new LinkedList();
                            newList1.add(tnode.val);
                            lans.remove(l-1);
                            lans.add(l - 1, newList1);
                        }
                    } else {

                        if (rans.size()-1>= l ) {
                            list = rans.get(l);
                            list.add(tnode.val);
                            rans.remove(l);
                            rans.add(l, new LinkedList(list));
                        } else {
                            List<Integer> newList = new LinkedList();
                            newList.add(tnode.val);
                            rans.remove(l);
                            rans.add(l, newList);
                        }
                    }

                    if (tnode.left != null) {

                        q.add(new Pair(tnode.left, level - 1));
                    }
                    if (tnode.right != null) {
                        q.add(new Pair(tnode.right, level + 1));
                    }
                }
            }
                for(int i=0;i<lans.size();i++)
                {
                    ans.add(0,lans.get(i));
                }
                for(int i=0;i<rans.size();i++)
                {
                    ans.add(rans.get(i));
                }

            return ans;

        }

}
