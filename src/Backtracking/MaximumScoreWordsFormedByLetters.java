//package Backtracking;
//
//public class MaximumScoreWordsFormedByLetters {
//
//
//    public static void main(String[] args) {
//        MaximumScoreWordsFormedByLetters a = new MaximumScoreWordsFormedByLetters();
//        System.out.println(a.maxScoreWords(new String[]{"add","dda","bb","ba","add"},new char[]{'a','a','a','a','b','b','b','b','c','c','c','c','c','d','d','d'},
//                new int[]{3,9,8,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}  ));
//    }
//
//    public int maxScoreWords(String[] words, char[] letters, int[] score) {
//        int[] chars = new int[26];
//
//        for(char letter: letters)
//            chars[letter-'a']++;
//        return  backtrack(0,words,chars,score,0);
//    }
//
//    int backtrack( int start, String[] words, int[] chars, int[] score, int currScore)
//    {
//        int n = words.length;
//        int ans = currScore;
//        for(int i=start;i<n;i++)
//        {
//
//            char[] word = words[i].toCharArray();
//            int j=0;
//            boolean flag = false;
//            for( j=0;j<word.length;j++)
//            {
//                chars[word[j]-'a']--;
//                currScore+=score[word[j]-'a'];
//                if(chars[word[j]-'a']<0)
//                {
//                    flag = true;
//                    while(j>=0)
//                    {
//                        currScore-=score[word[j]-'a'];
//                        chars[word[j]-'a']++;
//                        j--;
//                    }
//                    break;
//                }
//            }
//
//            ans = Math.max(ans,backtrack( start+1, words, chars, score, currScore));
//                j = word.length-1;
//                while(j>=0)
//                {
//                    currScore-=score[word[j]-'a'];
//                    chars[word[j--]-'a']++;
//                }
//            }
//
//        }
//        return ;
//    }
//}
//
