package Dijkstras;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BlockCrusherKattis2 {
    static Cell[][] block;
    static int[][] memo;
    static int depth;
    static Cell dest;
    static class Cell{

//        To keep track of the parent
        public Cell prev;
        public Cell[] Cells =  new Cell[8];
        public int x,y,weight;

        public Cell(int xcord, int ycord, int w){
            x=xcord;
            y=ycord;
            weight=w;
            prev=null;
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());


        while(h!=0 && w!=0) {
            depth = h;
            memo = new int[h][w];
            block = new Cell[h][w];

            Cell temp;
            for (int i = 0; i < h; i++) {
                String line = in.readLine();
                for (int j = 0; j < w; j++) {
                    temp = new Cell(i, j, Integer.parseInt(line.substring(j, j + 1)));
                    block[i][j] = temp;
                    memo[i][j] = temp.weight;
                }
            }
            //  
            for (int i = 0; i <= h - 1; i++) {
                for (int j = 0; j <= w - 1; j++) {
                    temp = block[i][j];
                    if (i > 0) temp.Cells[0] = block[i - 1][j];                //north
                    if (i < h - 1) temp.Cells[4] = block[i + 1][j];              //south
                    if (j > 0) temp.Cells[6] = block[i][j - 1];                //west
                    if (j < w - 1) temp.Cells[2] = block[i][j + 1];              //east
                    if (i > 0 && j > 0) temp.Cells[7] = block[i - 1][j - 1];       //northwest
                    if (i < h - 1 && j > 0) temp.Cells[5] = block[i + 1][j - 1];     //southwest
                    if (i > 0 && j < w - 1) temp.Cells[1] = block[i - 1][j + 1];     //northeast
                    if (i < h - 1 && j < w - 1) temp.Cells[3] = block[i + 1][j + 1];   //southeast
                }
            }

            boolean[][]visited = new boolean[block.length][block[0].length];
            PriorityQueue<Cell> heap;
            heap= new PriorityQueue<>(new Comparator<Cell>(){
                public int compare(Cell a, Cell b){
                    return a.weight-b.weight;
                }
            });

            for(int i=0;i<memo[0].length;i++){
                Cell p=new Cell(-1,-1,0);
                block[0][i].prev=p;
                heap.add(block[0][i]);
            }
            int minWeightWeight = Integer.MAX_VALUE;
            while(heap.size()!=0){
                Cell qItem = heap.poll();

                if(qItem.x==depth-1 ) {
                    if (minWeightWeight > qItem.weight) {
                        dest = qItem;
                        minWeightWeight = qItem.weight;
                    }
                }
                if(qItem.weight<minWeightWeight){
//                    relaxing all the adjacent edges
                    for(int i=0;i<8;i++){
                        Cell neighbor = qItem.Cells[i];
                        if(neighbor!=null){
                            //  initially everyones prev is null except first layer ie i=0
                            if(!visited[neighbor.x][neighbor.y])
//                                relaxing new nodes based on distance
                                if(block[neighbor.x][neighbor.y].prev==null || block[neighbor.x][neighbor.y].weight>neighbor.weight+qItem.weight){
//                                    the nodes reaching from
                                    block[neighbor.x][neighbor.y]=neighbor;
                                    neighbor.prev=qItem;
                                    neighbor.weight+=qItem.weight;;
                                    heap.add(neighbor);
                                }
                            else continue;
                        }
                    }
                    visited[qItem.x][qItem.y]=true;

                }
            }

            //   recursing back to find the prev
            while(dest.x!=-1 & dest.y!=-1){
                memo[dest.x][dest.y]=0;
                dest=dest.prev;
            }
            for(int i=0;i<=h-1;i++)
            {
                for(int j=0;j<=w-1;j++)
                {
                    if(memo[i][j]==0)
                        System.out.print(" ");
                    else 
                        System.out.print(memo[i][j]);
                }
                System.out.println();
            }

            StringTokenizer strtok = new StringTokenizer(in.readLine());
            h = Integer.parseInt(strtok.nextToken());
            w = Integer.parseInt(strtok.nextToken());
        }
    }
}