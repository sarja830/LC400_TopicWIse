package Dijkstras;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BlockCrusherKattis {
    static Node[][] graph;
    static int[][] result;
    static int depth;
    static Node last;
    static class Node{
        public int x,y,weight;
        public Node parent;
        public Node[] nodes =  new Node[8];
        public Node(int a, int b, int c){
            x=a;
            y=b;
            weight=c;
            parent=null;
        }

    }
    static void dijkstra(){
        boolean[][]vstd = new boolean[graph.length][graph[0].length];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node a, Node b){
                return a.weight-b.weight;
            }
        });
        for(int i=0;i<result[0].length;i++){
            Node p=new Node(-1,-1,0);
            graph[0][i].parent=p;
            pq.add(graph[0][i]);
        }
        int min = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Node p = pq.poll();
            vstd[p.x][p.y]=true;
            if(p.x==depth-1 && min>p.weight){
                min=p.weight;
                last=p;
            }
            if(p.weight<min){
                for(int i=0;i<8;i++){
                    Node sibling = p.nodes[i];
                    if(sibling!=null){

                        //  initially everyones parent is null except first layer ie i=0
                        if(vstd[sibling.x][sibling.y]) continue;
                        else
                        if(graph[sibling.x][sibling.y].parent==null || graph[sibling.x][sibling.y].weight>sibling.weight+p.weight){
                            sibling.parent=p;
                            sibling.weight+=p.weight;
                            graph[sibling.x][sibling.y]=sibling;
                            pq.add(sibling);
                        }
                    }
                }

            }
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        while(h!=0 && w!=0)
        {
            result = new int[h][w];
            graph = new Node[h][w];
            depth=h;
            Node p;
            for (int i = 0; i < h; i++) {
                String line = in.readLine();
                for (int j = 0; j < w; j++) {
                    p = new Node(i,j, Integer.parseInt(line.substring(j, j + 1)));
                    graph[i][j]=p;
                    result[i][j]=p.weight;
                }
            }
            //           for each Node creating links with other Nodes
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    p=graph[i][j];
                    //                    up
                    if(i>0)p.nodes[0]=graph[i-1][j];
                    //                    up right
                    if(i>0 && j<w-1)p.nodes[1]=graph[i-1][j+1];
                    //                    right
                    if(j<w-1)p.nodes[2]=graph[i][j+1];
                    //                    down right
                    if(i<h-1 && j<w-1)p.nodes[3]=graph[i+1][j+1];
                    //                    down
                    if(i<h-1)p.nodes[4]=graph[i+1][j];
                    //                    down left
                    if(i<h-1 && j>0)p.nodes[5]=graph[i+1][j-1];
                    //                    left
                    if(j>0)p.nodes[6]=graph[i][j-1];
                    //                    up left
                    if(i>0 && j>0)p.nodes[7]=graph[i-1][j-1];
                }
            }
            dijkstra();

            //            recursing back to find the parent
            while(true){
                if(last.x==-1 & last.y==-1)break;
                result[last.x][last.y]=0;
                last=last.parent;
            }
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(result[i][j]==0)System.out.print(" ");
                    else System.out.print(result[i][j]);
                }
                System.out.println();
            }
            StringTokenizer st1 = new StringTokenizer(in.readLine());
            h = Integer.parseInt(st1.nextToken());
            w = Integer.parseInt(st1.nextToken());
        }
    }
}