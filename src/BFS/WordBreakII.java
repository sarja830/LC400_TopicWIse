package BFS;
import java.util.*;
public class WordBreakII {
    public static void main(String[] args) {
        WordBreakII a = new WordBreakII();

        a.wordBreak("catsanddog",new LinkedList<>(Arrays.asList("cat","cats","and","sand","dog")));
    }

    class Node
    {
        Node[] child;
        boolean end;
        public Node()
        {
            child = new Node[26];
            end = false;
        }
    }
    void insertIntoTrie(String word, Node root)
    {
        Node curr = root;
        for(char c: word.toCharArray())
        {
            if(curr.child[c-'a']==null)
                curr.child[c-'a'] = new Node();
            curr = curr.child[c-'a'];
        }
        curr.end= true;
    }
    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        int i=0;
        Node root = new Node();
        ans = new LinkedList<String>();
        for(String word: wordDict)
            insertIntoTrie(word,root);
        rec(0,root,root,"",s);
        return ans;
    }

    void rec(int i, Node root, Node curr, String word, String s)
    {

        int n = s.length();
        char c = s.charAt(i);
        if(i==n)
        {
            if(curr.end)
                ans.add(s.substring(0,n));
            return;
        }
        if(curr.child[c-'a']==null)
            return;
        if(root.child[c-'a'].end==true)
            rec(i+1,root,root,word+c+" ",s);
        rec(i+1,curr.child[c-'a'],root,word+c,s);
    }











//        public static  List<String> wordBreak(String s, List<String> wordDict) {
//            Queue<Integer> q = new LinkedList();
//            Queue<List<String>> q1 = new LinkedList();
//            HashSet<String> set = new HashSet(wordDict);
//            List<String> ans = new LinkedList();
//            int n = s.length();
//            q.add(0);
//
//            while(!q.isEmpty())
//            {
//                int temp = q.poll();
//                List<String> l = ((!q1.isEmpty())?q1.poll(): new LinkedList());
//
//                if(temp==n)
//                {
//                    String as = "";
//                    for(String s1: l)
//                        if(as.length()==0)
//                            as = s1;
//                        else
//                            as = as+" "+s1;
//                    ans.add(as);
//                    continue;
//                }
//                for(String word: wordDict)
//                {
//                    int n1 = word.length();
//                    if(temp+n1<=n)
//                    {
//                        String w = s.substring(temp,temp+n1);
//                        if(set.contains(w))
//                        {
//                            q.add(temp+n1);
//                            l.add(w);
//                            q1.add(new LinkedList(l));
//                            l.remove(l.size()-1);
//                        }
//                    }
//                }
//            }
//            return ans;
//
//        }

}
