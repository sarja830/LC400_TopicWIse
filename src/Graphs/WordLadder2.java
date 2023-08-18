package Graphs;
import java.util.*;
class WordLadder2
{
    public static void main(String[] args) {
        WordLadder2 a = new WordLadder2();
        a.findLadders("hit","cog", new LinkedList(Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new LinkedList();

        HashMap<String,Integer> levelWiseWords = BFSFindLevelWiseWords(endWord,beginWord,wordList);

        DFS(ans,new LinkedList(),levelWiseWords, 0,beginWord,endWord);

        return  ans;

    }

    void DFS(List<List<String>> ans,List<String> list, HashMap<String,Integer> levelWise,int level, String word,String endWord)
    {
        if((word).equals(endWord))
        {
            list.add(word);
            ans.add(new LinkedList(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(word);
        for(int i=0;i<word.length();i++)
        {
            char[] wordArray = word.toCharArray();
            for( char j='a';j<='z';j++)
            {
                wordArray[i] = j;
                String newWord = new String(wordArray);
                if(level+1==levelWise.getOrDefault(newWord,-5))
                    DFS(ans,list,levelWise,level+1,newWord, endWord);
            }
        }
        list.remove(list.size()-1);
        return;
    }

    HashMap<String,Integer> BFSFindLevelWiseWords(String endWord, String startWord, List<String> wordList)
    {
        HashSet<String> set = new HashSet(wordList);
        Queue<String> q = new LinkedList();
        int level = 0;
        HashMap<String,Integer> levelWise = new HashMap();
        q.add(startWord);
        levelWise.put(startWord,level);
        while(!q.isEmpty())
        {
            int siz = q.size();
            level++;
            for(int k=0;k<siz;k++)
            {
                String temp = q.poll();

                if((temp.equals(endWord)))
                {
                    levelWise.put(endWord,level-1);
                    return levelWise;
                }
                for(int i=0;i<temp.length();i++)
                {
                    char[] word = temp.toCharArray();
                    for(char j='a';j<='z';j++)
                    {
                        word[i] = j;
                        String newWord = new String(word);
                        if(set.contains(newWord))
                        {
                            levelWise.put(newWord,level);
                            set.remove(newWord);
                            q.add(newWord);
                        }
                    }
                }
            }
        }
        return levelWise;
    }
}