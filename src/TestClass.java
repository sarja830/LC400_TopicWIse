import java.util.*;
public class TestClass {
    public static void main(String[] args)
    {
//       for dijkstras algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{1,8});
        pq.add(new int[]{1,9});
        System.out.println(pq.poll()[1]);
        System.out.println(pq.poll()[1]);
    }

}
class Pair
{
    int[]  pair = new int[2];
    public Pair(int node ,int distance)
    {
       pair[0]=node;
       pair[1]=distance;
    }
}