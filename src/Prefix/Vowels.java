package Prefix;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Vowels {

    public static List<Integer> hasVowels(List<String> strArr, List<String> query) {
        List<Integer> ans = new LinkedList<>();
        int[] boolVal = new int[strArr.size()];
        int i=0;

        for(i=0;i<strArr.size();i++)
        {
            String s = strArr.get(i);
            if((
                    s.charAt(0)=='a' || s.charAt(0)=='e'|| s.charAt(0)=='i' || s.charAt(0)=='o' || s.charAt(0)=='u') &&
                    ( s.charAt(s.length()-1)=='a' || s.charAt(s.length()-1)=='e'|| s.charAt(s.length()-1)=='i' || s.charAt(s.length()-1)=='o' || s.charAt(s.length()-1)=='u') )
            {
                if(i!=0)
                    boolVal[i] =boolVal[i-1]+1;
                else
                    boolVal[i] =1;
            }
            else
                boolVal[i] =boolVal[i-1];
        }
        for(String q: query)
        {
            int l= q.charAt(0)-'1';
            int r = q.charAt(2)-'1';
            if(l==0) ans.add(boolVal[r]-0);
            else ans.add(boolVal[r]-boolVal[l]);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        List<String> strArr = Arrays.asList("aba", "bcb", "ece", "aa", "e");
        List<String> query = Arrays.asList("1-3", "2-5", "2-2");

        List<Integer> answer = hasVowels(strArr, query);

        hasVowels(strArr,query);
    }
}

