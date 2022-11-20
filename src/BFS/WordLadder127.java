    package BFS;

    import java.util.*;

    public class WordLadder127 {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

//        to improve the search performance we use set instead of list
        Set<String> wordListSet = new HashSet(wordList);
        Queue<String> q = new LinkedList();
        int level = 0;
        Set<String> visited = new HashSet<String>();
        q.add(beginWord);
        visited.add(beginWord);
        while (!q.isEmpty()) {

            int siz = q.size();
            level = level + 1;
            System.out.println("level " + level);
            for (int i = 0; i < siz; i++) {

                String qword = q.poll();
                if (qword.equals(endWord)) {
                    return level;
                }

                char[] word = qword.toCharArray();

                for (int k = 0; k < beginWord.length(); k++) {

                    // this is important to restore the word
                    char backup = word[k];

    //                    include j as well whenever you are
                    for (char j = 'a'; j <= 'z'; j++) {
                        word[k] = j;

                        // String w= Arrays.toString(word);
                        String w = String.valueOf(word);

                        if (!visited.contains(w) && wordListSet.contains(w)) {
                            q.add(w);
                            visited.add(w);
                        }
                    }
    //                    restoring the word so that you change the character in orignal word
                    word[k] = backup;
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {
    //            String beginWord = "hit";
    //            String endWord = "cog";
    //            String[] wordList = new String[]{"hot","dot","dog","lot","log","cog"};
        String beginWord = "ymain";
        String endWord = "oecij";
        String[] wordList = new String[]{"ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain"};
        System.out.println(ladderLength(beginWord, endWord, Arrays.asList(wordList)));
    }
    }
