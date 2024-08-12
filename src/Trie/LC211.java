package Trie;

public class LC211 {

    public static void main(String[] args) {
        LC211 a = new LC211();
        a.addWord("at");
        a.addWord("and");
        a.addWord("an");
        a.addWord("add");
        a.search("a");
    }
        class Node
        {
            Node[] links;
            boolean flag ;
            Node()
            {
                links = new Node[26];
                flag = true;
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
        public LC211() {
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
