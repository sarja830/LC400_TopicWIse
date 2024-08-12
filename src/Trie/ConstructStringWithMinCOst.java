package Trie;

public class ConstructStringWithMinCOst {


    public static void main(String[] args) {
        ConstructStringWithMinCOst c = new ConstructStringWithMinCOst();
        c.minimumCost("abcdef",new String[]{"abdef","abc","d","def","ef"},new int[]{100,1,1,10,5});
    }
    class TrieNode
    {
        boolean end;
        int cost;
        TrieNode[] child;
        public TrieNode()
        {
            child = new TrieNode[26];
            end = false;
            cost = sum+1;
        }
    }
    TrieNode root;
    int sum ;
    int memo[];
    public int minimumCost(String target, String[] words, int[] costs) {
        root = new TrieNode();
        memo = new int[target.length()+1];
        int k=0;
        sum = 0;
        for(int i: costs)
            sum+=i;
        for(String word: words)
            if(word.length()<=target.length())
                insertToTrie(word,costs[k++]);
        int ans= rec(root,0,target);
        return  ans>sum?-1:ans;

    }

    int rec(TrieNode curr, int i, String target )
    {
        if(i==target.length())
        {    if(curr==root)
            return 0;
            return sum+1;
        }
        if(memo[i]!=0)
            return memo[i];
        char c = target.charAt(i);

        if(curr.child[c-'a']!=null)
        {
            curr = curr.child[c-'a'];
            if(curr.end)
            {   memo[i] =  Math.min(
                    curr.cost+rec(root,i+1,target ),
                    rec(curr,i+1,target)
            );
            }
            else{
                memo[i] = rec(curr,i+1,target);
            }

        }

        return memo[i];

    }
    void insertToTrie(String word, int cost)
    {
        TrieNode curr = root;
        for(char c: word.toCharArray())
        {
            if(curr.child[c-'a']==null)
                curr.child[c-'a']= new TrieNode();
            curr = curr.child[c-'a'];
        }
        curr.end = true;
        curr.cost = Math.min(cost,curr.cost);
    }

}
