package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {




    public static void main(String[] args) {
        // Create a BufferedReader object to read input from the standard input (System.in)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Create an empty array to store the lines
        String[] lines = new String[]{"Ben/Jon","Terry/David","Kyle/David","Ben/Kyle","Scott/Jon","Chris/Scott","Jon/Kenny","Kenny/David"};

        int n = lines.length;

        HashMap<String, List<String>> map = new HashMap<>();
        String from = lines[0].split("/")[1];
        String to = lines[0].split("/")[0];
        // Print the array of strings
        for (int i=1;i<n;i++) {
            String line = lines[i];
            String[] pair =  line.split("/");
            if(!map.containsKey(pair[1]))
                map.put(pair[1],new LinkedList<>());
            map.get(pair[1]).add(pair[0]);

        }
        System.out.println(calculate(map,from,to));
    }



    public static int calculate(HashMap<String, List<String>> map, String from, String to)
    {
        int level =0;
        Queue<String> q = new LinkedList<>();
        q.add(from);
        while(!q.isEmpty())
        {
            int siz = q.size();
            for(int k=0;k<siz;k++)
            {
                String temp = q.poll();
                if(temp.equals(to))
                {
                    return level;
                }
                if(map.containsKey(temp))
                {
                    for(String s: map.get(temp))
                    {
                        q.add(s);
                    }
                }
            }
            level++;
        }
        return -1;
    }



}
